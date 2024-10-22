package chapter13_IO_Fundamentals.examples.ScannerExample;

public class StockException extends Exception {
    private static final long serialVersionUID = 103L;
    public StockException(String reason) {
        super (reason);
    }
}
