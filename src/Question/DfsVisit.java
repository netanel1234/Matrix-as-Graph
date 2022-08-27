package Question;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DfsVisit<T> {

    private Stack<Node<T>> workingStack;
    private Set<Node<T>> finished;

    public DfsVisit() {
        workingStack = new Stack<>();
        finished = new LinkedHashSet<>();
    }

    public Set<T> traverse(Graph<T> aGraph) {
        workingStack.push(aGraph.getRoot());
        while (!workingStack.isEmpty()) {
            Node<T> removed = workingStack.pop();
            finished.add(removed);
            Collection<Node<T>> reachableNodes = aGraph.getReachableNodes(removed);
            for (Node<T> reachableNode : reachableNodes)
                if (!finished.contains(reachableNode) && !workingStack.contains(reachableNode))
                    workingStack.push(reachableNode);
        }

        /** We want to return concrete data and not the Nodes themselves */
        Set<T> blackSet = new LinkedHashSet<>();
        for (Node<T> node : finished)
            blackSet.add(node.getData());
        /** We clear the Set represents the 'finished' Nodes just in case we wnt to traverse() from another Node in the graph */
        finished.clear();
        return blackSet;
    }
}
