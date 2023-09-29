package com.yang.linear.linkedlist;


/**
 * @Description: 实现一个链表
 * @Author : wy
 * @Date : Created 2023/9/26 11:27 PM
 */
public class MyLinkedList<E> {

    /**
     * 链表长度
     */
    transient int size = 0;
    /**
     * 头节点
     */
    transient Node<E> head;
    /**
     * 尾节点
     */
    transient Node<E> tail;

    /**
     * 链表头节点插入
     *
     * @param e 元素
     */
    public void headAdd(E e) {
        Node<E> temp = head;
        Node<E> newNode = new Node<>(null, e, temp);

        head = newNode;

        if (temp == null) {
            tail = newNode;
        } else {
            temp.prev = newNode;
        }
        size++;
    }

    /**
     * 链表尾插法
     *
     * @param e 元素
     */
    public void tailAdd(E e) {

        Node<E> temp = tail;
        Node<E> newNode = new Node<>(temp, e, null);

        tail = newNode;

        if (temp == null) {
            head = newNode;
        } else {
            temp.next = newNode;
        }
        size++;

    }

    /**
     * 拆链 给定一个元素，将这个节点从链表上移除
     *
     * @param x 节点
     * @return 节点中的数据
     */
    public E unLinked(Node<E> x) {

        E element = x.data;
        Node<E> prev = x.prev;
        Node<E> next = x.next;

        //针对 指定节点的 前一个节点的操作
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        //针对 指定节点的 后一个节点的操作
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.data = null;
        size--;
        return element;

    }

    /**
     * 删除操作
     * @param o 删除的值
     * @return true｜ false
     */
    public boolean remove(Object o) {

        if (o == null) {
            for (Node<E> x = head; x.data != null; x = x.next) {
                if (x.data == null) {
                    unLinked(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = head; head != null; x = x.next) {
                if (o.equals(x.data)) {
                    unLinked(x);
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * 打印链表中的值
     */
    public  void printLinked(){
        StringBuilder sb = new StringBuilder();
        for(Node<E> x = head; x != null; x = x.next){
            sb.append(x.data).append(" ");
        }
        System.out.println(sb);


    }


    //测试链表
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        linkedList.headAdd("b");
        linkedList.headAdd("a");
        System.out.println("头插法结果： ");
        linkedList.printLinked();

        linkedList.tailAdd("c");
        linkedList.tailAdd("ok");
        System.out.println("尾插法结果：" );
        linkedList.printLinked();

        System.out.println("删除 值为 ok 的节点");
        boolean res = linkedList.remove("ok");
        System.out.println(res);
        linkedList.printLinked();


    }
}
