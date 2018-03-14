package Enity;

import Controller.Utility;

public class Lending {

    private String bcode;
    private String rcode;
    private int state;

    public Lending() {
    }

    public Lending(String bcode, String rcode, int state) {
        this.bcode = bcode;
        this.rcode = rcode;
        this.state = state;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void inputLendingInfor() {
        System.out.print("Enter bcode: ");
        this.setBcode(Utility.inputString());
        System.out.print("Enter rcode: ");
        this.setRcode(Utility.inputString());

        while (true) {
            System.out.print("Enter state: ");
            this.setState(Utility.inputInt());
            if(state <0 || state >2){
                System.out.println("State must be 0 or 1 or 2");
                continue;
            }
            break;

        }

    }

    @Override
    public String toString() {
        return String.format("%-5s%-5s%-5s%-5s%d%5s", bcode, "|", rcode, "|", state, "|");
    }
    

}
