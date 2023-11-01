package _10_Random함수;
import java.util.*;

/*
10. 범위가 주어졌을 때 랜덤 함수를 사용하지 않고, 20개의 수를 랜덤으로 추첨해주는 프로그램을 작성해 보세요. (Hint: 시간)

 */
public class Random {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;

        // 20개의 랜덤 수를 생성

        Set<Integer> randomNumbers = generate(lowerBound, upperBound, 20);

        // 결과 출력
        System.out.println("20개의 랜덤 수: " + randomNumbers);
    }

    public static Set<Integer> generate(int lowerBound, int upperBound, int cnt){
        Set<Integer> randomNumbers = new HashSet<>();

        while(randomNumbers.size() < cnt){
            long currentTime = System.nanoTime();
            int randomNumber = (int) (currentTime %(upperBound - lowerBound +1)) + lowerBound;

            // 중복 있으면 안됌

            randomNumbers.add(randomNumber);

//            try{
//                Thread.sleep(1);
//            }catch (InterruptedException e){
//                Thread.currentThread().interrupt();
//                throw new RuntimeException(("Thread was Interrupted"));
//            }
        }
        return randomNumbers;
    }
}
