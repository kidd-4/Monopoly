package actionListener;

import house.Location;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import others.MainT;
import player.Player;
import playerMaker.PlayerMaker;
import basicFrame.BFrame;

public class InitButtonAction implements ActionListener {
	int num = 0;
//	BasicFrame basicFrame;
	BFrame basicFrame;
	int money = 10000;
	int point = 0;
	Player[] player;

	
	public InitButtonAction(BFrame Bframe) {
		this.basicFrame = Bframe;
	}
	
	
	///////////////////////////////////////////////////////////////////////start 
	// TODO
//	public InitButtonAction(BasicFrame Bframe) {
//		this.basicFrame = Bframe;
//	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String playerNumOld =  basicFrame.getInitPlayerNum().getText().trim();
		String initMoney = basicFrame.getInitMoney().getText().trim();
		String initPoints = basicFrame.getInitPoints().getText().trim();
		if((!MainT.isNumeric(playerNumOld)) || (!MainT.isNumeric(initMoney)) 
				|| (!MainT.isNumeric(initPoints))) {
			JOptionPane.showMessageDialog(basicFrame.getFrame(), "输入有误咯，要纯数字");
		}
		num = Integer.parseInt(playerNumOld);
		money = Integer.parseInt(initMoney);
		point = Integer.parseInt(initPoints);
		
		
		
		
//		player1 = new Player(MainT.Names[1], money, point);
//		player2 = new Player(MainT.Names[2], money, point);	
		player = new Player[num];
		for(int i = 0; i< num; i++) {
			player[i] = PlayerMaker.makePlayer(MainT.Names[i], money, point, MainT.colors[i]);
//			System.out.println(player[i]);
		}
		
		
		
		// TODO
//		basicFrame.getInitPanel().setVisible(false);
		// end
		
		
		
		
		
		
		
		JTextField[] showPlayerInfo = basicFrame.getShowPlayersInfo();
		
		for(int i = 0; i<10; i++) {
			showPlayerInfo[i].setText(player[0].getPlayerData().get(i));
			showPlayerInfo[i+10].setText(player[1].getPlayerData().get(i));
		}
		if(num>=3) {
			for(int i = 0; i<10; i++) {
				showPlayerInfo[i+20].setText(player[2].getPlayerData().get(i));
			}
		}
		if(num==4) {
			for(int i = 0; i<10; i++) {
				showPlayerInfo[i+30].setText(player[3].getPlayerData().get(i));
			}
		}
		
		
		/**
		 *  �����е�Location����ʼ��
		 */
		// "isPlain"�յ�,"isStartPlace"�����,
		// "isHouse"�з�, "isToolHouse" ������,"isGiftHouse"��Ʒ��,"isMagicHouse"ħ����,
		// "isRoadBlock"��·��,"isBoomb"��ը��,"isPrison"�м���,"isHospital"��ҽԺ,"isMine"���
		
//		Location startLocation = new Location(0, "isStartPlace");
		MainT.markLocation.put(0, new Location(0, "isStartPlace", "isForbid"));
		
		Location[] plainLocation = new Location[100];
		for(int i =1;i<=62;i++) {
			if(i==14) {
				Location hospitalLocation = new Location(14, "isHospital", "isForbid");
				MainT.markLocation.put(14, hospitalLocation);
			} else if(i==28) {
				Location toolHouseLocation = new Location(28, "isToolHouse", "isForbid");
				MainT.markLocation.put(28, toolHouseLocation);
			} else if(i==35) {
				Location giftHouseLocation = new Location(35, "isGiftHouse", "isForbid");
				MainT.markLocation.put(35, giftHouseLocation);
			} else if(i==49) {
				Location prisonLocation = new Location(49, "isPrison", "isForbid");
				MainT.markLocation.put(49, prisonLocation);
			} else {
//				plainLocation[i] = new Location(i, "isPlain");
				MainT.markLocation.put(i, new Location(i, "isPlain", "isEmpty"));
			}
		}
		MainT.markLocation.put(63, new Location(63, "isMagicHouse", "isForbid"));
		for(int i =64;i<=69;i++) {
			MainT.markLocation.put(i, new Location(i, "isMine", "isEmpty"));
		}
		for(int i =0;i<70;i++) {
			System.out.println(i + ":" + MainT.markLocation.get(i).getIsHouseState() + "," +  MainT.markLocation.get(i).getIsToolState());
			
		}
		
		
		
		
		
		
		
		
		
		
//		JLabel[] player1Labels = basicFrame.getPlayerLabels(0);
//		JLabel[] player2Labels = basicFrame.getPlayerLabels(1);
//		
//		
//		for(int i = 0; i<player1Labels.length; i++) {
//			player1Labels[i].setText(player[0].getPlayerData().get(i));
//		}
//		for(int i = 0; i<player2Labels.length; i++) {
//			player2Labels[i].setText(player[1].getPlayerData().get(i));
//		}
		
		ButtonDiceAction.player = player;
		UseBombAction.player = player;
		
	}

	
	/**
	 *  ��ȡ��ʼ�������
	 * @return
	 */
	public Player[] getPlayers() {
		return player;
	}
	
	

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}
	
	

	
	
	
	
}
