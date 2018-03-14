package Enity;

import Controller.Utility;

public class Book {

    private String bcode;
    private String title;
    private int quantity;
    private int lended;
    private Double price;

    public Book() {
    }

    public Book(String bcode, String title, int quantity, int lended, Double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void inputBookInfor() {
        System.out.print("Enter bcode: ");
        this.setBcode(Utility.inputString());
        System.out.print("Enter title:");
        this.setTitle(Utility.inputString());
        System.out.print("Enter quanity: ");
        this.setQuantity(Utility.inputInt());
        while (true) {
            System.out.print("Enter lended: ");
            this.setLended(Utility.inputInt());
            if (lended > quantity) {
                System.out.println("Lended must not be larger than quantity (" + quantity + ")");
                continue;
            }
            break;
        }
        System.out.print("Enter price:");
        this.setPrice(Utility.inputDouble());
    }

    @Override
    public String toString() {
        return String.format("%-5s%-5s%-5s%5s%10d%5s%10d%5s%10.1f%5s%10.1f%5s",
                bcode,"|",title,"|",quantity,"|",lended,"|",price,"|",quantity*price,"|");
                       
    }

}
