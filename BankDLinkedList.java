import java.util.Scanner;

public class BankDLinkedList<T> {
    Node<T> head;
    
    private double balance;
    static Scanner Scn = new Scanner(System.in);

    public class Node<T> {
        User data;
        Node<T> prev, next;

        Node(User data) {
            this.data = data;
        }
    }

    public void Push(User data) {
        Node<T> new_node = new Node(data);

        new_node.next = head;
        new_node.prev = null;

        if (head != null)
        head.prev = new_node;

        head = new_node;
    }

    public User pop() {
        if(head == null) {
            System.out.println("No User...");
            return null;
        }
    User PopUser = head.data;
    head = head.next;

    if(head != null) {
        head.prev = null;
    }
    return null;
    }

    public User searchNode(String username, String password) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.getUsername().equals(username) &&
            current.data.getPass().equals(password)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }


    public User loginUser(String username, String password) {
        return searchNode(username, password);
    }

    public boolean validatePhoneNumber(String name, String phoneNumber) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Your Phone Number is registered! Please log in with the account registered.");
                return false;
            }
            current = current.next;
        }
        System.out.printf("\nWelcome to Aurea %s!. Please log in with your account.", name);
        return true;
    }

    public void addUser(String name, String password, String username, String phoneNumber, double balance) {
        User new_user = new User(name, username, password, phoneNumber, balance);
        Push(new_user);
    }

    public void displayTest() {
        Node<T> temp = head;
        while (temp!= null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}