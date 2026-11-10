package com.inventory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Alert {
    private final StockItem item;
    private final LocalDateTime time = LocalDateTime.now();

    public Alert(StockItem item) { this.item = item; }

    public String getMessage() {
        return "LOW STOCK: " + item.getName() + " has only " + item.getQuantity()
                + " left (threshold " + item.getThreshold() + ")";
    }

    @Override
    public String toString() {
        return "[" + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "] " + getMessage();
    }
}
