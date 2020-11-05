package com.datastructure.structure;

import java.util.*;

/**
 * @author dzl
 * 2020/9/24 15:25
 * @Description 冒泡排序包括两个步骤： 1.找出一个数，2.将这个数和其他所有的数做比较，并将这两个值交换   ----> 最大值/最小值
 * 2.找下一个数， 将其和剩余的数做比较 ----> 次大值/次小值
 * 快速排序：1.找一个基准点。然后从两头出发，找到大于、小于这个数的点。然后交换他们的位置 如果两个位置相遇。本次循环结束
 * 具体步骤：1.找到一个基准点temp.将其
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {6, 3, 1, 7, 1, 5, 8, 9, 2, 4};
//        int[] a = new int[100000000];
//        for (int i = 0; i < 100000000; i++) {
//            a[i] = new Random().nextInt(100000000);
//        }
//        long l = System.currentTimeMillis();

        Sort sort = new Sort();
//        sort.fastSort(a, 0 , a.length-1);
//        System.out.println(sort.isPalindrome(121));
        sort.shell(a);
//        Cell cell = new Cell(1,1,false);
//        sort.search(  1,1,0,4);
//        sort.bfs(4);
        System.out.println(Arrays.toString(a));
    }

    public void sortBigtoSmallA(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //12,35,99,18,76
    public void sortBigToSmallB(int[] array, int lo, int hi) {
        int i, j, t, temp;
        if (lo > hi) {
            return;
        }
        temp = array[lo];
        i = lo;
        j = hi;
        while (i != j) {
            while (array[j] >= temp && i < j) {
                j--;
            }
            while (array[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        array[lo] = array[i];
        array[i] = temp;
        System.out.println(Arrays.toString(array));
        sortBigToSmallB(array, lo, i - 1);
        sortBigToSmallB(array, i + 1, hi);
    }

    public void getQQ(int[] num) {
        StringBuilder x = new StringBuilder();
        while (num.length != 0) {
            x.append(num[0]);
            int[] a = new int[num.length - 1];
            for (int i = 1; i < num.length; i++) {
                if (i == 1) {
                    a[a.length - 1] = num[i];
                } else {
                    a[i - 2] = num[i];
                }
            }
            System.out.println(Arrays.toString(a));
            num = a;
        }
        System.out.println(x.toString());
    }

    public void getQQByQueue(int[] num) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < num.length; i++) {
//            queue.add(num[i]);
//        }
//        StringBuilder s = new StringBuilder();
//        while (!queue.isEmpty()){
//            s.append(queue.poll());
//            if (!queue.isEmpty()) {
//                queue.add(queue.poll());
//            }
//        }
        queue.addFirst(1);
//        System.out.println(s.toString());
    }


    /**
     * A 3, B 8,C 5
     * A---> 13 3
     * B---> 8 2
     * C---> 11 5
     * <p>
     * 第一轮---> 两个数相同的话，第二个人就能知道  第三个人做的是什么事情？
     * <p>
     * <p>
     * 144 = x + y
     * 143 1 144
     *
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 10 && x >= 0) {
            return true;
        }
        String[] a = String.valueOf(x).split("");
        int index = a.length / 2;
        int i = 0;
        if (a.length % 2 != 0) {
            i = 1;
        }
        Stack<String> strings = new Stack<>();
        for (int j = 0; j < index; j++) {
            strings.add(a[j]);
        }
        while (!strings.isEmpty()) {
            if (!strings.pop().equals(a[index + i])) {
                return false;
            }
            index++;
        }
        return true;
    }


    private void swap(int[] array, int i, int j) {
        int num = array[i];
        array[i] = array[j];
        array[j] = num;
    }


    /**
     * step one : 如何往盒子里放扑克牌
     */
    int[] a = new int[9];
    int[] book = new int[9];

    void dfs(int step, int n) {
        if (step == n + 1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (book[i] == 0) {
                a[step] = i;
                book[i] = 1;
                dfs(step + 1, n);
                book[i] = 0;
            }
        }
    }

    /**
     * 深度优先算法
     *
     * @param digits 输入数字，算出这些数字的字母组合
     * @return 剛才穷举组合的那道题目标是集中于  在一个位置上放入什么数字
     * 我们这道题也应该思考的是在什么位置上放置什么数
     * 唯一不同是，需要将些一样的数合并看待
     * <p>
     * -----> 回归到这个问题上。那我们需要做的是，1.在特定位置上找到那个数，将其
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        String[] split = digits.split("");
        StringBuilder builder = new StringBuilder();
        dfs(list, split, builder, 0);
        return list;
    }

    private void dfs(List<String> list, String[] split, StringBuilder builder, int step) {
        if (split.length == step) {
            list.add(builder.toString());
            return;
        }
        List<String> aChar = getChar(split[step]);
        for (int i = 0; i < aChar.size(); i++) {
            builder.append(aChar.get(i));
            dfs(list, split, builder, step + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }


    public List<String> getChar(String c) {
        switch (c) {
            case "2":
                return Arrays.asList("a", "b", "c");
            case "3":
                return Arrays.asList("d", "e", "f");
            case "4":
                return Arrays.asList("g", "h", "i");
            case "5":
                return Arrays.asList("j", "k", "l");
            case "6":
                return Arrays.asList("m", "n", "o");
            case "7":
                return Arrays.asList("p", "q", "r", "s");
            case "8":
                return Arrays.asList("t", "u", "v");
            case "9":
                return Arrays.asList("w", "x", "y", "z");
            default:
                return new ArrayList();
        }
    }

    public int getRecursion(int i) {
//        return i ==1?i:i*getRecursion(i-1);
        int index = 1;
        while (i > 1) {
            index = index * i;
            i--;

        }
        return index;
    }

    /**
     * 快速排序
     *
     * @param array
     */
    public void fastSort(int[] array, int lo, int hi) {
        int i, j, t, temp;
        if (lo > hi) {
            return;
        }
        i = lo;
        j = hi;
        temp = array[lo];
        while (i != j) {
            while (array[i] >= temp && i < j) {
                i++;
            }
            while (array[j] <= temp && j > i) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }

        }
        array[lo] = array[i];
        array[i] = temp;
        fastSort(array, lo, i - 1);
        fastSort(array, i + 1, hi);
    }

    private void insert(int[] array) {
        int j, temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    private void fast(int[] array, int lo, int hi) {
        int i, j, temp;
        if (lo > hi)
            return;
        i = lo;
        j = hi;
        temp = array[lo];
        while (i != j) {
            while (array[j] >= temp && j > i) {
                j--;
            }
            while (array[i] <= temp && j > i)
                i++;
            if (j > i)
                swap(array, i, j);
        }
        swap(array, lo, i);
        fast(array, lo, i - 1);
        fast(array, i + 1, hi);
    }

    /**
     * 计算1-9 排列为三个三位数。这三个三位数相加的和相等
     */
    int[] books = new int[10];
    int[] numbers = new int[10];

    /**
     * 深度优先算法   1.判断边界  2.尝试每一种可能  3.开始下一次循环
     *
     * @param step
     * @param size
     */
    public void calculation(int step, int size) {
        if (step == size + 1) {
            int addend0 = getHundredDigit(books[1], books[2], books[3]);
            int addend1 = getHundredDigit(books[4], books[5], books[6]);
            int sum = getHundredDigit(books[7], books[8], books[9]);
            if (addend0 + addend1 == sum) {
                System.out.println(addend0 + " + " + addend1 + " = " + sum);
            }
            return;
        }

        for (int i = 1; i <= size; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 1;
                books[step] = i;
                calculation(step + 1, size);
                numbers[i] = 0;
            }
        }
    }

    Map<String, Cell> maps = new HashMap<>();
    int[][] steps = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int aimX = 3, aimY = 3, min = Integer.MAX_VALUE;
    int head, tail;
    Cell[] cellArray = new Cell[17];

    public void init() {
        Cell cell = null;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                cell = new Cell(i, j, false);
                if ((i == 2 && j == 2) || (i == 2 && j == 3)) {
                    cell.setRoadBlockFlag(true);
                }
                if (i == 1 && j == 1) {
                    cell.setGoneFlag(true);
                }
                maps.put(i + "&" + j, cell);
            }
        }

        head = 1;
        tail = 1;
        Cell cell1 = maps.get(1 + "&" + 1);
        cellArray[tail] = cell1;
        cell1.setStep(0);
        cell1.setGoneFlag(true);
        tail++;
    }

    public void bfs(int rang) {
        int x, y;
        boolean flag = false;
        while (head < tail) {
            for (int i = 0; i < steps.length; i++) {
                x = cellArray[head].getX() + steps[i][0];
                y = cellArray[head].getY() + steps[i][1];
                if (x < 1 || x > rang || y < 1 || y > rang) {
                    continue;
                }

                Cell cell = maps.get(x + "&" + y);
                if (!cell.isRoadBlockFlag() && !cell.isGoneFlag()) {
                    cellArray[tail] = cell;
                    cell.setStep(cellArray[head].getStep() + 1);
                    cell.setGoneFlag(true);
                    cell.setLastCell(cellArray[head]);
                    tail++;
                }
                if (cell.getX() == aimX && cell.getY() == aimY) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            head++;
        }
        if (flag) {
            printLn(cellArray[tail - 1]);
            System.out.println(cellArray[tail - 1].getStep());
        }
    }


    /**
     * @Param x--> x坐标
     * @Param y--> y坐标
     * @param step --> 步骤
     * @Param rang --> 边界值
     */
    List<Cell> cells = new ArrayList<>();

    public void search(int x, int y, int step, int rang) {
        int xx, yy;
        // 边界值
        if (x == aimX && y == aimY) {
            System.out.println(step);
        }

        for (int i = 0; i < steps.length; i++) {
            xx = x + steps[i][0];
            yy = y + steps[i][1];
            if (xx < 1 || xx > rang || yy < 1 || yy > rang) {
                continue;
            }
            Cell cell = maps.get(xx + "&" + yy);
            if (!cell.isRoadBlockFlag() && !cell.isGoneFlag()) {
                cell.setGoneFlag(true);
                search(xx, yy, step + 1, rang);
                cell.setGoneFlag(false);
            }
        }
    }


    private void printLn(List<Cell> cell) {

    }

    private void printLn(Cell cell) {
        while (cell != null) {
            System.out.println(cell);
            cell = cell.getLastCell();
        }
    }


    public int getHundredDigit(int hundred, int ten, int one) {
        return hundred * 100 + ten * 10 + one;
    }


    public void  mergeSort(int[] arr, int left , int right , int[] temp){
        if (left < right){
            int mid = (left + right) /2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1 , right,temp);
            merger(arr,left,mid,right,temp);

        }

    }

    private void merger(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid +1;
        int t = 0;
        while (i <= mid && j<= right){
            if (arr[i] < arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid)
            temp[t++] = arr[i++];
        while (j<= right)
            temp[t++] = arr[j++];

    }



    //合并函数
    public static void Merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        //t为辅助数组的索引
        int t = 0;
        //当其中一个数组复制完毕后，将另一个数组内的数组全部复制进辅助数组
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        //将辅助数组内已经排好的数据全部复制进原数组，排序完成
        while (left <= right) {
            arr[left++] = temp[t++];
        }

    }




    public void insert1(int[] array){
        int j , temp;
        for (int i = 1; i < array.length; i++) {
            j = i - 1;
            temp = array[i];
            while (j >= 0 && array[j] > temp){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }
    public void shell(int[] array){
        int i , j ,temp, gap = 1 , len = array.length;
        while (gap< len/3){
            gap = gap*3+1;
        }
        while (gap>0){
            for ( i = gap; i < array.length; i++) {
                j = i - gap;
                temp = array[i];
                while (j >= 0 && array[j] > temp){
                    array[j+1] = array[j];
                    j -= gap;
                }
                array[j+gap] = temp;
            }
            gap /=3;
        }

    }


    // Java实现
    public  void shell_sort(int[] arr) {
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3)
            gap = gap * 3 + 1;
        for (; gap > 0; gap /= 3)
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
            }
    }


}
