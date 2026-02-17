// Emit => Send a message to the client
// On => Listen for a message from the client
// Bind => to reserve a port or ip for socket in socket.io const io = new Server(2000,{ cors: { origin: "*" } }); its internally bind 2000 port



const { Server } = require("socket.io");

const io = new Server(2000,{ cors: { origin: "*" } });

io.on("connection", (socket) => {
  console.log("a user connected");

  socket.on("message", (data) => { 
    socket.emit("message", "Hello from the server!");
    console.log("Server received message:", data);
  });
  
  socket.on("text", (data) => {
    console.log("Server received text (" + socket.id + ") : " + data);
    // io.emit("chatstream", data, socket.id);             //  To stream the message to all the clients including the sender
    socket.broadcast.emit("chatstream", data, socket.id);  // To stream the message to all the clients except the sender

  });

  socket.on("disconnect", () => {
    console.log("a user disconnected");
  });

  socket.on("enterRoom", (data) => {
    console.log("Received request to enter room:", data);
    socket.join("Room-1");
    socket.emit("Room1", "Welcome to Room-1! Your Socket ID is: " + socket.id);
  });

  io.to(socket.id).emit("dailyNews", "Server maybe shutting down Today!"); // To send message to all the clients in the room

});


io.on("disconnect", () => {
  console.log("a user disconnected");
});
