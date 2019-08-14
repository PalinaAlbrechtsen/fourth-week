package week.fourth.task.structure;

import week.fourth.task.second.Visitor;

public interface Node<T> {

    Node decorate(Visitor v);
}
