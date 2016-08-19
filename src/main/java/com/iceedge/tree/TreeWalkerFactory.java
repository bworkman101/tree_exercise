package com.iceedge.tree;

public interface TreeWalkerFactory {

  /**
   * Create a tree walker to walk the given tree.
   *
   * @param tree
   * @return
   */
  TreeWalker createTreeWalker(Tree tree);

}
