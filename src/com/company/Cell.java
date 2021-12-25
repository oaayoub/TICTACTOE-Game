package com.company;
import java.util.Scanner;
public class Cell {
    char XorO;
    int state=0;
    public char getXorO() {
        return XorO;
    }

    public void setXorO(char xorO) {
        XorO = xorO;
        if(xorO=='X')
            state=1;
        else
            state =-1;
    }
    public int checkXO()
    {
        return state;
    }

}
