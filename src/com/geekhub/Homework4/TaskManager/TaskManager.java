package com.geekhub.Lesson04.Homework01;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TaskManager {
    void add(LocalDateTime date, Task task);

    void remove(LocalDateTime date);

    Set<String> getCategories();

    Map<String, List<Task>> getTasksByCategories(String... categories);

    List<Task> getTasksByCategory(String category);

    List<Task> getTasksForToday();
}
