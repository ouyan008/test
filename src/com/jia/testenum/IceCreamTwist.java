package com.jia.testenum;

public enum IceCreamTwist {
    VANILLA("white"),
    STRAWBERRY("pink"),
    WALNUT("brown"),
    CHOCOLATE("dark brown");

    String color;

    IceCreamTwist(String color) {
        this.color = color;
    }

    public String toString() {
    	return color;
    }
    
    public static void main(String[] args) {
        System.out.println(VANILLA);            //line1
        System.out.println(CHOCOLATE);          //line2
    }
}