package contactmanagement;

public class Node {

    Contact contact;
    Node previous;
    Node next;

    // Constructor
    public Node(Contact contact) {
        this.contact = contact;
        this.previous = null;
        this.next = null;
    }
}