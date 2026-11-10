package com.inventory;

public class Main {
    public static void main(String[] args) {
        StockManagement sm = new StockManagement();
        Admin admin = new Admin(1, "Vidhya");
        ShopStaff staff = new ShopStaff(2, "Ravi");

        System.out.println(admin);
        System.out.println(staff);
        System.out.println();

        admin.addItem(sm, new StockItem(101, "Rice 1kg", 50, 10));
        admin.addItem(sm, new StockItem(102, "Sugar 1kg", 30, 8));
        admin.addItem(sm, new StockItem(103, "Milk 1L", 12, 5));
        System.out.println();
        sm.printStock();
        System.out.println();

        staff.sellItem(sm, 101, 20);
        staff.sellItem(sm, 103, 8);   // drops below threshold -> alert
        staff.sellItem(sm, 102, 25);  // drops below threshold -> alert
        System.out.println();

        staff.receiveStock(sm, 103, 30);
        System.out.println();
        sm.printStock();

        System.out.println("\nTotal alerts raised: " + sm.getAlerts().size());
    }
}
