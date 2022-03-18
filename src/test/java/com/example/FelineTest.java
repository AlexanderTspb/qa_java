package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void EatMeatVerifyTest() throws Exception {
    feline.getFood("Хищник"); // вызвали метод объекта с аргументом
    Mockito.verify(feline).getFood("Хищник"); // проверили, что метод вызван с этим параметром
}

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
    public void getKittensVerifyTest() {
    feline.getKittens(5); // вызвали метод объекта с аргументом
    Mockito.verify(feline).getKittens(5); // проверили, что метод вызван с этим параметром
    }

    @Test
    public void getKittensTest() {
        Feline kot = new Feline();
        int countKittens = kot.getKittens();
        Assert.assertEquals(1,countKittens);
    }

    @Test
    public void getKittensThenReturnTest() {
        Mockito.when(feline.getKittens()).thenReturn(5);
        Assert.assertEquals(5, feline.getKittens());
    }
}