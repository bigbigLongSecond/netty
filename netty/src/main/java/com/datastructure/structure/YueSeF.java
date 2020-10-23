package com.datastructure.structure;

/**
 * @author dzl
 * 2020/5/28 17:11
 * @Description
 */
public class YueSeF {

    public static void main(String[] args) {
        ysf(getListNode());
    }
    private static void ysf(ListNode node){
        int count = 0;
        boolean flag = true;
        ListNode listNode = node;
        while(listNode != null){
            count++;
            if (count== 2){
                count = 0;
                listNode.next = listNode.next.next;
            }else {
                listNode = listNode.next;
            }
            if (listNode == listNode.next.next){
                break;
            }
            System.out.println(count);
            System.out.println( "**********"+listNode.val);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    
    private static ListNode getListNode(){
        ListNode node = null;
        ListNode currnt = null;
        ListNode first = null;
        for (int i = 1; i < 43; i++) {
            if (i== 1){
                node = new ListNode(i);
                first = node;
                currnt = node;
            }else if (i== 42){
                currnt.next = first;
            }else {
                currnt.next = new ListNode(i);
                currnt = currnt.next ;
            }
        }
        return node;
    }
}
