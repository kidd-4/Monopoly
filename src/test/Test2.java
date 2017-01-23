package test;

import javax.swing.JButton;

import actionListener.ButtonDiceAction;
import actionListener.InitButtonAction;
import actionListener.UseBombAction;
import basicFrame.BFrame;


public class Test2 {
	static BFrame basicFrame;
	public static void main(String[] args) {
		basicFrame = new BFrame();
		
		JButton initButton = basicFrame.getInitButton();
		JButton buttonDice = basicFrame.getButtonDice();
		JButton useBomb = basicFrame.getUseBomb();
		
		InitButtonAction initButtonAction = new InitButtonAction(basicFrame);
		initButton.addActionListener(initButtonAction);
		
		UseBombAction useButtonAction = new UseBombAction(basicFrame);
		useBomb.addActionListener(useButtonAction);
		
		buttonDice.addActionListener(new ButtonDiceAction(basicFrame));
		
	}

}
