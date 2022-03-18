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
        Assert.assertEquals(1,lion.getKittens());
    }

    @Test
    public void doesHaveManeIsTrueTest() throws Exception {
        Lion lion = new Lion("Самец",feline);
        boolean mane = lion.doesHaveMane();
        assertEquals(mane,true);
    }

    @Test
    public void doesHaveManeIsFalseTest() throws Exception {
        Lion lion = new Lion("Самка",feline);
        boolean mane = lion.doesHaveMane();
        assertEquals(mane,false);
    }

    @Test
    public void doesHaveManeIsExceptionTest() throws Exception {

        try {
            Lion lion = new Lion("Samka", feline);

        } catch (Exception exception) {
            String exp = String.valueOf(exception);
            assertEquals(exp, "java.lang.Exception: Используйте допустимые значения пола животного - самей или самка");
        }
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец",feline);
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),lion.getFood());
    }

}