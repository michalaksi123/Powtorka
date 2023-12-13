package pl.kurs.service;

import pl.kurs.exception.CandyNotFoundException;
import pl.kurs.model.Candy;
import pl.kurs.model.Kid;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CandyService {

    public List<Candy> allCandyThatKidsBought(List<Kid> list){
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(kid -> kid.getCandies().stream())
                .toList();
    }



    public List<Candy> allUniqeCandyThatKidsBought(List<Kid> list){
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .flatMap(kid -> kid.getCandies().stream())
                .distinct()
                .toList();
    }

    public String namesCandyAsString(List<Candy> list) {
        return  Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .map(candy -> candy.getName().toLowerCase())
                .distinct()
                .collect(Collectors.joining(", "));
    }

    public Candy findNthMostPopularCandy(List<Kid> list, int n) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .flatMap(kid -> kid.getCandies().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Candy, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .skip(n - 1)
                .findFirst()
                .orElseThrow(CandyNotFoundException::new);
    }

}
