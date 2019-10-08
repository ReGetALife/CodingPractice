package tk.solidays.algorithm.others;

/**
 * 线段树
 * 适用场景：求某一段区间内数的和，且存在较多更新。
 * 可以将求和、更新的操作平衡到O(log(n))
 */
public class SegmentTree {
    private int[] tree;
    private int[] nums;
    private int index;
    private int val;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        /*
         * 层数为n的满二叉树，有2^(n)-1个节点，有2^(n-1)个叶子节点
         * 线段树的数组原始值都存在叶子节点中，且除了最后一层都是满的，所以要满足满二叉树叶子节点大于等于数组大小
         */
        int s = 1;
        while (s < nums.length) s <<= 1;
        tree = new int[2 * s - 1];
        buildTree(0, nums.length - 1, 0);
    }

    private int buildTree(int left, int right, int treeNode) {
        if (left == right) return (tree[treeNode] = nums[left]);
        int mid = (left + right) / 2;
        return (tree[treeNode] = buildTree(left, mid, treeNode * 2 + 1) +
                buildTree(mid + 1, right, treeNode * 2 + 2));
    }

    public int query(int left, int right) {
        return recursion(left, right, 0, nums.length - 1, 0);
    }

    private int recursion(int leftTarget, int rightTarget, int leftCurrent, int rightCurrent, int treeNode) {
        if (rightTarget < leftCurrent) return 0;
        if (leftTarget > rightCurrent) return 0;
        if (leftTarget == leftCurrent && rightCurrent == rightTarget) return tree[treeNode];
        int mid = (leftCurrent + rightCurrent) / 2;
        int ans = 0;
        if (leftTarget <= mid)
            ans += recursion(leftTarget, Math.min(mid, rightTarget), leftCurrent, mid, treeNode * 2 + 1);
        if (rightTarget >= mid + 1)
            ans += recursion(Math.max(mid + 1, leftTarget), rightTarget, mid + 1, rightCurrent, treeNode * 2 + 2);
        return ans;
    }

    public void update(int index, int val) {
        this.index = index;
        this.val = val;
        recursion2(0, nums.length - 1, 0);
    }

    private int recursion2(int left, int right, int treeNode) {
        if (index == left && left == right) return tree[treeNode] = val;
        int mid = (left + right) / 2;
        if (index <= mid) return tree[treeNode] = recursion2(left, mid, treeNode * 2 + 1) + tree[treeNode * 2 + 2];
        return tree[treeNode] = recursion2(mid + 1, right, treeNode * 2 + 2) + tree[treeNode * 2 + 1];
    }

    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(segmentTree.query(0, 0));
        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(3, 5));
        segmentTree.update(0, 2);
        segmentTree.update(5, 5);
        System.out.println(segmentTree.query(0, 0));
        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(3, 5));
    }

}
