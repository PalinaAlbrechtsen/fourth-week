package week.fourth.task.second;

import org.junit.Assert;
import org.junit.Test;
import week.fourth.task.structure.NodeImpl;

public class SecondTest {

    @Test
    public void checkWorkOfVisitorWithDecorator() {
        NodeImpl<String> root = new NodeImpl<>("root");
        NodeImpl<String> leftOne = new NodeImpl<>("leftOne");
        root.setLeft(leftOne);
        NodeImpl<String> rightOne = new NodeImpl<>("rightOne");
        root.setRight(rightOne);

        ConcreteVisitor concreteVisitor = new ConcreteVisitor();
        NodeImpl visited = concreteVisitor.visit(new NodeImpl(root));

        Assert.assertNotEquals(root, visited);
    }
}
