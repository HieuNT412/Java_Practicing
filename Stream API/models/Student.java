package models;

public class Student {

    String name;  // Tên học sinh
    String grade; // Lớp (ví dụ: "10A", "10B")
    int score;    // Điểm số (từ 0 đến 100)

    public Student(String name, String grade, int score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
