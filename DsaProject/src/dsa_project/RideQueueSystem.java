package dsa_project;

import java.util.*;

class Customer {
    private final String name;
    private final int priority;

    public Customer(String name) {
        this.name = name;
        this.priority = Integer.MAX_VALUE;
    }

    public Customer(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', priority=" + priority + '}';
    }
}

class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c1.getPriority(), c2.getPriority());
    }
}

class RideManager {
    private final Queue<Customer> regularQueue; 
    private final PriorityQueue<Customer> priorityQueue; 

    public RideManager() {
        regularQueue = new LinkedList<>();
        priorityQueue = new PriorityQueue<>(new CustomerComparator());
    }

    public void addRegularRide(String customerName) {
        Customer customer = new Customer(customerName);
        regularQueue.add(customer);
        System.out.println("Added Regular Customer: " + customerName);
    }

    public void addPriorityRide(String customerName, int priority) {
        Customer customer = new Customer(customerName, priority);
        priorityQueue.add(customer);
        System.out.println("Added Priority Customer: " + customerName + " with priority " + priority);
    }

    public void serveNextRide() {
        if (!priorityQueue.isEmpty()) {
            Customer next = priorityQueue.poll();
            System.out.println("Serving Priority Customer: " + next.getName());
        } else if (!regularQueue.isEmpty()) {
            Customer next = regularQueue.poll();
            System.out.println("Serving Regular Customer: " + next.getName());
        } else {
            System.out.println("No customers to serve.");
        }
    }

    public void displayQueues() {
        System.out.println("\nPriority Queue: " + priorityQueue);
        System.out.println("Regular Queue: " + regularQueue);
    }
}

public class RideQueueSystem {
    public static void main(String[] args) {
        RideManager rideManager = new RideManager();

        rideManager.addRegularRide("M Hamza khan");
        rideManager.addPriorityRide("Zubair nawab", 2);
        rideManager.addRegularRide("Bhavesh Kumar");
        rideManager.addPriorityRide("Asad Ullah Khan", 1);

        rideManager.serveNextRide(); 
        rideManager.serveNextRide(); 
        rideManager.serveNextRide(); 
        rideManager.serveNextRide(); 
        rideManager.serveNextRide(); 

    
        rideManager.displayQueues();
    }
}
