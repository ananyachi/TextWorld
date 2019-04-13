package ananyac.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Level {
    // private List<Room> rooms;
    private HashMap<String, Room> rooms;
    private ArrayList<Creature> creatures;
    private Player player;





    public Level() {
        rooms = new HashMap<String, Room>();
        creatures = new ArrayList<Creature>();
    }

    public void addRoom(String name, String description) {
        if (getRoom(name) != null) {
            System.out.println(name + " already exists");
        } else {
            Room room = new Room(name);
            room.setDescription(description);
            this.rooms.put(name, room);
        }

    }

    public void addDirectedEdge(String name1, String name2) {
        Room n1 = getRoom(name1);
        Room n2 = getRoom(name2);
        n1.addNeighbor(n2);

    }

    public void addUndirectedEdge(String name1, String name2) {
        Room n1 = getRoom(name1);
        Room n2 = getRoom(name2);
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

    public Room getRoom(String name) {

        Room n = rooms.get(name);
        return n;
    }

    public void addRandomChickens(int n){
        for (int i = 0; i < n; i++) {
            Chicken chicken = new Chicken("chicken" + i, "I am a chicken");
            creatures.add(chicken);
        }
    }
    public Level.Room getRandomRoom() {
        Random random =  new Random();
        Object[] keySetArray = rooms.keySet().toArray();
        Object key = keySetArray[random.nextInt(keySetArray.length)];
        return rooms.get(key);
    }
    public void updateAllCreatures(){
        for (Creature c: creatures ){
            c.act();
        }
    }
    private Player getPlayer(){
        return this.player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addCreature(Creature c) {
        creatures.add(c);
    }

    public class Room {
        private String name;
        private HashMap<String, Room> neighbors;
        private String description;
        ArrayList<Item> items;


        public Room(String name) {
            neighbors = new HashMap<String, Room>();
            this.name = name;
            items = new ArrayList<>();
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


        public void addNeighbor(Room n) {
            //add nieghbor
            getNeighbors().put(n.getName(), n);
        }

        public String getNeighborNames() {
            //returns a string of all the names of the neighbors of this node
            String resultStr = "";
            for (String name : this.getNeighbors().keySet()) {
                resultStr += name + ", ";
            }
            return resultStr;
        }

        public HashMap<String, Room> getNeighbors() {
            return neighbors;
        }

        public Room getNeighbor(String name) {
            //return neighboring node whose name is name; return null otherwise
            Room n = neighbors.get(name);
            return n;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void addItem(Item item) {
            getItems().add(item);
        }

        public Item removeItem(String name) {
            for (Item i : items) {
                if (i.getName().equals(name)) {
                    items.remove(i);
                    return i;
                } else {
                    System.out.println("item" + name + "does not exist");

                }
            }
            return null;
        }

        public Room getRandomNeighbor() {
            Random random =  new Random();
            Object[] keySetArray = neighbors.keySet().toArray();
            Object key = keySetArray[random.nextInt(keySetArray.length)];
            return neighbors.get(key);
        }
    }
}


