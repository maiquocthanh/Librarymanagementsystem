package LibraryManagementSystem;

import Controller.Utility;
import Enity.Book;
import Enity.Lending;
import Enity.Reader;
import list.LinkedList;
import list.Queue;
import list.Stack;

public class LibraryManagement {

    Book book;
    Reader reader;
    Lending lender;
    LinkedList bookList;
    Stack readerList;
    Queue lendingList;

    public LibraryManagement() {
        bookList = new LinkedList();
        readerList = new Stack();
        lendingList = new Queue();
    }

    public boolean addLast() {
        book = new Book();
        book.inputBookInfor();
        if (bookList.contain(book)) {
            System.out.println("Book was existing in the list");
            return false;
        }
        bookList.addLast(book);
        System.out.println("Book is inserted successful");
        return true;

    }

    public void bookDisplay() {
        System.out.println(String.format("%-5s%-5s%-5s%5s%10s%5s%10s%5s%10s%5s%10s%5s",
                "code", "|", "Title", "|", "Quantity", "|", "Lended", "|", "Price", "|", "Value", "|"));
        System.out.println("--------------------------------------------------------------------------------");
        bookList.traverse();
    }

    public void bookSearch() {
        System.out.print("Please input bcode to search: ");
        String xcode = Utility.inputString();
        LinkedList.BookNode node = bookList.search(xcode);

        if (node == null) {
            System.out.println("Data not found!");
            return;
        }
        System.out.println(String.format("%-5s%-5s%-5s%5s%10s%5s%10s%5s%10s%5s%10s%5s",
                "code", "|", "Title", "|", "Quantity", "|", "Lended", "|", "Price", "|", "Value", "|"));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(node.getData());
    }

    public boolean addFirst() {
        book = new Book();
        book.inputBookInfor();
        if (bookList.contain(book)) {
            System.out.println("Book was existing in the list");
            return false;
        }
        bookList.addFirst(book);
        System.out.println("Book is inserted successful");
        return true;
    }

    public boolean addTo() {
        book = new Book();
        book.inputBookInfor();
        if (bookList.contain(book)) {
            System.out.println("Book was existing in the list");
            return false;
        }
        System.out.print("Please enter index: ");
        int index = Utility.inputInt();
        if (!bookList.addTo(book, index)) {
            System.out.println("Index out of bound!");
            return false;
        }
        System.out.println("Book is inserted successful");
        return true;
    }

    public void bookDelete() {
        System.out.print("Please enter index: ");
        int index = Utility.inputInt();
        if (!bookList.delete(index)) {
            System.out.println("Index out of bound!");
            return;
        }
        System.out.println("Delete Successful!");
    }

// Reader Manager
    public boolean ReaderAdd() {
        reader = new Reader();
        reader.inputReaderInfor();
        if (readerList.contain(reader)) {
            System.out.println("Reader was existing in the list");
            return false;
        }
        readerList.push(reader);
        System.out.println("Reader is inserted successful");
        return true;
    }

    public void readerDisplay() {
        System.out.println(String.format("%-5s%-5s%-5s%-5s%s%5s", "rcode", "|", "name", "|", "byear", "|"));
        System.out.println("------------------------------");
        readerList.traverse();

    }

    public void readerSearch() {
        System.out.print("Please input rcode to search: ");
        String xcode = Utility.inputString();
        Stack.ReaderNode node = readerList.search(xcode);
        if (node == null) {
            System.out.println("Data not found!");
            return;
        }
        System.out.println(String.format("%-5s%-5s%-5s%-5s%s%5s", "rcode", "|", "name", "|", "byear", "|"));
        System.out.println("------------------------------");
        System.out.println(node.getData());
    }

    public void readerDelete() {
        System.out.print("Input rcode to delete: ");
        String xcode = Utility.inputString();
        if (!readerList.delete(xcode)) {
            System.out.println("Data not found!");
        } else {
            System.out.println("Delete successful!");
        }
    }

//Lending Manager
    public void lendingAdd() {
        lender = new Lending();
        lender.inputLendingInfor();
        LinkedList.BookNode bookNode = bookList.search(lender.getBcode());
        Stack.ReaderNode readerNode = readerList.search(lender.getRcode());
        
        if (bookNode == null) {
            System.out.println("Book is not found");
        } else if (readerNode == null) {
            System.out.println("Reader is not found");
        } else {
            book = bookNode.getData();
            int bookState = lender.getState();
            if (bookState == 2) {
                int lendedBook = book.getLended() - 1;
                if (lendedBook >= 0) {
                    book.setLended(lendedBook);                   
                }
            }
            if (bookState == 1) {
                int lendedBook = book.getLended() + 1;
                if (lendedBook <= book.getQuantity()) {
                    book.setLended(lendedBook);                  
                }                 
            }
            lendingList.enqueue(lender);
            System.out.println("Lending is added successful");
        }
    }

    public void lendingDisplay() {
        System.out.println(String.format("%-5s%-5s%-5s%-5s%s%5s", "Bcode", "|", "Rcode", "|", "State", "|"));
        System.out.println("------------------------------");
        lendingList.traverse();
    }

    public static void main(String[] args) {
        LibraryManagement bm = new LibraryManagement();
        String option;
        do {
            System.out.println("\n");
            System.out.println("_____________________MENU_______________________");
            System.out.println("1.Book list:");
            System.out.println("\t" + "1.1 Input & add to the end");
            System.out.println("\t" + "1.2 Display data");
            System.out.println("\t" + "1.3 Search by bcode");
            System.out.println("\t" + "1.4 Input and add to beginning");
            System.out.println("\t" + "1.5 Add after position k");
            System.out.println("\t" + "1.6 Delete position k");
            System.out.println("2.Reader list:");
            System.out.println("\t" + "2.1 Add reader");
            System.out.println("\t" + "2.2 Display data");
            System.out.println("\t" + "2.3 Search by rcode");
            System.out.println("\t" + "2.4 Delete by rcode");
            System.out.println("3.Lending list:");
            System.out.println("\t" + "3.1 Input data");
            System.out.println("\t" + "3.2 Display data");
            System.out.println("4.Exit");
            System.out.println("\t" + "4.1 Exit");
            System.out.println("________________________________________________");
            System.out.print("Please enter your option: ");
            option = Utility.inputString();
            System.out.println("");

            switch (option) {
                case "1.1":
                    bm.addLast();
                    break;
                case "1.2":
                    bm.bookDisplay();
                    break;
                case "1.3":
                    bm.bookSearch();
                    break;
                case "1.4":
                    bm.addFirst();
                    break;
                case "1.5":
                    bm.addTo();
                    break;
                case "1.6":
                    bm.bookDelete();
                    break;
                case "2.1":
                    bm.ReaderAdd();
                    break;
                case "2.2":
                    bm.readerDisplay();
                    break;
                case "2.3":
                    bm.readerSearch();
                    break;
                case "2.4":
                    bm.readerDelete();
                    break;
                case "3.1":
                    bm.lendingAdd();
                    break;
                case "3.2":
                    bm.lendingDisplay();
                    break;
                case "4.1":
                    System.out.println("--------------See you again-------------");
                    break;
                default:
                    System.out.println("Input not match!");
                    break;
            }
        } while (!"4.1".equals(option));
    }
}
