/*
 * Copyright (c) 2008, 2009, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package Lesson14;

import java.io.IOException;
import java.nio.file.*;

/**
 * Example utility that works like the df(1M) program to print out disk space
 * information
 */

//utility program mimics the UNIX df command by displaying total, used, and available disk space in kilobytes for all file systems or specified file paths.

public class DiskUsage {

    // Constant for kilobyte conversion (1 KB = 1024 bytes)
    static final long K = 1024;

    /**
     * Prints disk space info for a given FileStore in kilobytes.
     */
    static void printFileStore(FileStore store) throws IOException {
        // Total space in KB
        long total = store.getTotalSpace() / K;
        // Used space = total - unallocated
        long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / K;
        // Available space in KB
        long avail = store.getUsableSpace() / K;

        // If store name is too long, print it separately
        String s = store.toString();
        if (s.length() > 20) {
            System.out.println(s);
            s = "";
        }

        // Format and print the disk usage info
        System.out.format("%-20s %12d %12d %12d\n", s, total, used, avail);
    }

    public static void main(String[] args) throws IOException {
        // Print table headers
        System.out.format("%-20s %12s %12s %12s\n", "Filesystem", "kbytes", "used", "avail");

        if (args.length == 0) {
            // No arguments: list all file stores from default file system
            FileSystem fs = FileSystems.getDefault();
            for (FileStore store : fs.getFileStores()) {
                printFileStore(store);
            }
        } else {
            // If arguments are provided, list disk usage for each specified path
            for (String file : args) {
                FileStore store = Files.getFileStore(Paths.get(file));
                printFileStore(store);
            }
        }
    }
}