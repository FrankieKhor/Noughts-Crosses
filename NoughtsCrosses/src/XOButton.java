import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
public class XOButton extends JButton implements ActionListener{
	ImageIcon X; 
	ImageIcon O;
	int value = 0;
	
	public XOButton()
	{
	X = new ImageIcon("D:\\Frankie\\Pictures\\X.png");
	O = new ImageIcon("D:\\Frankie\\Pictures\\O.png");
	this.addActionListener(this);
}
	public void actionPerformed(ActionEvent e){
		value++;
		value%=3;
		switch(value){
			case 0:
				setIcon(null);
				break;
			case 1:
				setIcon(X);
				break;
			case 2:
				setIcon(O);
				break;

		}
	}
	
	public void win(){
		
	}
}
