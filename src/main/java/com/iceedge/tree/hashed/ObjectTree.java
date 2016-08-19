package com.iceedge.tree.hashed;

import com.iceedge.tree.ObjectNotInTreeException;
import com.iceedge.tree.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a tree of Objects of any type.
 */
public class ObjectTree implements Tree {

  private final Map<Object, TreeNode> treeMap = new HashMap<>();
  private TreeNode rootNode;

  public void addChildrenToNode(Object node, Object[] children) throws ObjectNotInTreeException {
    TreeNode treeNode = treeMap.get(node);

    if (treeNode == null && rootNode == null) {
      if (rootNode == null) {
        treeNode = new TreeNode(node);
        treeMap.put(node, treeNode);
        rootNode = treeNode;
      }
      else {
        throw new ObjectNotInTreeException("attempting to children to a node that isn't in the tree");
      }
    }

    for (Object child: children) {
      if (treeMap.containsKey(child)) {
        throw new ObjectNotInTreeException("attempting to add a child node that has already been added to another node");
      }
      TreeNode childNode = new TreeNode(child);
      treeMap.put(child, childNode);
      treeNode.addChildNode(childNode);
    }
  }

  @Override
  public List getChildren(Object node) throws ObjectNotInTreeException {
    return findNode(node).getChildren();
  }

  @Override
  public Object getParent(Object node) throws ObjectNotInTreeException {
    return findNode(node).getParentNode();
  }

  private TreeNode findNode(Object node) throws ObjectNotInTreeException {
    TreeNode treeNode = treeMap.get(node);
    if (treeNode == null) {
      throw new ObjectNotInTreeException("node not found");
    }
    return treeNode;
  }

  @Override
  public boolean isInTree(Object node) {
    return treeMap.containsKey(node);
  }

  @Override
  public String toString() {
    return rootNode.toString();
  }

}
