package week.fourth.task.second;

import week.fourth.task.structure.NodeImpl;

public class ConcreteVisitor implements Visitor {

    @Override
    public NodeImpl visit(NodeImpl node) {
        node.setValue("CHANGED");
        return node;
    }
}
