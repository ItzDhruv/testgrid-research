package room;


import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Room {

    String roomId;
    Set<ClientHandler> members = ConcurrentHashMap.newKeySet();

    public Room(String roomId) {
        this.roomId = roomId;
    }

    public void join(ClientHandler client) {
        members.add(client);
    }

    public void leave(ClientHandler client) {
        members.remove(client);
    }

    public void broadcast(String sender, String message) {
        for (ClientHandler member : members) {
            member.sendMessage(sender, message);
        }
    }
}

