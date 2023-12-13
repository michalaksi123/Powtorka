package services;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.exception.KidNotFoundException;
import pl.kurs.model.Candy;
import pl.kurs.model.Kid;
import pl.kurs.service.KidService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class KidServiceTest {

    private Candy candy1;
    private Candy candy2;
    private Kid kid1;
    private Kid kid2;
    private List<Kid> kids;
    private List<Candy> candies;
    private KidService kidService;

    @Before
    public void init() {
        kidService = new KidService();
        kid1 = new Kid("Marcin", 4);
        kid2 = new Kid("Magdalena", 8);
        candy1 = new Candy("Chocolate", "Bar");
        candy2 = new Candy("Haribo", "Gum");

        kid1.buyCandy(candy1);
        kid2.buyCandy(candy2);
        kid1.buyCandy(candy1);


        kids = Arrays.asList(kid1, kid2);
        candies = Arrays.asList(candy1, candy2, candy1);
    }

    @Test
    public void testFirstKidWithTwoCandy() {
        Kid result = kidService.firstKidWithTwoCandy(kids, 2);
        assertThat(result).isEqualTo(kid1);
    }

    @Test
    public void testKidWithTheMostAmountOfSpecificType() {
        Kid result = kidService.kidWithTheMostAmountOfSpecificType(kids, "Bar");
        assertThat(result).isEqualTo(kid1);
    }

    @Test
    public void testHowManySweetsOfAGivenTypeWereBoughtByChildren() {
        long result = kidService.howManySweetsOfAGivenTypeWereBoughtByChildren("Bar", candies);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testKidWithGum() {
        boolean result = kidService.kidWithGum(candies);
        assertTrue(result);
    }

    @Test(expected = KidNotFoundException.class)
    public void ShouldThrowKidNotFoundException() {
        kidService.firstKidWithTwoCandy(null,0);
    }
}

