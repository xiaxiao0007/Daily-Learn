package Javase.Day202217;
/*
* 链表的优点：随机增删效率较高。(因为删除元素不需要涉及大量元素位移)
* 链表的缺点：查询效率较低，每一次查找某个元素的时候都需要从头节点开始往下遍历
* */
public class LinkNode {
    //创建统一节点
    Node next = null;
}

class Link{
    //创建头节点
    Node header;

    public void grow(Object data){
        if(header == null){
            header = new Node(data,null);
        }else{
            Node temp;
            temp = header;
            header = new Node(data,null);
            header.next.next = temp;
        }
    }

    public void delete(){

    }
}

class Node{
    Object data;
    Node next;

    public Node() {
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}