import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a list of strings as command line arguments.");
            return;
        }

        List<String> inputList = Arrays.asList(args[0].split(", "));
        List<String> sortedList = sortStrings(inputList);

        List<String> l1 = new ArrayList<>(sortedList);
        List<String> l2 = sortSecondList(l1);

        System.out.println("L1: " + l1);
        System.out.println("L2: " + l2);
    }

    public static List<String> sortStrings(List<String> inputList) {
        Collections.sort(inputList);
        return inputList;
    }

    public static List<String> sortSecondList(List<String> sortedList) {
        Map<Character, List<String>> map = new HashMap<>();
        for (String str : sortedList) {
            char firstChar = str.charAt(0);
            map.computeIfAbsent(firstChar, k -> new ArrayList<>()).add(str);
        }

        List<String> l2 = new ArrayList<>();
        for (List<String> list : map.values()) {
            list.sort((s1, s2) -> {
                int num1 = Integer.parseInt(s1.substring(1));
                int num2 = Integer.parseInt(s2.substring(1));
                return Integer.compare(num2, num1);
            });
            l2.addAll(list);
        }

        return l2;
    }
}
