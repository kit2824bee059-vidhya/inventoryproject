package com.inventory;

public class ShopStaff extends User {
    public ShopStaff(int id, String name) { super(id, name); }

    @Override
    public String getRole() { return "ShopStaff"; }

    public void sellItem(StockManagement sm, int itemId, int qty) {
        sm.reduceStock(itemId, qty);
    }

    public void receiveStock(StockManagement sm, int itemId, int qty) {
        sm.addStock(itemId, qty);
    }
}
