package LinkedList;

import Element.Element;

public class Position {

    private Element data;

    public Position() {
        data = null;
    }

    public Position(Element data) {
        this.data = data;
    }

    public Position(Position p) {
        this.data = p.data;
    }

    public Element GetPosition() {
        return data;
    }

    public void SetPosition(Element data) {
        this.data = data;
    }

    public int Compare(Position p) {
        return data == p.data ? 0 : -1;
    }
}
