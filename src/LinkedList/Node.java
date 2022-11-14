package LinkedList;

import Element.Element;

public class Node {
    private Element element;
    private Node next;

    public Node() {
        element = null;
        next = null;
    }

    public Node(Element element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Element getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
