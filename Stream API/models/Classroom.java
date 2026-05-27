package models;

import java.util.List;

public class Classroom {
    private String grade;
    private List<Book> borrowedBooks;

    public Classroom(String grade, List<Book> borrowedBooks) {
        this.grade = grade;
        this.borrowedBooks = borrowedBooks;
    }
    public String getGrade() { return grade; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
}
