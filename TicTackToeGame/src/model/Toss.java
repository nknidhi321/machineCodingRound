package model;

import java.util.Random;

public class Toss {
   
    public int generateToss() {
        Random rand = new Random();
        int tossResult = rand.nextInt(2);
        return tossResult;
    }
    
}