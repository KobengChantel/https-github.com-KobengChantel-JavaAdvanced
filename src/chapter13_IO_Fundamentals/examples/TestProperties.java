package chapter13_IO_Fundamentals.examples;

import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.list(System.out);
    }
}