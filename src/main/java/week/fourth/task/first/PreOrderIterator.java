package week.fourth.task.first;

import week.fourth.task.structure.NodeImpl;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrderIterator<T> implements NodeStrategyIterator<T> {

    private static PreOrderIterator preOrderIterator;
    private Deque<NodeImpl<T>> nodes;

    private PreOrderIterator(NodeImpl<T> root) {
        fillNodeDeque(root);
    }

    private void fillNodeDeque(NodeImpl<T> root) {
        nodes = new ArrayDeque<>();
        Deque<NodeImpl<T>> deque = new ArrayDeque<>();
        while (root != null) {
            nodes.add(root);
            deque.push(root);
            root = root.getLeft();
        }
        while (!deque.isEmpty()) {
            root = deque.pop();
            root = root.getRight();
            while (root != null) {
                nodes.add(root);
                deque.push(root);
                root = root.getLeft();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static PreOrderIterator getInstance(NodeImpl root) {
        if (preOrderIterator == null) {
            preOrderIterator = new PreOrderIterator(root);
        }

        return preOrderIterator;
    }

    @Override
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    @Override
    public NodeImpl next() {
        return nodes.poll();
    }
}
