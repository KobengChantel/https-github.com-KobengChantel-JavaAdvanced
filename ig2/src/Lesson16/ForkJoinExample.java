package Lesson16;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

// This class demonstrates using a ForkJoinPool to run multiple FolderProcessor tasks concurrently to search for files with specific extensions in different directories.
public class ForkJoinExample {
    public static void main(String[] args) {

        // Create a ForkJoinPool to manage and execute ForkJoinTasks
        ForkJoinPool pool = new ForkJoinPool();

        // Create FolderProcessor tasks to search for ".log" files in Windows and Program Files folders,
        // and ".txt" files in a user-defined directory
        FolderProcessor system = new FolderProcessor("C:\\Windows", "log");
        FolderProcessor apps = new FolderProcessor("C:\\Program Files", "log");
        FolderProcessor documents = new FolderProcessor("C:\\Users\\Chantel\\YourJavaDirectory", "txt");

        // Execute the three tasks asynchronously in the pool
        pool.execute(system);
        pool.execute(apps);
        pool.execute(documents);

        // Periodically print status info about the pool while tasks are running
        do {
            System.out.printf("********************************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("********************************************************\n");

            try {
                // Sleep for 1 second before printing status again
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Continue while any of the tasks are still not finished
        } while ((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));

        // Shutdown the pool after all tasks are completed
        pool.shutdown();

        // Retrieve and print the number of files found by each task
        List<String> results;

        results = system.join();
        System.out.printf("System: %d files found.\n", results.size());

        results = apps.join();
        System.out.printf("Apps: %d files found.\n", results.size());

        results = documents.join();
        System.out.printf("Documents: %d files found.\n", results.size());
    }
}
