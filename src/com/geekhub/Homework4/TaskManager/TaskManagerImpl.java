package com.geekhub.Lesson04.Homework01;

import java.time.LocalDateTime;
import java.util.*;

public class TaskManagerImpl implements TaskManager {
    private Map<LocalDateTime, Task> tasksDateMap = new TreeMap<>();

    @Override
    public void add(LocalDateTime date, Task task) {
        tasksDateMap.put(date, task);
    }

    @Override
    public void remove(LocalDateTime date) {
        tasksDateMap.remove(date);
    }

    @Override
    public Set<String> getCategories() {
        Set<String> categories = new HashSet<>(Collections.EMPTY_SET);
        for (Task tasksValue : tasksDateMap.values()) {
            for (String itrCategorySet : categories) {
                if (!tasksValue.getCategory().equals(itrCategorySet)) {
                    categories.add(tasksValue.getCategory());
                }
            }
        }
        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        Map<String, List<Task>> tasksByCategories = new HashMap<>(Collections.EMPTY_MAP);
        for (String itrCategory : categories) {
            tasksByCategories.put(itrCategory, getTasksByCategory(itrCategory));
        }
        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> tasksByCategory = new ArrayList<Task>(Collections.EMPTY_SET);
        for (Task tasksValue : tasksDateMap.values()) {
            if (tasksValue.getCategory().equals(category)) {
                if (tasksByCategory.isEmpty()) {
                    tasksByCategory = new ArrayList<>();
                }
                tasksByCategory.add(tasksValue);
            }
        }
        return tasksByCategory;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasksForToday = new ArrayList<>(Collections.EMPTY_SET);
        for (Map.Entry<LocalDateTime, Task> entry : tasksDateMap.entrySet()) {
            Task value = entry.getValue();
            LocalDateTime date = entry.getKey(),
                    today = LocalDateTime.now();

            if (today.getDayOfYear() == date.getDayOfYear()
                    && today.getMonth() == date.getMonth()
                    && today.getDayOfMonth() == date.getDayOfMonth()) {
                tasksForToday.add(value);
            }
        }
        return tasksForToday;
    }
}
