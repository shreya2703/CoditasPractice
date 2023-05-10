package org.example;

//@Entity
public class Book {

    //@Id
    //@GeneratedValue(strategy =  GenerationType.AUTO)
    //@Column(name="Book_Id");

    private int id;
    //@Column(name="Book_Id");
    private String bookname;
    //@Column(name="authname");
    private String authname;
    //@Column(name="publishername");
    private String publishername;

    //@Columns(columns={
            //@Column(name="publisheryear"),
           //@Column(name="price")  })

    private int publisheryear,price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthname() {
        return authname;
    }

    public void setAuthname(String authname) {
        this.authname = authname;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    public int getPublisheryear() {
        return publisheryear;
    }

    public void setPublisheryear(int publisheryear) {
        this.publisheryear = publisheryear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", authname='" + authname + '\'' +
                ", publishername='" + publishername + '\'' +
                ", publisheryear=" + publisheryear +
                ", price=" + price +
                '}';
    }
}
