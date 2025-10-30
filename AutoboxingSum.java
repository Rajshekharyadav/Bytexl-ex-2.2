import java.util.ArrayList;

public class AutoboxingSum {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10); // autoboxing: int to Integer
        numbers.add(20);
        numbers.add(30);

        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // unboxing: Integer to int
        }
        System.out.println("Sum of integers: " + sum);
    }
}
