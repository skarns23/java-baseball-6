package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static boolean isComputer = true;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isContinue = false;
        while (!isContinue) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Player player1 = new Player(isComputer);
            System.out.println(player1.getNumberList().toString());
            Player player2 = new Player(!isComputer);
            isContinue = checkEnd(player1, player2);
        }
    }

    // 3스트라이크를 맞춘 경우 1,2를 반환할 함수
    public static boolean checkEnd(Player player1, Player player2) {
        while (!compareValue(player1, player2)) {
            player2.setNumberList();
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하면 2를 입력하세요.");
        String choose = Console.readLine();
        Validation.validationInputLength(choose, 1);
        Validation.validationValueInRange(choose, 1, 2);
        return choose.equals("2");
    }

    public static boolean compareValue(Player player1, Player player2) {
        int[] arr = new int[Player.MAX_SIZE];
        String sb = "";
        boolean isCorrect = false;
        for (int idx = 0; idx < player2.getNumberList().size(); idx++) {
            arr[checkBall(idx, player2.getNumberList().get(idx), player1.getNumberList())]++;
        }
        if (arr[2] != 0) {
            sb += arr[2] + "볼 ";
        }
        if (arr[1] != 0) {
            sb += arr[1] + "스트라이크 ";
            if (arr[1] == Player.MAX_SIZE) {
                isCorrect = true;
            }
        }
        if (arr[0] == 3) {
            sb += "낫싱";
        }
        System.out.println(sb);
        return isCorrect;
    }

    public static int checkBall(int index, int value, List<Integer> numList) {
        int findIdx = numList.indexOf(value);
        return findIdx == -1 ? 0 : findIdx == index ? 1 : 2;
    }


}
