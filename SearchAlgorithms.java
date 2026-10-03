
package contactmanagement;

public class SearchAlgorithms {

    // Search for a contact by ID
    public static Contact searchById(DoublyLinkedList list, int contactId) {

        Node current = list.getHead();

        while (current != null) {

            if (current.contact.getContactId() == contactId) {
                return current.contact;
            }

            current = current.next;
        }

        return null;
    }

    // Search for a contact by name
    public static Contact searchByName(DoublyLinkedList list, String name) {

        Node current = list.getHead();

        while (current != null) {

            if (current.contact.getName().equalsIgnoreCase(name)) {
                return current.contact;
            }

            current = current.next;
        }

        return null;
    }

    // Search for a contact by phone number
    public static Contact searchByPhone(DoublyLinkedList list,
                                         String phoneNumber) {

        Node current = list.getHead();

        while (current != null) {

            if (current.contact.getPhoneNumber().equals(phoneNumber)) {
                return current.contact;
            }

            current = current.next;
        }

        return null;
    }
}
