package com.geekhub.Lesson04.Homework01;

import java.time.LocalDateTime;
import java.util.*;

public class TaskManagerImpl implements TaskManager {
    private static Map<LocalDateTime, Task> map = new TreeMap<>();

    public void add(LocalDateTime date, Task task) {
        map.put(date, task);
    }

    public void remove(LocalDateTime date) {
        map.remove(date);
    }

    public Set<String> getCategories() {
        Set<String> categories = new HashSet<>();
        for (Map.Entry<LocalDateTime, Task> entry : map.entrySet()) {
            Task value = entry.getValue();
            if (value.getCategory() != null) {
                categories.add(value.getCategory());
            }
        }
        return categories;
    }

    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        Map<String, List<Task>> tasksByCategories = new TreeMap<>();
        for (Map.Entry<LocalDateTime, Task> entry : map.entrySet()) {
            Task value = entry.getValue();
            for (String category : categories) {
                List<Task> tasksList = tasksByCategories.get(category);
                if (tasksList != null) {
                    tasksList = new ArrayList<>();
                    tasksByCategories.put(category, tasksList);
                }
                tasksList.add(value);
            }
        }
        return tasksByCategories;
    }

    public List<Task> getTasksByCategory(String category) {
        List<Task> tasksByCategory = null;
        for (Map.Entry<LocalDateTime, Task> entry : map.entrySet()) {
            Task value = entry.getValue();
            if (value.getCategory() == category) {
                if (tasksByCategory == null) {
                    tasksByCategory = new ArrayList<>();
                }
                tasksByCategory.add(value);
            }
        }
        return tasksByCategory;
    }

    public List<Task> getTasksForToday() {
        List<Task> tasksForToday = null;
        for (Map.Entry<LocalDateTime, Task> entry : map.entrySet()) {
            Task value = entry.getValue();
            LocalDateTime date = entry.getKey(), today = LocalDateTime.now();

            if (today == date) {
                tasksForToday.add(value);
            }
        }
        return tasksForToday;
    }
}
