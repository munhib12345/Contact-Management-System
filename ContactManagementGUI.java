
package contactmanagement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContactManagementGUI extends Application {

    private DoublyLinkedList contactList = new DoublyLinkedList();

    // Contact fields
    private TextField idField;
    private TextField nameField;
    private TextField phoneField;
    private TextField emailField;
    private TextField addressField;

    // Search
    private TextField searchField;
    private ComboBox<String> searchType;

    // Sort
    private ComboBox<String> sortType;

    // Table
    private TableView<Contact> table;

    // Status
    private Label statusLabel;
    private Label totalLabel;

    @Override
    public void start(Stage stage) {

        // =========================================================
        // HEADER
        // =========================================================

        Label title = new Label(
                "CONTACT MANAGEMENT SYSTEM"
        );

        title.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        30
                )
        );

        title.setTextFill(Color.WHITE);

        Label subtitle = new Label(
                "Manage, search, sort and organize your contacts"
        );

        subtitle.setFont(
                Font.font("Arial", 14)
        );

        subtitle.setTextFill(
                Color.web("#CFD8DC")
        );

        VBox titleBox = new VBox(5);
        titleBox.setAlignment(Pos.CENTER);

        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        VBox header = new VBox(titleBox);

        header.setAlignment(Pos.CENTER);
        header.setPadding(
                new Insets(22, 20, 22, 20)
        );

        header.setStyle(
                "-fx-background-color: linear-gradient(" +
                "to right, #1F2D35, #263C47" +
                ");"
        );

        // =========================================================
        // CONTACT INFORMATION
        // =========================================================

        Label inputTitle = new Label(
                "Contact Information"
        );

        inputTitle.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        19
                )
        );

        inputTitle.setTextFill(
                Color.web("#263238")
        );

        idField =
                createTextField("Contact ID");

        nameField =
                createTextField("Full Name");

        phoneField =
                createTextField("Phone Number");

        emailField =
                createTextField("Email Address");

        addressField =
                createTextField("Address");

        GridPane inputGrid = new GridPane();

        inputGrid.setHgap(10);
        inputGrid.setVgap(8);

        inputGrid.add(
                createLabel("ID"),
                0, 0
        );

        inputGrid.add(
                idField,
                1, 0
        );

        inputGrid.add(
                createLabel("Name"),
                0, 1
        );

        inputGrid.add(
                nameField,
                1, 1
        );

        inputGrid.add(
                createLabel("Phone"),
                0, 2
        );

        inputGrid.add(
                phoneField,
                1, 2
        );

        inputGrid.add(
                createLabel("Email"),
                0, 3
        );

        inputGrid.add(
                emailField,
                1, 3
        );

        inputGrid.add(
                createLabel("Address"),
                0, 4
        );

        inputGrid.add(
                addressField,
                1, 4
        );

        ColumnConstraints labelColumn =
                new ColumnConstraints();

        labelColumn.setMinWidth(60);

        ColumnConstraints fieldColumn =
                new ColumnConstraints();

        fieldColumn.setHgrow(
                Priority.ALWAYS
        );

        inputGrid.getColumnConstraints().addAll(
                labelColumn,
                fieldColumn
        );

        // =========================================================
        // CONTACT BUTTONS
        // =========================================================

        Button addButton =
                createButton("Add Contact");

        Button updateButton =
                createButton("Update Contact");

        Button deleteButton =
                createButton("Delete Contact");

        Button clearButton =
                createLightButton("Clear Fields");

        HBox row1 = new HBox(8);

        row1.setAlignment(
                Pos.CENTER
        );

        row1.getChildren().addAll(
                addButton,
                updateButton
        );

        HBox row2 = new HBox(8);

        row2.setAlignment(
                Pos.CENTER
        );

        row2.getChildren().addAll(
                deleteButton,
                clearButton
        );

        VBox buttonBox = new VBox(8);

        buttonBox.setAlignment(
                Pos.CENTER
        );

        buttonBox.getChildren().addAll(
                row1,
                row2
        );

        // =========================================================
        // CONTACT CARD
        // =========================================================

        VBox contactCard = new VBox(11);

        contactCard.setPadding(
                new Insets(16)
        );

        contactCard.getChildren().addAll(
                inputTitle,
                inputGrid,
                buttonBox
        );

        setCardStyle(contactCard);

        // =========================================================
        // SEARCH CARD
        // =========================================================

        Label searchTitle =
                new Label("Search Contacts");

        searchTitle.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        17
                )
        );

        searchTitle.setTextFill(
                Color.web("#263238")
        );

        searchField =
                createTextField(
                        "Enter search value"
                );

        searchType =
                new ComboBox<>();

        searchType.getItems().addAll(
                "ID",
                "Name",
                "Phone"
        );

        searchType.setValue("ID");

        searchType.setPrefWidth(82);
        searchType.setPrefHeight(35);

        styleComboBox(searchType);

        Button searchButton =
                createSmallButton("Search");

        Button showAllButton =
                createSmallButton("Show All");

        HBox searchBox =
                new HBox(7);

        searchBox.setAlignment(
                Pos.CENTER_LEFT
        );

        searchBox.getChildren().addAll(
                searchField,
                searchType,
                searchButton,
                showAllButton
        );

        HBox.setHgrow(
                searchField,
                Priority.ALWAYS
        );

        VBox searchCard =
                new VBox(8);

        searchCard.setPadding(
                new Insets(16)
        );

        searchCard.getChildren().addAll(
                searchTitle,
                searchBox
        );

        setCardStyle(searchCard);

        // =========================================================
        // SORT CARD
        // =========================================================

        Label sortTitle =
                new Label("Sort Contacts");

        sortTitle.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        17
                )
        );

        sortTitle.setTextFill(
                Color.web("#263238")
        );

        sortType =
                new ComboBox<>();

        sortType.getItems().addAll(
                "Name",
                "ID",
                "Phone"
        );

        sortType.setValue("Name");

        sortType.setPrefWidth(105);
        sortType.setPrefHeight(35);

        styleComboBox(sortType);

        Button sortButton =
                createSmallButton("Sort");

        Label sortInfo =
                new Label("Merge Sort");

        sortInfo.setFont(
                Font.font(
                        "Arial",
                        FontWeight.NORMAL,
                        12
                )
        );

        sortInfo.setTextFill(
                Color.web("#78909C")
        );

        HBox sortBox =
                new HBox(10);

        sortBox.setAlignment(
                Pos.CENTER_LEFT
        );

        sortBox.getChildren().addAll(
                sortType,
                sortButton,
                sortInfo
        );

        VBox sortCard =
                new VBox(8);

        sortCard.setPadding(
                new Insets(16)
        );

        sortCard.getChildren().addAll(
                sortTitle,
                sortBox
        );

        setCardStyle(sortCard);

        // =========================================================
        // TABLE
        // =========================================================

        table =
                new TableView<>();

        TableColumn<Contact, Integer> idColumn =
                new TableColumn<>("ID");

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "contactId"
                )
        );

        TableColumn<Contact, String> nameColumn =
                new TableColumn<>("Name");

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "name"
                )
        );

        TableColumn<Contact, String> phoneColumn =
                new TableColumn<>("Phone");

        phoneColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "phoneNumber"
                )
        );

        TableColumn<Contact, String> emailColumn =
                new TableColumn<>("Email");

        emailColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "email"
                )
        );

        TableColumn<Contact, String> addressColumn =
                new TableColumn<>("Address");

        addressColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "address"
                )
        );

        table.getColumns().addAll(
                idColumn,
                nameColumn,
                phoneColumn,
                emailColumn,
                addressColumn
        );

        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );

        table.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-background-color: white;" +
                "-fx-border-color: #DCE3E7;"
        );

        // =========================================================
        // TABLE TITLE
        // =========================================================

        Label tableTitle =
                new Label("Contact List");

        tableTitle.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        20
                )
        );

        tableTitle.setTextFill(
                Color.web("#263238")
        );

        Label tableSubtitle =
                new Label(
                        "All contacts stored in the system"
                );

        tableSubtitle.setFont(
                Font.font(
                        "Arial",
                        12
                )
        );

        tableSubtitle.setTextFill(
                Color.web("#78909C")
        );

        VBox tableHeading =
                new VBox(2);

        tableHeading.getChildren().addAll(
                tableTitle,
                tableSubtitle
        );

        // =========================================================
        // STATUS BAR
        // =========================================================

        totalLabel =
                new Label(
                        "Total Contacts: 0"
                );

        totalLabel.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        14
                )
        );

        totalLabel.setTextFill(
                Color.web("#263238")
        );

        statusLabel =
                new Label("Ready");

        statusLabel.setFont(
                Font.font(
                        "Arial",
                        FontWeight.NORMAL,
                        13
                )
        );

        statusLabel.setTextFill(
                Color.web("#607D8B")
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        HBox bottomBar =
                new HBox(15);

        bottomBar.setAlignment(
                Pos.CENTER_LEFT
        );

        bottomBar.getChildren().addAll(
                totalLabel,
                spacer,
                statusLabel
        );

        // =========================================================
        // LEFT PANEL
        // =========================================================

        VBox leftSide =
                new VBox(10);

        leftSide.setPrefWidth(390);
        leftSide.setMinWidth(360);
        leftSide.setMaxWidth(410);

        leftSide.getChildren().addAll(
                contactCard,
                searchCard,
                sortCard
        );

        // =========================================================
        // RIGHT PANEL
        // =========================================================

        VBox rightSide =
                new VBox(10);

        rightSide.getChildren().addAll(
                tableHeading,
                table,
                bottomBar
        );

        VBox.setVgrow(
                table,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                rightSide,
                Priority.ALWAYS
        );

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        HBox content =
                new HBox(18);

        content.setPadding(
                new Insets(18)
        );

        content.getChildren().addAll(
                leftSide,
                rightSide
        );

        HBox.setHgrow(
                rightSide,
                Priority.ALWAYS
        );

        // =========================================================
        // BUTTON ACTIONS
        // =========================================================

        addButton.setOnAction(
                e -> addContact()
        );

        updateButton.setOnAction(
                e -> updateContact()
        );

        deleteButton.setOnAction(
                e -> deleteContact()
        );

        clearButton.setOnAction(
                e -> clearFields()
        );

        searchButton.setOnAction(
                e -> searchContact()
        );

        showAllButton.setOnAction(
                e -> showAllContacts()
        );

        sortButton.setOnAction(
                e -> sortContacts()
        );

        // =========================================================
        // TABLE SELECTION
        // =========================================================

        table.setOnMouseClicked(e -> {

            Contact selected =
                    table.getSelectionModel()
                            .getSelectedItem();

            if (selected != null) {

                idField.setText(
                        String.valueOf(
                                selected.getContactId()
                        )
                );

                nameField.setText(
                        selected.getName()
                );

                phoneField.setText(
                        selected.getPhoneNumber()
                );

                emailField.setText(
                        selected.getEmail()
                );

                addressField.setText(
                        selected.getAddress()
                );

                statusLabel.setText(
                        "Contact selected"
                );
            }
        });

        // =========================================================
        // ROOT
        // =========================================================

        BorderPane root =
                new BorderPane();

        root.setTop(header);
        root.setCenter(content);

        root.setStyle(
                "-fx-background-color: #F3F6F8;"
        );

        // =========================================================
        // SCENE
        // =========================================================

        Scene scene =
                new Scene(root);

        stage.setTitle(
                "Contact Management System"
        );

        stage.setScene(scene);

        /*
         * Fullscreen hides the Windows taskbar.
         */
        stage.setFullScreen(true);

        stage.setFullScreenExitHint("");

        stage.show();

        // =========================================================
        // AUTOMATIC LOAD
        // =========================================================

        FileManager.loadContacts(
                contactList
        );

        refreshTable();

        statusLabel.setText(
                "Contacts loaded successfully"
        );
    }

    // =============================================================
    // ADD CONTACT
    // =============================================================

    private void addContact() {

        try {

            int id =
                    Integer.parseInt(
                            idField.getText().trim()
                    );

            String name =
                    nameField.getText().trim();

            String phone =
                    phoneField.getText().trim();

            String email =
                    emailField.getText().trim();

            String address =
                    addressField.getText().trim();

            if (name.isEmpty()
                    || phone.isEmpty()
                    || email.isEmpty()
                    || address.isEmpty()) {

                showAlert(
                        "Input Error",
                        "Please fill in all fields."
                );

                return;
            }

            if (contactList.getById(id)
                    != null) {

                showAlert(
                        "Duplicate ID",
                        "A contact with ID "
                                + id
                                + " already exists."
                );

                return;
            }

            Contact contact =
                    new Contact(
                            id,
                            name,
                            phone,
                            email,
                            address
                    );

            contactList.add(contact);

            // Automatically save
            FileManager.saveContacts(
                    contactList
            );

            refreshTable();

            clearInputFields();

            statusLabel.setText(
                    "Contact added successfully"
            );

        } catch (NumberFormatException e) {

            showAlert(
                    "Invalid ID",
                    "Contact ID must be a number."
            );
        }
    }

    // =============================================================
    // UPDATE CONTACT
    // =============================================================

    private void updateContact() {

        try {

            int id =
                    Integer.parseInt(
                            idField.getText().trim()
                    );

            String name =
                    nameField.getText().trim();

            String phone =
                    phoneField.getText().trim();

            String email =
                    emailField.getText().trim();

            String address =
                    addressField.getText().trim();

            if (name.isEmpty()
                    || phone.isEmpty()
                    || email.isEmpty()
                    || address.isEmpty()) {

                showAlert(
                        "Input Error",
                        "Please fill in all fields."
                );

                return;
            }

            boolean updated =
                    contactList.update(
                            id,
                            name,
                            phone,
                            email,
                            address
                    );

            if (updated) {

                // Automatically save
                FileManager.saveContacts(
                        contactList
                );

                refreshTable();

                statusLabel.setText(
                        "Contact updated successfully"
                );

                Contact updatedContact =
                        contactList.getById(id);

                if (updatedContact != null) {

                    table.getSelectionModel()
                            .select(
                                    updatedContact
                            );
                }

            } else {

                showAlert(
                        "Contact Not Found",
                        "No contact exists with ID "
                                + id
                );
            }

        } catch (NumberFormatException e) {

            showAlert(
                    "Invalid ID",
                    "Contact ID must be a number."
            );
        }
    }

    // =============================================================
    // DELETE CONTACT
    // =============================================================

    private void deleteContact() {

        try {

            int id =
                    Integer.parseInt(
                            idField.getText().trim()
                    );

            Contact contact =
                    contactList.getById(id);

            if (contact == null) {

                showAlert(
                        "Contact Not Found",
                        "No contact exists with ID "
                                + id
                );

                return;
            }

            Alert confirmation =
                    new Alert(
                            Alert.AlertType.CONFIRMATION
                    );

            confirmation.setTitle(
                    "Delete Contact"
            );

            confirmation.setHeaderText(
                    "Delete this contact?"
            );

            confirmation.setContentText(
                    "Name: "
                            + contact.getName()
                            + "\nID: "
                            + contact.getContactId()
            );

            ButtonType result =
                    confirmation.showAndWait()
                            .orElse(
                                    ButtonType.CANCEL
                            );

            if (result ==
                    ButtonType.OK) {

                boolean deleted =
                        contactList.removeById(id);

                if (deleted) {

                    // Automatically save
                    FileManager.saveContacts(
                            contactList
                    );

                    refreshTable();

                    clearInputFields();

                    statusLabel.setText(
                            "Contact deleted successfully"
                    );
                }
            }

        } catch (NumberFormatException e) {

            showAlert(
                    "Invalid ID",
                    "Enter a valid contact ID."
            );
        }
    }

    // =============================================================
    // SEARCH CONTACT
    // =============================================================

    private void searchContact() {

        String value =
                searchField.getText().trim();

        if (value.isEmpty()) {

            showAlert(
                    "Search Error",
                    "Please enter a search value."
            );

            return;
        }

        Contact result = null;

        String type =
                searchType.getValue();

        switch (type) {

            case "ID":

                try {

                    int id =
                            Integer.parseInt(value);

                    result =
                            SearchAlgorithms.searchById(
                                    contactList,
                                    id
                            );

                } catch (NumberFormatException e) {

                    showAlert(
                            "Invalid ID",
                            "ID must be a number."
                    );

                    return;
                }

                break;

            case "Name":

                result =
                        SearchAlgorithms.searchByName(
                                contactList,
                                value
                        );

                break;

            case "Phone":

                result =
                        SearchAlgorithms.searchByPhone(
                                contactList,
                                value
                        );

                break;
        }

        if (result != null) {

            ObservableList<Contact> resultList =
                    FXCollections.observableArrayList();

            resultList.add(result);

            table.setItems(
                    resultList
            );

            table.getSelectionModel()
                    .select(result);

            statusLabel.setText(
                    "Contact found"
            );

        } else {

            table.setItems(
                    FXCollections.observableArrayList()
            );

            statusLabel.setText(
                    "No contact found"
            );

            showAlert(
                    "Search Result",
                    "No contact was found."
            );
        }
    }

    // =============================================================
    // SHOW ALL CONTACTS
    // =============================================================

    private void showAllContacts() {

        refreshTable();

        statusLabel.setText(
                "Showing all contacts"
        );
    }

    // =============================================================
    // SORT CONTACTS
    // =============================================================

    private void sortContacts() {

        if (contactList.isEmpty()) {

            showAlert(
                    "Sort Error",
                    "There are no contacts to sort."
            );

            return;
        }

        String type =
                sortType.getValue();

        switch (type) {

            case "Name":

                SortingAlgorithm.sortByName(
                        contactList
                );

                break;

            case "ID":

                SortingAlgorithm.sortById(
                        contactList
                );

                break;

            case "Phone":

                SortingAlgorithm.sortByPhone(
                        contactList
                );

                break;
        }

        // Save new order automatically
        FileManager.saveContacts(
                contactList
        );

        refreshTable();

        statusLabel.setText(
                "Sorted by "
                        + type
                        + " using Merge Sort"
        );
    }

    // =============================================================
    // REFRESH TABLE
    // =============================================================

    private void refreshTable() {

        ObservableList<Contact> contacts =
                FXCollections.observableArrayList();

        Node current =
                contactList.getHead();

        while (current != null) {

            contacts.add(
                    current.contact
            );

            current =
                    current.next;
        }

        table.setItems(
                contacts
        );

        table.refresh();

        totalLabel.setText(
                "Total Contacts: "
                        + contactList.size()
        );
    }

    // =============================================================
    // CLEAR INPUT FIELDS
    // =============================================================

    private void clearInputFields() {

        idField.clear();
        nameField.clear();
        phoneField.clear();
        emailField.clear();
        addressField.clear();

        table.getSelectionModel()
                .clearSelection();
    }

    // =============================================================
    // CLEAR FIELDS BUTTON
    // =============================================================

    private void clearFields() {

        clearInputFields();

        searchField.clear();

        statusLabel.setText(
                "Fields cleared"
        );
    }

    // =============================================================
    // CREATE TEXT FIELD
    // =============================================================

    private TextField createTextField(
            String prompt) {

        TextField field =
                new TextField();

        field.setPromptText(
                prompt
        );

        field.setPrefHeight(35);

        field.setMaxWidth(
                Double.MAX_VALUE
        );

        field.setStyle(
                "-fx-background-color: #FAFCFD;" +
                "-fx-background-radius: 7;" +
                "-fx-border-radius: 7;" +
                "-fx-border-color: #CFD8DC;" +
                "-fx-padding: 7 10 7 10;" +
                "-fx-font-size: 13px;"
        );

        return field;
    }

    // =============================================================
    // CREATE LABEL
    // =============================================================

    private Label createLabel(
            String text) {

        Label label =
                new Label(text);

        label.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        12
                )
        );

        label.setTextFill(
                Color.web("#455A64")
        );

        return label;
    }

    // =============================================================
    // CREATE MAIN BUTTON
    // =============================================================

    private Button createButton(
            String text) {

        Button button =
                new Button(text);

        button.setPrefHeight(35);
        button.setPrefWidth(130);

        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        11
                )
        );

        button.setStyle(
                "-fx-background-color: #37474F;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 7;" +
                "-fx-cursor: hand;"
        );

        return button;
    }

    // =============================================================
    // CREATE LIGHT BUTTON
    // =============================================================

    private Button createLightButton(
            String text) {

        Button button =
                new Button(text);

        button.setPrefHeight(35);
        button.setPrefWidth(130);

        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        11
                )
        );

        button.setStyle(
                "-fx-background-color: #ECEFF1;" +
                "-fx-text-fill: #37474F;" +
                "-fx-background-radius: 7;" +
                "-fx-border-color: #CFD8DC;" +
                "-fx-border-radius: 7;" +
                "-fx-cursor: hand;"
        );

        return button;
    }

    // =============================================================
    // CREATE SMALL BUTTON
    // =============================================================

    private Button createSmallButton(
            String text) {

        Button button =
                new Button(text);

        button.setPrefHeight(35);
        button.setPrefWidth(90);

        button.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        11
                )
        );

        button.setStyle(
                "-fx-background-color: #455A64;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 7;" +
                "-fx-cursor: hand;"
        );

        return button;
    }

    // =============================================================
    // STYLE COMBO BOX
    // =============================================================

    private void styleComboBox(
            ComboBox<String> box) {

        box.setStyle(
                "-fx-background-color: #FAFCFD;" +
                "-fx-border-color: #CFD8DC;" +
                "-fx-border-radius: 7;" +
                "-fx-background-radius: 7;" +
                "-fx-font-size: 12px;"
        );
    }

    // =============================================================
    // STYLE CARD
    // =============================================================

    private void setCardStyle(
            VBox card) {

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: #E0E6E9;" +
                "-fx-effect: dropshadow(" +
                "gaussian, rgba(0,0,0,0.08), " +
                "8, 0, 0, 2);"
        );
    }

    // =============================================================
    // ALERT
    // =============================================================

    private void showAlert(
            String title,
            String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(title);

        alert.setHeaderText(null);

        alert.setContentText(
                message
        );

        alert.showAndWait();
    }

    // =============================================================
    // MAIN
    // =============================================================

    public static void main(
            String[] args) {

        launch(args);
    }
}
