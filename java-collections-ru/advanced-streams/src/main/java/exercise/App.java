package exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        List<String> unsortedList = new ArrayList<>();
        List<String> sortedList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        String sRes = "";
        Scanner scanner = new Scanner(content);
        while (scanner.hasNextLine()){
            unsortedList.add(scanner.nextLine());
        }
        for(int i = 0; i < unsortedList.size(); i++){
            if(unsortedList.get(i).startsWith("environment=")){
                sortedList.add(unsortedList.get(i));
            }
        }
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        for(String s : sortedList){
            Matcher m = p.matcher(s);
            while (m.find()) {
                resultList.add(m.group(1));
            }
        }
        for(String s : resultList){
            String[] arrStr = s.replaceAll(" ", "").split(",");
            for (String subStr : arrStr){
                if(subStr.startsWith("X_FORWARDED_")){
                    result.add(subStr.replaceAll("X_FORWARDED_", ""));
                }
            }
        }
        for(String s : result){
            if(result.size() <= 1){
                sRes += s;
            }
            else {
                sRes += "," + s;
            }
        }
        if(result.size() > 1){
            sRes = sRes.replaceFirst(",", "");
        }
        return sRes;
    }
}
//END
