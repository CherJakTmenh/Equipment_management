package demo;

import collection.EquipmentCollectionManager;
import model.Item;
import model.User;
import model.Request;
import java.util.*;

/**
 * CollectionDemo - Demonstrates the usage of EquipmentCollectionManager
 * with various Java collection operations
 */
public class CollectionDemo {
    
    public static void main(String[] args) {
        // Create collection manager
        EquipmentCollectionManager manager = new EquipmentCollectionManager();
        
        // Demonstrate the collection operations
        System.out.println("=== Equipment Management Collection Demo ===\n");
        
        // 1. Add sample items
        addSampleItems(manager);
        
        // 2. Add sample users
        addSampleUsers(manager);
        
        // 3. Add sample requests
        addSampleRequests(manager);
        
        // 4. Demonstrate various collection operations
        demonstrateItemOperations(manager);
        demonstrateUserOperations(manager);
        demonstrateRequestOperations(manager);
        
        // 5. Show collection statistics
        showStatistics(manager);
        
        // 6. Show audit log
        showAuditLog(manager);
    }
    
    /**
     * Add sample items to demonstrate ArrayList, HashMap, TreeSet, and HashSet
     */
    private static void addSampleItems(EquipmentCollectionManager manager) {
        System.out.println("1. Adding Sample Items:");
        
        // Add various items
        manager.addItem(new Item("ITEM001", "Laptop", 15, 1));
        manager.addItem(new Item("ITEM002", "Desktop Computer", 8, 1));
        manager.addItem(new Item("ITEM003", "Printer", 5, 2));
        manager.addItem(new Item("ITEM004", "Monitor", 20, 1));
        manager.addItem(new Item("ITEM005", "Keyboard", 25, 3));
        manager.addItem(new Item("ITEM006", "Mouse", 30, 3));
        manager.addItem(new Item("ITEM007", "Projector", 3, 2));
        manager.addItem(new Item("ITEM008", "Router", 12, 4));
        
        System.out.println("✓ Added 8 sample items\n");
    }
    
    /**
     * Add sample users to demonstrate TreeMap organization by department
     */
    private static void addSampleUsers(EquipmentCollectionManager manager) {
        System.out.println("2. Adding Sample Users:");
        
        // Add users from different departments
        manager.addUser(new User("USER001", "John Doe", "john@company.com", "Manager", "123-456-7890", "IT"));
        manager.addUser(new User("USER002", "Jane Smith", "jane@company.com", "Developer", "123-456-7891", "IT"));
        manager.addUser(new User("USER003", "Mike Johnson", "mike@company.com", "Analyst", "123-456-7892", "Finance"));
        manager.addUser(new User("USER004", "Sarah Wilson", "sarah@company.com", "Designer", "123-456-7893", "Marketing"));
        manager.addUser(new User("USER005", "David Brown", "david@company.com", "Accountant", "123-456-7894", "Finance"));
        manager.addUser(new User("USER006", "Lisa Davis", "lisa@company.com", "Developer", "123-456-7895", "IT"));
        
        System.out.println("✓ Added 6 sample users\n");
    }
    
    /**
     * Add sample requests to demonstrate LinkedList, PriorityQueue, and Stack
     */
    private static void addSampleRequests(EquipmentCollectionManager manager) {
        System.out.println("3. Adding Sample Requests:");
        
        // Add various requests with different statuses
        manager.addRequest(new Request("REQ001", "USER001", "ITEM001", 2, "PENDING"));
        manager.addRequest(new Request("REQ002", "USER002", "ITEM003", 1, "URGENT"));
        manager.addRequest(new Request("REQ003", "USER003", "ITEM002", 1, "APPROVED"));
        manager.addRequest(new Request("REQ004", "USER004", "ITEM005", 3, "PENDING"));
        manager.addRequest(new Request("REQ005", "USER005", "ITEM006", 2, "URGENT"));
        manager.addRequest(new Request("REQ006", "USER006", "ITEM007", 1, "FULFILLED"));
        
        System.out.println("✓ Added 6 sample requests\n");
    }
    
    /**
     * Demonstrate item collection operations
     */
    private static void demonstrateItemOperations(EquipmentCollectionManager manager) {
        System.out.println("4. Item Collection Operations:");
        
        // Fast lookup using HashMap
        System.out.println("   a) Fast item lookup by ID:");
        Item foundItem = manager.findItemById("ITEM001");
        if (foundItem != null) {
            System.out.println("      Found: " + foundItem.getName() + " (Quantity: " + foundItem.getQuantity() + ")");
        }
        
        // Sorted items using TreeSet
        System.out.println("   b) Items sorted alphabetically:");
        Set<String> sortedNames = manager.getSortedItemNames();
        System.out.println("      " + sortedNames);
        
        // Filter items by category
        System.out.println("   c) Items in category 1 (Computers):");
        List<Item> categoryItems = manager.getItemsByCategory(1);
        for (Item item : categoryItems) {
            System.out.println("      - " + item.getName() + " (Qty: " + item.getQuantity() + ")");
        }
        
        // Find low stock items
        System.out.println("   d) Low stock items (≤ 10):");
        List<Item> lowStockItems = manager.findLowStockItems(10);
        for (Item item : lowStockItems) {
            System.out.println("      - " + item.getName() + " (Qty: " + item.getQuantity() + ")");
        }
        
        // Search items by name
        System.out.println("   e) Search items containing 'Computer':");
        List<Item> searchResults = manager.searchItemsByName("Computer");
        for (Item item : searchResults) {
            System.out.println("      - " + item.getName());
        }
        
        // Show all categories
        System.out.println("   f) All item categories:");
        Set<String> categories = manager.getAllItemCategories();
        System.out.println("      " + categories);
        
        System.out.println();
    }
    
    /**
     * Demonstrate user collection operations
     */
    private static void demonstrateUserOperations(EquipmentCollectionManager manager) {
        System.out.println("5. User Collection Operations:");
        
        // Show departments (TreeMap keeps them sorted)
        System.out.println("   a) All departments (sorted):");
        Set<String> departments = manager.getAllDepartments();
        System.out.println("      " + departments);
        
        // Show users by department
        System.out.println("   b) Users by department:");
        for (String dept : departments) {
            List<User> users = manager.getUsersByDepartment(dept);
            System.out.println("      " + dept + " (" + users.size() + " users):");
            for (User user : users) {
                System.out.println("        - " + user.getName() + " (" + user.getRole() + ")");
            }
        }
        
        // Show total users
        System.out.println("   c) Total users: " + manager.getTotalUsers());
        
        System.out.println();
    }
    
    /**
     * Demonstrate request collection operations
     */
    private static void demonstrateRequestOperations(EquipmentCollectionManager manager) {
        System.out.println("6. Request Collection Operations:");
        
        // Show all request statuses (LinkedHashSet maintains order)
        System.out.println("   a) Available request statuses:");
        Set<String> statuses = manager.getAllRequestStatuses();
        System.out.println("      " + statuses);
        
        // Show requests by status
        System.out.println("   b) Pending requests:");
        List<Request> pendingRequests = manager.getRequestsByStatus("PENDING");
        for (Request req : pendingRequests) {
            System.out.println("      - " + req.getRequestId() + " (User: " + req.getUserId() + 
                             ", Item: " + req.getItemId() + ", Qty: " + req.getQuantity() + ")");
        }
        
        // Process urgent requests (PriorityQueue)
        System.out.println("   c) Processing urgent requests:");
        Request urgentRequest = manager.getNextUrgentRequest();
        while (urgentRequest != null) {
            System.out.println("      Processing: " + urgentRequest.getRequestId() + 
                             " (User: " + urgentRequest.getUserId() + ")");
            urgentRequest = manager.getNextUrgentRequest();
        }
        
        // Show last processed request (Stack)
        System.out.println("   d) Last processed request:");
        Request lastRequest = manager.getLastProcessedRequest();
        if (lastRequest != null) {
            System.out.println("      " + lastRequest.getRequestId() + " (User: " + lastRequest.getUserId() + ")");
        }
        
        // Process next request from queue (LinkedList FIFO)
        System.out.println("   e) Processing next request from queue:");
        Request nextRequest = manager.processNextRequest();
        if (nextRequest != null) {
            System.out.println("      Processed: " + nextRequest.getRequestId() + 
                             " (User: " + nextRequest.getUserId() + ")");
        }
        
        System.out.println();
    }
    
    /**
     * Show collection statistics
     */
    private static void showStatistics(EquipmentCollectionManager manager) {
        System.out.println("7. Collection Statistics:");
        Map<String, Integer> stats = manager.getCollectionStatistics();
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
    
    /**
     * Show audit log (Vector - thread-safe)
     */
    private static void showAuditLog(EquipmentCollectionManager manager) {
        System.out.println("8. Audit Log (Recent 10 entries):");
        List<String> auditLog = manager.getAuditLog();
        int startIndex = Math.max(0, auditLog.size() - 10);
        for (int i = startIndex; i < auditLog.size(); i++) {
            System.out.println("   " + (i + 1) + ". " + auditLog.get(i));
        }
        System.out.println();
    }
}
