package chapter2.db;

import chapter2.tasks.News;
import chapter2.tasks.TaskManager;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<News> allNews = new ArrayList<>();

//task1
    static {
        allNews.add(new News(1l,"sadfsdf","sdfsdf","sdfsfaaaaa","sport"));
        allNews.add(new News(1l,"cinema","uiknkjabk","qwerty","cinema"));
        allNews.add(new News(1l,"culture of ancient","okasokmnv","werftgy","culture"));
        allNews.add(new News(1l,"yesyysy","vbnm","ronaldo","sport"));
    }

    public static ArrayList<News> getAllNews() {
        return allNews;
    }

    //task2
    private static ArrayList<TaskManager> allTasks = new ArrayList<>();
    private static Long id=5l;
    static {
        allTasks.add(new TaskManager
                (1l,"Create WEB application","hEROVO","25.05.22","YES"));
        allTasks.add(new TaskManager
                (2l,"Create WEB application","qqwert","24.03.22","NO"));
        allTasks.add(new TaskManager
                (3l,"Create WEB application","KJFXHBKJF","20.02.22","YES"));
        allTasks.add(new TaskManager
                (4l,"Create WEB application","PLONKHO","12.04.22","NO"));
    }
public static void addTask(TaskManager taskManager){
 taskManager.setId(id);
 allTasks.add(taskManager);
 id++;
}
public static ArrayList<TaskManager> getAllTasks() {
        return allTasks;
}
public static TaskManager getTask(Long id) {
        for (TaskManager ts:allTasks) {
            if (id== ts.getId())
                return ts;
        }
        return null;
}
    public static void deleteTask(Long id) { //этот метод удаляет задачу из списка по id
        int i = 0;
        for (TaskManager t : allTasks) {
            if (t.getId() == id) {
                allTasks.remove(i);
                return;
            }
            i++;
        }
    }
    public static void saveTask(Long id, TaskManager task) { //этот метод сохраняет изменения в задаче
        int i = 0;
        for (TaskManager t : allTasks) {
            if (t.getId() == id) {
                allTasks.set(i, task);
                return;
            }
            i++;
        }
    }
}
