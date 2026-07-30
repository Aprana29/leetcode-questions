import java.util.*;

class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy nodes
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node right after the head
    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {

        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node existing = map.get(key);
            remove(existing);
            map.remove(key);
        }

        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key, newNode);

        if (map.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    // Display cache from Most Recently Used to Least Recently Used
    public void display() {
        Node temp = head.next;

        System.out.print("Cache: ");

        while (temp != tail) {
            System.out.print("(" + temp.key + "," + temp.value + ") ");
            temp = temp.next;
        }

        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Cache Capacity: ");
        int capacity = sc.nextInt();

        LRUCache cache = new LRUCache(capacity);

        while (true) {

            System.out.println("\n1. Put");
            System.out.println("2. Get");
            System.out.println("3. Display Cache");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Key: ");
                    int key = sc.nextInt();

                    System.out.print("Enter Value: ");
                    int value = sc.nextInt();

                    cache.put(key, value);
                    System.out.println("Inserted Successfully");
                    break;

                case 2:
                    System.out.print("Enter Key: ");
                    key = sc.nextInt();

                    int ans = cache.get(key);

                    if (ans == -1)
                        System.out.println("Key Not Found");
                    else
                        System.out.println("Value = " + ans);

                    break;

                case 3:
                    cache.display();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}