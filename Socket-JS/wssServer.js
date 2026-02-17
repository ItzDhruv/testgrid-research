const fs = require("fs");
const https = require("https");
const WebSocket = require("ws");

const server = https.createServer(
  {
    key: fs.readFileSync("key.pem"),
    cert: fs.readFileSync("cert.pem")
  },
  (req, res) => {
    // Send response to browser
    res.writeHead(200);
    res.end("WSS Server Running");
  }
);

const wss = new WebSocket.Server({ server });

wss.on("connection", (ws) => {

  console.log("Client connected");

  ws.on("message", (msg) => {
    console.log("Received:", msg.toString());

    ws.send("Server reply: " + msg);
  });

});

server.listen(3000, () => {
  console.log("WSS Server running on https://localhost:3000");
});
