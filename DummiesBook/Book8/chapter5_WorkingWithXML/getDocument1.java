package DummiesBook.Book8.chapter5_WorkingWithXML;

public class getDocument1 {
    public static void main(String[] args) {
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
                System.out.println(e.getMessage());
            }
            return null;
        }
    }
}
