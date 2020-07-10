package datastructure.structure;

import java.util.ArrayList;

/**
 * @author dzl
 * 2020/5/25 11:22
 * @Description
 */
public class DeleteList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (head != null){
            while (head != null){
                list.add(head.val);
                head = head.next;
            }
        }
        if (list.size() <n){
            return  null;
        }

        int index = list.size()-n;
        ListNode node = null;
        ListNode  cur = null;
        for (int i = 0; i < list.size(); i++) {
            if (i != index){
               if (node == null){
                   node = new ListNode(list.get(i));
                   cur = node;
               }else {
                   ListNode listNode = new ListNode(list.get(i));
                   cur.next = listNode;
                   cur = listNode;
               }

            }
        }
        return  node;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next =new ListNode(4);
        listNode.next.next.next.next =new ListNode(5);
        removeNthFromEnd1(listNode ,2);
    }
    public static ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode rec = new ListNode(0);
        rec.next = head;
        ListNode p = rec;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        while (q != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return  rec.next;
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode rec=new ListNode(0);
//        rec.next=head;
//        ListNode p=rec;
//        ListNode q=head;
//        for(int i=1;i<=n;i++){
//            q=q.next;
//        }
//        while(q!=null){
//            p=p.next;
//            q=q.next;
//        }
//        p.next=p.next.next;
//        return rec.next;
//    }

}
