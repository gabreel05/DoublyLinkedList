package br.com.rpec;

public class DoublyLinkedList {
    private Node first;
    private Node last;
    private int totalOfElements = 0;

    public void addAtTheBeginning(Integer element) {
        if (this.totalOfElements == 0) {
            this.first = new Node(element);
            this.last = this.first;
        } else {
            Node newNode = new Node(element, this.first);
            newNode.setPrevious(this.last);
            this.first = newNode;
            this.last.setNext(this.first);
        }
        this.totalOfElements++;
    }

    public void add(Integer element) {
        if (this.totalOfElements == 0) {
            addAtTheBeginning(element);
        } else {
            Node newNode = new Node(element, this.first);
            this.last.setNext(newNode);
            newNode.setPrevious(this.last);
            this.last = newNode;
            this.first.setPrevious(this.last);

            this.totalOfElements++;
        }
    }

    public void add(Integer position, Integer element) {
        if (this.totalOfElements == 0) {
            addAtTheBeginning(element);
        } else if (position == totalOfElements) {
            add(element);
        } else {
            Node previous = getNode(position - 1);

            Node newNode = new Node(element, previous.getNext());
            Node next = previous.getNext();

            previous.setNext(newNode);
            newNode.setPrevious(previous);
            next.setPrevious(newNode);

            this.totalOfElements++;
        }
    }

    public void removeAtTheBeginning() {
        if (this.totalOfElements == 0)
            throw new IllegalArgumentException("Illegal position!");

        this.first = this.first.getNext();
        this.first.setPrevious(this.last);
        this.last.setNext(this.first);
        this.totalOfElements--;

        if (this.totalOfElements == 0)
            this.last = null;
    }

    public void removeAtTheEnd() {
        if (this.totalOfElements == 0)
            throw new IllegalArgumentException("Illegal position!");
        else if (this.totalOfElements == 1)
            removeAtTheBeginning();
        else {
            Node penultimate = this.last.getPrevious();
            penultimate.setNext(this.first);
            this.last = penultimate;
            this.first.setPrevious(this.last);
            this.totalOfElements--;
        }
    }

    public void remove(Integer position) {
        if (occupiedPosition(position))
            throw new IllegalArgumentException("Illegal position!");
        else if (position == 0)
            removeAtTheBeginning();
        else if (position == this.totalOfElements - 1)
            removeAtTheEnd();
        else {
            Node removedNode = getNode(position);
            Node previous = removedNode.getPrevious();
            Node next = removedNode.getNext();

            next.setPrevious(previous);
            previous.setNext(next);

            this.totalOfElements--;
        }
    }

    public boolean occupiedPosition(Integer position) {
        return position < 0 || position >= this.totalOfElements;
    }

    public Node getNode(Integer position) {
        if (occupiedPosition(position))
            throw new IllegalArgumentException("Illegal position!");
        Node actual = first;
        for (int i = 0; i < position; i++) {
            actual = actual.getNext();
        }

        return actual;
    }

    public Integer size() {
        return this.totalOfElements;
    }

    public boolean contains(Integer element) {
        Node actual = this.first;

        for (int i = 0; i < this.totalOfElements; i++) {
            if (actual.getElement() == element) {
                return true;
            }

            actual = actual.getNext();
        }

        return false;
    }

    @Override
    public String toString() {
        if (size() == 0)
            return "[]";

        Node actual = first;

        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < size(); i++) {
            stringBuilder.append(actual.getElement()).append(", ");
            actual = actual.getNext();
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
