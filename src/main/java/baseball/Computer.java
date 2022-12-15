package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {

    private List<Integer> answerNumber = new ArrayList<>();

    public Computer() {
        this.answerNumber = createAnswerNumber();
    }

    private List<Integer> createAnswerNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public boolean checkResult(List<Integer> guessNumber){
        int strikeCount = countStrike(guessNumber);
        int ballCount = countBall(guessNumber);
        return true;
    }

    private int countStrike(List<Integer> guessNumber) {
        int strikeCount = 0;
        for(int i = 0; i < 3; i++){
            if(Objects.equals(guessNumber.get(i), answerNumber.get(i)))
                strikeCount++;

        }
        return strikeCount;
    }


}
