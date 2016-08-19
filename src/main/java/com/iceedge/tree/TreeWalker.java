package com.iceedge.tree;

import java.util.Collection;

public interface TreeWalker {

  /**
   * Traverse the tree until the NodeCondition evaluates to true.
   * Then perform an action on the node.
   *
   * @param startNode
   * @param nodeCondition traverse until the node action is true
   * @param nodeAction perform the node action when the node condition is true
   * @return  Tree node
   */
  void walkTree(Object startNode, NodeCondition nodeCondition, NodeAction nodeAction) throws ObjectNotInTreeException;

}
