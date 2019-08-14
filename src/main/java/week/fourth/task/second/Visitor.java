package week.fourth.task.second;

import week.fourth.task.structure.NodeImpl;

public interface Visitor<T> {

    NodeImpl<T> visit(NodeImpl<T> node);
}
