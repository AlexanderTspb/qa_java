package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParametrizedTest {

    private final String checkingValue;
    private final List<String> expectedValue;

    public AnimalParametrizedTest(String checkingValue,List<String> expectedValue){
        this.checkingValue = checkingValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(checkingValue);
        assertEquals(expectedValue,actual);
    }

}