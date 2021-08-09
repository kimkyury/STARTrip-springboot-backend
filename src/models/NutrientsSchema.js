const videoSchema = new mongoose.Schema({
  menuName: String,
  description: String,
  createdAt: Date,
  /* 영상 가져와야함 */
});

const imgSchema = new mongoose.Schema({
  menuName: String,
  description: String,
  createdAt: Date,
  /* png,jpg,jpeg 등 가져와야함 */
});

const NutrientsSchema = new mongoose.Schema({
  kcal: Number,
  carbo: Number,
  sugar: Number,
  protein: Number,
  fat: Number,
  s_fat: Number,
  t_fat: Number,
  chol: Number,
  sodium: Number,
});

const AllergySchema = new mongoose.Schema({
  /* 알레르기 24가지에 대한 bool로 가져와야함 */
});
