/** Programmer:
 * Date:
 * Program Name: TicTacEvent.java
 * Program Description: This program runs the GUI for Tic-Tac-Toe
 */

//use the classes that will be required for the program
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//creates a class that responds to mouse and keyboard input by “listening.”
public class TicTacEvent implements ItemListener, ActionListener, Runnable {
    TicTac gui;//associates the game board with the event
    Thread playing;
    
    //Card Images
    ImageIcon back = new ImageIcon("cardback.jpg");
    ImageIcon a = new ImageIcon("x.jpg");
    ImageIcon b = new ImageIcon("o.jpg");
    
    //created to check for a winner
    int[][] check = new int[3][3];
    int clicks = 0;
    int winX = 0;//Stores Wins for X
    int winO = 0;//Stores Wins for Y
    
    //associates the two files to be used together
    public TicTacEvent (TicTac in){
        gui = in;
        
        for (int row=0; row<=2; row++){
           for (int col=0; col<=2; col++){
               check[row][col]=0;
           }
       }
    }
    
    //tells the program what to do when a button is clicked
    public void actionPerformed (ActionEvent event) {
       //takes the button name as input from the button that is clicked
       String command = event.getActionCommand();
       
       //checks the command variable and calls the appropriate method
       if (command.equals("Play")) {
           startPlaying();
       }
       //checks the command variable and calls the appropriate method
       if (command.equals("1")) {
           b1();
       }
       //checks the command variable and calls the appropriate method
       if (command.equals("2")) {
           b2();
       }
       //checks the command variable and calls the appropriate method
       if (command.equals("3")) {
           b3();
       }
       //checks the command variable and calls the appropriate method
       if (command.equals("4")) {
           b4();
       }
       //checks the command variable and calls the appropriate method
       if (command.equals("5")) {
           b5();
       }
       //checks the command variable and calls the appropriate method
       if (command.equals("6")) {
           b6();
       }
       //checks the command variable and calls the appropriate method
       if (command.equals("7")) {
           b7();
       }
       //checks the command variable and calls the appropriate method
       if (command.equals("8")) {
           b8();
       }
       //checks the command variable and calls the appropriate method
       if (command.equals("9")) {
           b9();
       }
    }

    void b1() {
        clicks = clicks + 1;//keeps track of the number of boxes chosen
        if ((clicks%2)==1){
            gui.boxes[0][0].setIcon(a);
            check[0][0] = 1;
        } 
        //puts an O on the board and declares that square to be taken
        else {
            gui.boxes[0][0].setIcon(b);
            check[0][0] = 2;
        }
        winner();

    }
    void b2() {
        clicks = clicks + 1;//keeps track of the number of boxes chosen
        //puts an X on the board and declares that square to be taken
        if ((clicks%2)==1){
            gui.boxes[0][1].setIcon(a);
            check[0][1] = 1;
        } 
        //puts an O on the board and declares that square to be taken
        else {
            gui.boxes[0][1].setIcon(b);
            check[0][1] = 2;
        }
        winner();
    }
    void b3() {
        clicks = clicks + 1;//keeps track of the number of boxes chosen
        //puts an X on the board and declares that square to be taken
        if ((clicks%2)==1){
            gui.boxes[0][2].setIcon(a);
            check[0][2] = 1;
        } 
        //puts an O on the board and declares that square to be taken
        else {
            gui.boxes[0][2].setIcon(b);
            check[0][2] = 2;
        }
        winner();
    }
    void b4() {
        clicks = clicks + 1;//keeps track of the number of boxes chosen
        //puts an X on the board and declares that square to be taken
        if ((clicks%2)==1){
            gui.boxes[1][0].setIcon(a);
            check[1][0] = 1;
        } 
        //puts an O on the board and declares that square to be taken
        else {
            gui.boxes[1][0].setIcon(b);
            check[1][0] = 2;
        }
        winner();
    }
    void b5() {
        clicks = clicks + 1;//keeps track of the number of boxes chosen
        //puts an X on the board and declares that square to be taken
        if ((clicks%2)==1){
            gui.boxes[1][1].setIcon(a);
            check[1][1] = 1;
        } 
        //puts an O on the board and declares that square to be taken
        else {
            gui.boxes[1][1].setIcon(b);
            check[1][1] = 2;
        }
        winner();
    }
    void b6() {
        clicks = clicks + 1;//keeps track of the number of boxes chosen
        //puts an X on the board and declares that square to be taken
        if ((clicks%2)==1){
            gui.boxes[1][2].setIcon(a);
            check[1][2] = 1;
        } 
        //puts an O on the board and declares that square to be taken
        else {
            gui.boxes[1][2].setIcon(b);
            check[1][2] = 2;
        }
        winner();
    }
    void b7() {
        clicks = clicks + 1;//keeps track of the number of boxes chosen
        //puts an X on the board and declares that square to be taken
        if ((clicks%2)==1){
            gui.boxes[2][0].setIcon(a);
            check[2][0] = 1;
        } 
        //puts an O on the board and declares that square to be taken
        else {
            gui.boxes[2][0].setIcon(b);
            check[2][0] = 2;
        }
        winner();
    }
    void b8() {
        clicks = clicks + 1;//keeps track of the number of boxes chosen
        //puts an X on the board and declares that square to be taken
        if ((clicks%2)==1){
            gui.boxes[2][1].setIcon(a);
            check[2][1] = 1;
        } 
        //puts an O on the board and declares that square to be taken
        else {
            gui.boxes[2][1].setIcon(b);
            check[2][1] = 2;
        }
        winner();
    }
    void b9() {
        clicks = clicks + 1;//keeps track of the number of boxes chosen
        //puts an X on the board and declares that square to be taken
        if ((clicks%2)==1){
            gui.boxes[2][2].setIcon(a);
            check[2][2] = 1;
        } 
        //puts an O on the board and declares that square to be taken
        else {
            gui.boxes[2][2].setIcon(b);
            check[2][2] = 2;
        }
        winner();
    }

    void winner() {
        /** Check rows for winner */
        for (int x=0; x<=2; x++){
            if ((check[x][0]==check[x][1])&&(check[x][0]==check[x][2])) {
                //checks to see if all entries are X, or all entries are O
                if (check[x][0]==1) {
                    JOptionPane.showMessageDialog(null, "X is the winner");//creates a pop up box declaring a winner
                    winX++;//Adds Point to X
                    System.out.println(winX + " " + winO);
                    gui.reset.setEnabled(true);
                    for (int row=0; row<=2; row++){
                        for (int y=0; y<=2; y++){
                            gui.boxes[row][y].setEnabled(false);
                        }
                    }
                } else if (check[x][0]==2){
                    JOptionPane.showMessageDialog(null, "O is the winner");//creates a pop up box declaring a winner
                    winO++;//Adds Point to O
                    System.out.println(winX + " " + winO);
                    gui.reset.setEnabled(true);
                    for (int row=0; row<=2; row++){
                        for (int y=0; y<=2; y++){
                            gui.boxes[row][y].setEnabled(false);
                        }
                    }
                }
            }
        }

        /** Check columns for winner */
        for (int x=0; x<=2; x++){
            if ((check[0][x]==check[1][x])&&(check[0][x]==check[2][x])) {
                //checks to see if all entries are X, or all entries are O
                if (check[0][x]==1) {
                    JOptionPane.showMessageDialog(null, "X is the winner");//creates a pop up box declaring a winner
                    winX++;//Adds Point to X
                    System.out.println(winX + " " + winO);
                    gui.reset.setEnabled(true);
                    for (int row=0; row<=2; row++){
                        for (int y=0; y<=2; y++){
                            gui.boxes[row][y].setEnabled(false);
                        }
                    }
                    
                } else if (check[0][x]==2) {
                    JOptionPane.showMessageDialog(null, "O is the winner");//creates a pop up box declaring a winner
                    winO++;//Adds Point to O
                    gui.reset.setEnabled(true);
                    System.out.println(winX + " " + winO);
                    for (int row=0; row<=2; row++){
                        for (int y=0; y<=2; y++){
                            gui.boxes[row][y].setEnabled(false);
                        }
                    }
                }
            }
        }

        /** Check diagonals for winner */
        if (((check[0][0]==check[1][1])&&(check[0][0]==check[2][2]))||
                ((check[2][0]==check[1][1])&&(check[1][1]==check[0][2]))){
            ////checks to see if all entries are X, or all entries are O
            if (check[1][1]==1) {
                JOptionPane.showMessageDialog(null, "X is the winner");//creates a pop up box declaring a winner
                winX++;//Adds Point to X
                gui.reset.setEnabled(true);
                System.out.println(winX + " " + winO);
                for (int row=0; row<=2; row++){
                    for (int y=0; y<=2; y++){
                        gui.boxes[row][y].setEnabled(false);
                    }
                }
            } else if (check[1][1]==2) {
                JOptionPane.showMessageDialog(null, "O is the winner");//creates a pop up box declaring a winner
                winO++;//Adds Point to O
                gui.reset.setEnabled(true);
                System.out.println(winX + " " + winO);
                for (int row=0; row<=2; row++){
                    for (int y=0; y<=2; y++){
                        gui.boxes[row][y].setEnabled(false);
                    }
                }
            }

        }

        //This structure checks to see if nine boxes have been chosen 
        //(clicks) and that a winner has not been declared (win == 0).
        /** Checks if the game is a tie */
        if ((clicks==9) && ((winX==0) || (winO==0))) {
            JOptionPane.showMessageDialog(null, "The game is a tie");
            gui.reset.setEnabled(true);
            for (int row=0; row<=2; row++){
                for (int y=0; y<=2; y++){
                    gui.boxes[row][y].setEnabled(false);
                }
            }
            System.out.println(winX + " " + winO);
        }
    }

    //ENABLE THIS AFTER U WIN TO MAKE POINTS WORK
    //DUMBASS
    void startPlaying() {
        //the execution of the program.
        //within an instance method or a constructor, this is a reference to the current object.
        playing = new Thread(this);
        playing.start();//starts the game
        gui.play.setEnabled(false);//disables the play button
        gui.points.setText("           "
            + "Total Points \n\n X: " + winX + "\n\n O: " + winO);
        //Enables Game Board
        for (int x=0; x<=2; x++){
            for (int y=0; y<=2; y++){
                gui.boxes[x][y].setEnabled(true);
            }
        }
    }

    public void itemStateChanged(ItemEvent e) {
    }
    public void run() {
    }


}

