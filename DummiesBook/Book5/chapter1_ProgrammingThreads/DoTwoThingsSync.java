package DummiesBook.Book5.chapter1_ProgrammingThreads;
//LISTING 1.9
//Creating Two More CountDownClock Threads
//


import java.util.concurrent.ScheduledThreadPoolExecutor;
public class DoTwoThingsSync
{
    ScheduledThreadPoolExecutor pool =
            new ScheduledThreadPoolExecutor(2);
    CountDownClockSync clock =
            new CountDownClockSync(20);
    public static void main(String[] args)
    {
        new DoTwoThingsSync();
    }
    DoTwoThingsSync()
    {
        pool.execute(clock);
        pool.execute(clock);
        pool.shutdown();
    }
}