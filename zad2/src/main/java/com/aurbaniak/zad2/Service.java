package com.aurbaniak.zad2;

public class Service {

    private String aString;
    private int lowerCase;
    private int upperCase;
    private int numbers;
    private int specialCharacters;
    private int characterSum;



    public Service(String aString) {
        this.aString = aString;
        lowerCase = 0;
        upperCase = 0;
        numbers = 0;
        specialCharacters = 0;
        characterSum = 0;
    }

    public void countLowerCaseLetters() {
        int count = 0;
        for(int i = 0; i <aString.length(); i++) {
            if(Character.isLowerCase(aString.charAt(i))) count++;
        }
        lowerCase = count;
    }

    public void countUpperCaseLetter() {
        int count = 0;
        for(int i = 0; i <aString.length(); i++) {
            if(Character.isUpperCase(aString.charAt(i))) count++;
        }
        upperCase = count;
    }

    public void countNumbers() {
        int count = 0;
        for(int i = 0; i <aString.length(); i++) {
            if(Character.isDigit(aString.charAt(i))) count++;
        }
        numbers = count;
    }

    public void countSpecialSigns() {
        int count = 0;
        for(int i = 0; i <aString.length(); i++) {
            if(Character.toString(aString.charAt(i)).matches("[^A-Za-z0-9]")) count++;
        }
        specialCharacters = count;
    }

    public void countAll() {
        characterSum = aString.length();
    }

    public String getaString() {
        return aString;
    }

    public int getLowerCase() {
        return lowerCase;
    }

    public int getUpperCase() {
        return upperCase;
    }

    public int getNumbers() {
        return numbers;
    }

    public int getSpecialCharacters() {
        return specialCharacters;
    }

    public int getCharacterSum() {
        return characterSum;
    }

}
