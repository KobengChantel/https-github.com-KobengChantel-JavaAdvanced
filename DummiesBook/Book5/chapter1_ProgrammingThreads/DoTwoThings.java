package DummiesBook.Book5.chapter1_ProgrammingThreads;
//LISTING 1.7
//Creating Two CountDownClock Threads


import java.util.concurrent.ScheduledThreadPoolExecutor;
public class DoTwoThings
{
    ScheduledThreadPoolExecutor pool =
            new ScheduledThreadPoolExecutor(2);
    CountDownClock7 clock = new CountDownClock7(20);
    public static void main(String[] args)
    {
        new DoTwoThings();
    }
    DoTwoThings()
    {
        pool.execute(clock);
        pool.execute(clock);
        pool.shutdown();
    }
}