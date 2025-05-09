package DummiesBook.Book8.chapter1_WorkingWithFiles;

import java.io.*;
public class ListDirectory
{
    public static void main(String[] args)
    {
        if (args.length > 0)
        {
            String path = args[0];
            File dir = new File(path);
            if (dir.isDirectory())
            {
                File[] files = dir.listFiles();
                for (File f : files)
                {
                    System.out.println(f.getName());
                }
            }
            else
                System.out.println("Not a directory.");
        }
    }
}
