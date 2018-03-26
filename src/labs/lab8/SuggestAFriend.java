package labs.lab8;

import java.util.*;
import java.util.stream.Collectors;

public class SuggestAFriend {

    /**
     * Given social network g and name s, returns an ArrayList of all
     * the names that this social network would suggest s may know
     * @param g
     * @param s
     */
    public static ArrayList<String> suggest(Graph g, String s) {
        // First, let's make sure name s exists in this graph g
        if (!g.containsName(s)) {
            System.err.println(s + " does not exist in this graph");
            return null;
        }

        Map<String, Integer> count = new HashMap<>();

        List<String> neighbors = g.getNbrs(s);
        neighbors.forEach(friend -> {
            g.getNbrs(friend)
                    .stream()
                    .filter( secondFriend -> !secondFriend.equals(s))
                    .filter( secondFriend -> !neighbors.contains(secondFriend))
                    .forEach(secondFriend -> {
                        count.put(secondFriend, count.containsKey(secondFriend) ? count.get(secondFriend) + 1 : 1);
                    });
        });

        List<Map.Entry<String, Integer>> sorted = count.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .collect(Collectors.toCollection(ArrayList::new));

        int best = sorted.stream()
                .findFirst()
                .map(Map.Entry::getValue)
                .get();

        return sorted.stream()
                .filter(a -> a.getValue() == best)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }




}
