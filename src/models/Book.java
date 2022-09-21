package models;

public class Book {

    private int id;
    private String author, title;
    private int publishYear;

    public Book(int id, String author, String title, int publishYear) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publishYear = publishYear;
    }
    public Book(String author, String title, int publishYear) {
        this.author = author;
        this.title = title;
        this.publishYear = publishYear;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishYear() {
        return publishYear;
    }
}
