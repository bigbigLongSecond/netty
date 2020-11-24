package com.atguigu.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 堆排序  每一个节点的值都要大于左右孩子的值  --->完全二叉树
 * 大顶堆和小顶堆
 * 升序用大顶堆  降序用小顶堆
 * 1.将排序的序列构建成大顶堆
 * 2.此时最大值就是根节点
 * 3.然后将末尾值与根元素交换
 * 4.然后将n-1个剩余元素构成大顶堆，如此反复进行，就是一个大顶堆。
 */
public class HeapSort {

	public static void main(String[] args) {
		//要求将数组进行降序排列
		int arr[] = {4, 6, 8,4,2,1,1, 5, 9};
		HeapSort heapSort = new HeapSort();
		heapSort.heapSort2(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 堆排序
	 * 1.构建成一个大顶堆
	 * 2.交换最大值与最后一位的值
	 * 3.由n-1个序列开始再排序
	 * @param arr
	 */
	public void heapSort(int[] arr) {
		for (int i = arr.length/2 -1; i >= 0 ; i--) {
			adjustSort(arr,i,arr.length);
		}
		for (int j = arr.length-1 ; j>= 0 ;j--){
			swap(arr,j,0);
			adjustSort(arr,0,j);
		}
	}

	/**
	 * 构建一个大顶堆的方法
	 * @param array  数组
	 * @param i     非叶子结点元素
	 * @param length 长度
	 */
	private void adjustSort(int[] array , int i , int length){
		int temp = array[i];
		for (int j = 2*i+1; j < length ; j = 2*j+1) {
			if (j+1<length && array[j+1] < array[j]){
				j++;
			}
			if (array[j] < temp){
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


	/**
	 * 堆排序
	 * 1.创建一个大顶堆
	 * 2.将0和末尾元素交换
	 * 3.再次创建大顶堆
	 * @param array
	 */
	public void heapSort2(int[] array){
		int i= array.length/2-1;
		for (;i>=0;i--){
			adjustSort2(array,i,array.length);
		}
		for (int j = array.length-1; j >= 0 ; j--) {
			swap(array,0,j);
			adjustSort2(array,0,j);

		}

	}

	/**
	 * 从小到大排序
	 * @param array
	 * @param i
	 * @param length
	 */
	private void adjustSort2(int[] array, int i, int length) {
		int temp = array[i];
		for (int j = 2*i+1; j <length ; j = 2*j+1) {
			if (j+1<length && array[j+1] > array[j])
				j++;
			if (array[j] >temp){
				array[i] = array[j];
				i=j;
			}else {
				break;
			}
		}
		array[i] = temp;
	}


}
