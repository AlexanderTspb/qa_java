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

public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String responseMeow = cat.getSound();
        Assert.assertEquals("Мяу", responseMeow);
    }

    //переделано на проверку,что метод cat.getFood обращается к feline.eatMeat и возращает значения
    @Test
    public void getFoodTest() throws Exception {

        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> listOfFood = cat.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), listOfFood);

    }

    //переделано на verify,что метод getFood вызывает метод eatMeat
    @Test
    public void getFoodVerifyTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline,Mockito.times(1)).eatMeat();
    }

}