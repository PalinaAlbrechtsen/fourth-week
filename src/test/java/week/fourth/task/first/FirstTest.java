package week.fourth.task.first;

import org.junit.Test;
import week.fourth.task.structure.NodeImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FirstTest {

    @Test
    public void getNodesTest(){
        NodeImpl<String> root = new NodeImpl<>("root");
        NodeImpl<String> leftOne = new NodeImpl<>("leftOne");
        root.setLeft(leftOne);
        NodeImpl<String> rightOne = new NodeImpl<>("rightOne");
        root.setRight(rightOne);
        NodeImpl<String> rightLeftTwo = new NodeImpl<>("rightLeftTwo");
        root.getRight().setLeft(rightLeftTwo);
        NodeImpl<String> leftLeftTwo = new NodeImpl<>("leftLeftTwo");
        root.getLeft().setLeft(leftLeftTwo);
        NodeImpl<String> leftRightTwo = new NodeImpl<>("leftRightTwo");
        root.getLeft().setRight(leftRightTwo);

        NodeStrategyIterator iterator = BreadthFirstTraversalIterator.getInstance(root);
        ArrayList<NodeImpl> resultFromBFT = new ArrayList<>();
        while(iterator.hasNext()){
            resultFromBFT.add(iterator.next());
        }
        ArrayList<NodeImpl> expectedFromBFT = new ArrayList<>();
        expectedFromBFT.add(root);
        expectedFromBFT.add(leftOne);
        expectedFromBFT.add(rightOne);
        expectedFromBFT.add(leftLeftTwo);
        expectedFromBFT.add(leftRightTwo);
        expectedFromBFT.add(rightLeftTwo);
        assertEquals(expectedFromBFT, resultFromBFT);

        NodeStrategyIterator newIterator = PreOrderIterator.getInstance(root);
        List<NodeImpl> resultFromPreOrder = new ArrayList<>();
        while(newIterator.hasNext()){
            resultFromPreOrder.add(newIterator.next());
        }
        ArrayList<NodeImpl> expectedFromPreOrder = new ArrayList<>();
        expectedFromPreOrder.add(root);
        expectedFromPreOrder.add(leftOne);
        expectedFromPreOrder.add(leftLeftTwo);
        expectedFromPreOrder.add(leftRightTwo);
        expectedFromPreOrder.add(rightOne);
        expectedFromPreOrder.add(rightLeftTwo);
        assertEquals(expectedFromPreOrder, resultFromPreOrder);

        NodeStrategyIterator inOrderIterator = InOrderIterator.getInstance(root);
        List<NodeImpl> resultFromInOrder = new ArrayList<>();
        while(inOrderIterator.hasNext()){
            resultFromInOrder.add(inOrderIterator.next());
        }
        ArrayList<NodeImpl> expectedFromInOrder = new ArrayList<>();
        expectedFromInOrder.add(leftLeftTwo);
        expectedFromInOrder.add(leftOne);
        expectedFromInOrder.add(leftRightTwo);
        expectedFromInOrder.add(root);
        expectedFromInOrder.add(rightLeftTwo);
        expectedFromInOrder.add(rightOne);
        assertEquals(expectedFromInOrder, resultFromInOrder);

        NodeStrategyIterator postIterator = PostOrderIterator.getInstance(root);
        List<NodeImpl> resultFromPostOrder = new ArrayList<>();
        while(postIterator.hasNext()){
            resultFromPostOrder.add(postIterator.next());
        }
        ArrayList<NodeImpl> expectedFromPostOrder = new ArrayList<>();
        expectedFromPostOrder.add(leftLeftTwo);
        expectedFromPostOrder.add(leftRightTwo);
        expectedFromPostOrder.add(leftOne);
        expectedFromPostOrder.add(rightLeftTwo);
        expectedFromPostOrder.add(rightOne);
        expectedFromPostOrder.add(root);
        assertEquals(expectedFromPostOrder, resultFromPostOrder);
    }
}
