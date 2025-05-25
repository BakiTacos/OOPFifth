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

    public boolean validateUsername(String username) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.getUsername().equals(username)) {
                System.out.println("Your username seems invalid. Please try another username.");
                return false;
            }
            current = current.next;
        }
        System.out.printf("\nWelcome to Aurea %s!. Please log in with your account.", username);
        return true;
    }

    public void addUser(String name, String password, String username, double balance) {
        User new_user = new User(name, username, password, balance);
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