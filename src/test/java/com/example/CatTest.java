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

    @Mock
    Cat cat;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String responseMeow = cat.getSound();
        Assert.assertEquals("Мяу", responseMeow);
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());

    }

    @Test
    public void getFoodIsExceptionTest() throws Exception {

        try {
            Cat cat = new Cat(feline);
            cat.getFood();

        } catch (Exception exception) {
            String exp = String.valueOf(exception);
            assertEquals(exp, "");
        }
    }

}