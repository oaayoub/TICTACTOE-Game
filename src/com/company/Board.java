package com.company;
import java.util.Scanner;

public class Board {

    Cell[][] board=new Cell[3][3];
public Board()
{

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j]=new Cell();


        }
   }
}
public void setPiece(int x,int y,char Q)
{
    board[x][y].setXorO(Q);
}
public int getPieceStatus(int x,int y)
{
   return board[x][y].checkXO();
}
    public void getBoardX()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j].getXorO() +" ");

            }
            if(i<2)
            System.out.println() ;
        }

    }
}
