package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",family);
    }

    @Test
    public void getFoodIsExceptionTest() throws Exception {

        try {
            Animal animal = new Animal();
            animal.getFood("Всеядное");

        } catch (Exception exception) {
            String exp = String.valueOf(exception);
            assertEquals(exp,"java.lang.Exception: Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }

    @Mock
    Animal animal;

    @Test
    public void getFoodVerifyHichnikTest() throws Exception {
        animal.getFood("Хищник"); // вызвали метод объекта с аргументом
        Mockito.verify(animal).getFood("Хищник"); // проверили, что метод вызван с этим параметром
    }

    @Test
    public void getFoodVerifyTravoyadnoeTest() throws Exception {
        animal.getFood("Травоядное"); // вызвали метод объекта с аргументом
        Mockito.verify(animal).getFood("Травоядное"); // проверили, что метод вызван с этим параметром
    }

}