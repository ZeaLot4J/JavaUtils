package net.zealot.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Book {
  private String name;
  private Double price;
  private String isbn;
  private String author;

  public Book() {}

  public Book(String name, Double price, String isbn, String author) {
    this.name = name;
    this.price = price;
    this.isbn = isbn;
    this.author = author;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return this.author;
  }

  public String toString() {
    return "{name: "
        + this.name
        + ", price: "
        + this.price
        + ", isbn: "
        + this.isbn
        + ", author: "
        + this.author
        + "}";
  }
}
