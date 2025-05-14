import java.util.Scanner;

class SuggestionQueue {
    private String[] queue;
    private int front; 
    private int rear; 
    private int size; 
    private int capacity; 
    
    public SuggestionQueue(int capacity){
        this.capacity = capacity; 
        this.queue = new String[capacity]; 
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void Enqueue(String username, String suggestion) {
        if(isFull()) {
            System.out.println("Suggestion is full");

        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = username + " | " + suggestion;
            size++;
            System.out.println("Suggestion added successfully!");
        }
    }

 public void printQueue() {
    if (isEmpty()) {
        System.out.println("Queue kosong!");
    } else {
        System.out.println("| Displaying All Suggestion from User |");
        for (int i = 0; i < capacity; i++) {
            if (queue[i] != null) {
                System.out.println("| " + (i + 1) + ". " + queue[i]);
            }
        }
    }
}

    public void update(int index, String newSuggestion) {
        if (isEmpty()) {
            System.out.println("No suggestion to update.");
            return;
        }
        if (index < 1 || index > size) {
            System.out.println("Invalid. There's no other suggestion.");
            return;
        }
        int actualIndex = (front + index - 1) % capacity; 
        queue[actualIndex] = " | " + newSuggestion; 
        System.out.println("Suggestion successfully edited.");
    }
    
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            queue[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
    System.out.println("Queue cleared.");
}

    public String suggestionHistory(int index) {
        if (index < 1 || index > size) {
            return null;
        }
        return queue[(front + index - 1) % capacity];
    }

    public void editSuggestion() {
        Scanner Scn = new Scanner(System.in);

        printQueue();
        System.out.print("Enter suggestion number you want to edit: ");
        int suggestionEdit = Scn.nextInt();
        String suggestions = suggestionHistory(suggestionEdit);
        Scn.nextLine();

        if (suggestions != null) {
            System.out.print("Enter the new suggestion: ");
            String newSuggest = Scn.nextLine();
            
            update(suggestionEdit, newSuggest);
        } else {
            System.out.println("Invalid");
        }
    }
}
