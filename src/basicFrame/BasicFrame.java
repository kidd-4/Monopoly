package basicFrame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class BasicFrame {

	public JFrame frmRichman;
	private JPanel panel_left;
	private JPanel panel_right;
	private JPanel panel_left_top;
	private JPanel panel_left_left;
	private JPanel panel_left_bottom;
	private JPanel panel_left_right;
	private JPanel panel_left_center;

//	private JLabel label_3;
//	private JLabel label_4;
	

	
	private JLabel[] label_top;
	private JLabel[] label_right;
	private JLabel[] label_bottom;
	private JLabel[] label_left;
	
	
	
	
	
	private JPanel panel_right_top;
	private JPanel panel_right_bottom;
	
	private JPanel panel_right_top_top;
	private JPanel panel_right_top_bottom;
	private JPanel panel_right_top_right;
	private JPanel panel_right_top_left;
	private JPanel panel_right_top_center;
	
	private JTextField initPlayerNum;
	private JTextField initMoney;
	private JTextField initPoints;
	private JButton initButton;
	
	
	private JPanel[] panel_right_players;
	private JLabel[] player1Labels;
	private JLabel[] player2Labels;
	private JLabel[] player3Labels;
	private JLabel[] player4Labels;
	
	public JLabel label_show_dice;
	public JButton button_dice;
	
	
	
	private List<JLabel> labelList;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Test1 window = new Test1();
//					window.frmRichman.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public BasicFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRichman = new JFrame();
		panel_left = new JPanel();
		panel_right = new JPanel();
		panel_left_top = new JPanel();
		panel_left_left = new JPanel();
		panel_left_bottom = new JPanel();
		panel_left_right = new JPanel();
		panel_left_center = new JPanel();
		

		labelList = new ArrayList<JLabel>();
		
		
		/////////////////////////////////////////////////////
	
		
		//////////////////////////////////////////////////////
		
		panel_left_top.setLayout(new GridLayout(2, 30));
		label_top = new JLabel[60];
		for(int i = 0; i<60;i++) {
			label_top[i] = new JLabel("");
			panel_left_top.add(label_top[i]);
			if(i>=30) {
				label_top[i].setText("0");
				label_top[i].setOpaque(true);
				label_top[i].setBackground(Color.WHITE);
				label_top[i].setBorder(new LineBorder(new Color(0, 0, 0)));
				labelList.add(label_top[i]);
			}
		}
		label_top[30].setText("S");
		label_top[44].setText("H");
		label_top[59].setText("T");
	
		///////////////////////////////////////////////////////
		// right
		panel_left_right.setLayout(new GridLayout(6, 2));
		label_right = new JLabel[12];
		for(int i =0;i<12;i++){
			label_right[i] = new JLabel("");
			panel_left_right.add(label_right[i]);
			if(i%2==0){
				label_right[i].setText("0");
				label_right[i].setOpaque(true);
				label_right[i].setBackground(Color.WHITE);
				label_right[i].setBorder(new LineBorder(new Color(0, 0, 0)));
				labelList.add(label_right[i]);
			}
		}
		
		//////////////////////////////////////////////////////////
		// bottom
		panel_left_bottom.setLayout(new GridLayout(2, 30));
		label_bottom = new JLabel[60];
		for(int i = 0; i<60;i++) {
			label_bottom[i] = new JLabel("");
			panel_left_bottom.add(label_bottom[i]);
			if(i<30) {
				label_bottom[i].setText("0");
				label_bottom[i].setOpaque(true);
				label_bottom[i].setBackground(Color.WHITE);
				label_bottom[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			}
		}
		label_bottom[0].setText("M");	// 设置魔法屋标识
		label_bottom[14].setText("P");	// 设置监狱标识
		label_bottom[29].setText("G");	// 设置礼品屋标识
		for(int i=0;i<30;i++){
			labelList.add(label_bottom[29-i]);
		}
		
		
		
		//////////////////////////////////////////////////////
		// left
		panel_left_left.setLayout(new GridLayout(6, 2));
		label_left = new JLabel[12];
		for(int i =0;i<12;i++){
			label_left[i] = new JLabel("");
			panel_left_left.add(label_left[i]);
			if(i%2!=0){
				label_left[i].setText("$");
				label_left[i].setOpaque(true);
				label_left[i].setBackground(Color.WHITE);
				label_left[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			}
		}
		for(int i = 0; i<12;i++) {
			if(i%2!=0) {
				labelList.add(label_left[12-i]);
			}
		}
		
		
		
		frmRichman.setTitle("RichMan3");
		frmRichman.setBounds(100, 100, 400, 200);
		frmRichman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRichman.getContentPane().setLayout(new GridLayout(1, 2));
		
		frmRichman.getContentPane().add(panel_left);
		frmRichman.getContentPane().add(panel_right);
		
		panel_left.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_left_top.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_left_bottom.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_left_right.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panel_left.setLayout(new BorderLayout());
		panel_left_left.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_left.add(panel_left_left, BorderLayout.WEST);
		panel_left.add(panel_left_right, BorderLayout.EAST);
		panel_left.add(panel_left_top, BorderLayout.NORTH);
		panel_left.add(panel_left_bottom, BorderLayout.SOUTH);
		
		panel_left_left.setLayout(new GridLayout(6, 2));
		
		panel_right.setLayout(new BorderLayout());
		panel_right_top = new JPanel();
		panel_right_bottom = new JPanel();
		panel_right.add(panel_right_top, BorderLayout.CENTER);
		panel_right.add(panel_right_bottom, BorderLayout.SOUTH);
		
		
		//////////////////////////////////////////////////////////start
		// 用来处理用户的输入初始化
		// TODO 0903 17:30
		initPlayerNum = new JTextField("输入玩家数");
		initMoney = new JTextField("输入初始金额");
		initPoints = new JTextField("输入初始点数");
		initButton = new JButton("确定");
		
		panel_right_top_top = new JPanel();
		panel_right.add(panel_right_top_top, BorderLayout.NORTH);
		panel_right_top_top.setName("初始化区");
		panel_right_top_top.add(initPlayerNum);
		panel_right_top_top.add(initMoney);
		panel_right_top_top.add(initPoints);
		panel_right_top_top.add(initButton);
		////////////////////////////////////////////////////////end
//		panel_right_top_bottom = new JPanel();
//		panel_right_top_right = new JPanel();
//		panel_right_top_left = new JPanel();
//		panel_right_top_center = new JPanel();
//		
//		
		
		label_show_dice = new JLabel();
		button_dice = new JButton("点击");
		panel_right_bottom.add(button_dice);	
		panel_right_bottom.add(label_show_dice);
		
		// TODO 0903 13:44 
//		panel_right_top.setLayout(new BorderLayout());
//		panel_right_top.add(panel_right_top_top, BorderLayout.NORTH);
//		panel_right_top.add(panel_right_top_right, BorderLayout.EAST);
//		panel_right_top.add(panel_right_top_bottom, BorderLayout.SOUTH);
//		panel_right_top.add(panel_right_top_left, BorderLayout.WEST);
//		panel_right_top.add(panel_right_top_center, BorderLayout.CENTER);
		
		panel_right_top.setLayout(new GridLayout(2, 2));
		
//		panel_right_top_center.setLayout(new GridLayout(2, 2));
		panel_right_players = new JPanel[4];	
		for(int i = 0;i<4;i++) {
			panel_right_players[i] = new JPanel();
//			panel_right_players[i].setBackground(Color.RED);
//			panel_right_players[i].setBorder(new LineBorder(Color.GRAY));
			panel_right_top.add(panel_right_players[i]);
		}
		
		// 先定义上面左右两个面板的玩家
		player1Labels = new JLabel[10];
		player2Labels = new JLabel[10];
		player3Labels = new JLabel[10];
		player4Labels = new JLabel[10];
		for(int i = 0; i< 10; i++) {
			player1Labels[i] = new JLabel();
			panel_right_players[0].add(player1Labels[i]);
			
			//////////////////////////////////////////////////////////////
			player1Labels[i].setOpaque(true);
//			player1Labels[i].setBackground(Color.WHITE);
			// 定义label的border
//			player1Labels[i].setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		for(int i = 0; i< 10; i++) {
			player2Labels[i] = new JLabel();
			panel_right_players[1].add(player2Labels[i]);
			
			////////////////////////////////////////////////////////////////
			player2Labels[i].setOpaque(true);
//			player2Labels[i].setBackground(Color.WHITE);
			// 定义label的border
//			player2Labels[i].setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		for(int i = 0; i< 10; i++) {
			player3Labels[i] = new JLabel();
			panel_right_players[2].add(player3Labels[i]);
			player3Labels[i].setOpaque(true);
		}
		for(int i = 0; i< 10; i++) {
			player4Labels[i] = new JLabel();
			panel_right_players[3].add(player4Labels[i]);
			player4Labels[i].setOpaque(true);
		}
		
//		button_dice.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int steps = RandomProduce.getRandom(1, 6);
//				num = steps;
//				label_show_dice.setText(""+ steps);
////				move_forward(steps);
//			}
//		});
		
	}
	
	public JPanel[] getPlayersPanels() {
		return panel_right_players;
	}
	
	public JLabel[] getPlayerLabels(int idOfPlayer) {
		if(idOfPlayer == 0) {
			return player1Labels;
		}else if(idOfPlayer == 1) {
			return player2Labels;
		}else if(idOfPlayer == 2) {
			return player3Labels;
		}
		return player4Labels;
	}
	
	
	public List<JLabel> getList(){
		return labelList;
	}
	
	public JFrame getFrame() {
		return frmRichman;
	}

	
	//////////////////////////////////////////
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
	public JPanel getInitPanel(){
		return panel_right_top_top;		//panel_right_top_top
	}
	
	
}




