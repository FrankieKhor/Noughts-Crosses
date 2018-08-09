import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Graphics;
public class NoughtsCrosses implements ActionListener{
	
	int turnCount = 0;
	static boolean win = false;  
	static boolean playerFirst = true;
	JButton[] button = new JButton[9];	//array of 9 jbutton for the user to click to display O/X 
	String letter = "";							//will store the value of X and O
	String player1 = "You";
	String player2 = "Computer"; 
	JTextArea output = new JTextArea(5,30);
	
	public static void main(String[]args)
	{
		new NoughtsCrosses();
	}
	
	public NoughtsCrosses()
	{
		JFrame frame = new JFrame("Noughts and crosses");
		JPanel backgroundPanel = new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();	
		frame.setVisible(true);
		frame.setSize(500,500);		
		frame.add(backgroundPanel);
		//creates the grid where the button can be placed 
		backgroundPanel.setLayout(new GridLayout(4,4));
		for(int i=0; i<9; i++)
		{
			button[i] = new JButton();
			button[i].setActionCommand(""+i);
			button[i].setText(""+i);
			button[i].addActionListener(this);
			backgroundPanel.add(button[i]);
		}
		 backgroundPanel.add(output,BorderLayout.CENTER);
	}
	 public void actionPerformed(ActionEvent clickEvent) 
	 {
		 // whose turn it is
		 turnCount++;
		
		 if(turnCount %2 == 1)
		 {	
			 letter = "X";
			 
			 System.out.println("POOOPOPOPOPO " +clickEvent.getActionCommand());
			
			 switch(clickEvent.getActionCommand()) {
			 case "0": 
				 button[0].setText(letter);
				 output.append(letter +" was placed in position 0\n"); 
				 button[0].setEnabled(false);
				 break;
			 case "1": 
				 button[1].setText(letter);
				 output.append(letter +" was placed in position 1\n"); 
				 button[1].setEnabled(false);
				 break;
			 case "2": 
				 button[2].setText(letter);
				 output.append(letter +" was placed in position 2\n"); 
				 button[2].setEnabled(false);
				 break;
			 case "3": 
				 button[3].setText(letter);
				 output.append(letter +" was placed in position 3\n"); 
				 button[3].setEnabled(false);
				 break;
			 case "4": 
				 button[4].setText(letter);
				 output.append(letter +" was placed in position 4\n"); 
				 button[4].setEnabled(false);
				 break;
			 case "5": 
				 button[5].setText(letter);
				 output.append(letter +" was placed in position 5\n"); 
				 button[5].setEnabled(false);
				 break;
			 case "6": 
				 button[6].setText(letter);
				 output.append(letter +" was placed in position 6\n"); 
				 button[6].setEnabled(false);
				 break;
			 case "7": 
				 button[7].setText(letter);
				 output.append(letter +" was placed in position 7\n"); 
				 button[7].setEnabled(false);
				 break;
			 case "8": 
				 button[8].setText(letter);
				 output.append(letter +" was placed in position 8\n"); 
				 button[8].setEnabled(false);
				 break;				 
			 }	  
	     } 
		 else 
		 {
			 letter = "O";			 
			 stupidAI();
			 }
		 winConditions();
	 }
	 
	 public void winConditionsHorizontal() {
		 for(int i =0;i< button.length;i+=3) {
			 if(button[i].getText().equals(button[i+1].getText()) && button[i+1].getText().equals(button[i+2].getText())) {
				 win = true;
				 win();
			 }
		 }
	 }
	 
	 public void win() 
	 {
		 String message = "";
		 if(win == true && letter =="O"){
			 message = player2 + " won ";
			 output.append(player2 + " Won");
			 }
		 else if(win == true && letter =="X"){
			 message = player1 + " won ";
			 output.append(player1 + " Won");
			 }
		 //creates a dialog box which show yes and no
		 int box =JOptionPane.showConfirmDialog(null,message +"would you like to play again",null, JOptionPane.YES_NO_OPTION) ;
		 if(box ==JOptionPane.YES_OPTION){
			 main(null);	//get new noughts and crosses board
		 }
		 else
		 {
			 System.exit(0);
		 }		
	 }
	 
	 public void winConditionVertical() {
		 for(int i =0;i< 3;i++) {
			 if(button[i].getText().equals(button[i+3].getText()) && button[i+3].getText().equals(button[i+6].getText())) {
				 win = true;
				 win();
			 }
		 }
	 }
	 
	 public void winConditionDiagonal() 
	 {
		 if(button[0].getText().equals (button[4].getText()) && (button[4].getText().equals (button[8].getText()) ))
		 {
			 win = true; 
			 win(); 
		 }
		 else if(button[2].getText().equals (button[4].getText()) && (button[4].getText().equals (button[6].getText())))
		 {
			 win = true;
			 win(); 
		 } 
     }
	 
	 public void winConditions() 
	 {
		 winConditionsHorizontal();
		 winConditionVertical();
		 winConditionDiagonal();
		  if(turnCount == 9)
		  {	
			  output.append(player1 +" and "+ player2 +" have tied");
			  int box =JOptionPane.showConfirmDialog(null,"You have tied, would you like to play again",null, JOptionPane.YES_NO_OPTION) ;
			  if(box ==JOptionPane.YES_OPTION)
			  {
				  main(null);	
			  } 
			  else
			  {
				  System.exit(0);
			  }		
		  }	
		  
	 }
	 
	 public void firstTurn()
	 {
	 	Random rand = new Random();
	 	int randNum = rand.nextInt((1 - 0) + 1);   
	 	if (randNum == 1){
	 	}
	 	else
	 	{
	 		stupidAI();
	 		}
	  }
	 //Random
	 public void stupidAI() {
		Random rand = new Random();
		int randomNum = rand.nextInt((8 - 0) + 1);   
		if( button[randomNum].isEnabled()) {
			button[randomNum].setText("O");
			button[randomNum].setEnabled(false);
			output.append("O was placed in position " + randomNum+ " \n"); 

		}else {
			stupidAI();
		}
		
	}

}

