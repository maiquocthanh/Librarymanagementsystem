package list;

import Enity.Book;

public class LinkedList {

    public class BookNode {

        Book data;
        BookNode next;

        BookNode() {
        }

         BookNode(Book x,  BookNode p) {
            data = x;
            next = p;
        }

         BookNode(Book x) {
            this(x, null);
        }

        public Book getData() {
            return data;
        }

        public void setData(Book data) {
            this.data = data;
        }

        public  BookNode getNext() {
            return next;
        }

        public void setNext( BookNode next) {
            this.next = next;
        }
    }

     BookNode head, tail;

    public LinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void addLast(Book x) {
         BookNode q = new  BookNode(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void addFirst(Book x) {
         BookNode q = new  BookNode(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        q.next = head;
        head = q;
    }

    public boolean addTo(Book x, int k) {
        int size = size();
        if (k > size || k < 0) {
            return false;
        }
         BookNode q = new  BookNode(x);
        if (isEmpty()) {
            head = tail = q;
            return true;
        }
        if (k == 0) {
            addFirst(x);
            return true;
        }
        if (k == size) {
            addLast(x);
            return true;
        }
        int index = 0;
         BookNode p = head;
        while (p.next != null) {
            if ((index + 1) == k) {
                q.next = p.next;
                p.next = q;

            }
            index++;
            p = p.next;
        }
        return true;
    }

    public boolean delete(int k) {
        int size = size();
        if (k > size || k < 0) {
            return false;
        }
        int index = 0;
         BookNode p = head;
        if (k == 0) {
            head = p.next;
            return true;
        }
        while (p.next != null) {
            if ((index + 1) == k) {
                p.next = p.next.next;
                return true;
            }
            index++;
            p = p.next;
        }
        if (k == size - 1) {
            p = null;
            return true;
        }
        return false;
    }

    public int size() {
        int size = 0;
         BookNode p = head;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }
//Kiem tra sach da co trong list chua

    public boolean contain(Book book) {
         BookNode p = head;
        while (p != null) {
            if (p.data.getBcode().equals(book.getBcode())) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public void traverse() {
         BookNode p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public  BookNode search(String xcode) {
         BookNode p = head;
        while (p != null) {
            if (p.data.getBcode().equals(xcode)) {
               
                return p;
            }
            p = p.next;
        }
        return null;
    }

    
}
