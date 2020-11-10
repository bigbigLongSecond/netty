package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author dzl
 * 2020/11/10 10:56
 * @Description 从大到小排序
 * 排序方法集合   冒泡排序 √ 快速排序 √ 归并排序 √ 插入排序√ 选择排序√ 基数排序 希尔排序  堆排序
 */
public class SortList {
    public static void main(String[] args) {
        int[] a = {6, 3, 1, 7, 1, 5, 8, 9, 2, 4};
        int[] temp = new int[a.length];
        SortList sortList = new SortList();
//        sortList.mergeSort(a, 0, a.length - 1, temp);
        sortList.heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 从大到小
     * 1.选择一个基准点temp
     * 2.开始两个指针，i, j.
     * 3.j从末尾到头开始遍历，假如array[j]<=temp ,则继续遍历。j++。如果不满足此条件。循环结束
     * 4.i从头开始遍历，假如array[i] >= temp,并且i<j。则继续遍历。如果不满足此条件。循环结束
     * 5.两次循环结束后。如果 i < j 则交换ij的位置
     * 6.如果满足循环条件，则继续遍历
     * 7.当循环条件不再满足，交换lo和temp的位置。
     * 递归
     *
     * @param array
     */
    public void fastSort(int[] array, int lo, int hi) {
        int temp, i = lo, j = hi;
        if (lo > hi) {
            return;
        }
        temp = array[i];
        while (i != j) {
            while (i < j && array[j] <= temp)
                j--;
            while (i < j && array[i] >= temp)
                i++;
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, lo, i);
        fastSort(array, lo, i - 1);
        fastSort(array, i + 1, hi);
    }

    /**
     * 对一个有序列表插入新元素
     * 1 2 3 4
     * i = i j = 0  1 1 3 4   j--; j = -1;  array[j+1] = temp;
     * i = 3 j = 2  3 2 1 4  3 2 1 1 3 2 2 1 3 3 2 1  j = -1;
     *
     * @param array
     */
    public void insertSort(int[] array) {
        int j, temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= 0 && array[j] <= temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    /**
     * 归并排序   实际上就是把一个数字分成一个个只有两个值的小数组，然后这两个小数组再合并
     *
     * @param array
     * @param left
     * @param right
     * @param temp
     */
    public void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    private void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (array[i] > array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        k = 0;
        while (left <= right) {
            array[left++] = temp[k++];
        }
    }

    public void selectSort(int[] array) {
        int key;
        for (int i = 0; i < array.length; i++) {
            key = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[key]) {
                    key = j;
                }
            }
            swap(array, key, i);
        }
    }

    public void bubbleSort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] > array[j]) {
                    flag = true;
                    swap(array, j + 1, j);
                }
            }
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
    }

    /**
     * 从大到小排序
     * 先做出一个小顶堆，然后首位交换位置
     * 在剩余的元素中再造一个小顶堆
     *
     * @param array
     */
    public void heapSort(int[] array) {
        int i = array.length / 2 - 1;
        for (; i >= 0; i--)
            adjustHeap(array, i, array.length);
        for (int j = array.length - 1; j >= 0; j--) {
            swap(array, j, 0);
            adjustHeap(array, 0, j);

        }


    }

    private void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && array[j + 1] < array[j])
                j++;
            if (array[j] < temp) {
                array[i] = array[j];
                i = j;
            }
        }
        array[i] = temp;
    }


    private void swap(int[] array, int i, int j) {
        int num = array[i];
        array[i] = array[j];
        array[j] = num;
    }

}
