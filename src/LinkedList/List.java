package LinkedList;
import Element.Element;

public class List {
    private Node head;

    public List() {
        head = null;
    }

    // возвращает ссылку на Position<T> next == null последнего элемента в списке
    // либо ссылку на head, если список пустой
    public Position end() {
        Node it = head;

        while (it != null) {
            it = it.getNext();
        }

        return it;
    }

    // добавляет новый элемент перед элементом position
    // если position == null, элемент добавляется в конец
    public void insert(Element x, Position position) {
//        if (position == null || position.GetPosition() == null)
//            throw new RuntimeException("Can not insert element: null position");

        // вставка в конец
        if (position.GetPosition() == null) {
            position.SetPosition(new Node(x, null));
            position.SetNext(new Position());
            return;
        }

        // вставка в начало
        if (head == position) {
            Position item = new Position(x, head);
            head = item;
            return;
        }

        if (head.GetPosition() == null) {
            throw new RuntimeException("Insertion error");
        }

        Position prev = head;
        Position it = head.GetNext();
        while (it.GetPosition() != null) {
            if (it == position) {
                prev.SetNext(new Position(x, it));
                return;
            }
            prev = it;
            it = it.GetNext();
        }

        throw new RuntimeException("Can not insert element: position is unreachable");
    }

    public Position locate(Element x) {
        Position it = head;
        while (it.GetPosition() != null) {
            if (it.GetPosition() == x) {
                return it;
            }
            it = it.GetNext();
        }
        return it;
    }

    public Element retrieve(Position position) {
        if (position == null || position.GetPosition() == null) {
            //throw new RuntimeException("Can not retrieve element from null position");
            return end().GetPosition();
        }

        return position.GetPosition();
    }

    public Position next(Position position) {
        if (position == null || position.GetPosition() == null) {
            return new Position();
        }

        return position.GetNext();
    }

    public Position previous(Position position) {
        if (position == null || position.GetPosition() == null || position == head) {
            return new Position();
        }

        if (head.GetPosition() != null) {
            Position prev = head;
            Position it = prev.GetNext();
            while (it.GetPosition() != null) {
                if (it == position) {
                    return prev;
                }
                prev = it;
                it = it.GetNext();
            }
        }

        return new Position();
    }

    public void delete(Position position) {
        if (position == null || position.GetPosition() == null) {
            return;
        }

        if (position == head) {
            head = head.GetNext();
            if (head.GetNext() == null) {
                head.SetNext(new Position());
            }
            //position = head;
            return;
        }

        Position prev = previous(position);
        if (prev.GetPosition() == null) {
            return;
        }
        prev.SetNext(position.GetNext());
        //position = position.GetNext();
    }

    public void makeNull() {
        head = new Position();
    }

    public Position first() {
        return head;
    }

    public void printList() {
        System.out.print("[ ");
        Position it = head;
        while (it != null && it.GetPosition() != null) {
            System.out.print(it.GetPosition().toString() + " ");
            it = it.GetNext();
        }
        System.out.println("]");
    }

}
