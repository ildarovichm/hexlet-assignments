package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Collections;
import java.util.LinkedList;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        boolean result = false;
        LinkedList listSymbols = new LinkedList();
        LinkedList listWord = new LinkedList();
        LinkedList listResult = new LinkedList();

        for (int i = 0; i < symbols.length(); i++) {
            listSymbols.add(symbols.toLowerCase().charAt(i));
        }
        for (int i = 0; i < word.length(); i++) {
            listWord.add(word.toLowerCase().charAt(i));
        }
        Collections.sort(listWord);
        Collections.sort(listSymbols);

        if (listSymbols.size() < listWord.size() || listSymbols.size() <= 0) {
            System.out.println("Not enough symbols");
            return false;
        } else if (listWord.size() < listSymbols.size()) {
            int i = 0;
            for (Object list : listSymbols) {
                if (list.equals(listWord.get(i))) {
                    listResult.add(list);
                    i++;
                }
            }
        }
        if (listWord.equals(listResult)) {
            result = true;
        }
        System.out.println(result);
        return result;
    }
}
//END
