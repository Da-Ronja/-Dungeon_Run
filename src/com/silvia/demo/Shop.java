package com.silvia.demo;

import com.silvia.demo.display.PrintColor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Shop extends Item {
    static final List<Shop> weaponShopList = new ArrayList<>();
    public static final List<Shop> potionShopList = new ArrayList<>();
    protected static boolean inShop = true;
    private Shop(String itemName, int itemValue, int itemPrice) {
        super(itemName, itemValue, itemPrice);
    }

    public static void initShopList() {
        generateItemLists(Item.weaponList, Shop.weaponShopList);
        generateItemLists(Item.potionList, Shop.potionShopList);
    }

    private static void generateItemLists(List<Item> itemList, List<Shop> shopList) {
    boolean correct = false;

        do {
            if (shopList.isEmpty()){

                for (Item item : itemList) {
                        shopList.add( new Shop(item.getItemName(), item.getItemValue(), item.getItemPrice()));

                }
            } else if (itemList.size() != shopList.size()) {
                shopList.clear();

                System.out.println("Something went wrong. Enter any key or restart game!");
                UserInput.continueGame();

            }  else {

                correct = true;
            }

        } while (!correct);

        shopList.removeIf(item -> Objects.equals(item.getItemName(), "Hands"));
        if (shopList == weaponShopList) {
            shopList.add( new Shop("Anti Virus", 100, 500));
        }
        sortShopByValue(shopList);
    }

    public static void sortShopByValue(List<Shop> itemList) {
        itemList.sort(Comparator.comparing(Shop::getItemValue));
    }

    public static void selectItem( int itemIndex, List<Shop> shopList) {

        if (Game.player.getGold() < shopList.get(itemIndex).getItemPrice()) {

            System.out.printf("%sYou don't have enough gold! %s\n", PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_RESET);
        } else {
            Menu.displayYesNoMenu(Menu.getWantToBuyText());
            System.out.printf("%s " + shopList.get(itemIndex) + "%s\n", PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_RESET);

            switch (UserInput.yesNo()) {
                case "Y" -> {

                    System.out.printf(transaction(shopList.get(itemIndex)), PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_RESET);
                    UserInput.continueGame();
                }
                case "N" ->
                        System.out.println("Naah, don't want to!");
                default -> System.out.println("Something went wrong!");
            }
        }
    }

    public static String transaction(Shop item) {

        Game.player.setGold(Game.player.getGold() - item.getItemPrice());
        GameItem gameItem = new GameItem(item.getItemName(), item.getItemValue());
        GameItem.addToInventory(gameItem);

        return "%sYou bought " + item.getItemName() + " for " + item.getItemPrice() + " gold!%s\n";
    }

}
