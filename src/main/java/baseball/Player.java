package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Player {

    private static final int MAX_SIZE = 3;         // 입력받는 최대의 수를 나타내는 상수
    private static final int START_INCLUSIVE = 1;  // 입력범위 시작 값을 나타내는 상수
    private static final int END_INCLUSIVE = 9;    // 입력범위 마지막 값을 나타내는 상수
    private List<Integer> numberList;              // 플레이어의 숫자를 담을 멤버변수 리스트, 외부에서 접근이 불가능하도록 private 지정
    private boolean isComputer;                    // 컴퓨터 여부를 저장하는 멤버변수


    public Player(boolean isComputer) {
        this.isComputer = isComputer;
        setNumberList();
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList() {
        this.numberList = this.isComputer ? generateRandomNumbers() : generateInputNumbers();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randNumList = new ArrayList<>();
        while (randNumList.size() < MAX_SIZE) {
            int genRandNum = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!randNumList.contains(genRandNum)) {
                randNumList.add(genRandNum);
            }
        }
        return randNumList;
    }

    private List<Integer> generateInputNumbers() throws IllegalArgumentException {

        String input = Console.readLine();
        validationInputLength(input);
        validationValueInRange(input);
        return null;
    }

    private void validationInputLength(String inputString) {
        if (inputString.length() != MAX_SIZE) {
            throw new IllegalArgumentException("형식에 맞지 않는 값을 입력하셨습니다.");
        }
    }

    private void validationValueInRange(String inputString) {
        String pattern = "^[1-9]*$";
        if (!Pattern.matches(pattern, inputString)) {
            throw new IllegalArgumentException("1~9까지의 숫자만 입력 가능합니다.");
        }
    }


}
