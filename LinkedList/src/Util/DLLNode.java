package Util;

public class DLLNode<T> {
    public T data;
    public DLLNode<T> next;
    public DLLNode<T> prev;

    public DLLNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
