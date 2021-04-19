import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodilityChallenge1 {

    static int count = 0;
    public static void main (String[] args) {

        System.out.println("count: " + solution(1, 8, 3, 2));
        count = 0;
        System.out.println("count: " + solution(2, 3, 3, 2));
        count = 0;
        System.out.println("count: " + solution(6, 2, 4, 7));
        count = 0;
        System.out.println("count: " + solution(9, 0, 0, 9));
    }

    public static int solution(int a, int b, int c, int d) {
        //00:00 - 23:59
        List<Integer> integerList = new ArrayList<>(Arrays.asList(a, b, c, d));
        for(int fh = 0; fh<=2; fh++) {
            if (integerList.contains(fh)) {
                List<Integer> tempList = new ArrayList<>(integerList);
                tempList.remove(tempList.indexOf(fh));
                if (fh == 2) {
                    //second hour digit 0..3
                    checkSecondHourDigit(tempList, 3);
                } else {
                    //second hour digit 0..9
                    checkSecondHourDigit(tempList, 9);
                }
            }
        }
        return count;
    }

    private static void checkSecondHourDigit(List<Integer> remainingList, int maxSecondHourNumRange) {
        for (int sh= 0; sh<=maxSecondHourNumRange; sh++) {
            if (remainingList.contains(sh)) {
                List<Integer> tempList = new ArrayList<>(remainingList);
                tempList.remove(tempList.indexOf(sh));
                checkMinuteDigits(tempList, 5);
            }
        }
    }

    private static void checkMinuteDigits(List<Integer> remainingList, int maxFirstMinuteNumRange) {
        for (int digit= 0; digit<=maxFirstMinuteNumRange; digit++) {
            if (remainingList.contains(digit)) {
                remainingList.remove(remainingList.indexOf(digit));
                int number = remainingList.get(0);
                if (number == digit) {
                    count++;
                } else if (number <= 5) {
                    count = count + 2;
                } else {
                    count++;
                }
                break;
            }
        }
    }

}
