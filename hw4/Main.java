package ananyac.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Level g = new Level();

        Item item1 = new Item("ball1", "red");
        Item item2 = new Item("ball2", "blue");
        Item item3 = new Item("ball3", "yellow");
        Item item4 = new Item("ball4", "green");


        g.addRoom("hall", "a long, dank hallway");
        g.addRoom("closet", " a dark, dark closet");
        g.addRoom("dungeon", "a cold dungeon");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");

        Level.Room current = g.getRoom("hall");
        current.addItem(item1);
        current.addItem(item2);
        current.addItem(item3);
        current.addItem(item4);

        Player player = new Player("playerName", "playerDescription");
        player.setCurrentRoom(current);

        String response = "";
        Scanner s = new Scanner(System.in);
        //display all the commands they can type so they know what to do

        do {
            System.out.println("you are in the " + current.getName());
            System.out.println("What do you want to do? > ");
            response = s.nextLine();
            String[] words = response.split(" ");
            String firstWord = words[0];

            if (firstWord.equals("go")) {
                if (words.length < 2) {
                    System.out.println("Command is: go <roomname>");
                } else if (g.getRoom(words[1]) == null) {
                    System.out.println(("room " + words[1] + " does not exist"));
                } else {

                    Level.Room newRoom = g.getRoom(words[1]);

                    String neighbors = player.getCurrentRoom().getNeighborNames();
                    String[] roomNames = neighbors.split(",");
                    for (String room : roomNames) {
                        if (room.equals(newRoom.getName())) {
                            player.setCurrentRoom(newRoom);
                            break;

                        }


                    }
                    if (!player.getCurrentRoom().getName().equals(newRoom.getName())) {

                        System.out.println("Room" + newRoom + "is not a neighbor");
                    }
                    g.addRandomChickens(5);
                    g.addCreature(new PopStar("ps1", "popstar"));
                    g.addCreature(new Wumpus("wum1" , "wumpus"));
                    g.setPlayer(player);

                }


            } else if (firstWord.equals("look")) {
                for (Item i : player.getCurrentRoom().getItems()) {
                    System.out.println(i.getName());
                }


                HashMap<String, Level.Room> neighbors = current.getNeighbors();
                String message = "";
                for (String name : neighbors.keySet()) {
                    Level.Room n = neighbors.get(name);
                    message = message + name + " (" + n.getDescription() + ") ";

                }
                System.out.println("You can exit to " + message);

            } else if (firstWord.equals("add")) {
                if (words.length < 4) {
                    System.out.println("Command is: add room <roomname> <description>");
                } else {
                    String name = words[2];
                    String description = "";
                    for (int i = 3; i < words.length; i++) {
                        if (i < words.length - 1) {
                            description += words[i] + " ";

                        } else {
                            description += words[i];
                        }
                    }
                    g.addRoom(name, description);
                    g.addDirectedEdge(current.getName(), name);
                }

            } else if (firstWord.equals("quit")) {
                break;
            } else if (firstWord.equals("take")) {
                String item = words[1];
                Item removedFromRoom = current.removeItem(item);
                player.addItem(removedFromRoom);


            } else if (firstWord.equals("drop")) {
                String itemDropped = words[1];
                Item removedFromPlayer = player.removeItem(itemDropped);
                current.addItem(removedFromPlayer);

            } else {
                System.out.println("commands are: go <roomname>, add room <roomname>, look, quit");

            }
        } while (!response.equals("quit"));

    }
}
