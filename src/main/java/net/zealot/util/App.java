package net.zealot.util;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    Person p1 = Person.INSTANCE;
    Person p2 = Person.INSTANCE;
    //    p1.setFirstName("ZeaLOt");
    //    p1.setLastName("Lancelot");
    //    p1.setAge(23);
    System.out.println(p1 == p2);
    System.out.println(p1);
    System.out.println(p2);
  }
}

enum Person {
  INSTANCE("abc", "efg", 100);

  private String firstName;
  private String lastName;
  private int age;

  private Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String toString() {
    return "firstName:" + this.firstName + ", lastName:" + this.lastName + ", age:" + this.age;
  }
}
