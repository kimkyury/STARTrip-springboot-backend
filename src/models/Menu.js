import mongoose from "mongoose";

const menuSchema = new mongoose.Schema({
  title: { type: String, required: true, trim: true, maxLength: 80 },
  description: { type: String, required: true, trim: true, minLength: 20 },
  createdAt: { type: Date, required: true, default: Date.now },
  ingredients: [{ type: String, trim: true }],
  meta: {
    views: { type: Number, default: 0, required: true },
    rating: { type: Number, default: 0, required: true },
  },

  /* 비디오, 사진, 여양성분, 알레르기 가져와야함 */
});

menuSchema.static("formatIngredients", function (ingredients) {
  return ingredients
    .split(",")
    .map((word) => (word.startsWith("#") ? word : `#${word}`));
});

const Menu = mongoose.model("Menu", menuSchema);

export default Menu;
