package net.zealot.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbUtils {
  public static void main(String[] args) {
    //    Book book = new Book("the Song of Ice and Fire", 100.00, "6437463437", "Martin");
    //    JaxbUtils.writeXml(book);
    //    Book book = (Book) JaxbUtils.readXml(Book.class);
    //    System.out.println(book);
  }

  private static String DIR = System.getProperty("user.dir");
  private static String XML_SUFFIX = ".xml";

  private JaxbUtils() {}

  public static void writeXml(Object o) {
    Class<?> c = o.getClass();
    String fileName = c.getSimpleName() + XML_SUFFIX;
    try {
      JAXBContext ctxt = JAXBContext.newInstance(c);
      Marshaller m = ctxt.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      m.marshal(o, Files.newBufferedWriter(Paths.get(DIR, fileName)));
    } catch (JAXBException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Object readXml(Class<?> c) {
    String fileName = c.getSimpleName() + XML_SUFFIX;
    Object o = null;
    try {
      JAXBContext ctxt = JAXBContext.newInstance(c);
      Unmarshaller um = ctxt.createUnmarshaller();
      o = um.unmarshal(Files.newBufferedReader(Paths.get(DIR, fileName)));
    } catch (JAXBException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return o;
  }
}
