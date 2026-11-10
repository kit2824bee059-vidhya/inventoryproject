package com.inventory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StockManagement {
    private final Map<Integer, StockItem> items = new LinkedHashMap<>();
    private final List<Alert> alerts = new ArrayList<>();

    public void addItem(StockItem item) {
        items.put(item.getId(), item);
        checkAlert(item);
    }

    public boolean removeItem(int id) {
        return items.remove(id) != null;
    }

    public StockItem findItem(int id) {
        return items.get(id);
    }

    public void addStock(int id, int qty) {
        StockItem item = require(id);
        item.increase(qty);
        System.out.println("Received " + qty + " x " + item.getName());
    }

    public void reduceStock(int id, int qty) {
        StockItem item = require(id);
        item.decrease(qty);
        System.out.println("Sold " + qty + " x " + item.getName());
        checkAlert(item);
    }

    // Alert logic: raise an alert when quantity <= threshold
    public void checkAlert(StockItem item) {
        if (item.isLowStock()) {
            Alert alert = new Alert(item);
            alerts.add(alert);
            System.out.println("  >> " + alert);
        }
    }

    public List<Alert> getAlerts() { return alerts; }

    public void printStock() {
        System.out.println("--- Current Stock ---");
        items.values().forEach(System.out::println);
    }

    private StockItem require(int id) {
        StockItem item = items.get(id);
        if (item == null) throw new IllegalArgumentException("Item #" + id + " not found");
        return item;
    }
}
