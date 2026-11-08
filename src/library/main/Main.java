package library.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import library.book.Book;
import library.service.LibraryService;

public class Main extends JFrame implements ActionListener {

    
    private LibraryService service;


    
    private JTextField idField;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField searchField;


    
    private JPanel booksPanel;


    
    private JButton addButton;
    private JButton searchButton;
    private JButton issueButton;
    private JButton returnButton;
    private JButton deleteButton;
    private JButton refreshButton;
    private JButton clearButton;


    
    private Color backgroundColor =
            new Color(245, 247, 250);

    private Color cardColor =
            Color.WHITE;

    private Color primaryColor =
            new Color(52, 73, 94);

    private Color buttonColor =
            new Color(41, 128, 185);

    private Color successColor =
            new Color(39, 174, 96);

    private Color dangerColor =
            new Color(192, 57, 43);


    
    public Main() {

        service = new LibraryService();

        setTitle("📚 Library Management System");

        setSize(1000, 700);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        createGUI();

        loadBooks();
    }


    
    private void createGUI() {

        getContentPane().setBackground(
                backgroundColor
        );


        
        JPanel headerPanel =
                new JPanel(new BorderLayout());

        headerPanel.setBackground(
                primaryColor
        );

        headerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 25, 20, 25
                )
        );


        JLabel titleLabel =
                new JLabel(
                        "📚  LIBRARY MANAGEMENT SYSTEM"
                );

        titleLabel.setForeground(Color.WHITE);

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );


        JLabel subtitleLabel =
                new JLabel(
                        "Manage your books easily"
                );

        subtitleLabel.setForeground(
                new Color(220, 220, 220)
        );

        subtitleLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );


        JPanel titlePanel =
                new JPanel(
                        new GridLayout(2, 1)
                );

        titlePanel.setOpaque(false);

        titlePanel.add(titleLabel);

        titlePanel.add(subtitleLabel);


        headerPanel.add(
                titlePanel,
                BorderLayout.WEST
        );


        add(
                headerPanel,
                BorderLayout.NORTH
        );


        
        JPanel centerPanel =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        centerPanel.setBackground(
                backgroundColor
        );

        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 20, 20, 20
                )
        );


        
        JPanel inputPanel =
                createInputPanel();


        centerPanel.add(
                inputPanel,
                BorderLayout.NORTH
        );


        
        booksPanel =
                new JPanel();

        booksPanel.setBackground(
                backgroundColor
        );

        booksPanel.setLayout(
                new GridLayout(0, 3, 15, 15)
        );


        JScrollPane scrollPane =
                new JScrollPane(booksPanel);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);


        centerPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );


        add(
                centerPanel,
                BorderLayout.CENTER
        );
    }


    
    private JPanel createInputPanel() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout(10, 10)
                );

        mainPanel.setBackground(
                backgroundColor
        );


        
        JPanel searchPanel =
                new JPanel(
                        new BorderLayout(5, 5)
                );

        searchPanel.setBackground(
                backgroundColor
        );


        searchField =
                new JTextField();

        searchField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        searchField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(200, 200, 200)
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 10, 8, 10
                        )
                )
        );


        searchButton =
                createButton(
                        "🔍 Search",
                        buttonColor
                );


        searchPanel.add(
                searchField,
                BorderLayout.CENTER
        );

        searchPanel.add(
                searchButton,
                BorderLayout.EAST
        );


        JPanel detailsPanel =
                new JPanel(
                        new GridLayout(1, 6, 8, 8)
                );

        detailsPanel.setBackground(
                backgroundColor
        );


        idField =
                createTextField();

        titleField =
                createTextField();

        authorField =
                createTextField();


        detailsPanel.add(
                createLabelPanel(
                        "Book ID",
                        idField
                )
        );

        detailsPanel.add(
                createLabelPanel(
                        "Title",
                        titleField
                )
        );

        detailsPanel.add(
                createLabelPanel(
                        "Author",
                        authorField
                )
    );

        addButton =
                createButton(
                        "➕ Add",
                        successColor
                );

        issueButton =
                createButton(
                        "📖 Issue",
                        buttonColor
                );

        returnButton =
                createButton(
                        "↩ Return",
                        buttonColor
                );

        deleteButton =
                createButton(
                        "🗑 Delete",
                        dangerColor
                );

        clearButton =
                createButton(
                        "✖ Clear",
                        primaryColor
                );

        refreshButton =
                createButton(
                        "🔄 Refresh",
                        primaryColor
                );


        detailsPanel.add(addButton);
        detailsPanel.add(issueButton);
        detailsPanel.add(returnButton);
        detailsPanel.add(deleteButton);


        JPanel bottomPanel =
                new JPanel(
                        new BorderLayout(8, 8)
                );

        bottomPanel.setBackground(
                backgroundColor
        );

        bottomPanel.add(
                detailsPanel,
                BorderLayout.CENTER
        );


        JPanel rightButtons =
                new JPanel(
                        new GridLayout(1, 2, 5, 5)
                );

        rightButtons.setBackground(
                backgroundColor
        );

        rightButtons.add(clearButton);
        rightButtons.add(refreshButton);


        bottomPanel.add(
                rightButtons,
                BorderLayout.EAST
        );


        mainPanel.add(
                searchPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                bottomPanel,
                BorderLayout.CENTER
        );


        
        searchButton.addActionListener(this);

        addButton.addActionListener(this);

        issueButton.addActionListener(this);

        returnButton.addActionListener(this);

        deleteButton.addActionListener(this);

        clearButton.addActionListener(this);

        refreshButton.addActionListener(this);


        return mainPanel;
    }


    
    private JPanel createLabelPanel(
            String text,
            JTextField field) {

        JPanel panel =
                new JPanel(
                        new BorderLayout(3, 3)
                );

        panel.setBackground(
                backgroundColor
        );


        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );


        panel.add(
                label,
                BorderLayout.NORTH
        );

        panel.add(
                field,
                BorderLayout.CENTER
        );


        return panel;
    }


   
    private JTextField createTextField() {

        JTextField field =
                new JTextField();

        field.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(200, 200, 200)
                        ),
                        BorderFactory.createEmptyBorder(
                                6, 8, 6, 8
                        )
                )
        );


        return field;
    }


    
    private JButton createButton(
            String text,
            Color color) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(Color.WHITE);

        button.setBackground(color);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        8, 12, 8, 12
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.setMargin(
                new Insets(5, 10, 5, 10)
        );


        return button;
    }


    
    @Override
    public void actionPerformed(
            ActionEvent e) {


        if (e.getSource() == addButton) {

            addBook();


        } else if (e.getSource() == searchButton) {

            searchBook();


        } else if (e.getSource() == issueButton) {

            issueBook();


        } else if (e.getSource() == returnButton) {

            returnBook();


        } else if (e.getSource() == deleteButton) {

            deleteBook();


        } else if (e.getSource() == clearButton) {

            clearFields();


        } else if (e.getSource() == refreshButton) {

            loadBooks();
        }
    }


   
    private void addBook() {

        try {

            String idText =
                    idField.getText().trim();

            String title =
                    titleField.getText().trim();

            String author =
                    authorField.getText().trim();


            if (idText.isEmpty()) {

                showMessage(
                        "Please enter Book ID."
                );

                return;
            }


            if (title.isEmpty()) {

                showMessage(
                        "Please enter book title."
                );

                return;
            }


            if (author.isEmpty()) {

                showMessage(
                        "Please enter author name."
                );

                return;
            }


            int id =
                    Integer.parseInt(idText);


            String message =
                    service.addBook(
                            id,
                            title,
                            author
                   );


            showMessage(message);


            loadBooks();

            clearFields();


        } catch (NumberFormatException e) {

            showMessage(
                    "Book ID must be a number."
            );
        }
    }


    
    private void searchBook() {

        try {

            String idText =
                    searchField.getText().trim();


            if (idText.isEmpty()) {

                idText =
                        idField.getText().trim();
            }


            if (idText.isEmpty()) {

                showMessage(
                        "Please enter Book ID to search."
                );

                return;
            }


            int id =
                    Integer.parseInt(idText);


            Book book =
                    service.searchBook(id);


            if (book == null) {

                showMessage(
                        "📕 Book not found."
                );

                return;
            }


            idField.setText(
                    String.valueOf(
                            book.getBookId()
                    )
            );


            titleField.setText(
                    book.getTitle()
            );


            authorField.setText(
                    book.getAuthor()
            );


            showMessage(
                    "📚 Book Found!\n\n" +
                    book.toString()
            );


        } catch (NumberFormatException e) {

            showMessage(
                    "Enter a valid Book ID."
            );
        }
    }


    private void issueBook() {

        try {

            int id =
                    getBookId();


            if (id == -1) {
                return;
            }


            String message =
                    service.issueBook(id);


            showMessage(message);


            loadBooks();


        } catch (Exception e) {

            showMessage(
                    "Unable to issue book."
            );
        }
    }


   
    private void returnBook() {

        try {

            int id =
                    getBookId();


            if (id == -1) {
                return;
            }


            String message =
                    service.returnBook(id);


            showMessage(message);


            loadBooks();


        } catch (Exception e) {

            showMessage(
                    "Unable to return book."
            );
        }
    }


    
    private void deleteBook() {

        try {

            int id =
                    getBookId();


            if (id == -1) {
                return;
            }


            int result =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Are you sure you want to delete this book?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION
                    );


            if (result !=
                    JOptionPane.YES_OPTION) {

                return;
            }


            String message =
                    service.deleteBook(id);


            showMessage(message);


            loadBooks();

            clearFields();


        } catch (Exception e) {

            showMessage(
                    "Unable to delete book."
            );
        }
    }


  
    private int getBookId() {

        String idText =
                idField.getText().trim();


        if (idText.isEmpty()) {

            showMessage(
                    "Please enter or select a Book ID."
            );

            return -1;
        }


        try {

            return Integer.parseInt(idText);

        } catch (NumberFormatException e) {

            showMessage(
                    "Book ID must be a number."
            );

            return -1;
        }
    }


   
    private void loadBooks() {

        booksPanel.removeAll();


        List<Book> books =
                service.getAllBooks();


        if (books.isEmpty()) {

            JLabel emptyLabel =
                    new JLabel(
                            "📚 No books available",
                            SwingConstants.CENTER
                    );

            emptyLabel.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            18
                    )
            );


            booksPanel.setLayout(
                    new BorderLayout()
            );


            booksPanel.add(
                    emptyLabel,
                    BorderLayout.CENTER
            );


        } else {

            booksPanel.setLayout(
                    new GridLayout(
                            0,
                            3,
                            15,
                            15
                    )
            );


            for (Book book : books) {

                JPanel card =
                        createBookCard(book);


                booksPanel.add(card);
            }
        }


        booksPanel.revalidate();

        booksPanel.repaint();
    }


   
    private JPanel createBookCard(
            final Book book) {

        JPanel card =
                new JPanel(
                        new BorderLayout(8, 8)
                );


        card.setBackground(cardColor);


        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 220, 220),
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                12, 12, 12, 12
                        )
                )
        );


     
        JLabel iconLabel =
                new JLabel(
                        "📖",
                        SwingConstants.CENTER
                );


        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        45
                )
        );


        card.add(
                iconLabel,
                BorderLayout.WEST
        );


       
        JPanel infoPanel =
                new JPanel(
                        new GridLayout(
                                4,
                                1,
                                2,
                                2
                        )
                );


        infoPanel.setOpaque(false);


        JLabel titleLabel =
                new JLabel(
                        book.getTitle()
                );


        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );


        JLabel authorLabel =
                new JLabel(
                        "✍ " +
                        book.getAuthor()
                );


        authorLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );


        JLabel idLabel =
                new JLabel(
                        "ID: " +
                        book.getBookId()
                );


        idLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );


        JLabel statusLabel;


        if (book.isAvailable()) {

            statusLabel =
                    new JLabel(
                            "● Available"
                    );

            statusLabel.setForeground(
                    successColor
            );

        } else {

            statusLabel =
                    new JLabel(
                            "● Issued"
                    );

            statusLabel.setForeground(
                    dangerColor
            );
        }


        statusLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );


        infoPanel.add(titleLabel);

        infoPanel.add(authorLabel);

        infoPanel.add(idLabel);

        infoPanel.add(statusLabel);


        card.add(
                infoPanel,
                BorderLayout.CENTER
        );


        
        JButton selectButton =
                createButton(
                        "Select",
                        primaryColor
                );


        selectButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        selectBook(book);
                    }
                }
        );


        card.add(
                selectButton,
                BorderLayout.SOUTH
        );


       
        card.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );


        return card;
    }


   
    private void selectBook(
            Book book) {

        idField.setText(
                String.valueOf(
                        book.getBookId()
                )
        );


        titleField.setText(
                book.getTitle()
        );


        authorField.setText(
                book.getAuthor()
        );
    }


    
    private void clearFields() {

        idField.setText("");

        titleField.setText("");

        authorField.setText("");

        searchField.setText("");
    }


    
    private void showMessage(
            String message) {

        JOptionPane.showMessageDialog(
                this,
                message
        );
    }


   
    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {

                        Main gui =
                                new Main();

                        gui.setVisible(true);
                    }
                }
        );
    }
}