
package contactmanagement;

public class SortingAlgorithm {

    // Sort contacts by name
    public static void sortByName(DoublyLinkedList list) {
        if (list.getHead() == null || list.getHead().next == null) {
            return;
        }

        Node newHead = mergeSort(list.getHead(), "name");
        rebuildLinks(list, newHead);
    }

    // Sort contacts by ID
    public static void sortById(DoublyLinkedList list) {
        if (list.getHead() == null || list.getHead().next == null) {
            return;
        }

        Node newHead = mergeSort(list.getHead(), "id");
        rebuildLinks(list, newHead);
    }

    // Sort contacts by phone number
    public static void sortByPhone(DoublyLinkedList list) {
        if (list.getHead() == null || list.getHead().next == null) {
            return;
        }

        Node newHead = mergeSort(list.getHead(), "phone");
        rebuildLinks(list, newHead);
    }

    // Merge Sort
    private static Node mergeSort(Node head, String criteria) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle node
        Node middle = getMiddle(head);
        Node secondHalf = middle.next;

        // Separate the two halves
        middle.next = null;

        if (secondHalf != null) {
            secondHalf.previous = null;
        }

        // Recursively sort both halves
        Node left = mergeSort(head, criteria);
        Node right = mergeSort(secondHalf, criteria);

        // Merge the sorted halves
        return merge(left, right, criteria);
    }

    // Find middle node using slow and fast pointers
    private static Node getMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted lists
    private static Node merge(Node left, Node right, String criteria) {

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (compare(left.contact, right.contact, criteria) <= 0) {

            left.next = merge(left.next, right, criteria);

            if (left.next != null) {
                left.next.previous = left;
            }

            left.previous = null;

            return left;

        } else {

            right.next = merge(left, right.next, criteria);

            if (right.next != null) {
                right.next.previous = right;
            }

            right.previous = null;

            return right;
        }
    }

    // Compare two contacts according to the selected criteria
    private static int compare(
            Contact first,
            Contact second,
            String criteria) {

        switch (criteria) {

            case "name":
                return first.getName()
                        .compareToIgnoreCase(second.getName());

            case "id":
                return Integer.compare(
                        first.getContactId(),
                        second.getContactId());

            case "phone":
                return first.getPhoneNumber()
                        .compareTo(second.getPhoneNumber());

            default:
                return 0;
        }
    }

    // Rebuild previous/next links and update list head/tail
    private static void rebuildLinks(
            DoublyLinkedList list,
            Node newHead) {

        Node current = newHead;
        Node previous = null;
        Node newTail = null;

        while (current != null) {

            current.previous = previous;

            if (previous != null) {
                previous.next = current;
            }

            previous = current;
            newTail = current;
            current = current.next;
        }

        // Make sure the last node points to null
        if (newTail != null) {
            newTail.next = null;
        }

        // Update the actual DoublyLinkedList
        list.updateHeadAndTail(newHead, newTail);
    }
}
