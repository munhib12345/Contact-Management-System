package contactmanagement;

public class Contact {

    private int contactId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    // Constructor
    public Contact(int contactId, String name, String phoneNumber,
                   String email, String address) {

        this.contactId = contactId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    // Getters
    public int getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Display contact information
    @Override
    public String toString() {
        return String.format(
            "ID: %d | Name: %s | Phone: %s | Email: %s | Address: %s",
            contactId, name, phoneNumber, email, address
        );
    }
}