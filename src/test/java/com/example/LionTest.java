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
    //добавил дополнительную проверку в блоке finally
    //таким образом,в случае, если не выкидывается исключение, то все равно выполнится доп проверка и тест упадет
    @Test
    public void doesHaveManeIsExceptionTest() throws Exception {

        String isNotException = "exception не был вызван";
        String isException = "Используйте допустимые значения пола животного - самец или самка";
        try {
            Lion lion = new Lion("Samka", feline);

        } catch (Exception exception) {
            isNotException = exception.getMessage();
            assertEquals(isException, isNotException);
        }
        finally {
            assertEquals(isException, isNotException);
        }
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