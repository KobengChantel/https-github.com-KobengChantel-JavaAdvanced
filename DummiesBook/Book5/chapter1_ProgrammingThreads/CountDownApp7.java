package DummiesBook.Book5.chapter1_ProgrammingThreads;
// LISTING 1.13
//The Countdown Application with Aborts
//ow you can interrupt threads, Listing 1-13 shows yet another ver-
//sion of the countdown application. This version aborts the countdown if some-
//thing goes wrong with any of the launch events


import java.util.ArrayList;
public class CountDownApp7
        {
public static void main(String[] args)
{
    CountDownClock7 clock = new CountDownClock7(20);
    ArrayList<Runnable> events =
            new ArrayList<Runnable>();
    events.add(new LaunchEvent7(16,
            "Flood the pad!", clock));
    events.add(new LaunchEvent7(6,
            "Start engines!", clock));


    events.add(new LaunchEvent7(0,
            "Liftoff!", clock));
    clock.start();
    for (Runnable e : events)
        new Thread(e).start();
}
}
interface TimeMonitor7
{
    int getTime();
    void abortCountDown();
}
class CountDownClock7 extends Thread
        implements TimeMonitor7
{
    private int t;
    public CountDownClock7(int start)
    {
        this.t = start;
    }
    public void run()
    {
        boolean aborted = false;
        for (; t >= 0; t--)
        {
            System.out.println("T minus " + t);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                aborted = true;
            }
            if (Thread.interrupted())
                aborted = true;
            if (aborted)
            {
                System.out.println(
                        "Stopping the clock!");
                break;
            }
        }
    }


    public int getTime()
    {
        return t;
    }
    public synchronized void abortCountDown()
    {
        Thread[] threads =
                new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for(Thread t : threads)
        t.interrupt();
    }
}
class LaunchEvent7 implements Runnable
{
    private int start;
    private String message;
    TimeMonitor7 tm;
    public LaunchEvent7(int start, String message,
                        TimeMonitor7 monitor)
    {
        this.start = start;
        this.message = message;
        this.tm = monitor;
    }
    public void run()
    {
        boolean eventDone = false;
        boolean aborted = false;
        while (!eventDone)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                aborted = true;
            }
            if (tm.getTime() <= start)
            {
                System.out.println(this.message);
                eventDone = true;
                System.out.println("ABORT!!!!");


                tm.abortCountDown();
            }
            if (Thread.interrupted())
                aborted = true;
            if (aborted)
            {
                System.out.println(
                        "Aborting " + message);
                break;
            }
        }
    }
}