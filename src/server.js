import express from "express";
import morgan from "morgan";
import globalRouter from "./routers/globalRouter";
import menuRouter from "./routers/menuRouter";

const app = express();
const logger = morgan("dev");

app.set("view engine", "pug");
app.set("views", process.cwd() + "/src/views");
app.use(logger);
app.use(express.urlencoded({ extended: true }));
app.use("/", globalRouter);
app.use("/menus", menuRouter);

export default app;
