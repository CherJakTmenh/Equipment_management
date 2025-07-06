package collection;

import java.util.*;
import java.util.stream.Collectors;
import model.Item;
import model.User;
import model.Request;

/**
 * EquipmentCollectionManager - A comprehensive collection management system
 * for the Equipment Management project. This class demonstrates various
 * Java collection types and their practical usage.
 */
public class EquipmentCollectionManager {
    
    // ArrayList - Good for indexed access and when you need to maintain insertion order
    private List<Item> itemList;
    
    // LinkedList (used as Queue) - Good for frequent insertions/deletions at beginning/middle
    private Queue<Request> requestQueue;
    
    // HashMap - Fast key-value lookups for items by ID
    private Map<String, Item> itemMap;
    
    // TreeMap - Sorted map for users by department (maintains natural ordering)
    private Map<String, List<User>> usersByDepartment;
    
    // HashSet - Fast duplicate checking for unique item categories
    private Set<String> itemCategories;
    
    // LinkedHashSet - Maintains insertion order while ensuring uniqueness
    private Set<String> requestStatuses;
    
    // TreeSet - Sorted set for item names (alphabetical order)
    private Set<String> sortedItemNames;
    
    // Priority Queue - For handling urgent requests
    private PriorityQueue<Request> urgentRequests;
    
    // Stack - For maintaining request history (LIFO)
    private Stack<Request> requestHistory;
    
    // Vector - Thread-safe list (if needed for concurrent access)
    private Vector<String> auditLog;
    
    /**
     * Constructor initializes all collections
     */
    public EquipmentCollectionManager() {
        // Initialize List collections
        itemList = new ArrayList<>();
        requestQueue = new LinkedList<>();
        
        // Initialize Map collections
        itemMap = new HashMap<>();
        usersByDepartment = new TreeMap<>();
        
        // Initialize Set collections
        itemCategories = new HashSet<>();
        requestStatuses = new LinkedHashSet<>();
        sortedItemNames = new TreeSet<>();
        
        // Initialize specialized collections
        urgentRequests = new PriorityQueue<>(new RequestPriorityComparator());
        requestHistory = new Stack<>();
        auditLog = new Vector<>();
        
        // Initialize default request statuses
        initializeRequestStatuses();
    }
    
    /**
     * Initialize default request statuses in order
     */
    private void initializeRequestStatuses() {
        requestStatuses.add("PENDING");
        requestStatuses.add("APPROVED");
        requestStatuses.add("REJECTED");
        requestStatuses.add("FULFILLED");
        requestStatuses.add("CANCELLED");
    }
    
    // ========== ITEM COLLECTION OPERATIONS ==========
    
    /**
     * Add an item to multiple collections
     */
    public void addItem(Item item) {
        // Add to list
        itemList.add(item);
        
        // Add to map for fast lookup
        itemMap.put(item.getItemId(), item);
        
        // Add item name to sorted set
        sortedItemNames.add(item.getName());
        
        // Add category if it exists
        if (item.getCategoryId() != -1) {
            itemCategories.add(String.valueOf(item.getCategoryId()));
        }
        
        // Log the action
        auditLog.add("Added item: " + item.getName() + " (ID: " + item.getItemId() + ")");
    }
    
    /**
     * Find item by ID using HashMap (O(1) lookup)
     */
    public Item findItemById(String itemId) {
        return itemMap.get(itemId);
    }
    
    /**
     * Get all items sorted by name
     */
    public List<Item> getItemsSortedByName() {
        return itemList.stream()
                .sorted(Comparator.comparing(Item::getName))
                .collect(Collectors.toList());
    }
    
    /**
     * Get items by category
     */
    public List<Item> getItemsByCategory(int categoryId) {
        return itemList.stream()
                .filter(item -> item.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }
    
    /**
     * Get all unique item categories
     */
    public Set<String> getAllItemCategories() {
        return new HashSet<>(itemCategories);
    }
    
    /**
     * Get all item names in alphabetical order
     */
    public Set<String> getSortedItemNames() {
        return new TreeSet<>(sortedItemNames);
    }
    
    // ========== USER COLLECTION OPERATIONS ==========
    
    /**
     * Add user and organize by department
     */
    public void addUser(User user) {
        String department = user.getDepartmentName();
        
        // Initialize department list if it doesn't exist
        usersByDepartment.computeIfAbsent(department, k -> new ArrayList<>());
        
        // Add user to department
        usersByDepartment.get(department).add(user);
        
        // Log the action
        auditLog.add("Added user: " + user.getName() + " to department: " + department);
    }
    
    /**
     * Get users by department
     */
    public List<User> getUsersByDepartment(String department) {
        return usersByDepartment.getOrDefault(department, new ArrayList<>());
    }
    
    /**
     * Get all departments in alphabetical order
     */
    public Set<String> getAllDepartments() {
        return usersByDepartment.keySet();
    }
    
    /**
     * Get total users across all departments
     */
    public int getTotalUsers() {
        return usersByDepartment.values().stream()
                .mapToInt(List::size)
                .sum();
    }
    
    // ========== REQUEST COLLECTION OPERATIONS ==========
    
    /**
     * Add a request to various collections
     */
    public void addRequest(Request request) {
        // Add to queue
        requestQueue.add(request);
        
        // Add to history stack
        requestHistory.push(request);
        
        // Add to urgent queue if status is urgent
        if ("URGENT".equals(request.getStatus())) {
            urgentRequests.offer(request);
        }
        
        // Log the action
        auditLog.add("Added request: " + request.getRequestId() + " for user: " + request.getUserId());
    }
    
    /**
     * Process next request from queue (FIFO)
     */
    public Request processNextRequest() {
        Request request = requestQueue.poll();
        if (request != null) {
            auditLog.add("Processed request: " + request.getRequestId());
        }
        return request;
    }
    
    /**
     * Get next urgent request
     */
    public Request getNextUrgentRequest() {
        return urgentRequests.poll();
    }
    
    /**
     * Get last processed request from history
     */
    public Request getLastProcessedRequest() {
        return requestHistory.isEmpty() ? null : requestHistory.peek();
    }
    
    /**
     * Get all requests by status
     */
    public List<Request> getRequestsByStatus(String status) {
        return requestQueue.stream()
                .filter(request -> status.equals(request.getStatus()))
                .collect(Collectors.toList());
    }
    
    /**
     * Get all available request statuses
     */
    public Set<String> getAllRequestStatuses() {
        return new LinkedHashSet<>(requestStatuses);
    }
    
    // ========== UTILITY METHODS ==========
    
    /**
     * Get audit log
     */
    public List<String> getAuditLog() {
        return new ArrayList<>(auditLog);
    }
    
    /**
     * Get collection statistics
     */
    public Map<String, Integer> getCollectionStatistics() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("Total Items", itemList.size());
        stats.put("Total Users", getTotalUsers());
        stats.put("Pending Requests", requestQueue.size());
        stats.put("Urgent Requests", urgentRequests.size());
        stats.put("Request History", requestHistory.size());
        stats.put("Departments", usersByDepartment.size());
        stats.put("Item Categories", itemCategories.size());
        return stats;
    }
    
    /**
     * Clear all collections
     */
    public void clearAllCollections() {
        itemList.clear();
        requestQueue.clear();
        itemMap.clear();
        usersByDepartment.clear();
        itemCategories.clear();
        requestStatuses.clear();
        sortedItemNames.clear();
        urgentRequests.clear();
        requestHistory.clear();
        auditLog.clear();
        
        // Reinitialize request statuses
        initializeRequestStatuses();
    }
    
    /**
     * Custom comparator for request priority
     */
    private static class RequestPriorityComparator implements Comparator<Request> {
        @Override
        public int compare(Request r1, Request r2) {
            // Priority order: URGENT > PENDING > others
            return getPriority(r1.getStatus()) - getPriority(r2.getStatus());
        }
        
        private int getPriority(String status) {
            switch (status.toLowerCase()) {
                case "urgent": return 1;
                case "pending": return 2;
                default: return 3;
            }
        }
    }
    
    // ========== SEARCH AND FILTER METHODS ==========
    
    /**
     * Search items by name (case-insensitive)
     */
    public List<Item> searchItemsByName(String searchTerm) {
        return itemList.stream()
                .filter(item -> item.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Find items with low stock
     */
    public List<Item> findLowStockItems(int threshold) {
        return itemList.stream()
                .filter(item -> item.getQuantity() <= threshold)
                .collect(Collectors.toList());
    }
    
    /**
     * Get items with quantity greater than specified amount
     */
    public List<Item> getItemsWithQuantityGreaterThan(int quantity) {
        return itemList.stream()
                .filter(item -> item.getQuantity() > quantity)
                .collect(Collectors.toList());
    }
}
