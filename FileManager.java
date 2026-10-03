package contactmanagement;

import java.io.*;

public class FileManager {

    private static final String FILE_NAME = "contacts.txt";

    // Save all contacts to file
    public static void saveContacts(DoublyLinkedList list) {

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(FILE_NAME))) {

            Node current = list.getHead();

            while (current != null) {

                Contact contact = current.contact;

                writer.println(
                        contact.getContactId() + "|" +
                        contact.getName() + "|" +
                        contact.getPhoneNumber() + "|" +
                        contact.getEmail() + "|" +
                        contact.getAddress()
                );

                current = current.next;
            }

            System.out.println("Contacts saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving contacts: "
                            + e.getMessage()
            );
        }
    }

    // Load contacts from file
    public static void loadContacts(DoublyLinkedList list) {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 5) {

                    int id =
                            Integer.parseInt(data[0]);

                    Contact contact =
                            new Contact(
                                    id,
                                    data[1],
                                    data[2],
                                    data[3],
                                    data[4]
                            );

                    // Avoid duplicate IDs
                    if (list.getById(id) == null) {
                        list.add(contact);
                    }
                }
            }

            System.out.println(
                    "Contacts loaded successfully."
            );

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error loading contacts: "
                            + e.getMessage()
            );
        }
    }
}