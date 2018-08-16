package net.zealot.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

import net.zealot.bean.Book;
import org.junit.BeforeClass;
import org.junit.Test;

public class JaxbUtilsTest {
  private static Book book;

  @BeforeClass
  public static void beforeClass() {
    book = new Book("the Song of Ice and Fire", 100.00, "6437463437", "Martin");
  }

  @Test
  public void testWriteXml() {
    JaxbUtils.writeXml(book);
    Book book = (Book) JaxbUtils.readXml(Book.class);
    assertThat(book, hasProperty("name", equalTo("the Song of Ice and Fire")));
    assertThat(book, hasProperty("price", equalTo(100.00)));
    assertThat(book, hasProperty("isbn", equalTo("6437463437")));
    assertThat(book, hasProperty("author", equalTo("Martin")));
  }

  @Test
  public void testReadXml() {
    Book book = (Book) JaxbUtils.readXml(Book.class);
    assertThat(book, hasProperty("name", equalTo("the Song of Ice and Fire")));
    assertThat(book, hasProperty("price", equalTo(100.00)));
    assertThat(book, hasProperty("isbn", equalTo("6437463437")));
    assertThat(book, hasProperty("author", equalTo("Martin")));
  }
}
