package week.fourth.task.first;

import week.fourth.task.structure.NodeImpl;

import java.util.Iterator;

public interface NodeStrategyIterator<T> extends Iterator {

     @Override
     NodeImpl<T> next();
}
