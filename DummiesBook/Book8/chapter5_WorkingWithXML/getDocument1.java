package DummiesBook.Book8.chapter5_WorkingWithXML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class getDocument1 {

    public static void main(String[] args) {

        Document document = getDocument("movies.xml");  // Replace with your XML file path
        if (document != null) {
            System.out.println("Document parsed successfully.");
        } else {
            System.out.println("Failed to parse the document.");
        }
    }


        private static Document getDocument(String name)
        {
            try
            {
                DocumentBuilderFactory factory =
                        DocumentBuilderFactory.newInstance();
                factory.setIgnoringComments(true);
                factory.setIgnoringElementContentWhitespace(true);
                factory.setValidating(true);
                DocumentBuilder builder =
                        factory.newDocumentBuilder();
                return builder.parse(new InputSource(name));
            }
            catch (Exception e)
            {
                System.out.println("Error parsing document: " + e.getMessage());
            }
            return null;
        }
    }



//package DummiesBook.Book8.chapter5_WorkingWithXML;
//
//// Listing 5.3
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.xml.sax.InputSource;
//import java.text.NumberFormat;
//import java.io.File;
//
//public class ListMoviesXML {
//
//    private static final NumberFormat cf = NumberFormat.getCurrencyInstance();
//
//    public static void main(String[] args) {
//        String filePath = "C:\\Bootcamp\\JAVA\\Java_Advanced\\java_work\\DummiesBook\\Book8\\chapter5_WorkingWithXML\\movies.xml";
//        File xmlFile = new File(filePath);
//
//        // Check if file exists
//        if (!xmlFile.exists()) {
//            System.out.println("File not found: " + filePath);
//            return;
//        }
//
//        Document doc = getDocument(filePath);
//
//        if (doc == null) {
//            System.out.println("Failed to load the XML document.");
//            return;
//        }
//
//        Element root = doc.getDocumentElement();
//        Element movieElement = (Element) root.getFirstChild();
//        Movie m;
//
//        while (movieElement != null) {
//            m = getMovie(movieElement);
//            String msg = Integer.toString(m.year);
//            msg += ": " + m.title;
//            msg += " (" + cf.format(m.price) + ")";
//            System.out.println(msg);
//            movieElement = (Element) movieElement.getNextSibling();
//        }
//    }
//
//    private static Document getDocument(String name) {
//        try {
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            factory.setIgnoringComments(true);
//            factory.setIgnoringElementContentWhitespace(true);
//            factory.setValidating(false);  // Disable validation temporarily
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            return builder.parse(new InputSource(name));
//        } catch (Exception e) {
//            System.out.println("Error parsing document \"" + name + "\": " + e.getMessage());
//            e.printStackTrace();  // Print stack trace for debugging
//        }
//        return null;
//    }
//
//    private static Movie getMovie(Element e) {
//        // Get the year attribute
//        String yearString = e.getAttribute("year");
//        int year = Integer.parseInt(yearString);
//
//        // Get the Title element
//        Element tElement = (Element) e.getFirstChild();
//        String title = getTextValue(tElement).trim();
//
//        // Get the Price element
//        Element pElement = (Element) tElement.getNextSibling();
//        String pString = getTextValue(pElement).trim();
//        double price = Double.parseDouble(pString);
//
//        return new Movie(title, year, price);
//    }
//
//    private static String getTextValue(Node n) {
//        return n.getFirstChild().getNodeValue();
//    }
//
//    private static class Movie {
//        public String title;
//        public int year;
//        public double price;
//
//        public Movie(String title, int year, double price) {
//            this.title = title;
//            this.year = year;
//            this.price = price;
//        }
//    }
//}


