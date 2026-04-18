package com.pluralsight;

public class Book {

    // Properties/ Instances
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructor
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false; // default to not checked out
        this.checkedOutTo = "";    // default to no one

    }

    // Getters
    public int getId() {
        return id;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public boolean isCheckedOut() {
        return isCheckedOut;
    }
    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCheckedOut(boolean checkedOut) {
        this.isCheckedOut = checkedOut; }
    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo; }


    // Methods
    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }

    public void checkIn(String name) {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

}
