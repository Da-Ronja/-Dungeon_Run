package com.silvia.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class WriteFileSystem {
    File myFile;

    public void createMyFile() {
        myFile = new File("myGameFile.txt");

        try {
            if (myFile.createNewFile()) {
                System.out.println("\nA file with your stats was created: " + myFile.getName());
            } else {
                System.out.println("\nYour stats file already exists");
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void writeMyFile(String fighterName, int killedMonsters, int level, List<GameItem> weaponList) {

        try {
            FileWriter myFileWriter = new FileWriter(myFile.getAbsolutePath());

            myFileWriter.write(fighterName + " killed " + killedMonsters + " and got to level " +
                    level + ".\n");

            if (weaponList.size() == 1) {
                myFileWriter.write("You died bear hands!");
            } else {

                myFileWriter.write("You died with ");

                for (GameItem item : weaponList) {

                    if (!Objects.equals(item.getItemName(), "Hands")) {
                        myFileWriter.write("\n" + item.getAmount() + " " + item.getItemName());
                    }
                }
                myFileWriter.write("\nin your weapon bag!");
            }

            myFileWriter.close();
        } catch (IOException error) {

            error.printStackTrace();
        }
    }
}
