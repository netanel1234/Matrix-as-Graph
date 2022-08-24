package Question;

import java.util.Objects;

public class Node<T> {

    private T data;
    private Node<T> parent;

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public Node(T data) {
        /* Calling to another constructor in this class */
        this(data, null);
    }

    public Node() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    /** This is not the default implementation of hashcode here. This hashcode delegates authority to the hashcode of the data member it contains */
    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
