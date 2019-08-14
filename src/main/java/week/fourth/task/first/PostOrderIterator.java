package week.fourth.task.first;

import lombok.NonNull;
import week.fourth.task.structure.NodeImpl;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostOrderIterator<T> implements NodeStrategyIterator {

    private static PostOrderIterator postOrderIterator;
    private Deque<NodeImpl<T>> nodes;

    private PostOrderIterator(NodeImpl<T> root) {
        fillNodes(root);
    }

    public static PostOrderIterator getInstance(NodeImpl root) {
        if (postOrderIterator == null) {
            postOrderIterator = new PostOrderIterator(root);
        }

        return postOrderIterator;
    }

    public void fillNodes(@NonNull NodeImpl<T> root) {
        nodes = new ArrayDeque<>();
        Deque<NodeImpl<T>> temporaryDeque = new ArrayDeque<NodeImpl<T>>();
        Deque<NodeImpl<T>> values = new ArrayDeque<>();
        while (root != null) {
            values.push(root);
            temporaryDeque.push(root);
            root = root.getRight();
        }
        while (!temporaryDeque.isEmpty()) {
            root = temporaryDeque.pop();
            root = root.getLeft();
            while (root != null) {
                values.push(root);
                temporaryDeque.push(root);
                root = root.getRight();
            }
        }
        while (!values.isEmpty()) {
            nodes.add(values.pop());
        }
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
