package week.fourth.task.first;

import week.fourth.task.structure.NodeImpl;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversalIterator<T> implements NodeStrategyIterator<T> {

    private static BreadthFirstTraversalIterator breadthFirstTraversalIterator;
    private Queue<NodeImpl<T>> nodes;

    private BreadthFirstTraversalIterator(NodeImpl<T> root) {
        nodes = new LinkedList<>();
        nodes.add(root);
    }

    @SuppressWarnings("unchecked")
    public static BreadthFirstTraversalIterator getInstance(NodeImpl root) {
        if (breadthFirstTraversalIterator == null) {
            breadthFirstTraversalIterator = new BreadthFirstTraversalIterator(root);
        }

        return breadthFirstTraversalIterator;
    }

    @Override
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    @Override
    public NodeImpl<T> next() {
        NodeImpl<T> polledNode = nodes.poll();
        assert polledNode != null;
        if (polledNode.getLeft() != null) {
            nodes.add(polledNode.getLeft());
        }
        if (polledNode.getRight() != null) {
            nodes.add(polledNode.getRight());
        }

        return polledNode;
    }
}
