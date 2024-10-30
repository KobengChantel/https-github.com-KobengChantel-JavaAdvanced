package DummiesBook.Book5.chapter1_ProgrammingThreads;
// LISTING 1.10
//Using the synchronized Keyword

//synchronized keyword ensures that only one thread at a
//time calls the run method. The resulting output shows one complete execution of
//the run method followed by another


class CountDownClockSync extends Thread
{
    private int start;
    public CountDownClockSync(int start)
    {
        this.start = start;
    }
    synchronized public void run()
    {
        for (int t = start; t >= 0; t--)
        {
            System.out.println("T minus " + t);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {}
        }
    }
}
