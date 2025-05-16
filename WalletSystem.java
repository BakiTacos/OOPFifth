public class WalletSystem {
    static class Node {
        User account;
        Node next, prev;

        Node (User u) {
            account = u;
        }

        Node head;

        public void addUser(String name, int password, int cardNumber, String cardType, double balance) {
            User userAccounts = new User(name, cardType, cardType);
            Node new_node = new Node(userAccounts);

            new_node.next = head;
            new_node.prev = null;
             
            if (head != null) {
                head.prev = new_node;
            }

            head = new_node;
        }

        public void addAdmin() {

        }

        public void deleteUser() {

        }

        public void showUser() {
            Node n = head;
            while (n != head) {
                System.out.println(n.account + " ");
                n = n.next;
            }
            System.out.println();
        }
    }
}
