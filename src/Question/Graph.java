package Question;

import java.util.Collection;

/** This interface defines the common functionality required of a Graph-like object */
public interface Graph<T> {
    Node<T> getRoot();
    /** This method returns to allow different implementation of Graph to return different types of collections (List, Set...) */
    Collection<Node<T>> getReachableNodes(Node<T> node);
}
