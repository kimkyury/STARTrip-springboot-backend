import Menu from "../models/Menu";

export const home = async (req, res) => {
  const menus = await Menu.find({}).sort({ createdAt: "desc" });
  return res.render("home", { pageTitle: "Home", menus });
};

export const watch = async (req, res) => {
  const { id } = req.params;
  const menu = await Menu.findById(id);
  if (!menu) {
    return res.render("404", { pageTitle: "Menu not found." });
  }
  return res.render("watch", { pageTitle: menu.title, menu });
};

export const getEdit = async (req, res) => {
  const { id } = req.params;
  const menu = await Menu.findById(id);
  if (!menu) {
    return res.status(404).render("404", { pageTitle: "Menu not found." });
  }
  return res.render("edit", { pageTitle: `Edit: ${menu.title}`, menu });
};

export const postEdit = async (req, res) => {
  const { id } = req.params;
  const { title, description, ingredients } = req.body;
  const menu = await Menu.exists({ _id: id });
  if (!menu) {
    return res.status(404).render("404", { pageTitle: "Menu not found." });
  }
  await Menu.findByIdAndUpdate(id, {
    title,
    description,
    ingredients: Menu.formatIngredients(ingredients),
  });
  return res.redirect(`/menus/${id}`);
};

export const getUpload = (req, res) => {
  return res.render("upload", { pageTitle: "Upload Menu" });
};

export const postUpload = async (req, res) => {
  const { title, description, ingredients } = req.body;
  try {
    await Menu.create({
      title,
      description,
      ingredients: Menu.formatIngredients(ingredients),
    });
    return res.redirect("/");
  } catch (error) {
    return res.status(404).render("upload", {
      pageTitle: "Upload Menu",
      errorMessage: error._message,
    });
  }
};

export const deleteMenu = async (req, res) => {
  const { id } = req.params;
  await Video.findByIdAndDelete(id);
  return res.redirect("/");
};

export const search = async (req, res) => {
  const { keyword } = req.query;
  let menus = [];
  if (keyword) {
    menus = await Menu.find({
      title: {
        $regex: new RegExp(`${keyword}`, "i"),
      },
    });
  }
  return res.render("search", { pageTitle: "Search", menus });
};
