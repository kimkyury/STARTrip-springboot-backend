import express from "express";
import { home, search } from "../controllers/menuController";

const globalRouter = express.Router();

globalRouter.get("/", home);

export default globalRouter;
