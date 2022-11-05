package com.silvia.demo;

import java.util.List;

public class Item {
    private String itemName;
    private int itemValue, itemPrice;

    // FOR SHOP
    protected Item(String itemName, int itemValue, int itemPrice) {
        setItemName(itemName);
        setItemValue(itemValue);
        setItemPrice(itemPrice);
    }
    // FOR INVENTORY
    protected Item(String itemName, int itemValue) {
        setItemName(itemName);
        setItemValue(itemValue);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemValue() {
        return itemValue;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    protected static final List<Item> weaponList = List.of(  //Immutable collection MaxChars 12
            new Item("Hands", 0, 0),
            new Item("Dagger", 2, 5),
            new Item("Bow and arrow", 4, 10),
            new Item("Sword", 6, 15),
            new Item("Ice axe", 8, 20),
            new Item("Fireball", 10, 25)
    );

    protected static final List<Item> potionList = List.of(
            new Item("Health potion", 10, 10),
            new Item("Health potion", 20, 20),
            new Item("Health potion", 30, 30),
            new Item("Health potion", 50, 40)
    );

    protected static final List<Item> goldList = List.of(
            new Item("Gold pouch", 5),
            new Item("Gold pouch", 10),
            new Item("Gold pouch", 15),
            new Item("Gold pouch", 20)
    );

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemValue=" + itemValue +
                '}';
    }

}
