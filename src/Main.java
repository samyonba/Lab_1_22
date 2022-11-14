import ArrayList.*;
import Element.Element;

//import LinkedList.*;

public class Main {

    // 1 вариант удаления дубликатов
    public static void deleteDuplicate(List L)
    {
        // p, q - позиция в списке, L - список
        Position p = L.first();
        while (p.Compare(L.end()) != 0) {
            Position q = L.next(p);
            while (q.Compare(L.end()) != 0) {
                if (L.retrieve(p).compareTo(L.retrieve(q)) == 0) {
                    Position prev_q_position = L.previous(q);
                    L.delete(q);
                    q = L.next(prev_q_position);
                }
                else
                    q = L.next(q);
            }
            p = L.next(p);
        }

    }

    // 2 вариант удаления дубликатов
//    public static void deleteDuplicate(List list)
//    {
//        Position i = list.first();
//        while (!(i.Compare(list.end()) == 0))
//        {
//            if (list.locate(list.retrieve(i)).Compare(i) == 0)
//            {
//                i = list.next(i);
//            } else
//            {
//                list.delete(i);
//            }
//        }
//    }

    // тесты
    /*
    public static void testArrayList() {
        List<Integer> list = new List<>(new Integer[10]);

        list.insert(10, new Position(0));
        list.insert(12, new Position(1));
        list.insert(11, new Position(1));
        list.printList();

        list.insert(10, list.end());
        list.insert(11, list.end());
        list.insert(12, list.end());
        list.insert(11, list.end());
        list.insert(12, list.end());
        list.insert(10, list.end());
        list.printList();

        deleteDuplicate(list);
        list.printList();
    }

    public static void testLinkedList() {
        List<Integer> list = new List<Integer>();

        list.insert(1, list.end());
        list.printList();

        list.insert(2, list.end());
        list.printList();

        list.insert(3, list.end());
        list.printList();

        list.insert(2, list.locate(3));
        list.printList();

        list.insert(4, list.locate(4));
        list.printList();

        list.insert(0, list.previous(list.locate(3)));
        list.printList();

        list.delete(list.locate(0));
        list.printList();

        list.makeNull();
        list.printList();

        list.insert(10, list.first());
        list.printList();

        list.insert(9, list.first());
        list.printList();
    }

    public static void testElement() {
        Element e1 = new Element();
        e1.setName(new char[]{'E', 'v', 'e'});
        e1.setAddress(new char[]{'M', 'o', 's', 'c', 'o', 'w'});

        Element e2 = new Element();
        e2.setName(new char[]{'E', 'v', 'e'});
        e2.setAddress(new char[]{'M', 'o', 's', 'c', 'o', 'w'});

        assert (e1.compareTo(e2) == 0);
        System.out.println(e1.compareTo(e2));
    }
    */

    // Инициализация списка элементами, в том числе дубликатами
    public static void initElements(List L) {
        L.insert(new Element ("Eva", "Toronto"), L.first());
        L.insert(new Element("Paolina", "Moscow"), L.first());
        L.insert(new Element("Maria", "Warsaw"), L.first());
        L.insert(new Element("Katya", "Helsinki"), L.first());
        L.insert(new Element("Dasha", "London"), L.first());
        L.insert(new Element("Liza", "Tokyo"), L.first());
        L.insert(new Element("Antonina", "Rome"), L.first());
        L.insert(new Element("Paolina", "Moscow"), L.first());
        L.insert(new Element("Antonina", "Rome"), L.first());
        L.insert(new Element("Eva", "Toronto"), L.first());
        L.insert(new Element("Antonina", "Rome"), L.first());
        L.insert(new Element("Eva", "Toronto"), L.first());
        L.insert(new Element("Eva", "Toronto"), L.first());
        L.insert(new Element("Katya", "Helsinki"), L.first());
        L.insert(new Element("Paolina", "Moscow"),L.first());
    }

    public static void main(String[] args) {

        //testArrayList();
        //testLinkedList();
        //testElement();

        // Объявление и инициализация списка при использовании ArayList
        //List list = new List(new Element[20]);

        // Объявление и инициализация списка при использовании linkedList
        List list = new List();

        initElements(list);
        list.printList();
        System.out.println("\nDelete duplicates:");
        deleteDuplicate(list);
        list.printList();

    }
}
