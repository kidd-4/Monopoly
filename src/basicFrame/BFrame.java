package basicFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


 public class BFrame extends JFrame {
	private int i,j,k;
	JPanel p1,p2,p3,p4,p5,p6,p7;
	JButton[] btn= new JButton[70];
	public JFrame frmRichman;
	JButton initButton;
	private JButton buttonDice; 
	JTextField[] tf;
	JTextField initPlayerNum;
	JTextField initMoney;
	JTextField initPoints;
	JLabel showDice; 
	
	JTextField bombLocation;
	JButton  useBomb;
	
	
	private List<JButton> buttonList;
	
	public BFrame() {
		init();
	}
	
	public  void init(){
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		
		
		
		
		
		
		
		
		initPlayerNum = new JTextField("     ");
		initMoney = new JTextField("    ");
		initPoints = new JTextField("    ");
		initButton = new JButton("确定");
		
		p3.add(initPlayerNum);
		p3.add(initMoney);
		p3.add(initPoints);
		p3.add(initButton);
		
		
		JLabel[] lab= new JLabel[40];//建立32个JLabel显示玩家信息，每个玩家8个
		for(i=0;i<=39;i++)
		{   
			if(i%10==0)
			{
			    lab[i]= new JLabel("Name");
			    if(i>=0&&i<=9||i>=30&&i<=39)
			    lab[i].setForeground(Color.orange);
			    else
			    lab[i].setForeground(Color.red);
			}
			else if(i%10==1)
			{
			    lab[i]= new JLabel("State");
			    if(i>=0&&i<=9||i>=30&&i<=39)
			    lab[i].setForeground(Color.orange);
			    else
			    lab[i].setForeground(Color.red);
			}
			else if(i%10==2)
			{
				lab[i]= new JLabel("Remaining Time");
				if(i>=0&&i<=9||i>=30&&i<=39)
				lab[i].setForeground(Color.orange);
				else
				lab[i].setForeground(Color.red);
			}
			else if(i%10==3)
			{
				lab[i]= new JLabel("Total Money");
				if(i>=0&&i<=9||i>=30&&i<=39)
			    lab[i].setForeground(Color.orange);
				else
				lab[i].setForeground(Color.red);
			}
			else if(i%10==4)
			{
				lab[i]= new JLabel("Cash");
				if(i>=0&&i<=9||i>=30&&i<=39)
				lab[i].setForeground(Color.orange);
				else
				lab[i].setForeground(Color.red);
			}
			else if(i%10==5)
			{
				lab[i]= new JLabel("Points");
				if(i>=0&&i<=9||i>=30&&i<=39)
				lab[i].setForeground(Color.orange);
				else
				lab[i].setForeground(Color.red);
			}
			else if(i%10==6)
			{
				lab[i]= new JLabel("HouseNum");
				if(i>=0&&i<=9||i>=30&&i<=39)
				lab[i].setForeground(Color.orange);
				else
				lab[i].setForeground(Color.red);
			}
			else if(i%10==7)
			{
				lab[i]= new JLabel("Robot");
				if(i>=0&&i<=9||i>=30&&i<=39)
				lab[i].setForeground(Color.orange);
				else
				lab[i].setForeground(Color.red);
			}
			else if(i%10==8)
			{
				lab[i]= new JLabel("RoadBlock");
				if(i>=0&&i<=9||i>=30&&i<=39)
				lab[i].setForeground(Color.orange);
				else
				lab[i].setForeground(Color.red);
			}
			else 
			{
				lab[i]= new JLabel("Boomb");
				if(i>=0&&i<=9||i>=30&&i<=39)
				lab[i].setForeground(Color.orange);
				else
				lab[i].setForeground(Color.red);
			}
			
		}

		tf = new JTextField[40];
		for(i=0;i<=39;i++)
		{   
			if(i%10==0)
			{
			    tf[i]= new JTextField();
			    tf[i].setEditable(false);
			}
			else if(i%10==1)
			{
				tf[i]= new JTextField();
				tf[i].setEditable(false);
			}
			else if(i%10==2)
			{
				tf[i]= new JTextField();
				tf[i].setEditable(false);
			}
			else if(i%10==3)
			{
				tf[i]= new JTextField();
				tf[i].setEditable(false);
			}
			else if(i%10==4)
			{
				tf[i]= new JTextField();
				tf[i].setEditable(false);
			}
			else if(i%10==5)
			{
				tf[i]= new JTextField();
				tf[i].setEditable(false);
			}
			else if(i%10==6)
			{
				tf[i]= new JTextField();
				tf[i].setEditable(false);
			}
			else if(i%10==7)
			{
				tf[i]= new JTextField();
				tf[i].setEditable(false);
			}
			else if(i%10==8)
			{
				tf[i]= new JTextField();
				tf[i].setEditable(false);
			}
			else 
			{
				tf[i]= new JTextField();
				tf[i].setEditable(false);
			}
			
		}
		
		
	
		p1.setLayout(new GridLayout(8,29));//JPanel布局
		
		// 总的人员列表panel
		p2.setLayout(new GridLayout(2,2));
		
		// 四个人的panel
		p4.setLayout(new GridLayout(10,2));
		p5.setLayout(new GridLayout(10,2));
		p6.setLayout(new GridLayout(10,2));
		p7.setLayout(new GridLayout(10,2));
		
		p1.setBackground(Color.blue);
		p2.setBackground(Color.orange);
		p3.setBackground(Color.cyan);
		p4.setBackground(Color.darkGray);
		p5.setBackground(Color.LIGHT_GRAY);
		p6.setBackground(Color.LIGHT_GRAY);
		p7.setBackground(Color.darkGray);
		
		
		p2.add(p4);//在p2中添加4个JPanel
		p2.add(p5);
		p2.add(p6);
		p2.add(p7);
		
		p4.add(lab[0]);//第一个玩家的JLabel和JTextField
		p4.add(tf[0]);
		p4.add(lab[1]);
		p4.add(tf[1]);
		p4.add(lab[2]);
		p4.add(tf[2]);
		p4.add(lab[3]);
		p4.add(tf[3]);
		p4.add(lab[4]);
		p4.add(tf[4]);
		p4.add(lab[5]);
		p4.add(tf[5]);
		p4.add(lab[6]);
		p4.add(tf[6]);
		p4.add(lab[7]);
		p4.add(tf[7]);
		p4.add(lab[8]);
		p4.add(tf[8]);
		p4.add(lab[9]);
		p4.add(tf[9]);
		
	
		p5.add(lab[10]);//第二个玩家的JLabel和JTextField
		p5.add(tf[10]);
		p5.add(lab[11]);
		p5.add(tf[11]);
		p5.add(lab[12]);
		p5.add(tf[12]);
		p5.add(lab[13]);
		p5.add(tf[13]);
		p5.add(lab[14]);
		p5.add(tf[14]);
		p5.add(lab[15]);
		p5.add(tf[15]);
		p5.add(lab[16]);
		p5.add(tf[16]);
		p5.add(lab[17]);
		p5.add(tf[17]);
		p5.add(lab[18]);
		p5.add(tf[18]);
		p5.add(lab[19]);
		p5.add(tf[19]);
		
		
		
		p6.add(lab[20]);//第三个玩家的JLabel和JTextField
		p6.add(tf[20]);
		p6.add(lab[21]);
		p6.add(tf[21]);
		p6.add(lab[22]);
		p6.add(tf[22]);
		p6.add(lab[23]);
		p6.add(tf[23]);
		p6.add(lab[24]);
		p6.add(tf[24]);
		p6.add(lab[25]);
		p6.add(tf[25]);
		p6.add(lab[26]);
		p6.add(tf[26]);
		p6.add(lab[27]);
		p6.add(tf[27]);
		p6.add(lab[28]);
		p6.add(tf[28]);
		p6.add(lab[29]);
		p6.add(tf[29]);
		
	
		
		p7.add(lab[30]);//第四个玩家的JLabel和JTextField
		p7.add(tf[30]);
		p7.add(lab[31]);
		p7.add(tf[31]);
		p7.add(lab[32]);
		p7.add(tf[32]);
		p7.add(lab[33]);
		p7.add(tf[33]);
		p7.add(lab[34]);
		p7.add(tf[34]);
		p7.add(lab[35]);
		p7.add(tf[35]);
		p7.add(lab[36]);
		p7.add(tf[36]);
		p7.add(lab[37]);
		p7.add(tf[37]);
		p7.add(lab[38]);
		p7.add(tf[38]);
		p7.add(lab[39]);
		p7.add(tf[39]);
		
	
		buttonDice = new JButton("掷骰子");
		p3.add(buttonDice);
//		buttonDice.setBounds(1400, 600, 50,50);
		
		showDice = new JLabel();
		p3.add(showDice);
		
		
		bombLocation = new JTextField("      地址       ");
		useBomb = new JButton("使用炸弹");
		p3.add(bombLocation);
		p3.add(useBomb);
		
		
		
		
		
		
		
		
		
		
		frmRichman = new JFrame();
	   
		
	    frmRichman.setLayout(null);//设置JPanel的位置及大小
		p1.setBounds(0,0,900,500);
		p2.setBounds(900,0,460,500);
		p3.setBounds(0,500,1360,500);
		
		frmRichman.add(p1,BorderLayout.CENTER);//给JPanel添加方位
		frmRichman.add(p2,BorderLayout.EAST);
		frmRichman.add(p3,BorderLayout.SOUTH);
	    
	
		 draw();//调用draw方法画图
		
		 frmRichman.setTitle("RichMan3");
		 frmRichman.setSize(1500, 800);
		 frmRichman.setVisible(true);
		 frmRichman.addWindowListener(new Handle());
	}
	
//	public static void main(String args[])
	//{
	//	new map();
//	}

	
	class Handle extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			(e.getWindow()).dispose();
			System.exit(0);
		}
	}
	
	
	
	
	
	
	// 画地图按钮
	public void draw() {
		//  JButton[] btn= new JButton[70];
		buttonList = new ArrayList<JButton>();
		for(int i=0;i<=69;i++)//创建按钮并初始化按钮
		{   
			btn[i]= new JButton();
			btn[i].setText("0");
			btn[i].setBackground(new Color(238,238,238));
			btn[i].setMargin(new Insets(0,0,0,8));
			buttonList.add(btn[i]);
			if(i>63) {
				btn[i].setText("$");
			}
		}
		btn[0].setText("S");
		btn[14].setText("H");
		btn[28].setText("T");
		btn[35].setText("G");
		btn[49].setText("P");
		btn[63].setText("M");
//		for(int i = 0; i<29; i++) {
//			buttonList.add(btn[i]);
//		}
//		for(int i =30;i<=40;i+=2) {
//			buttonList.add(btn[i]);
//		}
//		for(int i=69;i>=41;i--){
//			buttonList.add(btn[i]);
//		}
//		for(int i = 39;i>=29;i-=2){
//			buttonList.add(btn[i]);
//		}
//		
		System.out.println(btn[0].getBackground().toString());
		
		
		for(int i = 0; i<=28; i++) {
			p1.add(btn[i]);
		}
		p1.add(btn[69]);
		for(int i=0; i<=26;i++) {
			p1.add(new JLabel());
		}
		p1.add(btn[29]);
		p1.add(btn[68]);
		for(int i=0; i<=26;i++) {
			p1.add(new JLabel());
		}
		p1.add(btn[30]);
		p1.add(btn[67]);
		for(int i=0; i<=26;i++) {
			p1.add(new JLabel());
		}
		p1.add(btn[31]);
		p1.add(btn[66]);
		for(int i=0; i<=26;i++) {
			p1.add(new JLabel());
		}
		p1.add(btn[32]);
		p1.add(btn[65]);
		for(int i=0; i<=26;i++) {
			p1.add(new JLabel());
		}
		p1.add(btn[33]);
		p1.add(btn[64]);
		for(int i=0; i<=26;i++) {
			p1.add(new JLabel());
		}
		p1.add(btn[34]);
		for(int i =63;i>=35;i--) {
			p1.add(btn[i]);
		}
		
		
		
//		for(j=0;j<=7;j++)//画地图
//		for(i=0;i<=28;i++)
//		{
//			
//			if(j==0&&(i>=1&&i<=27&&i!=14))//给上下两排添加按钮
//			       p1.add(btn[i]);
//			else if (j==7&&(i>=1&&i<=27&&i!=14))
//				   p1.add(btn[i+35]);
//			 
//			else if (j==0&&i==0)
//			{
//			       p1.add(btn[0]);
//			       btn[0].setText("S");
//			}
//			else if (j==0&&i==28)
//			{
//				   p1.add(btn[28]);
//				   btn[28].setText("T");
//			}
//			else if(j==7&&i==0)
//			{
//				   p1.add(btn[63]);
//				   btn[63].setText("M");
//				  
//			}
//			else if(j==7&&i==28)
//			{
//				   p1.add(btn[35]);
//				   btn[35].setText("G");
//			}
//			else if(i==14&&j==0)
//            {
//				   p1.add(btn[14]);
//				   btn[14].setText("H");
//			}
//			else if (i==14&&j==7)
//			{
//				   p1.add(btn[49]);
//				   btn[49].setText("P");
//			}
//			
//			else if(j>=1&&j<=6&&i==28)//给左右添加按钮
//				   p1.add(btn[28+j]);
//			
//			else if (i==0&&j>=1&&j<=6)
//			{
//				p1.add(btn[63+j]);
//				btn[63+j].setText("$");
//			}
//			
//			else
//				p1.add(new JLabel());
//		
//		}
//		
	}

	
	
	
	public JTextField[] getShowPlayersInfo() {
		return tf;
	}
	
	
	
	public JButton getButtonDice() {
		return buttonDice;
	}
	
	public JTextField getInitPlayerNum() {
		return initPlayerNum;
	}
	
	public JTextField getInitMoney() {
		return initMoney;
	}
	public JTextField getInitPoints() {
		return initPoints;
	}
	public JButton getInitButton() {
		return initButton;
	}
	public JFrame getFrame() {
		return frmRichman;
	}
	public JLabel showDice() {
		return showDice;
	}
	
	public List<JButton> getButtonList() {
		return buttonList;
	}
	public JTextField getBombLocation() {
		return bombLocation;
	}
	public JButton getUseBomb() {
		return useBomb;
	}

}
