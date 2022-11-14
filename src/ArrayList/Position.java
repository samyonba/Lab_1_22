package ArrayList;

public class Position {

    private int index;

    public Position(int index) {
        this.index = index;
    }

    public Position(Position orig) {
        this.index = orig.index;
    }

    public int GetPosition() {
        return index;
    }

    public void SetPosition(int p) {
        index = p;
    }

//    public int Compare(Position p) {
//        if (index < p.GetPosition())
//            return -1;
//        else return index == p.GetPosition() ? 0 : 1;
//    }

    public boolean equals(Position p) {
        if (p == null) {
            return false;
        }
        return index == p.GetPosition();
    }
}
