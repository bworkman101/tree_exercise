package com.iceedge.tree.hashed;

import com.iceedge.tree.*;

import java.util.List;

/**
 * Tree Walker that walks from the root of a tree, down to every node in the tree.
 */
public final class HashingTreeWalker implements TreeWalker {

  private final Tree tree;

  public HashingTreeWalker(Tree tree) {
    this.tree = tree;
  }

  @Override
  public void walkTree(Object node, NodeCondition nodeCondition, NodeAction nodeAction) throws ObjectNotInTreeException {

    if (tree.isInTree(node)) {

      if (nodeCondition.isTrue(node)) {
        nodeAction.doAction(node);
      }

      List children = tree.getChildren(node);

      for (Object childNode : children) {
        walkTree(childNode, nodeCondition, nodeAction);
      }

    }

  }

}
