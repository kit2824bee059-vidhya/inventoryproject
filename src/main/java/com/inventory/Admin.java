package com.inventory;

public class Admin extends User {
    public Admin(int id, String name) { super(id, name); }

    @Override
    public String getRole() { return "Admin"; }

    public void addItem(StockManagement sm, StockItem item) {
        sm.addItem(item);
        System.out.println(getName() + " added item: " + item.getName());
    }

    public void removeItem(StockManagement sm, int itemId) {
        if (sm.removeItem(itemId)) {
            System.out.println(getName() + " removed item #" + itemId);
        } else {
            System.out.println("Item #" + itemId + " not found.");
        }
    }

    public void setThreshold(StockManagement sm, int itemId, int threshold) {
        StockItem item = sm.findItem(itemId);
        if (item != null) {
            item.setThreshold(threshold);
            sm.checkAlert(item);
        }
    }
}
