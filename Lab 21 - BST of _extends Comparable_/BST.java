/* Binary Search Tree Class
*  A binary search tree of generic type which extends Comparable
*/

public class BST<E extends Comparable<E>> implements Tree<E> {

    private TreeNode root;
    private int size;

    public class TreeNode<E> {
        public E element;
        public TreeNode rightChild;
        public TreeNode leftChild;

        /* TODO: finish this constructor
        *  Think: what needs to be initialized, there are three member variables */
        public TreeNode(E element) {

        }
    }

    public BST() {
        this.root = null;
        size = 0;
    }

    public BST(E item) {
        this();
        insert(item);
    }

    public BST(E[] items) {
        /* TODO: Insert all of items into this tree */

    }

    /* TODO: finish this method */
    @Override
    public boolean search(E e) {

        return false;
    }

    /* TODO: finish this method */
    @Override
    public boolean insert(E e) {
        return false;
    }

    /* TODO: finish this method */
    @Override
    public boolean remove(E e) {
        return false;
    }

    /* Getter method for the size of the tree
    *  TODO: complete this method
    */
    @Override
    public int size() {
        return 0;
    }

    /* Does an inorder traversal of the tree, printing each visited node
    *  TODO: Complete this method
    */
    @Override
    public void inorder() {

    }

    /* Does a postorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void postorder() {

    }


    /* Does a preorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void preorder() {

    }


    /* Prints true on empty tree, false otherwise
     *  TODO: Complete this method
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /* Returns the root node of the tree */
    public TreeNode getRoot() {
        return root;
    }
}
