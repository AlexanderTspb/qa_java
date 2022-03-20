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
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец",feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int countOfKittens = lion.getKittens();
        Assert.assertEquals(1,countOfKittens);
    }

    @Test
    public void doesHaveManeIsExceptionTest() throws Exception {

        try {
            Lion lion = new Lion("Samka", feline);

        } catch (Exception exception) {
            String exp = exception.getMessage();
            assertEquals(exp, "Используйте допустимые значения пола животного - самец или самка");
        }
    }

   //переделано на проверку, что метод lion.getFood обращается к feline.getFood и возращает значения
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец",feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> listOfFood = lion.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),listOfFood);
    }
}