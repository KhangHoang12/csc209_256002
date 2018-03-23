import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Node<Item> top;
    private int n;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        top = null;
        n = 0;
    }

    public boolean isEmpty() { return top == null; }

    public int size() { return n; }

    public void push(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;
        newNode.next = top;
        top = newNode;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        Item item = top.item;
        top = top.next;
        n--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new myStackIterator<Item>(top);
    }

    private class myStackIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        public myStackIterator(Node<Item> begin) {
            current = begin;
        }
        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}
