class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;   // remove node
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
