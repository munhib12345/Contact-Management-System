
package contactmanagement;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Returns the number of contacts
    public int size() {
        return size;
    }

    // Checks whether the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Returns the first node
    public Node getHead() {
        return head;
    }

    // Returns the last node
    public Node getTail() {
        return tail;
    }

    // Adds a contact at the end of the list
    public void add(Contact contact) {

        Node newNode = new Node(contact);

        // Empty list
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // Removes a contact using its ID
    public boolean removeById(int contactId) {

        Node current = head;

        while (current != null) {

            if (current.contact.getContactId() == contactId) {
                removeNode(current);
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Removes a specific node from the list
    private void removeNode(Node node) {

        // Removing the head
        if (node == head) {
            head = node.next;
        }
        else {
            node.previous.next = node.next;
        }

        // Removing the tail
        if (node == tail) {
            tail = node.previous;
        }
        else {
            node.next.previous = node.previous;
        }

        size--;

        // If the list becomes empty
        if (size == 0) {
            head = null;
            tail = null;
        }
    }

    // Finds a contact by ID
    public Contact getById(int contactId) {

        Node current = head;

        while (current != null) {

            if (current.contact.getContactId() == contactId) {
                return current.contact;
            }

            current = current.next;
        }

        return null;
    }

    // Updates an existing contact
    public boolean update(int contactId,
                          String name,
                          String phoneNumber,
                          String email,
                          String address) {

        Contact contact = getById(contactId);

        if (contact == null) {
            return false;
        }

        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);
        contact.setAddress(address);

        return true;
    }

    // Displays contacts from head to tail
    public void displayForward() {

        if (isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println(current.contact);
            current = current.next;
        }
    }

    // Displays contacts from tail to head
    public void displayBackward() {

        if (isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        Node current = tail;

        while (current != null) {
            System.out.println(current.contact);
            current = current.previous;
        }
    }

    // Removes all contacts
    public void clear() {

        head = null;
        tail = null;
        size = 0;
    }
    
 // Updates the head and tail after sorting
 public void updateHeadAndTail(Node newHead, Node newTail) {
     head = newHead;
     tail = newTail;
 }

}
