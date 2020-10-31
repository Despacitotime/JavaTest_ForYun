package JavaBasis.DataIn;

import java.util.Scanner;

/**给定一个二进制数组， 计算其中最大连续1的个数。
 * 注意：输入的数组只包含 0 和1。
 *      输入数组的长度是正整数，且不超过 10,000。
 * @author xxx
 * @date 2020/10/31 15:41
 */
public class GetData {
    public static void main(String[] args){
        System.out.println("请输入一串字符，格式 [1,1,0,1,1,1]");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        System.out.println(str);
        char[] charArray = str.toCharArray();
        int maxSize = 0,counts = 0;
        for(int i = 0;i < str.length();i++){
            while(charArray[i]!='0'){
                if(charArray[i]=='1') counts++;
                i++;
                if(i==str.length()){
                    break;
                }
            }
            if(counts>maxSize) maxSize=counts;
            counts=0;
        }
        System.out.println(maxSize);
    }
}
