package DummiesBook.Book8.chapter5_WorkingWithXML;

// Listing 5.3

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import java.text.NumberFormat;
import java.io.File;

public class ListMoviesXMl {

    private static final NumberFormat cf = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        String filePath = "C:\\Bootcamp\\JAVA\\Java_Advanced\\java_work\\DummiesBook\\Book8\\chapter5_WorkingWithXML\\movies.xml";
        File xmlFile = new File(filePath);

        // Check if file exists
        if (!xmlFile.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        Document doc = getDocument(filePath);

        if (doc == null) {
            System.out.println("Failed to load the XML document.");
            return;
        }

        Element root = doc.getDocumentElement();
        Node movieNode = root.getFirstChild();
        Movie m;

        while (movieNode != null) {
            if (movieNode instanceof Element) { // Only process Element nodes
                Element movieElement = (Element) movieNode;
                m = getMovie(movieElement);
                String msg = m.year + ": " + m.title + " (" + cf.format(m.price) + ")";
                System.out.println(msg);
            }
            movieNode = movieNode.getNextSibling();
        }
    }

    private static Document getDocument(String name) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setValidating(false);  // Disable validation temporarily
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(name));
        } catch (Exception e) {
            System.out.println("Error parsing document \"" + name + "\": " + e.getMessage());
            e.printStackTrace();  // Print stack trace for debugging
        }
        return null;
    }

    private static Movie getMovie(Element e) {
        // Get the year attribute
        String yearString = e.getAttribute("year");
        int year = Integer.parseInt(yearString);

        // Get the Title and Price elements
        String title = null;
        double price = 0.0;

        Node childNode = e.getFirstChild();
        while (childNode != null) {
            if (childNode instanceof Element) {
                Element element = (Element) childNode;
                if (element.getTagName().equals("Title")) {
                    title = getTextValue(element).trim();
                } else if (element.getTagName().equals("Price")) {
                    price = Double.parseDouble(getTextValue(element).trim());
                }
            }
            childNode = childNode.getNextSibling();
        }

        return new Movie(title, year, price);
    }

    private static String getTextValue(Node n) {
        return n.getFirstChild().getNodeValue();
    }

    private static class Movie {
        public String title;
        public int year;
        public double price;

        public Movie(String title, int year, double price) {
            this.title = title;
            this.year = year;
            this.price = price;
        }
    }
}
