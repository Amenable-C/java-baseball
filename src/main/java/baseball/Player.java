package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private List<Integer> guessNumbers = new ArrayList<>();

    public void createGuessNumber(){
        String guessNumbersForValid = readLine();
        if(!isValidNumbers(guessNumbersForValid)){
            throw new IllegalArgumentException();
        }

        List<Integer> guessNumbers = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            guessNumbers.add(guessNumbersForValid.charAt(i) - '0');
        }

        this.guessNumbers = guessNumbers;
    }

    private boolean isValidNumbers(String guessNumbers) {
        if(!isValidSize(guessNumbers) || !isValidScope(guessNumbers) || !isValidDifferentNumber(guessNumbers)){
            return false;
        }
        return true;
    }

    private boolean isValidDifferentNumber(String guessNumbers) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < guessNumbers.length(); i++){
            if(map.containsKey(guessNumbers.charAt(i)))
                return false;
            map.put(guessNumbers.charAt(i), 1);
        }
        return true;
    }

    private boolean isValidScope(String guessNumbers) {
        for(int i = 0; i < 3; i++){
            if(!(guessNumbers.charAt(i) >= '0' && guessNumbers.charAt(i) <= '9'))
                return false;
        }
        return true;
    }

    private boolean isValidSize(String guessNumbers) {
        return guessNumbers.length() == 3;
    }
}
