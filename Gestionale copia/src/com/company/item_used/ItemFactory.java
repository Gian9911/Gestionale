package com.company.item_used;

public class ItemFactory implements Factory {
    @Override
    public Item getItem(String item) {
        if(item == null)
            return null;
        if(item.equalsIgnoreCase("UI")){
            return new ItemUnitPrice(1);
        }else if(item.equalsIgnoreCase("CI")){
            return new ItemComplessivePrice(1);
        }
        return null;
    }
}
