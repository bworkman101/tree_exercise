package com.iceedge.tree.hashed;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A tree node that contains a value of any java Object type.
 */
public class TreeNode {

  private final Object value;
  private List<TreeNode> children = new ArrayList();
  private TreeNode parentNode;

  public TreeNode(Object node) {
    this.value = node;
  }

  public void addChildNode(TreeNode childNode) {
    children.add(childNode);
    childNode.parentNode = this;
  }

  public List<Object> getChildren() {
    return children.stream().map(treeNode -> treeNode.value).collect(Collectors.toList());
  }

  public TreeNode getParentNode() {
    return parentNode;
  }

  public int countParents() {
    if (parentNode != null) {
      return 1 + parentNode.countParents();
    }
    else {
      return 0;
    }
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder("\n");

    for (int i = 0; i < countParents(); i++) {
      out.append("   ");
    }

    out.append("-").append(value);
    children.stream().forEach(child -> out.append(child.toString()));
    return out.toString();
  }
}
