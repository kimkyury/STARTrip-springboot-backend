import express from "express";
import {
  watch,
  getEdit,
  getUpload,
  postEdit,
  postUpload,
} from "../controllers/menuController";

const menuRouter = express.Router();

menuRouter.get("/:id(\\d+)", watch);
menuRouter.route("/:id(\\d+)/edit").get(getEdit).post(postEdit);
menuRouter.route("/upload").get(getUpload).post(postUpload);

export default menuRouter;
