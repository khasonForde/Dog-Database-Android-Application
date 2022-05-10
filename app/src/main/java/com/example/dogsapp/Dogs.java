package com.example.dogsapp;

import java.io.Serializable;
import java.util.Random;

public class Dogs implements Serializable {
    static final String UNDERWEIGHT = "underweight";
    static final String HEALTHY = "healthy";
    static final String OVERWEIGHT = "overweight";
    static final String OBESE = "obese";

    static final String PUPPY = "puppy";
    static final String ADOLESCENT = "adolescent";
    static final String ADULT = "adult";
    static final String SENIOR = "senior";

    int age;
    String name;
    String breed;
    float weight;
    float height;

    public Dogs (String n, int a, String b, float w, float h) {
        age = a;
        name = n;
        breed = b;
        weight = w;
        height = h;
    }

    public String bark(){
        return (name + ": Woof! Woof!!");
    }

    public String growl(){
        return (name + ": Grrr! Grrr!!");
    }

    public int ageinHumanYears(){
        //YOU MUST IMPLEMENT THIS METHOD
        int ageInHumanYears = 0;
        if (age == 1) {
            ageInHumanYears = 15;
        } else if (age == 2) {
            ageInHumanYears = 24;
        } else if (age > 2) {
            ageInHumanYears = ((age - 2)*5) + 24;
        }
        return ageInHumanYears;
    }

    public String ageCategory() {
        //YOU MUST IMPLEMENT THIS METHOD
        String AgeCategory = "None";
        if (age <= 1) {
            AgeCategory = PUPPY;
        } else if ((age > 1) && (age < 4)) {
            AgeCategory = ADOLESCENT;
        } else if ((age > 4) && (age < 10)) {
            AgeCategory = ADULT;
        } else if (age > 10) {
            AgeCategory = SENIOR;
        } else {
            AgeCategory = "N/A";
        }
        return AgeCategory;
    }

    public float wthRatio(){
        //YOU MUST IMPLEMENT THIS METHOD
        float WTH = 0;
        WTH = weight / height;
        return WTH;
    }

    public String wthCategory(){
        //YOU MUST IMPLEMENT THIS METHOD
        String WTHCAT = "none";
        // A dog with a WTH lower than 2 is considered underweight
        if (wthRatio() < 2){
            WTHCAT = UNDERWEIGHT;
        }
        // A dog with a WTH between 2 and 3 is considered healthy
        else if (wthRatio() >= 2 && wthRatio() < 3){
            WTHCAT = HEALTHY;
        }
        // A dog with a WTH greater than 3 and up to 4 is considered overweight
        else if (wthRatio() > 3 && wthRatio() <= 4){
            WTHCAT = OVERWEIGHT;
        }
        //A dog with a WTH greater than 4 is considered obese
        else {
            WTHCAT = OBESE;
        }
        return WTHCAT;
    }

    public String toString()
    {
        //YOU MUST IMPLEMENT THIS METHOD
        String out = name + " is a " + age + " year(s) old " + breed + " " + ageCategory() + " who is " + ageinHumanYears() + " years old in human years. " + name + "'s BMI or WTH is " + wthRatio() + " and he is considered " + wthCategory() + ".";
        return out;
    }


}
