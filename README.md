# Inventory Stock Alert System (Public Distribution Area)

A Java-based platform that monitors ration stock levels and generates automated low-stock alerts for public distribution shops.

**Course:** Object-Oriented Programming in Java 

**Department:** Electrical and Electronics Engineering

**Institution:** Kalaignarkarunanidhi Institute of Technology

**Guide:** Ms.Mahalakshmi

## Team

| Name | Roll No. |
|------|----------|
| Semmalai S | 711524BEE052 |
| Subash | 711524BEE055 |
| Vidhya K | 711524BEE059 |

## Problem Statement

- Manual stock registers are maintained at every shop
- Shortages are noticed only after beneficiaries are turned away
- Errors occur in manual balance calculation
- Supervisors have no real-time visibility
- Report preparation is time-consuming

## Proposed Solution

- Centralized Java application for shop staff and supervisors
- Daily stock issued / received entry per commodity
- Automatic remaining-stock calculation
- Threshold-based low-stock alert generation
- Stored history and reports for replenishment decisions

## Objectives

1. Develop a user-friendly stock alert system for distribution shops
2. Automate low-stock detection and alert generation
3. Maintain commodity-wise stock records for each shop (rice, wheat, sugar, kerosene)
4. Calculate and update remaining stock accurately
5. Reduce shortages and manual monitoring effort
6. Implement OOP concepts using Java

## Technology Stack

| Component | Technology |
|-----------|------------|
| Language | Java |
| Interface | Java Swing |
| Database | MySQL (JDBC) |
| Concepts | OOP: classes, inheritance, encapsulation, polymorphism, abstraction |
| IDE | Eclipse / IntelliJ IDEA / NetBeans |

## System Architecture

1. **User Interface:** Java Swing screens for login, stock entry, alerts and reports
2. **Java Application Logic:** user roles, validation and session handling
3. **Stock Alert Module:** balance update, threshold check, alert generation
4. **Database / File Storage:** MySQL tables via JDBC for shops, stock and alerts

## Modules

**Admin Module**
- Admin login
- Add / update / delete shops
- Set alert thresholds
- View all stock alerts
- Generate stock reports

**Shop Module**
- Shop staff login
- View commodity stock
- Update stock issued / received
- View low-stock alerts
- Check stock history

**Stock Management**
- Commodity selection
- Stock quantity entry
- Threshold validation
- Alert status update
- History maintenance

**Report Module**
- Shop-wise stock report
- Low-stock alert report
- Commodity-wise report

## System Workflow

1. Shop staff login
2. View current stock
3. Enter stock issued / received
4. System updates balance
5. System checks threshold
6. Alert generated if low
7. Supervisor reviews alert
8. Replenishment initiated

## OOP Concepts Used

| Concept | Application | Classes |
|---------|-------------|---------|
| Encapsulation | Private fields with getters / setters | StockItem, Shop |
| Inheritance | Admin and ShopStaff extend User | User → Admin, ShopStaff |
| Polymorphism | Role-specific overridden operations | Admin, ShopStaff |
| Abstraction | Threshold and alert logic hidden behind methods | StockManagement |
| Classes & Objects | Core entities instantiated at runtime | Shop, Commodity, StockEntry, Alert |

## Class Design

- **User:** userId, name, username, password, login()
- **ShopStaff (extends User):** shopId, shopName, location, updateStock(), viewStockHistory()
- **Admin (extends User):** manageShops(), setThreshold(), viewAllAlerts(), generateReports()
- **StockItem:** stockId, commodityName, quantity, thresholdLevel, lastUpdated
- **StockManagement:** updateStock(), checkThreshold(), generateAlert(), viewStockHistory()
- **Alert:** alertId, shopId, commodityName, status

## Database Design

**Shop table**

| Field | Description |
|-------|-------------|
| shop_id (PK) | Unique shop ID |
| shop_name | Shop name |
| location | Shop location |
| username | Login username |
| password | Login password |

**Stock table**

| Field | Description |
|-------|-------------|
| stock_id (PK) | Unique stock entry ID |
| shop_id (FK) | Shop reference |
| commodity_name | Rice / Wheat / Sugar / Kerosene |
| quantity_available | Current stock quantity |
| threshold_level | Minimum stock before alert |
| last_updated | Date of last update |

One shop has many stock entries (1:N). Alerts are derived by comparing `quantity_available` with `threshold_level`.

## Core Alert Logic (Java)

```java
public class StockManagement {

    public boolean checkThreshold(StockItem item) {
        return item.getQuantity() < item.getThresholdLevel();
    }

    public void updateStock(StockItem item, int issued) {
        item.setQuantity(item.getQuantity() - issued);
        item.setLastUpdated(LocalDate.now());
        if (checkThreshold(item)) {
            generateAlert(item);
        }
    }

    public void generateAlert(StockItem item) {
        Alert alert = new Alert(item.getShopId(),
                item.getCommodityName(), item.getQuantity());
        alertDao.save(alert);
    }
}
```

## Test Cases

| ID | Scenario | Input | Expected Result |
|----|----------|-------|-----------------|
| T1 | Valid shop staff login | Correct username and password | Dashboard opens for shop staff |
| T2 | Invalid login | Wrong password | Error message; access denied |
| T3 | Stock issue within balance | Rice 120 kg, issue 40 kg | Balance updated to 80 kg |
| T4 | Stock falls below threshold | Balance 80 kg, threshold 100 kg | Low-stock alert generated |
| T5 | Issue more than available | Issue 500 kg from 80 kg | Rejected with validation message |
| T6 | Supervisor views alerts | Admin login, open alerts | All low-stock alerts listed shop-wise |
| T7 | Stock history | Open history for a commodity | Previous updates shown with dates |

## Key Outcomes

- **Automated alerts:** low stock is detected the moment a balance crosses the threshold
- **Accurate balances:** stock is recalculated on every update
- **Central visibility:** supervisors monitor all shops and commodities in one view
- **Reliable records:** stock history and reports are stored and easy to retrieve

## Limitations

- Alerts are shown inside the application only
- Desktop application, no mobile access
- No link to the ration card database

## Future Enhancements

- SMS & Email notifications
- Mobile application
- Ration card integration
- Demand forecasting
- Online deployment (cloud-based multi-shop dashboard)
- Role-based access control

## Conclusion

The Inventory Stock Alert System provides a simple, efficient and automated way to monitor public distribution stock levels and prevent shortages before beneficiaries are affected. Built with Java and Object-Oriented Programming concepts, the project demonstrates practical software development skills while solving a real public distribution problem.
