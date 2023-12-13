package services;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.kurs.model.Candy;
import pl.kurs.model.Kid;
import pl.kurs.service.CandyService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


public class CandyServiceTest {

    private Candy candy1;
    private Candy candy2;
    private Kid kid1;
    private Kid kid2;
    private List<Kid> kids;
    private List<Candy> candies;
    private CandyService candyService;

    @Before
    public void init() {
        candyService = new CandyService();
        kid1 = new Kid("Marcin", 4);
        kid2 = new Kid("Magdalena", 8);
        candy1 = new Candy("Chocolate", "Milka");
        candy2 = new Candy("Haribo", "Gum");

        kid1.buyCandy(candy1);
        kid2.buyCandy(candy2);
        kid2.buyCandy(candy2);

        kids = Arrays.asList(kid1, kid2);
        candies = Arrays.asList(candy1, candy2, candy1);
    }

    @Test
    public void testAllCandyThatKidsBought() {
        List<Candy> result = candyService.allCandyThatKidsBought(kids);
        List<Candy> expected = new ArrayList<>(List.of(candy1, candy2, candy2));
        assertEquals(expected, result);
    }

    @Test
    public void testAllUniqueCandyThatKidsBought() {
        List<Candy> result = candyService.allUniqeCandyThatKidsBought(kids);
        List<Candy> expected = new ArrayList<>(List.of(candy1, candy2));
        assertEquals(expected, result);
    }

    @Test
    public void testNamesCandyAsString() {
        String result = candyService.namesCandyAsString(candies);
        assertEquals("chocolate, haribo", result);
    }

    @Test
    public void testFindNthMostPopularCandy() {
        kid1.buyCandy(candy2);
        Candy result1 = candyService.findNthMostPopularCandy(kids, 2);
        assertEquals(candy1, result1);
    }
}

