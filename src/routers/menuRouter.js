import express from "express";
import {
  watch,
  getUpload,
  getEdit,
  postEdit,
  postUpload,
  deleteMenu,
} from "../controllers/menuController";

const menuRouter = express.Router();

menuRouter.get("/:id([0-9a-f]{24})", watch);
menuRouter.route("/:id([0-9a-f]{24})/edit").get(getEdit).post(postEdit);
menuRouter.route("/:id([0-9a-f]{24})/delete").get(deleteMenu);
menuRouter.route("/upload").get(getUpload).post(postUpload);

export default menuRouter;
