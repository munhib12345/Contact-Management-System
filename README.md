# 📇 Contact Management System

A **JavaFX-based Contact Management System** built to demonstrate the practical implementation of **Data Structures, Algorithms, Object-Oriented Programming, File Handling, and GUI development**.

The application allows users to easily **add, update, delete, search, sort, and manage contacts** through an interactive graphical interface, while automatically saving data for persistent storage.

---

## ✨ Features

* ➕ **Add Contacts** — Create new contact records
* ✏️ **Update Contacts** — Modify existing contact information
* 🗑️ **Delete Contacts** — Remove contacts using their ID
* 🔍 **Search Contacts**

  * Search by ID
  * Search by Name
  * Search by Phone Number
* 🔃 **Sort Contacts**

  * Sort by Name
  * Sort by ID
  * Sort by Phone Number
* 📋 **Display Contacts** — View all records in a JavaFX table
* 💾 **Automatic Data Persistence** — Contacts are automatically saved to `contacts.txt`
* 🔄 **Automatic Loading** — Saved contacts are loaded when the application starts
* 🔢 **Contact Counter** — Displays the total number of stored contacts
* ✅ **Input Validation** — Handles empty fields, invalid IDs, duplicate IDs, and non-existing contacts
* 🖱️ **Interactive Table** — Selecting a contact automatically fills its information into the input fields

---

## 🧠 Data Structures & Algorithms

This project focuses on applying fundamental **Data Structures and Algorithms** concepts to a practical application.

### 🔗 Doubly Linked List

Contacts are stored using a custom **Doubly Linked List**.

```text
NULL ← Contact 1 ⇄ Contact 2 ⇄ Contact 3 → NULL
```

Each node contains:

* `Contact` object
* Reference to the previous node
* Reference to the next node

The list maintains:

* `head`
* `tail`
* `size`

This allows the contact collection to grow dynamically without requiring a fixed-size array.

### 🔍 Searching

The system implements linear searching for:

| Search Type  | Complexity |
| ------------ | ---------: |
| ID           |       O(n) |
| Name         |       O(n) |
| Phone Number |       O(n) |

### 🔃 Merge Sort

Contacts can be sorted using **Merge Sort** based on:

* Name
* Contact ID
* Phone Number

**Time Complexity:** `O(n log n)`

Merge Sort was selected to provide efficient sorting for larger collections compared with basic quadratic-time sorting algorithms.

---

## 💾 Persistent Storage

The application uses a text file called:

```text
contacts.txt
```

Contact records are stored using a delimiter-based format:

```text
1|Ali Khan|03001234567|ali@gmail.com|Karachi
2|Ahmed|03111234567|ahmed@gmail.com|Lahore
```

The system automatically:

* Loads contacts when the application starts
* Saves changes after adding contacts
* Saves changes after updating contacts
* Saves changes after deleting contacts
* Saves changes after sorting

This ensures that contact information remains available between program executions.

---

## 🏗️ Project Structure

```text
Contact Management System
│
├── Contact.java
├── Node.java
├── DoublyLinkedList.java
├── SearchAlgorithms.java
├── SortingAlgorithm.java
├── FileManager.java
└── ContactManagementGUI.java
```

### 📌 Class Responsibilities

| Class                  | Purpose                                     |
| ---------------------- | ------------------------------------------- |
| `Contact`              | Represents an individual contact            |
| `Node`                 | Stores a contact and linked-list references |
| `DoublyLinkedList`     | Manages contact nodes and list operations   |
| `SearchAlgorithms`     | Implements contact searching                |
| `SortingAlgorithm`     | Implements Merge Sort                       |
| `FileManager`          | Handles saving and loading contact data     |
| `ContactManagementGUI` | Provides the JavaFX graphical interface     |

---

## 🖥️ User Interface

The application provides an interactive JavaFX interface containing:

```text
╔══════════════════════════════════════════════╗
║        CONTACT MANAGEMENT SYSTEM             ║
╠══════════════════════════════════════════════╣
║ Contact Information                          ║
║                                              ║
║ ID       [____________]                      ║
║ Name     [____________]                      ║
║ Phone    [____________]                      ║
║ Email    [____________]                      ║
║ Address  [____________]                      ║
║                                              ║
║ [Add Contact] [Update Contact]               ║
║ [Delete Contact] [Clear Fields]              ║
║                                              ║
║ Search Contacts                              ║
║ [Search Field] [ID/Name/Phone] [Search]      ║
║                                              ║
║ Sort Contacts                                ║
║ [Name/ID/Phone] [Sort]                       ║
║                                              ║
║ Contact List                                 ║
║ ──────────────────────────────────────────── ║
║ ID │ Name │ Phone │ Email │ Address          ║
║ ──────────────────────────────────────────── ║
║                                              ║
║ Total Contacts: X                            ║
║ Status: Ready                                ║
╚══════════════════════════════════════════════╝
```

---

## ⚙️ Technologies Used

* ☕ **Java**
* 🎨 **JavaFX**
* 🔗 **Doubly Linked List**
* 🔍 **Linear Search**
* 🔃 **Merge Sort**
* 💾 **File Handling**
* 🧱 **Object-Oriented Programming**

---

## 📊 Time Complexity

| Operation                  | Time Complexity |
| -------------------------- | --------------: |
| Add at Tail                |            O(1) |
| Search by ID               |            O(n) |
| Search by Name             |            O(n) |
| Search by Phone            |            O(n) |
| Update Contact             |            O(n) |
| Delete Contact             |            O(n) |
| Remove after locating node |            O(1) |
| Merge Sort                 |      O(n log n) |
| Save Contacts              |            O(n) |
| Load Contacts              |            O(n) |

Where `n` represents the number of contacts.

---

## 🛡️ Input Validation

The application performs basic validation to maintain data integrity.

It checks for:

* Empty input fields
* Invalid numerical IDs
* Duplicate Contact IDs
* Non-existing Contact IDs
* Invalid contact operations

Appropriate status/error messages are displayed through the GUI.

---

## 🎯 Project Objectives

The main objectives of this project were to:

1. Implement a practical application using a **Doubly Linked List**.
2. Apply **searching and sorting algorithms** to real-world data.
3. Implement **Merge Sort** with `O(n log n)` complexity.
4. Develop a graphical interface using **JavaFX**.
5. Implement persistent storage using **file handling**.
6. Apply **Object-Oriented Programming** principles.
7. Understand how data structures and algorithms can be integrated into software applications.

---

## 📚 Learning Outcomes

Through this project, the following concepts were practiced:

* Object-Oriented Programming
* Classes and Objects
* Encapsulation
* Doubly Linked Lists
* Node-based data structures
* Linear Searching
* Merge Sort
* Recursion
* File Handling
* Data Persistence
* JavaFX GUI Development
* Input Validation
* Algorithm Complexity Analysis

---

## 🚀 Getting Started

### Prerequisites

Make sure you have:

* **Java JDK** installed
* **JavaFX SDK** configured
* A Java IDE such as **Eclipse**, IntelliJ IDEA, or VS Code

### Running the Project

1. Clone the repository:

```bash
git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git
```

2. Open the project in your preferred Java IDE.

3. Configure the JavaFX libraries/modules.

4. Run:

```text
ContactManagementGUI.java
```

5. The application will start and automatically load existing contacts from:

```text
contacts.txt
```

---

## 📁 Data Storage

The application creates/uses:

```text
contacts.txt
```

Keep this file in the appropriate project/runtime directory so that saved contacts can be loaded correctly when the application starts.

---

## 🔮 Future Improvements

Possible future enhancements include:

* 🔐 Password-protected contact management
* 👤 User accounts and authentication
* 🖼️ Contact profile pictures
* 📱 Mobile-friendly version
* 🗄️ Database integration using MySQL
* 📤 Import/export functionality
* 📧 Email integration
* 📞 Direct calling functionality
* 🌙 Dark/light theme support
* ⚡ Faster searching using additional indexing structures

---

## 👨‍💻 Project Type

**Academic / Data Structures & Algorithms Project**

This project was developed to demonstrate how fundamental data structures and algorithms can be integrated with a graphical user interface to create a functional real-world application.

---

## ⭐ Highlights

> **A practical JavaFX application combining a custom Doubly Linked List, Linear Search, Merge Sort, File Handling, and Object-Oriented Programming into one complete contact management system.**

---

### 📌 Repository Contents

The repository contains the complete Java source code required to understand and run the Contact Management System.

If you find the project useful, consider giving the repository a ⭐!
