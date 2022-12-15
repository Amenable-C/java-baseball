package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private List<Integer> guessNumber = new ArrayList<>();

    public List<Integer> getGuessNumber() {
        return guessNumber;
    }
    public void createGuessNumber(){
        String guessNumberForValid = readLine();
        if(!isValidNumbers(guessNumberForValid)){
            throw new IllegalArgumentException();
        }

        List<Integer> guessNumber = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            guessNumber.add(guessNumberForValid.charAt(i) - '0');
        }

        this.guessNumber = guessNumber;
    }

    private boolean isValidNumbers(String guessNumber) {
        if(!isValidSize(guessNumber) || !isValidScope(guessNumber) || !isValidDifferentNumber(guessNumber)){
            return false;
        }
        return true;
    }

    private boolean isValidDifferentNumber(String guessNumber) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < guessNumber.length(); i++){
            if(map.containsKey(guessNumber.charAt(i)))
                return false;
            map.put(guessNumber.charAt(i), 1);
        }
        return true;
    }

    private boolean isValidScope(String guessNumber) {
        for(int i = 0; i < 3; i++){
            if(!(guessNumber.charAt(i) >= '0' && guessNumber.charAt(i) <= '9'))
                return false;
        }
        return true;
    }

    private boolean isValidSize(String guessNumber) {
        return guessNumber.length() == 3;
    }

    public boolean restart() {
        return false;
    }
}
