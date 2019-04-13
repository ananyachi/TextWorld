package ananyac.hw4;

import java.util.ArrayList;

public class Player {
    String name;
    String description;
    ArrayList<Item> items;
    Level.Room currentRoom;


    public Player(String name, String description) {
     this.name= name;
     this.description = description;
     items = new ArrayList<>();
    }

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Level.Room newRoom) {
        this.currentRoom = newRoom;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String name) {
        for(Item i : items){
            if (i.getName().equals(name)){
                items.remove(i);
                return i;
            }else{
                System.out.println("item" + name+ "does not exist");
            }
        }
        return null;

    }

    public ArrayList<Item> getItems() {
        return items;
    }



}
