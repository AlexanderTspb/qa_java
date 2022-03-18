package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;

public class LionAlexTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        LionAlex alex = new LionAlex(feline);
        int countKittens = alex.getKittens();
        Assert.assertEquals(0,countKittens);
    }

    @Test
    public void getFriendsTest() throws Exception {
        LionAlex alex = new LionAlex(feline);
        List<String> responseList = alex.getFriends();
        Assert.assertEquals(List.of("Марти","Мелман","Глория"),responseList);

    }

    @Test
    public void getPlaceOfLivingTest() throws Exception {
        LionAlex alex = new LionAlex(feline);
        String responsePlace = alex.getPlaceOfLiving();
        Assert.assertEquals("Нью-йоркский зоопарк", responsePlace);
    }
}