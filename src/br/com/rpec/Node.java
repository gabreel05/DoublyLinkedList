package br.com.rpec;

public class Node {
    private Integer element;
    private Node previous;
    private Node next;

    public Node(Integer element) {
        this.element = element;
    }

    public Node(Integer element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getElement() {
        return element;
    }

    public void setElement(Integer element) {
        this.element = element;
    }
}
