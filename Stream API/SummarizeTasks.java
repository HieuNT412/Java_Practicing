import models.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummarizeTasks {
    public static Map<Boolean, String> summarizeTasks(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) return new HashMap<>();

        Map<Boolean, String> result = tasks.stream()
                .collect(Collectors.partitioningBy(
                        Task::isCompleted,
                        Collectors.mapping(
                                Task::getTitle,
                                Collectors.joining(", ")
                        )
                ));
        return result;
    }

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("Code tính năng", true),
                new Task("Họp đội ngũ", false),
                new Task("Sửa lỗi UI", true),
                new Task("Viết tài liệu", false)
        );

        Map<Boolean, String> result = summarizeTasks(tasks);

        // Kết quả mong đợi:
        // {false=Họp đội ngũ, Viết tài liệu, true=Code tính năng, Sửa lỗi UI}
        System.out.println("Tóm tắt công việc: " + result);
    }
}
