import mongoose from "mongoose";

const menuSchema = new mongoose.Schema({
  videoUrl: { type: String, required: true },
  imgUrl: { type: String, required: true },

  title: { type: String, required: true, trim: true, maxLength: 20 },
  description: { type: String, required: true, trim: true, maxLength: 40 },
  ingredients: [{ type: String, trim: true }],
  allergies: [{ type: String, trim: true }],

  nt_calories: { type: String, required: true },
  nt_totalCarbohydrate: { type: String, required: true },
  nt_totalSugars: { type: String, required: true },
  nt_protein: { type: String, required: true },
  nt_totalFat: { type: String, required: true },
  nt_SaturatedFat: { type: String, required: true },
  nt_transFat: { type: String, required: true },
  nt_cholesterol: { type: String, required: true },
  nt_sodium: { type: String, required: true },
});

menuSchema.static("formatIngredients", function (allergies) {
  return allergies
    .split(",")
    .map((word) => (word.startsWith("#") ? word : `#${word}`));
});

const Menu = mongoose.model("Menu", menuSchema);

export default Menu;
