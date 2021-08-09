import express from "express";
import { home, search } from "../controllers/menuController";

const rootRouter = express.Router();

rootRouter.get("/", home);

export default rootRouter;
