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
    //добавил дополнительную проверку в блоке finally
    //таким образом, в случае, если не выкидывается исключение, то все равно выполнится доп проверка и тест упадет
    @Test
    public void getFoodIsExceptionTest() throws Exception {

        String isNotException = "exception не был вызван";
        String isException = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

        try {
            Animal animal = new Animal();
            animal.getFood("Всеядное");

        } catch (Exception exception) {
            isNotException = exception.getMessage();
            assertEquals(isException,isNotException);
        }
        finally {
            assertEquals(isException, isNotException);
        }
    }

}