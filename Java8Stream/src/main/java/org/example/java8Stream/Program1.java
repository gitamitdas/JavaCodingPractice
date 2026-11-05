package org.example.java8Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Program1 {
    public static void main(String[] args) {
        Integer[] numbers={5,2,4,3,1,9,7,8,6};
        String[] words={"eat","ate","tea","dog","god","cat"};
        Optional<Integer> max = Arrays.stream(numbers).max(Comparator.naturalOrder());
        System.out.println(max.get());
        List<Integer> numberList = Arrays.stream(numbers).filter(x->x%2==0).toList();
        List<Integer> numberList1 = Arrays.stream(numbers).map(x->x*2).toList();
        List<Integer> numberList2 = Arrays.stream(numbers).sorted().toList().reversed();
        List<String> wordList = Arrays.stream(words).map(String::toUpperCase).toList();
        Arrays.stream(words).collect(Collectors.groupingBy(x->{
            char[] wordChar = x.toCharArray();
            Arrays.sort(wordChar);
            return new String(wordChar);
        })).forEach((k,v)->{
            System.out.println(v);
        });
        System.out.println(numberList);
        System.out.println(numberList1);
        System.out.println(numberList2);
        System.out.println(wordList);
        //System.out.println(groupedWords);
        List<List<Integer>> groupedNumbers = List.of(
                Arrays.stream(numbers).filter(x -> x % 2 == 0).sorted().toList(),
                Arrays.stream(numbers).filter(x -> x % 3 == 0).sorted().toList(),
                Arrays.stream(numbers).filter(x -> x % 2 != 0 && x % 3 != 0).sorted().toList()
        );

        System.out.println(groupedNumbers);

    }
}
