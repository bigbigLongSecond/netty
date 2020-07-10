package datastructure.structure;

/**
 * @author dzl
 * 2020/6/15 16:40
 * @Description
 *
 * . 表示单个任意字符
 * * 表示前一个字符重复0次或者多次
 * abcd  a*.*d
 */
public class MatchTest {

    char xiao = '.';
    char suoyou = '*';
    public boolean isMatch(String s, String p) {
        return true;
    }

    /**
     * 判断三种情况
     *
     * 1. a --->  单个字符匹配
     * 2. a*--->  单个字符匹配0个或多个
     * 3. .*--->  任意字符匹配0个或多个
     */

        public static void main(String[] args){
            int[] arr={3,3,7,1,2,4,2,5,5,4,7};
            int res=0;//初始值
            for(int i=0;i<arr.length;i++){
                res ^=arr[i];
            }
            System.out.println(res);
        }

}
