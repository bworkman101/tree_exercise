import com.iceedge.tree.ObjectNotInTreeException;
import com.iceedge.tree.Tree;
import com.iceedge.tree.TreeWalker;
import com.iceedge.tree.hashed.HashingTreeWalker;
import com.iceedge.tree.hashed.ObjectTree;

import java.util.ArrayList;
import java.util.List;

public class WalkTree {

  public static void main(String... args) {

    try {
      Tree tree = createObjectTree();
      TreeWalker treeWalker = new HashingTreeWalker(tree);
      List<String> stringsInTree = new ArrayList<>();

      // walk the tree looking for Strings
      treeWalker.walkTree(true, treeNode -> treeNode instanceof String, treeNode -> stringsInTree.add((String) treeNode));

      System.out.println("\n\n-----Strings in Tree--------------------------------------------------------");
      stringsInTree.forEach(str -> System.out.println(str));
      System.out.println("----------------------------------------------------------------------------");

    }
    catch (ObjectNotInTreeException ex) {
      ex.printStackTrace();
      System.exit(1);
    }

  }

  private static Tree createObjectTree() throws ObjectNotInTreeException {
    ObjectTree tree = new ObjectTree();

    tree.addChildrenToNode(true, new Object[]{"cat", new Object(), 42});
    tree.addChildrenToNode("cat", new Object[]{"kitty", "mittens", 9, 'P'});
    tree.addChildrenToNode(9, new Object[]{"lives", "plan 9", 69});
    tree.addChildrenToNode(42, new Object[]{"the meaning of life, the universe, and everything in it"});

    System.out.println("tree created\n" + tree);

    return tree;
  }

}
