package models;

public class Book {
    private String title;
    private String category;
    private int pages;

    public Book(String title, String category, int pages) {
        this.title = title;
        this.category = category;
        this.pages = pages;
    }
    public String getCategory() { return category; }
    public int getPages() { return pages; }
}
