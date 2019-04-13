package ananyac.hw4;

import java.util.HashMap;

public class Wumpus extends Creature {
    private Player player;

    public Wumpus(String name, String desc){
        super(name, desc);
    }

    @Override
    public void act() {
        super.act();

    }

    @Override
    public Level.Room chooseNextRoom() {
        Level.Room playerCurrentRoom = lookForPlayer();
        Level.Room returnRoom = null;
        if (playerCurrentRoom != null) {
            HashMap<String, Level.Room> neighbors = playerCurrentRoom.getNeighbors();
            //wumpus needs to move away from player
            //check all the neighbors of the current room that player is in and move to the first neighbor

            for (String name : neighbors.keySet()) {
                System.out.println(this.name + " - moving from " + currentRoom.getName() + " to " + name);
                this.moveToNeighboringRoom(name);
                returnRoom = neighbors.get(name);
                break;

            }
        }
        return returnRoom;
    }

    private Level.Room lookForPlayer() {
        return player.getCurrentRoom();
    }

    public void act(Player player){
        this.player = player;
        act();
    }
}
