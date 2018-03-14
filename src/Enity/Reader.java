package Enity;

import Controller.Utility;

public class Reader {

    private String rcode;
    private String name;
    private int byear;

    public Reader() {
    }

    public Reader(String rcode, String name, int byear) {
        this.rcode = rcode;
        this.name = name;
        this.byear = byear;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRCode(String rcode) {
        this.rcode = rcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getByear() {
        return byear;
    }

    public void setByear(int byear) {
        this.byear = byear;
    }

    public void inputReaderInfor() {
        System.out.print("Enter rcode: ");
        this.setRCode(Utility.inputString());
        System.out.print("Enter name: ");
        this.setName(Utility.inputString());
        while (true) {
            System.out.print("Enter byear: ");
            this.setByear(Utility.inputInt());
            if (byear > 2010 || byear < 1900) {
                System.out.println("Byear must be between 1900 and 2010");
                continue;
            }
            break;
        }
    }

    @Override
    public String toString() {
        return String.format("%-5s%-5s%-5s%-5s%d%5s", rcode, "|", name, "|", byear, "|");
    }
}
