package ananyac.hw4;

public class Chicken extends Creature {

    public Chicken(String name, String desc){
        super(name, desc);
    }

    @Override
    public void act() {
        Level.Room next = getCurrentRoom().getRandomNeighbor();
        if(next != null){
            System.out.println(this.name+" -moving from " +currentRoom.getName()+" to "+ next.getName());
            this.moveToNeighboringRoom(next.getName());
        }
    }

    @Override
    public Level.Room chooseNextRoom() {
        return getCurrentRoom().getRandomNeighbor();
    }
}
