package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class tictactoe implements GameStatus, ActionListener {
    Scanner tscan = new Scanner(System.in);
    int[] SUM_rows = {0, 0, 0};
    int[] SUM_col = {0, 0, 0};
    int SUM_dgn = 0;
    int SUM_dgp = 0;
    Player PlayerOne = new HumanPlayer(1);
    Player PlayerTwo = new HumanPlayer(2);
    Board myBoard = new Board();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JLabel winner_field = new JLabel();
    JButton[] buttons = new JButton[9];
    JPanel winner_panel = new JPanel();


    public tictactoe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textfield.setBackground(Color.WHITE);
        textfield.setForeground(Color.BLACK);
        textfield.setFont(new Font("Verdana", Font.BOLD, 33));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC-TAC-TOE");
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 700, 100);
        title_panel.add(textfield);
        /*

        winner_field.setBackground(Color.WHITE);
        winner_field.setForeground(Color.BLACK);
        winner_field.setFont(new Font("Verdana", Font.BOLD, 33));
        winner_field.setHorizontalAlignment(JLabel.CENTER);

        winner_panel.setLayout(new BorderLayout());
        winner_panel.setBounds(0, 0, 1500, 1500);
        winner_panel.add(winner_field);
        */
        frame.add(title_panel, BorderLayout.NORTH);
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.WHITE);
        frame.add(button_panel);
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            title_panel.add(textfield);
            frame.add(button_panel);
            frame.add(title_panel, BorderLayout.NORTH);

        }


    }


    public int checkWinner(int x, int y, char XO) {
        int state;
        if (XO == 'X')
            state = 1;
        else state = -1;

        SUM_rows[x] += state;
        if (SUM_rows[x] == 3 * state)
            return state;
        SUM_col[y] += state;
        if (SUM_col[y] == 3 * state)
            return state;
        if (x == y)
            SUM_dgn += state;
        if (SUM_dgn == 3 * state)
            return state;
        if (3 - 1 - y == x)
            SUM_dgp += state;
        if (SUM_dgp == 3 * state)
            return state;


        return 0;


    }


    @Override
    public void startGamePVP() {


        Board myBoard = new Board();
        SUM_rows = new int[]{0, 0, 0};
        SUM_col = new int[]{0, 0, 0};
        SUM_dgn = 0;
        SUM_dgp = 0;

        //setting players info
        System.out.println("Player 1");
        PlayerOne.setName();
        System.out.println("Player 2");
        PlayerTwo.setName();
        for (int i = 0; i < 9; i++) {


            System.out.println("Enter X,Y");
            if (i % 2 == 0) {
                System.out.println("Player 1");
                textfield.setText("Player " + PlayerOne.name + " turn");
            } else {
                System.out.println("Player 2");
                textfield.setText("Player " + PlayerTwo.name + " turn");
            }


            int x;
            x = tscan.nextInt();
            int y;
            y = tscan.nextInt();
            if (x > 2 || y > 2 || x < 0 || y < 0) {
                while (true) {
                    System.out.println("Out of bounds");
                    if (x <= 2 && x >= 0 && y <= 2 && y >= 0)
                        break;

                    x = tscan.nextInt();
                    y = tscan.nextInt();


                }
            }
            ///////////////////


            int piece_stat = myBoard.getPieceStatus(x, y);
            if (piece_stat != 0) {
                System.out.println("This place isn't valid...");
                while (true) {
                    x = tscan.nextInt();
                    y = tscan.nextInt();
                    if (x <= 2 && x >= 0 && y <= 2 && y >= 0) {
                        if (myBoard.getPieceStatus(x, y) == 0)
                            break;
                        System.out.println("This place isn't valid...");

                    }
                    System.out.println("Out of bounds");
                }
            }
            if (i % 2 == 0) {
                System.out.println(x + " " + y);

                myBoard.setPiece(x, y, 'X');
                myBoard.getBoardX();

                if (checkWinner(x, y, 'X') == 1) {
                    System.out.println("Player 1 wins..");
                    break;
                }
            } else {
                System.out.println(x + " " + y);

                myBoard.setPiece(x, y, 'O');
                myBoard.getBoardX();
                if (checkWinner(x, y, 'O') == -1) {
                    System.out.println("Player 2 wins..");
                    break;
                }
            }


        }
        //for loop i(9)
        myBoard.getBoardX();


    }

    boolean player_turn = false;

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {

            if (e.getSource() == buttons[i]) {
                if (player_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.BLACK);
                        buttons[i].setText("O");
                        player_turn = false;
                        //

                         //textfield.setText("Player " + PlayerTwo.name +" Turn" );
                        textfield.setText("Player 2 Turn" );

                        //
                        int row = (i) / 3;
                        int col = 22;
                        //
                        if (((i + 1) % 3) == 1)
                            col = 0;
                        if (((i + 1) % 3) == 2)
                            col = 1;
                        if (((i + 1) % 3) == 0)
                            col = 2;

                        myBoard.setPiece(row, col, 'O');
                        myBoard.getBoardX();
                        System.out.println(" ");

                        if (checkWinner(row, col, 'O') == -1) {
                            System.out.println("O WINSS");
                            //textfield.setText("Player " + PlayerTwo.name + " WINS");
                            textfield.setText("Player 2 WINS");
                            break;

                        }
                        //
                        //textfield.setText("Player " + PlayerOne.name +" Turn" );
                        textfield.setText("Player 1 Turn" );
                        //

                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.BLACK);
                        buttons[i].setText("X");
                        player_turn = true;
                        //
                       // textfield.setText("Player " + PlayerOne.name +" Turn" );
                        textfield.setText("Player 1 Turn" );
                        //
                        int row = (i) / 3;
                        int col = 22;
                        //
                        if (((i + 1) % 3) == 1)
                            col = 0;
                        if (((i + 1) % 3) == 2)
                            col = 1;
                        if (((i + 1) % 3) == 0)
                            col = 2;

                        myBoard.setPiece(row, col, 'X');
                        myBoard.getBoardX();
                        System.out.println(" ");
                        if (checkWinner(row, col, 'X') == 1) {
                            System.out.println("X WINSS");
                            //textfield.setText("Player 1" + PlayerOne.name + " WINS");
                            textfield.setText("Player 1 WINS");
                            break;

                        }
                        //
                        //textfield.setText("Player " + PlayerTwo.name +" Turn" );
                        textfield.setText("Player 2 Turn" );
                        //

                    }
                }
            }
        }
    }
}



