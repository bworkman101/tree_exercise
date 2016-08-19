# Tree Exercise

This is a exercise in creating a tree.

Assignment:
The object of this assignment is to assess your skills at OOD and your ability to make/use abstract frameworks.

You have a Tree which contains Objects with the following interface:
public interface Tree {
      // Will return empty list if node has no children
      public List getChildren(Object node) throws ObjectNotInTreeException;
      
      // Will return null if node is the root of the tree
      public Object getParent(Object node) throws ObjectNotInTreeException;

      public boolean isInTree(Object node);
      
      // ObjectNotInTreeException is a checked Exception
}

We want to be able to transverse the trees using different transversal algorithms, and when some condition holds for an Object visited perform some action on that Object.

Assignment
Build a simple yet flexible framework for walking the tree in an arbitrary manner, and if an arbitrary condition holds on the Objects visited, performs an arbitrary action on that Object.
Using your framework show how, given an Object startNode in a Tree, you can build a Collection of all descendents of startNode that are of Type String.
Using your framework show how, given an Object startNode in a Tree, you can concatenate the toString() results of all ancestors of startNode.  


