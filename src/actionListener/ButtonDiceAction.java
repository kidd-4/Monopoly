package actionListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JTextField;

import others.MainT;
import player.Player;
import test.RandomProduce;
import basicFrame.BFrame;

public class ButtonDiceAction implements ActionListener {
	private BFrame basicFrame;
	
	
	static int flag = 1;
	
	static Player[] player;
	JTextField[] showPlayerInfo;
	
	
	
	public ButtonDiceAction(){
		
	}
//	public ButtonDiceAction(BasicFrame frame) {
//		this.basicFrame = frame;
////		this.player = initButton.getPlayers();
//	}
	

	
	public ButtonDiceAction(BFrame frame) {
	this.basicFrame = frame;
//	this.player = initButton.getPlayers();
	flag = 1;
	
}
	

	
	
	/**
	 * ��Ӧ���Ӱ�ť�¼�
	 */
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		showPlayerInfo = basicFrame.getShowPlayersInfo();
		int steps = RandomProduce.getRandom(1, 6);
		
		Color originalColor = new Color(238, 238, 238);
		
		// TODO
//		basicFrame.label_show_dice.setText(""+ steps);
//		List<JLabel> labelList = basicFrame.getList();
		
		
		basicFrame.showDice().setText("" + steps);
		List<JButton> labelList = basicFrame.getButtonList();
		
		
		
		
		///////////////////////////////////////////////////////////////////////start
		// TODO 0903 17:45
		if(flag==1 && player[0].getState()!=3) {
			System.out.println("玩家1开始");
//			String labelText = labelList.get(player[0].getLocation()).getText();
//			
//			if(!MainT.defaultChar.contains(labelText)) {
//				labelList.get(player[0].getLocation()).setText("  ");
//			}
//			labelList.get(player[0].getLocation()).setBackground(Color.WHITE);
//			player[0].moveForward(steps);
//			String labelTextNew = labelList.get(player[0].getLocation()).getText();
//			if(!MainT.defaultChar.contains(labelTextNew)) {
////				labelList.get(player1.getLocation()).setText("h1");
//			}
//			labelList.get(player[0].getLocation()).setBackground(Color.RED);
			// ��֮ǰ�Ƴ���ǰɫ
			Queue<Color> colorQueue = MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue(); //.pop();
			if(colorQueue.size()>=2) {		// ����Ĭ��ɫsize=1���Ҳ��Ƿ���ɫsize=2��
				colorQueue.remove();
//				System.out.println("被移除的颜色：" + colorQueue.remove());
//			// ������ҽ���֮ǰ����ɫ
				
			labelList.get(player[flag-1].getLocation()).setBackground(MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue().peek());
				
			} else if(colorQueue.size()==1 && MainT.markLocation.get(player[flag-1].getLocation()).getIsHouseState().equals("isHouse")) {
				labelList.get(player[flag-1].getLocation()).setBackground(MainT.allHouseMap.get(player[flag-1].getLocation()).getHouseColor());
			} else {
				labelList.get(player[flag-1].getLocation()).setBackground(originalColor);
			}
			 
			
			// ��ǰ���������ӵ��������ʾ��ɫ
			showPlayerInfo[0].setBackground(Color.PINK);
			// TODO 0904 18.04
			// ǰ����Ӧ�õĵص㣬������·������
			player[0].moveForward(steps);
			labelList.get(player[flag-1].getLocation()).setBackground(Color.RED);
			MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue().add(Color.RED);
			
			
			player[flag-1].checkIfbuyLand();
			String labelText = labelList.get(player[flag-1].getLocation()).getText();
			if(!MainT.defaultChar.contains(labelText)) {
				labelList.get(player[flag-1].getLocation()).setText("1");
			}
			reshowPlayerInfo(player);
			showPlayerInfo[0].setBackground(originalColor);
			getNextTextfield(flag).setBackground(originalColor);
//			flag++;
			System.out.println("玩家1结束flag=" + flag);
		}
		
		
		
		if(flag==2 &&  player[flag-1].getState()!=3) {
			System.out.println("玩家2开始");
//			String labelText = labelList.get(player[1].getLocation()).getText();
//			if(!MainT.defaultChar.contains(labelText)) {
//				labelList.get(player[1].getLocation()).setText("  ");
//			}
//			labelList.get(player[1].getLocation()).setBackground(Color.WHITE);
//			player[1].moveForward(steps);
//			String labelTextNew = labelList.get(player[1].getLocation()).getText();
//			if(!MainT.defaultChar.contains(labelTextNew)) {
////				labelList.get(player2.getLocation()).setText("h2");
//			}
//			labelList.get(player[1].getLocation()).setBackground(Color.YELLOW);
			
			Queue<Color> colorQueue = MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue(); //.pop();
			if(colorQueue.size()>=2) {		// ����Ĭ��ɫsize=1���Ҳ��Ƿ���ɫsize=2��
				colorQueue.remove();
//				System.out.println("被移除的颜色：" + colorQueue.remove());
//			// ������ҽ���֮ǰ����ɫ
				
					labelList.get(player[flag-1].getLocation()).setBackground(MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue().peek());
				
			} else if(colorQueue.size()==1 && MainT.markLocation.get(player[flag-1].getLocation()).getIsHouseState().equals("isHouse")) {
				labelList.get(player[flag-1].getLocation()).setBackground(MainT.allHouseMap.get(player[flag-1].getLocation()).getHouseColor());
			} else {
				labelList.get(player[flag-1].getLocation()).setBackground(originalColor);
			}
			
			// ��ǰ���������ӵ��������ʾ��ɫ
			showPlayerInfo[10].setBackground(Color.PINK);
			// TODO 0904 18.04
			player[flag-1].moveForward(steps);
			labelList.get(player[flag-1].getLocation()).setBackground(Color.YELLOW);
			MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue().add(Color.YELLOW);
			
			
			player[flag-1].checkIfbuyLand();
			String labelText = labelList.get(player[flag-1].getLocation()).getText();
			if(!MainT.defaultChar.contains(labelText)) {
				labelList.get(player[flag-1].getLocation()).setText("2");
			}
			reshowPlayerInfo(player);
			showPlayerInfo[10].setBackground(originalColor);
			getNextTextfield(flag).setBackground(originalColor);
//			flag++;
			System.out.println("玩家2结束flag=" + flag);
			System.out.println("player.length=" + player.length);
		}
		
		if(player.length>=3) {
			if(flag==3) {
				if(player[flag-1].getState()!=3) {
					System.out.println("玩家3开始");
	//				String labelText = labelList.get(player[3].getLocation()).getText();
					// ��֮ǰ�Ķ���
	//				Location presentLocation = MainT.markLocation.get(player[3].getLocation());
	//				if(MainT.defaultChar.contains(labelText)) {
	//					labelList.get(player[3].getLocation()).setText("  ");
	//				}
	//				labelList.get(player[3].getLocation()).setBackground(Color.WHITE);
	//				Location presentLocation = MainT.markLocation.get(player[3].getLocation());
					
					Queue<Color> colorQueue = MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue(); //.pop();
					if(colorQueue.size()>=2) {		// ����Ĭ��ɫsize=1���Ҳ��Ƿ���ɫsize=2��
						colorQueue.remove();
//						System.out.println("���Ƴ�����ɫ��" + colorQueue.remove());
//					// ������ҽ���֮ǰ����ɫ
						
							labelList.get(player[flag-1].getLocation()).setBackground(MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue().peek());
						
					} else if(colorQueue.size()==1 && MainT.markLocation.get(player[flag-1].getLocation()).getIsHouseState().equals("isHouse")) {
						labelList.get(player[flag-1].getLocation()).setBackground(MainT.allHouseMap.get(player[flag-1].getLocation()).getHouseColor());
					} else {
						labelList.get(player[flag-1].getLocation()).setBackground(originalColor);
					}
					// ��ǰ���������ӵ��������ʾ��ɫ
					showPlayerInfo[20].setBackground(Color.PINK);
					player[flag-1].moveForward(steps);
					labelList.get(player[flag-1].getLocation()).setBackground(Color.GREEN);
					MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue().add(Color.GREEN);
					
					
					player[flag-1].checkIfbuyLand();
					String labelText = labelList.get(player[flag-1].getLocation()).getText();
					if(!MainT.defaultChar.contains(labelText)) {
						labelList.get(player[flag-1].getLocation()).setText("3");
					}
					reshowPlayerInfo(player);
					showPlayerInfo[20].setBackground(originalColor);
					getNextTextfield(flag).setBackground(originalColor);
					
	//				String labelTextNew = labelList.get(player[3].getLocation()).getText();
	//				if(!MainT.defaultChar.contains(labelTextNew)) {
	//				}
//					if(player.length==3) {
//						flag=1;
//					} else
//						flag++;
					System.out.println("玩家3结束flag:" + flag);
//				} else
//					flag++;
				}
			}
			if(flag==4) {
				if(player[flag-1].getState()!=3) {
					System.out.println("玩家4开始");
					
					Queue<Color> colorQueue = MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue(); //.pop();
					if(colorQueue.size()>=2) {		// ����Ĭ��ɫsize=1���Ҳ��Ƿ���ɫsize=2��
						colorQueue.remove();
//						System.out.println("���Ƴ�����ɫ��" + colorQueue.remove());
//					// ������ҽ���֮ǰ����ɫ
						
							labelList.get(player[flag-1].getLocation()).setBackground(MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue().peek());
						
					} else if(colorQueue.size()==1 && MainT.markLocation.get(player[flag-1].getLocation()).getIsHouseState().equals("isHouse")) {
						labelList.get(player[flag-1].getLocation()).setBackground(MainT.allHouseMap.get(player[flag-1].getLocation()).getHouseColor());
					} else {
						labelList.get(player[flag-1].getLocation()).setBackground(originalColor);
					}
					
					
					// ��ǰ���������ӵ��������ʾ��ɫ
					showPlayerInfo[30].setBackground(Color.PINK);
					player[flag-1].moveForward(steps);
					labelList.get(player[flag-1].getLocation()).setBackground(Color.GRAY);
					MainT.markLocation.get(player[flag-1].getLocation()).getColorQueue().add(Color.GRAY);
					
					player[flag-1].checkIfbuyLand();
					String labelText = labelList.get(player[flag-1].getLocation()).getText();
					if(!MainT.defaultChar.contains(labelText)) {
						labelList.get(player[flag-1].getLocation()).setText("4");
					}
					reshowPlayerInfo(player);
					showPlayerInfo[30].setBackground(originalColor);
					getNextTextfield(flag).setBackground(originalColor);
//					flag=1;
					System.out.println("玩家4结束flag:"+ flag);
//				} else 
//					flag=1;
				
			}
			}
			
			
			
			
			}
//		} else {
//			flag=1;
//		}
			
		

		
		
		/**
		 * ����2����3����4����תЧ��
		 */
		if(player.length==2) {
			flag = (flag%2==0) ? 1 : 2;
		} else if (player.length==3) {
			if(flag==3) {
				flag=1;
			} else {
				flag++;
			}
		} else {
			if(flag==4) {
				flag=1;
			} else {
				flag++;
			}
		}
		
		// ���������л�Ч��
//		flag = (flag%2==0) ? 1 : 2;
		/////////////////////////////////////////////////////////////////////////end
	}


	




	public void setPlayers(Player[] players) {
		this.player = players;
	}
	
	public void reshowPlayerInfo(Player[] players) {
		for(int i = 0; i<10; i++) {
			showPlayerInfo[i].setText(player[0].getPlayerData().get(i));
			showPlayerInfo[i+10].setText(player[1].getPlayerData().get(i));
		}
		if(players.length==3) {
			for(int i = 0; i<10; i++) {
				showPlayerInfo[i+20].setText(player[2].getPlayerData().get(i));
			}
		}
		if(players.length==4) {
			for(int i = 0; i<10; i++) {
				showPlayerInfo[i+20].setText(player[2].getPlayerData().get(i));
				showPlayerInfo[i+30].setText(player[3].getPlayerData().get(i));
			}
		}
	}
	
	public JTextField getNextTextfield(int index) {
		int num = player.length;
		if(num==2) {
			if(index==1) {
				return showPlayerInfo[10];
			} else {
				return showPlayerInfo[0];
			}
		} else if(num==3) {
			if(index==1) {
				return showPlayerInfo[10];
			} else if(index==2) {
				return showPlayerInfo[20];
			} else {
				return showPlayerInfo[0];
			}
		} else {
			if(index==1) {
				return showPlayerInfo[10];
			}else if(index==2) {
				return showPlayerInfo[20];
			}else if(index==3) {
				return showPlayerInfo[30];
			}else if(index==4) {
				return showPlayerInfo[0];
			}
		}
		return null;
	}



	public int getFlag() {
		
		return flag;
	}

}
