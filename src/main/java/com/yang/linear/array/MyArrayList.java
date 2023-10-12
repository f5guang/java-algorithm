package com.yang.linear.array;

import java.util.Arrays;

/**
 * @Description: 实现数组操作
 * @Author : wy
 * @Date : Created 2023/9/29 10:59 AM
 */
public class MyArrayList<E> implements MyList<E>{

    //集合元素数量
    private int size;

    //默认容量 10
    private static final int DEFAULT_CAPACITY = 10;

    //默认空数据
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //存储ArrayList元素的数组缓冲区
    transient Object[] elementData;

    //初始化时默认给个空元素，第一次添加元素时设置初始容量
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    //添加元素
    @Override
    public boolean add(E e) {

        int minCapacity = size +1;
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            minCapacity = Math.max(minCapacity,DEFAULT_CAPACITY);
        }
        if (minCapacity -elementData.length >0){
            //判断是否需要扩容
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData,newCapacity);
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {

       /**
        *   v（index= 2）
        0 1 2 3 4
        a b s d f
           5 - 2 -1
        **/
       E oldValue = (E)elementData[index];
       //要移动的元素个数
       int numMoved = size - index -1;

       if (numMoved > 0) {
           //从源数组元素某个位置开始，拷贝到目标数组从某个位置开始拷贝n个元素
           System.arraycopy(elementData,index+1,elementData,index,numMoved);
       }
       elementData[--size] = null;
       return oldValue;
    }

    @Override
    public E get(int index) {
        return (E)elementData[index];
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("~");
        System.out.println(arrayList);

        arrayList.remove(1);
        System.out.println(arrayList);

        System.out.printf(arrayList.get(0));

    }
}

