package ananyac.hw4;

import java.util.HashMap;

public abstract class Creature {
    String name;
    String description;
    HashMap<String, Item> items;
    Level.Room currentRoom;

    public Creature(String name, String desc){
        this.name = name;
        this.description = desc;
    }
    public void act(){
        move();
    }

    private void move() {
        Level.Room next = chooseNextRoom();
        if(next != null ){
            moveToRoom(next);
        }
    }

    public abstract Level.Room chooseNextRoom();

    public boolean moveToRoom(Level.Room next) {
        if(next != null){
            currentRoom = next;
            return true;
        }
        return false;
    }


    public boolean moveToNeighboringRoom(String name){
        Level.Room neighbor = currentRoom.getNeighbor(name);

        if(neighbor != null){
            System.out.println(this.name+ " - moving from  " + currentRoom.getName() + " to " + neighbor.getName());
            currentRoom = neighbor;
            return true;
        }
        return false;
    }

    public Level.Room getCurrentRoom(){
        return currentRoom;
    }
}
