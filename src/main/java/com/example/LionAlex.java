package com.example;

import java.util.List;

public class LionAlex extends Lion {

    public LionAlex(Feline feline) throws Exception {
        super("Самец",feline);
    }

    @Override
    public int getKittens() {
        System.out.println("Львят нет");
        return 0;
    }

   public List<String> getFriends(){
        return List.of("Марти","Мелман","Глория");
   }

   public String getPlaceOfLiving(){
        return "Нью-йоркский зоопарк";
  }

}
