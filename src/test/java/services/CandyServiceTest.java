package services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import pl.kurs.model.Candy;
import pl.kurs.model.Kid;
import pl.kurs.service.CandyService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CandyServiceTest {

    @Mock
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


        kids = Arrays.asList(kid1, kid2);
        candies = Arrays.asList(candy1, candy2, candy1);

    }

    @Test
    public void testAllCandyThatKidsBought() {
        List<Candy> result = candyService.allCandyThatKidsBought(kids);
        assertThat(result).containsExactlyInAnyOrder(candy1, candy2);
    }

    @Test
    public void testAllUniqueCandyThatKidsBought() {
        List<Candy> result = candyService.allUniqeCandyThatKidsBought(kids);
        assertThat(result).containsExactlyInAnyOrder(candy1, candy2);
    }

    @Test
    public void testNamesCandyAsString() {
        String result = candyService.namesCandyAsString(candies);
        assertThat(result).isEqualTo("chocolate, haribo");
    }

    @Test
    public void testFindNthMostPopularCandy() {
        kid1.buyCandy(candy1);
        Candy result1 = candyService.findNthMostPopularCandy(kids, 1);
        assertThat(result1).isEqualTo(candy1);
    }
}

