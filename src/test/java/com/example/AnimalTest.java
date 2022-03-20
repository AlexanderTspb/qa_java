package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

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
            String exp = exception.getMessage();
            assertEquals(exp,"Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }

}