package com.study.interview.tasks;

import java.math.BigDecimal;

public class AddTwoNumbersNorm {

    public static void main(String[] args) {
        //ListNode testNode1 = buildNode(new int[]{9});
        //ListNode testNode2 = buildNode(new int[]{1,9,9,9,9,9,9,9,9,9});[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]

        ListNode testNode1 = buildNode(new int[]{8});
        ListNode testNode2 = buildNode(new int[]{5});
        //ListNode testNode2 = buildNode(new int[]{1,9,9,9,9,9,9,9,9,9});[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
        //[5,6,4]
        //ListNode testNode1 = buildNode(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
        //ListNode testNode2 = buildNode(new int[]{5, 6, 4});

        new AddTwoNumbersNorm().addTwoNumbers(testNode1, testNode2);

        System.out.println();
    }

    private static ListNode buildNode(int[] input) {
        ListNode node = new ListNode(input[0]);
        ListNode currentNode = node;
        for (int i = 1; i < input.length; i++) {
            currentNode.next = new ListNode(input[i]);
            currentNode = currentNode.next;
        }

        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode currentNode = resultNode;
        int carry = 0;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;

        while (currentL1 != null || currentL2 != null) {
            int l1Value = currentL1 != null ? currentL1.val : 0;
            int l2Value = currentL2 != null ? currentL2.val : 0;

            int sum = l1Value + l2Value + carry;
            carry = sum / 10;

            currentL1 = currentL1 != null ? currentL1.next : null;
            currentL2 = currentL2 != null ? currentL2.next : null;

            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
        }

        if (carry == 1) {
            currentNode.next = new ListNode(1);
        }

        return resultNode.next;
    }

}

