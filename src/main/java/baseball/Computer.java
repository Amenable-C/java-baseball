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

    public List<Integer> createAnswerNumber() {
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

        System.out.println(resultMessage(strikeCount, ballCount));

        return strikeCount == 3;
    }

    private String resultMessage(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            return ballCount + "볼" + " " + strikeCount + "스트라이크";
        } else if (strikeCount > 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        } else if (strikeCount == 0 && ballCount > 0) {
            return ballCount + "볼";
        } else {
            return "낫싱";
        }
    }

    private int countBall(List<Integer> guessNumber) {
        int ballCount = 0;

        for(int i = 0; i < 3; i++){
            if(Objects.equals(guessNumber.get(i), answerNumber.get(i)))
                continue;
            if(answerNumber.contains(guessNumber.get(i))){
                ballCount++;
            }
        }
        return ballCount;
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
