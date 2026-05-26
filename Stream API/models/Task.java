package models;

public class Task {
    private String title;      // Tên công việc
    private boolean completed; // Trạng thái: true (đã xong), false (chưa xong)

    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }
}
