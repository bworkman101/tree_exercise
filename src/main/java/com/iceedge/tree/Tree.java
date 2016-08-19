package com.iceedge.tree;

import java.util.List;

public interface Tree {

  // Will return empty list if node has no children
  List getChildren(Object node) throws ObjectNotInTreeException;

  // Will return null if node is the root of the tree
  Object getParent(Object node) throws ObjectNotInTreeException;

  boolean isInTree(Object node);

}
