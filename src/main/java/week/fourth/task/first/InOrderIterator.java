package week.fourth.task.first;

import lombok.NonNull;
import week.fourth.task.structure.NodeImpl;

import java.util.ArrayDeque;
import java.util.Deque;

public class InOrderIterator<T> implements NodeStrategyIterator {

    private static InOrderIterator inOrderIterator;
    Deque<NodeImpl<T>> nodes;


    private InOrderIterator(NodeImpl<T> root) {
        fillNodes(root);
    }

    public static InOrderIterator getInstance(NodeImpl root) {
        if (inOrderIterator == null) {
            inOrderIterator = new InOrderIterator(root);
        }

        return inOrderIterator;
    }

    public void fillNodes(@NonNull NodeImpl<T> root) {
        nodes = new ArrayDeque<>();
        Deque<NodeImpl<T>> temporaryDeque = new ArrayDeque<>();
        while (root != null) {
            temporaryDeque.push(root);
            root = root.getLeft();
        }
        while (!temporaryDeque.isEmpty()) {
            root = temporaryDeque.pop();
            nodes.add(root);
            root = root.getRight();
            while (root != null) {
                temporaryDeque.push(root);
                root = root.getLeft();
            }
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
