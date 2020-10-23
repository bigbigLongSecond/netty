package com.datastructure.structure;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author dzl
 * 2020/5/6 10:00
 * @Description
 */
public class Solution {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(9);
//        addTwoNumbers(l1,l2);
//        System.out.println(isMatch("abaacd", "abacd"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        int sum = 0;
        ListNode current = null;
        ListNode current1 = null;
        int a = 0, b = 0;
        boolean flag = true;
        while (l1 != null || l2 != null) {
            a = 0;
            b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            count = a + b + sum;
            if (count > 9) {
                sum = 1;
                count = count % 10;
            } else {
                sum = 0;
            }
            if (flag) {
                current = new ListNode(count);
                flag = false;
                current1 = current;
            } else {
                ListNode listNode = new ListNode(count);
                current1.next = listNode;
                current1 = listNode;
            }
        }
        if (sum > 0) {
            ListNode listNode = new ListNode(sum);
            current1.next = listNode;
        }
        return current;
    }

    public static boolean isMatch(String s, String p) {
        char one = '.';
        char more = '*';
        int count = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        if (p != null && p.length() > 0) {
            char[] chars = p.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                stack.add(chars[chars.length - i - 1]);
            }
            char[] chars1 = s.toCharArray();
            Character pop = null;
            Character index = null;

            while (!stack.isEmpty()){
                pop = stack.pop();
                if ((index = stack.peek()) == one){

                }else if ((index = stack.peek()) == more){

                }else {

                }
            }

            for (int i = 0; i < chars1.length; i++) {
                char c = chars1[i];
                if (stack.empty()) {
                    break;
                }
                if (pop == null) {
                    pop = stack.peek();
                }
                if (pop == one) {
                    index = c;
                    stack.pop();
                    if (!stack.empty()) {
                        pop = stack.peek();
                    }
                } else if (pop == more) {
                    if (index != c) {
                        stack.pop();
                        if (!stack.empty()) {
                            pop = stack.peek();
                            i--;
                            count--;
                        }
                    } else {
                        if (i == chars1.length - 1) {
                            stack.pop();
                        }
                    }
                } else {
                    index = pop;
                    if (index != c) {
                        stack.pop();
                        if (!stack.empty()) {
                            pop = stack.peek();
                            if (pop != more) {
                                break;
                            }
                        }
                    } else {
                        stack.pop();
                        if (!stack.empty()) {
                            pop = stack.peek();
                        }
                    }

                }
                count++;
            }
        }
        return count == s.length() && stack.empty();
    }

}
