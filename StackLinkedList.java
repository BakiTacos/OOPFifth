import java.util.Scanner;

public class StackLinkedList<T>{
    
    private double balance;
    static Scanner Scn = new Scanner(System.in);

    public class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
        
        public T getData() {
        return data;
    }
    }

    private Node<T> top;

    public StackLinkedList(){
        this.top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }
    
    public void push(T data){
        Node<T> newNode = new Node(data);       top = newNode;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Stack underflow!");
            return null;
        }
        T poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return null;
        }
        return top.data;
    }

    public void printStack(){
        Node<T> temp = top;
        System.out.print("[ ");
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(" ]");
    }

 public boolean addUser(String name, String password, String username, double balance) {
        StackLinkedList<User> tempStack = new StackLinkedList<>(); // Stack sementara untuk memeriksa username
        boolean exists = false;

        // Memeriksa apakah username sudah ada di stack
        while (!isEmpty()) {
            User user = (User) pop(); // Casting data ke User
            if (user.getUsername().equals(username)) {
                exists = true;
            }
            tempStack.push(user); // Push user ke temp stack
        }

        // Mengembalikan data ke stack asli
        while (!tempStack.isEmpty()) {
        User user = (User) pop(); // Pop data dari stack dan casting ke User
            if (user.getUsername().equals(username)) {
                exists = true;
        }

        // Jika username sudah ada, return false
        if (exists) {
            return false; // Username sudah ada
        }

        // Buat user baru dan masukkan ke stack
        User newUser = new User(name, username, password, balance);
        push((T) newUser); // Casting ke T (User) dan push ke stack

    }        return true;
    }
    public void withdraw() {
    System.out.print("Enter amount: ");
    double withdrawAmount = Double.parseDouble(Scn.nextLine());

    if(withdrawAmount <= 0) {
        System.out.println("No balance!");
    }
    else if (withdrawAmount > balance) {
        System.out.println("Balanceis not enough!");
    }

    this.balance -= withdrawAmount;
    System.out.println("Penarikan berhasil. Sisa Saldo :" + balance);
    }
    
public User loginUser(String username, String password) {
    Node<T> current = top;
    while (current != null) {
        User user = (User) current.data;
        if (user.getUsername().equals(username) && user.getPass().equals(password)) {
            return user; // Login sukses
        }
        current = current.next;
    }
    return null; // Tidak ketemu
}



}