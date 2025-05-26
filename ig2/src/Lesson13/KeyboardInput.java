// Source code is decompiled from a .class file using FernFlower decompiler.
package Lesson13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {
    public KeyboardInput() {
    }

    public static void main(String[] var0) {
        String var1 = "";

        try {
            BufferedReader var2 = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.print("Type xyz to exit: ");

                for(var1 = var2.readLine(); var1 != null; var1 = var2.readLine()) {
                    System.out.println("Read: " + var1.trim());
                    if (var1.equals("xyz")) {
                        System.exit(0);
                    }

                    System.out.print("Type xyz to exit: ");
                }
            } catch (Throwable var6) {
                try {
                    var2.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            var2.close();
        } catch (IOException var7) {
            System.out.println("Exception: " + var7);
        }

    }
}
