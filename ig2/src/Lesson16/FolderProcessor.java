package Lesson16;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {

    //recursion is when something is calling itelf within its own body(for example functions)
    private static final long serialVersionUID = 1L;

    //this attribute will store the full path of the folder this task is going to process
    private final String path;

    //this attribute will store the name of the extension of the file this task is going to look for
    private final String extension;

    //this  will emplement the constructor of the clss to initialize its attributes
    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    //implement the compute() method. As you parameterized the recursiveTask class with the List<String> type
    @Override
    protected List<String> compute() {
        //List to store the names of the files stored in the folder
        List<String> list = new ArrayList<String>();
        //FolderProcessor tasks to store the subtasks that are going to process the subfolders stored in the folder
        List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
        //get the content of the folder
        File file = new File(path);
        File content[] = file.listFiles();
        //for each element in the folder, if there is a subfolder, create a new FolderProcessor object
        //and execute it synchronously using the fork() method
        if (content != null) {
            for (int i = 0; i < content.length; i++) {
                if (content[i].isDirectory()) {
                    FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(), extension);
                    task.fork();
                    tasks.add(task);

                }
                //otherwise, compare the extension of the file wit the extension you are lookinf for using the checkFile(
                //method
                //and if they are equal, store the full path of the file in the list of strings declared earlier
                else {
                    if (checkFile(content[i].getName())) {
                        list.add(content[i].getAbsolutePath());
                    }
                }
            }
        }
        //if the list of the FoderProcessor subtasks has more than 50 elements, write a message to the console to indicate this circumstance
        if (tasks.size() > 50) {
            System.out.println("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
        }
        //add to teh list of the files the results returned by the subtasks launched by this task
        addResultsFromTasks(list, tasks);
        return list;
    }

    //for each task stored in the list os tasks,call the join() method that
    //will wait for its finalization and then will return the result of the week
    //Add that  result to the list of strings using the addAll() method
    private void addResultsfromTasks(List<String> list, List<FolderProcessor> tasks) {
        for (FolderProcessor item : tasks) {
            list.addAll(item.join());
        }
    }
//this method compares if the name of a file passed as a parameter ends with the extension you are looking for
private boolean checkFile(String fileName) {
        return name.endsWith(extension);
}
}
