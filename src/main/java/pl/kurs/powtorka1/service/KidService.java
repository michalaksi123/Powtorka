package pl.kurs.powtorka1.service;

import pl.kurs.powtorka1.exception.KidNotFoundException;
import pl.kurs.powtorka1.model.Candy;
import pl.kurs.powtorka1.model.Kid;

import java.util.*;

public class KidService {

    public Kid firstKidWithTwoCandy (List<Kid> list, int numberOfcandy) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(kid -> kid.getCandies().size() >= numberOfcandy)
                .findFirst()
                .orElseThrow(KidNotFoundException::new);
    }

    public Kid kidWithTheMostAmountOfSpecificType(List<Kid> list,String type) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(kid -> kid.numberOfCandyOfGivenType(type) > 0)
                .max(Comparator.comparing(kid -> kid.numberOfCandyOfGivenType(type)))
                .orElseThrow(KidNotFoundException::new);
    }

    public long howManySweetsOfAGivenTypeWereBoughtByChildren(String type, List<Candy> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(candy -> candy.getType().equals(type))
                .count();
    }

    public boolean kidWithGum(List<Candy> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .anyMatch(candy -> candy.getType().equalsIgnoreCase("Gum"));
    }
}
