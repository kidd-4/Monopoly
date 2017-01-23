package player;

import house.House;
import house.Location;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import others.MainT;

/**
 *  ����࣬�л�ȡ���ʲ�����
 * @author Local_win8
 *
 */


public class Player{
	private String playerName;
	
	private int cash;
//	private long totalMoney;
//	private List<House> houseList;
	private Map<Integer, House> houseMap;
	private int points;	// ��ҵ���
	private int state;		// ���״̬��1������2ҽԺ�У�3�����У�4��������
	
//	private int totalTools;		// ���ӵ�еĵ�����,���10��
	private int roadBlock;		// ·�ϵ�����
	private int bomb;			// ը����
	private int robot;			// ��������
	private int location;
	
	private Color color;		// ÿλ�û�ӵ��һ����ɫ
	
	
	
	public Player(String playerName, int cash,int points, Color color) {
//		super();
		this.playerName = playerName;
		this.cash = cash;
//		this.houseList = new ArrayList<House>();
		this.houseMap = new HashMap<Integer, House>();
		this.points = points;
		this.color = color;
		this.state = 1;
		this.roadBlock = 0;
		this.bomb = 3;
		this.robot = 0;
//		this.district = "t";
		this.location = 0;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public long getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	/**
	 * ��ȡ��ҵ��ܽ����еķ��ݳ��ۼ�ֵ�������ֽ�
	 * @return
	 */
	public long getTotalMoney() {
		long totalMoney = cash;
		for(Entry<Integer,House> entry : houseMap.entrySet()) {
			totalMoney += entry.getValue().getHouseMoney() * 2;
		}
		return totalMoney;
	}

	
	///////////////////////////////////////////////
	/*
	 * �������ӷ��ݵؿ�ķ���
	 */
	public void addHouse() {
		House house = new House(playerName, location, state, color);		//  state Ϊ����״̬������rate�½�ʱΪ0
		MainT.allHouseMap.put(location, house);
		houseMap.put(location, house);
		MainT.markLocation.get(location).setIsHouseState("isHouse");
	}
	
	/**
	 * ��������
	 */
	public void updateHouse() {
		
		House house = houseMap.get(location);
		int rate = house.getHouseRate();
		house.setHouseRate(rate+1);
	}
	
	
	
	
	
	
	
	
	/**
	 *  ǰ��, �����û����ӵ���Ŀ��������ǰ����λ��
	 * @return
	 */
	public void moveForward(int step) {
		// ��� ��Ҫ���ߵ�·;���Ƿ���·��
		int checkPos = checkPassway(location, step);
		if(checkPos != 999) {	// ��·��
			step = checkPos-location;
		}
																		
		location+=step;											// "isPlain"�յ�,"isStartPlace"�����,,"isGiftHouse"��Ʒ��
		if(location>=70){										// 	"isHouse"�з�, "isToolHouse" ������,"isMagicHouse"ħ����,
			location -= 70; 									// "empty","isPrison"�м���,"isHospital"��ҽԺ
		}
		
	}
	
	/**
	 *  ����Ƿ���ǰ����
	 */
	public void checkIfbuyLand(){
		Location destLocation = MainT.markLocation.get(location);
		String isHouseState = destLocation.getIsHouseState();
		if(isHouseState.equals("isPlain")) {	// "�˴�Ϊ�յأ��Ƿ���÷�����")
			if(JOptionPane.showConfirmDialog(null,
					"�˴�Ϊ�յأ��Ƿ���÷�����", "���򷿲�", 
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				this.cash -= Location.getLandMoney(location);
			
				// �·�����ִ�к󣬷���Ϊ0�����ص�Ϊ��ǰ����ҵص㣬����״̬Ϊ1����ҵķ���map�Զ����ӵ�ǰ�ķ���
				this.addHouse();
			} else {
				
			}
		} else if(isHouseState.equals("isPrison")) {
			this.state = 3;
		} else {
			
		}
	}
	
	
	/**
	 *  �����Ҫ���ߵ�step·;�У��Ƿ���·�ϣ�����·�ϵ�location
	 * @param location
	 * @param step
	 * @return
	 */
	public int checkPassway(int location, int step) {
		int roadBlockPos = 999;
		for(int key=location+1;key<= location+step;key++) {
			if(MainT.markLocation.get(key).getIsToolState().equals("isRoadBlock")) {
				System.out.println("MainT.markLocation.get(key):" + MainT.markLocation.get(key).getIsToolState());
				roadBlockPos = key;
				break;
			}
		}
		return roadBlockPos;
	}
	
	
	public Map<Integer, House> getHouseMap() {
		return houseMap;
	}
	
	
	
	public int getHouseNum() {
		return houseMap.size();
	}
	
	public int getLocation() {
		return location;
	}
	
	public long getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getTotalTools() {
		return this.robot+this.roadBlock+this.bomb;
	}

	public int getRoadBlock() {
		return roadBlock;
	}
	public void setRoadBlock(int roadBlock) {
		this.roadBlock = roadBlock;
	}
	public int getBomb() {
		return bomb;
	}
	public void setBomb(int bomb) {
		this.bomb = bomb;
	}
	public int getRobot() {
		return robot;
	}
	public void setRobot(int robot) {
		this.robot = robot;
	}
	
	
	/////////////////////////////////////
	// ��ȡ�����б�
	public List<String> getPlayerData() {
		List<String> playerDataList = new ArrayList<String>();
		playerDataList.add(getPlayerName());
		playerDataList.add("" + getState());
		playerDataList.add("天");
		playerDataList.add("" + getTotalMoney());
		playerDataList.add("" + getCash());
		playerDataList.add("" + getPoints());
		playerDataList.add("" + getHouseNum());
		playerDataList.add("" + getRobot());
		playerDataList.add("" + getRoadBlock());
		playerDataList.add("" + getBomb());
		
		return playerDataList;
	}
	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", cash=" + cash
				+ ", houseMap=" + houseMap + ", points=" + points + ", state="
				+ state + ", roadBlock=" + roadBlock + ", boomb=" + bomb
				+ ", robot=" + robot + ", location=" + location + "]";
	}
	
	
}
