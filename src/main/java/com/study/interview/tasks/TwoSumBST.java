package com.study.interview.tasks;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(3,
                new TreeNode(2),
                new TreeNode(4));
        TreeNode r1 = new TreeNode(6);
        root.left = l1;
        root.right = r1;

        System.out.println(new TwoSumBST().findTarget(root, 12));
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> numbers = new ArrayList<>();
        traverse(root, numbers);

        int leftIndex = 0;
        int rightIndex = numbers.size() - 1;

        while (leftIndex < rightIndex) {
            int sum = numbers.get(leftIndex) + numbers.get(rightIndex);

            if (sum == k) {
                return true;
            } else if (sum < k) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return false;
    }

    private void traverse(TreeNode node, List<Integer> numbers) {

        if (node.left != null) {
            traverse(node.left, numbers);
        }

        numbers.add(node.val);
        System.out.println(node.val);

        if (node.right != null) {
            traverse(node.right, numbers);
        }

    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
