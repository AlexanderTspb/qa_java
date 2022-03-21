package com.example;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void doesHaveManeIsExceptionTest() throws Exception {

        exceptionRule.expect(java.lang.Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion("Samka", feline);

    }


   //теперь список создается один раз и сохраняется в переменную listOfFoodExp
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец",feline);
        List<String> listOfFoodExp = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(listOfFoodExp);
        List<String> listOfFoodAct = lion.getFood();
        Assert.assertEquals(listOfFoodExp,listOfFoodAct);
    }
}