package list;

import Enity.Reader;

public class Stack {

    ReaderNode head;

   public class ReaderNode {

        Reader data;
        ReaderNode next;

        public ReaderNode() {
        }

        public ReaderNode(Reader x, ReaderNode p) {
            this.data = x;
            this.next = p;
        }

        public Reader getData() {
            return data;
        }

        public void setData(Reader data) {
            this.data = data;
        }

        public ReaderNode getNext() {
            return next;
        }

        public void setNext(ReaderNode next) {
            this.next = next;
        }

    }

    public Stack() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;

    }

    public void push(Reader x) {
        ReaderNode q = new ReaderNode(x, head);
        if (isEmpty()) {
            head = q;
            return;
        }
        head = q;

    }

    public void popAll() {
        while (!isEmpty()) {
            System.out.println(pop());
        }
    }

    public Reader pop() {
        if (isEmpty()) {
            return (null);
        }
        Reader x = head.data;
        head = head.next;
        return (x);
    }

    public void traverse() {
        ReaderNode p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public ReaderNode search(String xcode) {
        ReaderNode p = head;
        while (p != null) {
           if (p.data.getRcode().equals(xcode)) {              
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public boolean delete(String xCode) {
        ReaderNode p = head;
        if (p.data.getRcode().equals(xCode)) {
            pop();
            return true;
        }
        while (p.next != null) {
            if (p.next.data.getRcode().equals(xCode)) {
                p.next = p.next.next;
                return true;
            }
            p = p.next;
        }
        return false;
    }
    public boolean contain(Reader reader){
        ReaderNode p =head;
        while( p != null){
            if(p.data.getRcode().equals(reader.getRcode())){
                return true;
            }
            p =p.next;        
        }
        return false;
    }
     
}
