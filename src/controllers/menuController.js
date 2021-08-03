import Menu from "../models/Menu";

export const home = async (req, res) => {
  const Menus = await Menu.find({});
  return res.render("home", { pageTitle: "Home", Menus });
};

export const watch = (req, res) => {
  const { id } = req.params;
  return res.render("watch", { pageTitle: `Watching` });
};
export const getEdit = (req, res) => {
  const { id } = req.params;
  return res.render("edit", { pageTitle: `Editing` });
};
export const postEdit = (req, res) => {
  const { id } = req.params;
  const { title } = req.body;
  return res.redirect(`/Menus/${id}`);
};

export const getUpload = (req, res) => {
  return res.render("upload", { pageTitle: "Upload Menu" });
};

export const postUpload = (req, res) => {
  const { title } = req.body;
  return res.redirect("/");
};
