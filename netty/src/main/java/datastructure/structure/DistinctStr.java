package datastructure.structure;

/**
 * @author dzl
 * 2020/4/30 14:43
 * @Description   无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * advsddsfdsfeegrfscsfafsfcdc
 */
public class DistinctStr {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("adfvc"));
//        String a = "abcdabcd";
//        System.out.println(a.lastIndexOf("abcd"));
        DistinctStr distinctStr = new DistinctStr();
//        String string =distinctStr.longestPalindrome("sadasafawrrsdsadsfewfsda");
        long s= System.currentTimeMillis();
        String string =distinctStr.longestPalindrome3("asdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanflsansdadsadsafdvsndflefasdsafsadadwdsadsadsankfdjsanfls");
        System.out.println("^^^^^^^^^^^^^^^^^^"+string);
        System.out.println(System.currentTimeMillis()-s);
//        System.out.println(distinctStr.cheak("a"));
    }

    public static int lengthOfLongestSubstring(String s){
        if (s == null ||"".equals(s))
            return 0;
        if (s.length() == 1)
            return 1;
        int index = 0;
        int max = 0;
        StringBuilder current = new StringBuilder();
        current.append(s.substring(index,index+1));
        while (++index<s.length()){
            String single = s.substring(index,index+1);
            int currentIndex = current.indexOf(single);
            current.append(single);
            if (currentIndex >-1){
                current.substring(currentIndex+1);
            }
            if (current.length() > max){
                max = current.length();
            }
        }
        return max;
    }

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null || "".equals(s)|| s.length() == 1){
            return s;
        }
        String max = "";
        int index = 0;
        boolean flag = true;
        while (index<s.length()){
            if (max.length() > s.length()){
                break;
            }
            flag = true;
            String a = s.substring(index , index+1);
            String a1 = s.substring(index);
            while (flag){
                int length = a1.length();
                int i = a1.lastIndexOf(a);
                a1 = a1.substring(0,i+1);

                if (max.length() > a1.length()){
                    flag = false;
                    continue;
                }
                if (i==0){
                    if (max.length() < a1.length()){
                        max = a1;
                    }
                    flag = false;
                    continue;
                }
                if (cheak(a1)){
                    if (max.length() < a1.length()){
                        max = a1;
                    }
                    if (length == i+1){
                        flag = false;
                        continue;
                    }
                } else {
                    if (length == i+1){
                        a1 = a1.substring(0 , i);
                    }
                }
            }
            index++;
        }
        return max;
    }

    public  boolean cheak(String s){
        if (s.length() == 1)
            return true;
        final boolean equals = s.substring(0, 1).equals(s.substring(s.length() - 1, s.length()));
        if (s.length() == 2|| s.length() ==3)
            return equals;
        return equals && cheak(s.substring(1,s.length()-1));
    }

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if(s == null || "".equals(s)|| s.length() == 1){
            return s;
        }
        String[] strings = s.split("");
        String maxString = "";
        int min = 0 , max = strings.length-1;
        int center = s.length()/2;
        while (min < center){
            if (strings[min].equals(strings[max])){

            }
        }


        return s;
    }
    public String longestPalindrome3(String s) {
        String maxStr = "";
        int[] limit = new int[]{0,0};
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length)
        {
            i = getMaxStrIndex(ch, i, limit);
        }
        maxStr = s.substring(limit[0], limit[1]);
        return maxStr;
    }

    public int getMaxStrIndex(char[] ch, int low, int[] limit) {
        int high = low + 1;
        while (high < ch.length && ch[high] == ch[low]) {
            high++;
        }
        int result = high;
        while (low > 0 && high < ch.length && ch[low - 1] == ch[high]) {
            low--;
            high++;
        }

        if (high - low > limit[1] - limit[0]) {
            limit[0] = low;
            limit[1] = high;
        }
        return result;
    }

}
