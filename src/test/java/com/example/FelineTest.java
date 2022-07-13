package com.example;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void eatMeatTest() throws Exception {
        Feline kot = new Feline();
        List<String> responseList = kot.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),responseList);

    }

    @Test
    public void getFamilyTest() {
        Feline kot = new Feline();
        String responseFamily = kot.getFamily();
        Assert.assertEquals("Кошачьи",responseFamily);
    }

    @Test
    public void getKittensTest() {
        Feline kot = new Feline();
        int countKittens = kot.getKittens();
        Assert.assertEquals(1,countKittens);
    }

    //переделан тест вызов getKittens с int параметром
    @Test
    public void getKittensIntTest() {
        Feline kot = new Feline();
        int countKittens = kot.getKittens(5);
        Assert.assertEquals(5,countKittens);
    }

}