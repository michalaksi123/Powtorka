package pl.kurs.service;

import pl.kurs.model.Candy;
import pl.kurs.model.Kid;

import java.util.*;
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




}
