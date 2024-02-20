package lsn.example.pair;

import lsn.example.io.PrintService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PairService {

    private static PairService instance;
    private final PrintService printService;
    private final int goal = 13; //it won't work for even numbers
    private final int overHalf = (int) Math.ceil((double) goal / 2);

    private PairService() {
        printService = PrintService.getInstance();
    }

    public static PairService getInstance() {
        if (instance == null) {
            instance = new PairService();
        }
        return instance;
    }

    public void findPairs(String input) throws NumberFormatException {
        Map<Integer, Integer> frequencyMap = createSortedFrequencyMap(input);
        List<Pair> pairs = pairUp(frequencyMap);
        printService.printCorrectOutput(pairs);
    }

    private Map<Integer, Integer> createSortedFrequencyMap(String input) {
        String[] numbersStr = input.split(" ");
        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        for (String numStr : numbersStr) {
            try {
                int num = Integer.parseInt(numStr);
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            } catch (NumberFormatException exception) {
                throw new NumberFormatException("Input contains a number that is too large!");
            }

        }
        return frequencyMap;
    }

    private List<Pair> pairUp(Map<Integer, Integer> frequencyMap) {
        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int lowerValue = entry.getKey();
            if (lowerValue >= overHalf) {
                break;
            }
            int higherValue = goal - lowerValue;
            if (frequencyMap.containsKey(higherValue)) {
                int numberOfRepeats = frequencyMap.get(higherValue) * entry.getValue();
                for (int i = 0; i < numberOfRepeats; i++) {
                    pairs.add(new Pair(lowerValue, higherValue));
                }
            }
        }
        return pairs;
    }

}
