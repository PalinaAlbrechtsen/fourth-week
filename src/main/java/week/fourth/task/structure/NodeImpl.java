package week.fourth.task.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import week.fourth.task.second.Visitor;

@Data
@AllArgsConstructor
public class NodeImpl<T> implements Node {

    public T value;
    private NodeImpl<T> left;
    private NodeImpl<T> right;

    public NodeImpl(T value) {
        this.value = value;
    }

    @Override
    public Node decorate(Visitor v) {
        return v.visit(this);
    }
}
