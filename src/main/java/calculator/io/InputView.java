package calculator.io;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputExpression() {
        System.out.println("계산할 식을 입력해주세요.");
        String[] expression = scanner.nextLine().split(" ");

        if(expression.length < 3) {
            throw new IllegalArgumentException("식을 잘못 입력했습니다.");
        }

        if((expression.length - 3) % 2 != 0) {
            throw new IllegalArgumentException("식을 잘못 입력했습니다.");
        }

        return expression;
    }
}
