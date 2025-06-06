package DummiesBook.Book5.chapter1_ProgrammingThreads;
// LISTING 1.11
//Creating CountDownClock Threads (Again)

import java.util.concurrent.ScheduledThreadPoolExecutor;
public class DoTwoThingsLocked {
    ScheduledThreadPoolExecutor pool =
            new ScheduledThreadPoolExecutor(2);
    CountDownClockLocked clock =
            new CountDownClockLocked();
    public static void main(String[] args)
    {
        new DoTwoThingsLocked();
    }
    DoTwoThingsLocked()
    {
        pool.execute(clock);
        pool.execute(clock);
        pool.shutdown();
    }
}
