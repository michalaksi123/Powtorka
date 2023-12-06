package pl.kurs.service;

import pl.kurs.exception.KidNotFoundException;
import pl.kurs.model.Kid;

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
}
