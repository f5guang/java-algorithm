package com.yang.linear.array;

/**
 * @Description: 自定义list 接口
 * @Author : wy
 * @Date : Created 2023/10/7 11:35 PM
 */
public interface MyList<E> {

    public boolean add(E e);

    public E remove(int index);

    public E get(int index);

}
