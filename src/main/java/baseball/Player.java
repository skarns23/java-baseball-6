package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public static final int MAX_SIZE = 3;         // 입력받는 최대의 수를 나타내는 상수
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
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        Validation.validationInputLength(input, MAX_SIZE);
        Validation.validationValueInRange(input, START_INCLUSIVE, END_INCLUSIVE);
        List<Integer> inputNumList = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            inputNumList.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        Validation.validationIsUnique(inputNumList, MAX_SIZE);
        return inputNumList;
    }


}
