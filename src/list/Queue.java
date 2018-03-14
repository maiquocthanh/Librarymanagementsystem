package list;

import Enity.Lending;

public class Queue {

    Node head, tail;

    public class Node {

        Lending data;
        Node next;

        Node(Lending x, Node p) {
            data = x;
            next = p;
        }

        Node(Lending x) {
            this(x, null);
        }
    }

    public Queue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void enqueue(Lending x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void dequeueAll() {
        while (!isEmpty()) {
            System.out.println(dequeue());
        }
    }

    public Lending dequeue() {
        if (isEmpty()) {
            return (null);
        }
        Lending x = head.data;
        head = head.next;
        return (x);
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }
}
