import express from "express";

const PORT = 5000;
const app = express();
const handleListening = () =>
  console.log(`✅ DBDIP-ARDish, SERVER OPEN🚀  http://localhost:${PORT} `);

app.listen(PORT, handleListening);
