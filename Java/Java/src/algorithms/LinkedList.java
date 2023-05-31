package algorithms;

public class LinkedList {
    Node head;
    Node tail;

    public void reverse(){
        Node cursorNode = head;

        while(cursorNode != null){
            Node next = cursorNode.next;
            Node previous = cursorNode.previous;
            cursorNode.next = previous;
            cursorNode.previous = next;

            if(previous == null){
                tail = cursorNode;
            }

            if(next == null){
                head = cursorNode;
            }

            cursorNode = next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for(int i = 0; i< 10; i++){
            linkedList.add(i);
            System.out.print(i + " ");
        }

        linkedList.reverse();

        Node cursor = linkedList.head;
        System.out.println();
        while(cursor != null){
            System.out.print(cursor.value + " ");
            cursor = cursor.next;
        }
    }

    public void add(int value) {
        Node node = new Node();
        node.value = value;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;

        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;

        if (previous == null) {
            node.next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    public Node find(int value) {
        Node cursorNode = head;

        while (cursorNode != null) {
            if (cursorNode.value == value) {
                return cursorNode;
            }
            cursorNode = cursorNode.next;
        }
        return null;
    }

    public class Node {
        int value;
        Node next;
        Node previous;
    }
}
