package co.kulwadee.csc209.lect02;

public class GBox<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }
    public T get() {
        return obj;
    }
}
