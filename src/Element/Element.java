package Element;

import java.util.Arrays;

public class Element {

    private char[] name;

    private char[] address;

    public Element() {
        name = new char[20];
        address = new char[50];
    }

    public Element(char[] name, char[] address) {
        this.name = new char[20];
        this.address = new char[50];

        for (int i = 0; i < name.length; i++)
            this.name[i] = name[i];
        for (int i = 0; i < address.length; i++)
            this.address[i] = address[i];
    }

    public Element(String name, String address) {
        this.name = new char[20];
        this.address = new char[50];

        char[] nameArray = name.toCharArray();
        char[] addressArray = address.toCharArray();
        for (int i = 0; i < nameArray.length; i++)
            this.name[i] = nameArray[i];
        for (int i = 0; i < addressArray.length; i++)
            this.address[i] = addressArray[i];
    }



    public char[] getAddress() {
        return address;
    }

    public char[] getName() {
        return name;
    }

    public void setAddress(char[] address) {
        this.address = address;
    }

    public void setName(char[] name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String result = "";
        for (char c : name) {
            if (c != 0) {
                result += c;
            }
        }
        result += ", ";
        for (char c : address) {
            if (c != 0) {
                result += c;
            }
        }
        result += '\n';

        return result;
    }

    public int compareTo(Element o) {
        return (Arrays.equals(name, o.name) && Arrays.equals(address, o.address)) ? 0 : -1;
    }
}
