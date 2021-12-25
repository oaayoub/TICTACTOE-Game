package com.company;

import java.util.Scanner;


public class Player {
    String name;
    int num;


    Scanner scp =new Scanner(System.in);
    public void setName() {
        System.out.println("Enter player name");
        this.name =scp.next();


    }

    public String getName() {
        return name;
    }
}
