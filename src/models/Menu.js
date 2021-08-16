import mongoose from "mongoose";

const nutrientsSchema = new mongoose.Schema({
  calories: { type: String, required: true },
  totalCarbohydrate: { type: String, required: true },
  totalSugars: { type: String, required: true },
  protein: { type: String, required: true },
  totalFat: { type: String, required: true },
  SaturatedFat: { type: String, required: true },
  transFat: { type: String, required: true },
  cholesterol: { type: String, required: true },
  sodium: { type: String, required: true },
});

const menuSchema = new mongoose.Schema({
  title: { type: String, required: true, trim: true, maxLength: 20 },
  videoUrl: { type: String, required: true },
  imgUrl: { type: String, required: true },
  description: { type: String, required: true, trim: true, maxLength: 40 },
  ingredients: [{ type: String, trim: true }],
  ingredients: [{ type: String, trim: true }],
  allergies: [{ type: String, trim: true }],
  nutrients: nutrientsSchema,
});

menuSchema.static("formatIngredients", function (allergies) {
  return allergies
    .split(",")
    .map((word) => (word.startsWith("#") ? word : `#${word}`));
});

const Menu = mongoose.model("Menu", menuSchema);

export default Menu;
