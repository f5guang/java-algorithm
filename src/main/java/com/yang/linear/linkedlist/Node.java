package com.yang.linear.linkedlist;

/**
 * @Description: 节点
 * @Author : wy
 * @Date : Created 2023/9/26 6:26 PM
 *
 * 补充说明
 *  ？表示不确定的 java 类型
 *  T (type) 表示具体的一个java类型
 *  K V (key value) 分别代表java键值中的Key Value
 *  E (element) 代表Element
 *
 */
public class Node<E> {
    /**
     * 节点存储的数据对象
     */
    E data;
    /**
     * 指向上一个节点的引用
     */
    Node<E> prev;
    /**
     * 指向下一个节点的引用
     */
    Node<E> next;

    public Node( Node<E> prev,E data, Node<E> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
