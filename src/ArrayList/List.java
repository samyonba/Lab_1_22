package ArrayList;

import Element.Element;

public class List {
    private final Element[] array;
    private Position last; // позиция после последнего

    public List(Element[] array)
    {
        this.array = array;
        last = new Position(0);
    }

    public Position end() {
        return new Position(last);
    }

    public void insert(Element x, Position position) {
        if (position.GetPosition() < 0 || position.GetPosition() > last.GetPosition()) {
            throw new RuntimeException("Can not insert element: position is out of range");
        }
        for (int i = last.GetPosition(); i > position.GetPosition(); i--) {
            array[i] = array[i - 1];
        }
        array[position.GetPosition()] = x;

        // increment
        last.SetPosition(last.GetPosition() + 1);
    }

    public Position locate(Element x) {
        for (int i = 0; i < last.GetPosition(); i++) {
            if (array[i].compareTo(x) == 0)
                return new Position(i);
        }

        return new Position(last);
    }

    public Element retrieve(Position position) {
        if (position.GetPosition() < 0 || position.GetPosition() >= last.GetPosition()) {
            throw new RuntimeException("Can not retrieve element: position is out of range");
        }
        return array[position.GetPosition()];
    }

    public void delete(Position position) {
        if (position.GetPosition() < 0 || position.GetPosition() >= last.GetPosition())
            return;

        for (int i = position.GetPosition(); i < last.GetPosition() - 1; i++) {
            array[i] = array[i + 1];
        }

        // decrement
        last.SetPosition(last.GetPosition() - 1);
    }

    public Position next(Position position) {
        if (position.GetPosition() < 0 || position.GetPosition() >= last.GetPosition()) {
            throw new RuntimeException("Can not get next element: position is out of range");
        }
        return new Position(position.GetPosition() + 1);
    }

    public Position previous(Position position) {
        if (position.GetPosition() < 1 || position.GetPosition() >= last.GetPosition()) {
            throw new RuntimeException("Can not get previous element: position is out of range");
        }
        return new Position(position.GetPosition() - 1);
    }

    public void makeNull() {
        last.SetPosition(0);
    }

    public Position first() {
        return new Position(0);
    }

    public void printList() {
        System.out.print("[");
        for (int i = 0; i < last.GetPosition(); i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }
}
