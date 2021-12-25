package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      tictactoe TTT = new tictactoe();
      while (true)
      {
      TTT.startGamePVP();

          System.out.println("Do you want to play again?...");
          String ask;
          ask = sc.next().toUpperCase(Locale.ROOT);
          if(ask=="NO")
              break;

    }}
        }

