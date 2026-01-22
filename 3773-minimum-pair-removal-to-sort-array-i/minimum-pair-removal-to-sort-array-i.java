import java.util.*;

class Solution {
    class Pair {
        long sum;
        int leftIdx;
        Node leftNode;

        Pair(long sum, int leftIdx, Node leftNode) {
            this.sum = sum;
            this.leftIdx = leftIdx;
            this.leftNode = leftNode;
        }
    }

    class Node {
        int val;
        Node prev, next;
        int originalIdx;

        Node(int val, int idx) {
            this.val = val;
            this.originalIdx = idx;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        // 1. Build Doubly Linked List
        Node head = new Node(nums[0], 0);
        Node curr = head;
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(nums[i], i);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }

        int operations = 0;

        // 2. Simulation Loop
        while (!isSorted(head)) {
            // Find the leftmost minimum pair
            Node bestLeft = findMinPair(head);
            
            // Merge: Replace bestLeft and bestLeft.next with their sum
            bestLeft.val = bestLeft.val + bestLeft.next.val;
            Node toRemove = bestLeft.next;
            bestLeft.next = toRemove.next;
            if (toRemove.next != null) {
                toRemove.next.prev = bestLeft;
            }
            
            operations++;
        }

        return operations;
    }

    private boolean isSorted(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val > curr.next.val) return false;
            curr = curr.next;
        }
        return true;
    }

    private Node findMinPair(Node head) {
        Node curr = head;
        Node bestLeft = null;
        long minSum = Long.MAX_VALUE;

        while (curr != null && curr.next != null) {
            long currentSum = (long) curr.val + curr.next.val;
            if (currentSum < minSum) {
                minSum = currentSum;
                bestLeft = curr;
            }
            curr = curr.next;
        }
        return bestLeft;
    }
}