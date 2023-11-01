package _14_개수세기0;
import java.util.*;
public class CountZero {

    public static void main(String[] args) {
        int count = 0;

        for(int i = 1; i <= 1_000_000; i++){
            String number = Integer.toString(i);

            for(char digit : number.toCharArray()){
                if(digit == '0'){
                    count ++;
                }
            }
        }

        System.out.println("count : " + count);
    }
}
