import static calculator.StringCalculator.splitAndCalculate;
import static view.InputView.input;
import static view.OutputView.print;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        String[] input = input();

        int result = splitAndCalculate(input[0], input[1]);
        print(input[0], result);
    }
}
