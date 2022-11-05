package com.silvia.demo;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GameItem  extends Item {
    private int amount = 0;

    public GameItem(String itemName, int itemValue, int amount) {
        super(itemName, itemValue);
        setAmount(amount);
    }

    public GameItem(String itemName, int itemValue) {
        super(itemName, itemValue);

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "GameItem{" +
                "amount=" + amount +
                "} " + super.toString();
    }

    public static void sortItemByValue(List<GameItem> itemList) {
        itemList.sort(Comparator.comparing(GameItem::getItemValue));
    }

    protected static void generateDropList(GameItem weapon, List<GameItem> dropList) {

        int amountOFItems = potionList.size() + goldList.size() + 1;

        do {
            if (dropList.isEmpty()){

                dropList.add( new GameItem(weapon.getItemName(), weapon.getItemValue()));

                for (Item item : potionList) {
                    dropList.add( new GameItem(item.getItemName(), item.getItemValue() ));
                }
                for (Item item : goldList) {
                    dropList.add( new GameItem(item.getItemName(), item.getItemValue() ));
                }
            } else if (dropList.size() == 1) {
                dropList.set(0, new GameItem(weapon.getItemName(), weapon.getItemValue()));

                for (Item item : potionList) {
                    dropList.add( new GameItem(item.getItemName(), item.getItemValue() ));
                }
                for (Item item : goldList) {
                    dropList.add( new GameItem(item.getItemName(), item.getItemValue() ));
                }
            } else {

                if (dropList.size() != amountOFItems) {
                    System.out.println("dropList does not have right amount! " +
                            "\ndropList is " + dropList.size() + " and should be " + amountOFItems);
                    break;
                }

                dropList.set(0, new GameItem(weapon.getItemName(), weapon.getItemValue()));
            }
        } while (dropList.size() != amountOFItems);
    }

    protected static GameItem monsterDropItem(List<GameItem> dropList) {
        int index;

        do {
            index = (int)(Math.random() * dropList.size());

        } while (dropList.get(index).getItemName().contains("Hands"));


        return dropList.get(index);
    }

    private static String getItemForInventory(GameItem item) {
        String itemGroup = "";

        for (Item gold: Item.goldList) {
            if (Objects.equals(gold.getItemName(), item.getItemName()) && gold.getItemValue() == item.getItemValue()) {
                itemGroup = "Gold";

                return itemGroup;
            }
        }
        for (Item potion: Item.potionList) {
            if (Objects.equals(potion.getItemName(), item.getItemName()) && potion.getItemValue() == item.getItemValue()) {
                itemGroup = "Potion";

                return itemGroup;
            }
        }
        for (Item weapon: Item.weaponList) {
            if (Objects.equals(weapon.getItemName(), item.getItemName()) && weapon.getItemValue() == item.getItemValue()) {
                itemGroup = "Weapon";

                return itemGroup;
            }
        }

        return itemGroup;
    }

    protected static void addToInventory(GameItem item) {
        boolean contains;
        Player player = Game.player;

        switch (getItemForInventory(item)) {
            case "Gold" -> ifGold(item, player);
            case "Potion" -> {
                contains = ifInventoryContains(item, player.getPotionList());

                if (!contains) {
                    player.getPotionList().add(new GameItem(item.getItemName(), item.getItemValue(), 1));
                }
            }
            case "Weapon" -> {
                contains = ifInventoryContains(item, player.getWeaponList());

                if (!contains) {
                    player.getWeaponList().add(new GameItem(item.getItemName(), item.getItemValue(), 1));
                }

            }

            default -> System.out.println("It went wrong. You got nothing");
        }

    }

    private static boolean ifInventoryContains(GameItem item, List<GameItem> list){
        boolean contains = true;


        if (list.isEmpty()) {
            list.add( new GameItem(item.getItemName(), item.getItemValue(), 1));
        } else {
            for (GameItem listItem : list) {
                if (Objects.equals(listItem.getItemValue() , item.getItemValue())) {
                    listItem.setAmount(listItem.getAmount() + 1);
                    contains = true;

                      break;
                } else {
                    contains = false;
                }
            }
        }

        return contains;
    }

    private static void ifGold(GameItem item, Player player) {

        player.setGold(player.getGold() + item.getItemValue());
    }

    protected static void selectItem(int itemIndex, List<GameItem> list) {
        Player player = Game.player;
        int pickedIndex = itemIndex - 1;

        if (list == player.getWeaponList()) {
            GameItem weaponItem = player.getWeaponList().get(pickedIndex);

            if (player.getWeapon().getItemName().equals("Hands")) {

                player.setWeapon(weaponItem);
                removeFromAmount(weaponItem);

            } else if (player.getWeapon().equals(weaponItem)) {

                System.out.println("You are already holding " + weaponItem);
            } else {

                addToInventory(player.getWeapon());
                player.setWeapon(weaponItem);
                removeFromAmount(weaponItem);
            }

            if (weaponItem.getAmount() == 0) {
                if (!Objects.equals(weaponItem.getItemName(), "Hands")) {
                    removeItemFromList(list, weaponItem);
                }
            }


        } else if (list == player.getPotionList()) {
            GameItem potionItem = player.getPotionList().get(pickedIndex);

            usePotion(player, potionItem, list);
        }
    }

    private static void usePotion(Player player, GameItem potionItem, List<GameItem> list) {

        if (player.getHealth() < player.getMaxHealth()) {

            player.gainHealthParam(potionItem.getItemValue());
            removeFromAmount(potionItem);

            if (potionItem.getAmount() == 0) {

                removeItemFromList(list, potionItem);
            }
        } else {

            System.out.println("\nYou have full health. \nYou can not choose any more Health Potions!\n ");
        }
    }

    private static void removeFromAmount(GameItem item) {
        item.setAmount(item.getAmount() - 1);

    }

    private static void removeItemFromList(List<GameItem> list, GameItem item) {

        list.remove(item);
    }

}
