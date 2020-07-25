package com.study.interview.tasks;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class AddTwoNumbersStupid {

    public static void main(String[] args) {
        //ListNode testNode1 = buildNode(new int[]{9});
        //ListNode testNode2 = buildNode(new int[]{1,9,9,9,9,9,9,9,9,9});[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
        //[5,6,4]
        ListNode testNode1 = buildNode(new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
        ListNode testNode2 = buildNode(new int[]{5,6,4});

        new AddTwoNumbersStupid().addTwoNumbers(testNode1, testNode2);

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

    private static final BigDecimal TEN = new BigDecimal(10);

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal sumL1 = getSum(l1, 0, new BigDecimal(0));
        BigDecimal sumL2 = getSum(l2, 0, new BigDecimal(0));
        BigDecimal sum = sumL1.add(sumL2);

        ListNode resultNode = new ListNode();
        getNode(resultNode, sum);

        return resultNode;
    }

    private BigDecimal getSum(ListNode node, int power, BigDecimal sum) {
        sum = sum.add(new BigDecimal(node.val).multiply(TEN.pow(power)));

        if (node.next == null) {
            return sum;
        }

        return getSum(node.next, power + 1, sum);
    }

    private void getNode(ListNode node, BigDecimal number) {
        node.val = number.remainder(TEN).intValue();
        number = number.divideToIntegralValue(TEN);

        if (number.equals(ZERO)) {
            return;
        }

        node.next = new ListNode();

        getNode(node.next, number);
    }
}

