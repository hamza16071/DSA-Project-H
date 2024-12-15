package dsa_project;

import java.util.*;

class Customer {
    String name;
    int priority; 

    public Customer(String name) {
        this.name = name;
        this.priority = Integer.MAX_VALUE; 
    }

    public Customer(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + '\'' + ", priority=" + priority + '}';
    }
}

class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c1.priority, c2.priority);
    }
}

class RideManager {
    private Queue<Customer> regularQueue; 
    private PriorityQueue<Customer> priorityQueue; 

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
            System.out.println("Serving Priority Customer: " + next.name);
        } else if (!regularQueue.isEmpty()) {
            Customer next = regularQueue.poll();
            System.out.println("Serving Regular Customer: " + next.name);
        } else {
            System.out.println("No customers to serve.");
        }
    }

    public void displayQueues() {
        System.out.println("\nPriority Queue: " + priorityQueue);
        System.out.println("Regular Queue: " + regularQueue);
    }
}

 class RideQueueSystem {
    public static void main(String[] args) {
        RideManager rideManager = new RideManager();

        rideManager.addRegularRide("Hamza");
        rideManager.addPriorityRide("Agha", 2); 
        rideManager.addRegularRide("Asad");
        rideManager.addPriorityRide("Bhavesh", 1);

        rideManager.serveNextRide(); 
        rideManager.serveNextRide(); 
        rideManager.serveNextRide(); 
        rideManager.serveNextRide(); 
        rideManager.serveNextRide(); 

        rideManager.displayQueues();
    }
}
