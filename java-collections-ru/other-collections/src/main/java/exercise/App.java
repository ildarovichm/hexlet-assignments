package exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App{
    public static Map<String, Object> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();

        List<String> keys1 = new ArrayList<>(data1.keySet());
        List<String> keys2 = new ArrayList<>(data2.keySet());

        Map<String, Object> flattedMaps = Stream.of(data1, data2)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, TreeMap::new));

        List<String> allKeys = new ArrayList<>(flattedMaps.keySet());

        Set<String> treeSetOfKeys = new TreeSet<>(Comparator.naturalOrder());

        for(String k : allKeys){
            treeSetOfKeys.add(k);
        }

        for(String k : allKeys){
            if(data1.containsKey(k) && data2.containsKey(k)){
                if(data1.get(k).equals(data2.get(k))){
                    result.put(k, "unchanged");
                }
                else if(!data1.get(k).equals(data2.get(k)) && !data2.get(k).equals("") && !data2.get(k).equals(null)){
                    result.put(k, "changed");
                }
            }
            else if(data1.containsKey(k) && !data2.containsKey(k)){
                result.put(k, "deleted");
            }
            else if(!data1.containsKey(k) && data2.containsKey(k)){
                result.put(k, "added");
            }
        }
        return result;
    }
}
//END
