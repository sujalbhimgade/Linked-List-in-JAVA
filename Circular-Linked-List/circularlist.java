import java.util.Scanner;

class CircularLinkedList {
    Node head, tail;

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert a new node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; 
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; 
        }
    }

    // Search for a node
    public boolean search(int key) {
        if (head == null) return false;

        Node temp = head;
        do {
            if (temp.data == key) return true;
            temp = temp.next;
        } while (temp != head);

        return false;
    }

    // Delete a node
    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If head contains the key
        if (head.data == key) {
            if (head == tail) {
                head = null;
                tail = null; 
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }

        Node temp = head;
        do {
            if (temp.next.data == key) {
                temp.next = temp.next.next; 
                if (temp.next == head) tail = temp; 
                return;
            }
            temp = temp.next;
        } while (temp != head);
    }

    // Print the Circular Linked List
    public void printList() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Print List");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    list.insert(value);
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    if (list.search(value)) {
                        System.out.println("Value found.");
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    list.delete(value);
                    break;
                case 4:
                    System.out.println("Circular Linked List:");
                    list.printList();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
