package com.example.demo;

public class Service {

    private final long id;
    private final String text;

    public Service(long id, String text)
    {
        this.id = id;
        this.text = reverse(text);
    }

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }

    private String reverse(String str) {
        String rev = "";

        for(int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        return rev;
    }


}
