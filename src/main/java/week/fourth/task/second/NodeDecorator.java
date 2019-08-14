package week.fourth.task.second;

import lombok.AllArgsConstructor;
import week.fourth.task.structure.Node;

@AllArgsConstructor
public class NodeDecorator<T> implements Node {

    private Node<T> node;

    @Override
    public Node decorate(Visitor v) {
        return node.decorate(v);
    }
}
