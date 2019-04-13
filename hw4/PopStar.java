package ananyac.hw4;

public class PopStar extends Creature {


    private Player player;

    public PopStar(String name, String desc){
        super(name, desc);
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public Level.Room chooseNextRoom() {
        return lookForPlayer();
    }

    private Level.Room lookForPlayer() {
        return player.getCurrentRoom();
    }

    public void act(Player player){
        this.player = player;
        act();
    }

}
