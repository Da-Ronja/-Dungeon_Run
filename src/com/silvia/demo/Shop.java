package com.silvia.test;
import com.silvia.test.item.IItems;
import com.silvia.test.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Item implements IItems {

    List<Shop> weaponList = new ArrayList<>();
    List<Shop> potionList = new ArrayList<>();


    protected Shop(String itemName, int itemValue, int itemPrice) {
        super(itemName, itemValue, itemPrice);
    }

    @Override
    public void generateItemList() {
        for (Item item : Item.weaponList) {
            weaponList.add( new Shop(item.getItemName(), item.getItemValue(), getItemPrice()));
        }
        for (Item item : Item.potionList) {
            potionList.add( new Shop(item.getItemName(), item.getItemValue(), getItemPrice()));
        }
    }

    @Override
    public void pickItem() {
        System.out.println("Pick Item in Shop");
    }
}
