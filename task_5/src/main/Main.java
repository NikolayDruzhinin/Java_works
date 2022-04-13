package main;

import java.nio.channels.FileChannel;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //5.1 Return average value of list of integers
        System.out.println("{5.1 return average value of list of integers}");
        List<Integer> intList = new ArrayList<>();
        initList(new Integer[]{1, 1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 7, 7}, intList);
        System.out.println(intList);
        System.out.println(getAverage(intList) + "\n");

        //5.2 Convert all strings in the list to uppercase and add "_new_" word
        System.out.println("{5.2 convert all strings in the list to uppercase and add \"_new_\" word}");
        List<String> strList = new ArrayList<>();
        initList(new String[]{"alpha", "beta", "animal", "arm", "astra", "abc"}, strList);
        System.out.println(strList);
        System.out.println(toUpperCase(strList) + "\n");

        //5.3 Return list of squares of elements of the list that occur only once
        System.out.println("{5.3 return list of squares of elements of the list that occur only once}");
        System.out.println(intList);
        System.out.println(setUniqueSquare(intList) + "\n");

        //5.4 Return sorted string starting with a given letter
        System.out.println("{5.4 return sorted string starting with a given letter}");
        System.out.println(strList);
        System.out.println(getSortedStrings(strList, 'a') + "\n");

        //5.5 Get last element from collection or throw an exception
        System.out.println("{5.5 Get last element from collection or throw an exception}");
        System.out.println(strList);
        try {
            System.out.println(getLastElem(strList).get() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5.6 Get sum of even numbers or zero
        System.out.println("{5.6 Get sum of even numbers or zero}");
        System.out.println(intList);
        System.out.println(getEvenSum(intList) + "\n");

        //5.7 convert all strings in the list into map where key - first symbol
        // of the string and value - the others
        System.out.println(strList);
        Map<String, String> strMap = convertList(strList);
        for (String key : strMap.keySet())
            System.out.println(key + " - " + strMap.get(key));
    }

    private static <T> void initList(T[] arr, List<T> list) {
        for (T t : arr)
            list.add(t);
    }

    private static double getAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    private static List<String> toUpperCase(List<String> strings) {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    private static List<Integer> setUniqueSquare(List<Integer> list) {
        return list.stream()
                .distinct()
                .map(s -> s * s)
                .collect(Collectors.toList());
    }

    private static List<String> getSortedStrings(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.charAt(0) == letter)
                .sorted()
                .collect(Collectors.toList());
    }

    private static Optional<?> getLastElem(Collection<?> c) throws Exception {
        if(c.isEmpty())
            throw new Exception();
        return c.stream()
                .skip(c.size()-1)
                .findAny();
    }

    private static Integer getEvenSum(List<Integer> l) {
        return l.stream()
                .collect(Collectors
                        .summingInt(p -> p % 2 == 0 ? p : 0));
    }
    private static Map<String, String> convertList(List<String> l) {
        return l.stream()
                .collect(Collectors
                        .toMap(p -> p.substring(0,1), p -> p.substring(1),
                                (s,a) -> s + ", " + a, HashMap::new));
    }
}
