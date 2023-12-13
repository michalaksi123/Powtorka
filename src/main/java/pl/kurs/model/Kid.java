package pl.kurs.model;

import java.util.*;

public class Kid {
    private String name;
    private int age;
    private List<Candy> candies;


    public Kid(String name, int age) {
        this.name = name;
        this.age = age;
        this.candies = new ArrayList<>();

    }

    public void buyCandy(Candy candy) {
        candies.add(candy);
        candy.getKids().add(this);
    }

    public long numberOfCandyOfGivenType(String type){
        return Optional.ofNullable(candies)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(candy -> candy.getType().equals(type))
                .count();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
