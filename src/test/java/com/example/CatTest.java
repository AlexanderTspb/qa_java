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

    //теперь список создается один раз и сохраняется в переменную listOfFoodExp
    @Test
    public void getFoodTest() throws Exception {

        Cat cat = new Cat(feline);
        List<String> listOfFoodExp = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(listOfFoodExp);
        List<String> listOfFoodAct = cat.getFood();
        Assert.assertEquals(listOfFoodExp, listOfFoodAct);

    }

    //переделано на verify,что метод getFood вызывает метод eatMeat
    @Test
    public void getFoodVerifyTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline,Mockito.times(1)).eatMeat();
    }

}