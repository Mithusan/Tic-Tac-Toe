/*
Programmer: Mithusan Arulampalam
Date: December 4th, 2019
Program Name: Tic Tac Toe
* Program Description: Allows user to play a game of tic tac toe, keeps track
* total points, and allows user to reset game without restarting entire program
*/

//The import statements make the drawing classes ready to use.
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TicTac extends JFrame{
    TicTacEvent tictac = new TicTacEvent(this);
    
    //JPanel creates the outline box.
    static JPanel row1 = new JPanel();
    //JButton[ ] [ ] creates nine buttons in a 2D array that is 3 x 3.
    JButton[][] boxes = new JButton[3][3];
    
    //create buttons and text fields to be used later
    JButton play = new JButton("Play");
    JButton reset = new JButton("Reset");
    JOptionPane win = new JOptionPane("Winner");
    ImageIcon back = new ImageIcon("cardback.jpg");
    Color pink = new Color(255,192,203);
    
    //Points System
    JTextArea points = new JTextArea("           "
            + "Total Points \n\n X: " + tictac.winX + "\n\n O: " + tictac.winO);
    
    //creates the method to draw the game board
    public TicTac() {
        super("Tic to the Tac, to the Toe");//creates the outer frame with the title
        JFrame.setDefaultLookAndFeelDecorated(true);
        setSize (500,600);//sets the size of the outer frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets the program to quit running when the window is closed
        FlowLayout layout = new FlowLayout();//arranges components from left to right, centering components horizontally with a five pixel gap between them
        setLayout(layout);
        
        //Disables Buttons
        points.setEditable(false);
        reset.setEnabled(false);
        
        int name = 0;
        String newname;
        GridLayout layout1 = new GridLayout(4, 3, 10, 10);//arranges the components in a rectangular grid, where all cells are of equal size
        row1.setLayout(layout1);
        
        //creates and adds the buttons to the GridLayout's first three rows
        for (int x=0; x<=2; x++){
            for (int y=0; y<=2; y++){
                name = name + 1;
                newname = Integer.toString(name);
                boxes[x][y] = new JButton(newname);
                boxes[x][y].setIcon(back);
                row1.add(boxes[x][y]);
            }
        }
        
        //adds remaining components to the GridLayout
        row1.add(points);
        row1.add(play);
        row1.add(reset);
        add(row1);//adds the GridLayout to the FlowLayout
        
        //Play and Reset Button
        play.addActionListener(tictac);
        reset.addActionListener(new resetGame());
        
        //Disables Game Board
        for (int x=0; x<=2; x++){
            for (int y=0; y<=2; y++){
                boxes[x][y].addActionListener(tictac);
                boxes[x][y].setEnabled(false);
            }
        }
        row1.setBackground(Color.pink);//Changes Background Colour
        
        //shows the FlowLayout on the screen
        setVisible(true);
    }
    
    //RESET BUTTON
    private class resetGame implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            play.setEnabled(true);//Enables Play Button
            
            //Resets Game Board
            boxes[0][0].setIcon(back);
            boxes[0][1].setIcon(back);
            boxes[0][2].setIcon(back);
            boxes[1][0].setIcon(back);
            boxes[1][1].setIcon(back);
            boxes[1][2].setIcon(back);
            boxes[2][0].setIcon(back);
            boxes[2][1].setIcon(back);
            boxes[2][2].setIcon(back);
            
            //Reset Variables
            for (int row=0; row<=2; row++){
                for (int col=0; col<=2; col++){
                    tictac.check[row][col]=0;
                }
            }
            tictac.clicks = 0;
            
            reset.setEnabled(false);
        }
    }
   
    public static void main(String[] arguments){
        TicTac frame = new TicTac();
        
        //Sets Title
        TitledBorder border = new TitledBorder("Tic Tac Toe");//Title Name
        border.setTitleJustification(TitledBorder.CENTER);//Centers Title
        border.setTitlePosition(TitledBorder.TOP);//Puts at Top
        
        row1.setBorder(border);//Border
        
        //Sets Background Colour
        frame.getContentPane().setBackground(Color.pink);
    }
}