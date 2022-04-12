package br.com.rpec;

public class Main {

    public static void main(String[] args) {
	    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addAtTheBeginning(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(1, 3);
        doublyLinkedList.removeAtTheBeginning();
        doublyLinkedList.remove(0);
        boolean contains = doublyLinkedList.contains(1);
        System.out.println(contains);
    }
}
