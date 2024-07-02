package Util;

public class Tree<T> {
    public T data;
    public Tree<T> left;
    public Tree<T> right;

    public Tree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
