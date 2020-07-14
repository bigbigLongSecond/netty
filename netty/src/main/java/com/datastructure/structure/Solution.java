package com.datastructure.structure;

/**
 * @author dzl
 * 2020/5/6 10:00
 * @Description
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        addTwoNumbers(l1,l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        int sum = 0;
        ListNode current = null;
        ListNode current1 = null;
        int a=0 ,b =0 ;
        boolean flag = true;
        while (l1 != null || l2 != null){
            a=0 ;b =0;
             if (l1 != null){
                 a = l1.val;
                 l1 = l1.next;
             }
             if (l2 != null){
                 b = l2.val;
                 l2 = l2.next;
             }
             count = a+b+sum;
             if (count>9){
                 sum = 1;
                 count = count%10;
             }else {
                 sum = 0;
             }
             if (flag){
                 current = new ListNode(count);
                 flag = false;
                 current1 = current;
             }else {
                 ListNode listNode = new ListNode(count);
                 current1.next = listNode;
                 current1 = listNode;
             }
        }
        if (sum>0){
            ListNode listNode = new ListNode(sum);
            current1.next = listNode;
        }
        return  current;
    }

}
