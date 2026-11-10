package com.inventory;

public class StockItem {
    private final int id;
    private final String name;
    private int quantity;
    private int threshold;

    public StockItem(int id, String name, int quantity, int threshold) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.threshold = threshold;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getThreshold() { return threshold; }
    public void setThreshold(int threshold) { this.threshold = threshold; }

    public void increase(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be positive");
        quantity += qty;
    }

    public void decrease(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (qty > quantity) throw new IllegalArgumentException("Not enough stock for " + name);
        quantity -= qty;
    }

    public boolean isLowStock() {
        return quantity <= threshold;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-15s qty=%-5d threshold=%-5d %s",
                id, name, quantity, threshold, isLowStock() ? "[LOW]" : "[OK]");
    }
}
