package _2_자료구조구현;


/*
2진 검색 트리
1. 각 노드가 최대 두 개의 자식을 가질 수 있다.
2. 왼쪽 자식의 값은 부모 노드의 값보다 작고, 오른쪽 자식의 값은 부모 노드의 값보다 크다.
 */
class TreeNode<T extends Comparable<T>> {
    T value; // 값
    TreeNode<T> left; // 왼쪽 자식
    TreeNode<T> right; // 오른쪽 자식

    public TreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;

    }
}

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root; // 트리의 루트 노드

    public Tree() {
        this.root = null;
    }

    // 트리에 값을 추가하는 메서드
    public void add(T value) {
        root = addRecursive(root, value);
    }

    // 재귀를 통해서 값을 추가하는 도우미 메서드
    private TreeNode<T> addRecursive(TreeNode<T> current, T value) {
        if (current == null) {
            return new TreeNode<>(value);
        }
        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    // 특정 값이 트리에 존재하는지 확인하는 메서드
    public boolean contains(T value) {

        return containsRecursive(root, value);
    }

    // 재귀적으로 트리를 탐색하며 값을 찾는 도우미 메서드
    private boolean containsRecursive(TreeNode<T> current, T value) {
        if(current == null){
            return false;
        }
        if(value.equals(current.value)){
            return true;
        }
        return value.compareTo(current.value) < 0? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }

    // 트리를 중위 순회(In-order Traversal)하는 메서드
    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
        System.out.println();
    }

    // 재귀적으로 트리를 중위 순회하는 도우미 메서드
    private void inOrderTraversalRecursive(TreeNode<T> current) {
        if(current != null){
            inOrderTraversalRecursive(current.left);
            System.out.println(current.value+ " ");
            inOrderTraversalRecursive(current.right);
        }
    }

    public static void main(String[] args) {
        Tree<Integer> bst = new Tree<>();
        bst.add(6);
        bst.add(4);
        bst.add(8);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.add(9);

        System.out.println("Tree contains 4: " + bst.contains(4)); // true
        System.out.println("Tree contains 10: " + bst.contains(10)); // false

        System.out.print("In-order Traversal: ");
        bst.inOrderTraversal(); // 3 4 5 6 7 8 9
    }
}

