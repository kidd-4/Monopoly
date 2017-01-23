package house;

import java.awt.Color;

/**
 *  House���� ��  ���ݵȼ����ԣ��̳��˵ص����    ������ص� ���ԣ��Լ������ ��ȡ���ص��۷�����
 * @author Local_win8
 *
 */

public class House{
	private int houseRate;		// ���ݵȼ�
	private String houseOwner;		// ������������
	private int houseOwnerState;	// ����״̬
	private int location;
	private Color houseColor;
	
	public House(String owner, int houseRate, String district, int location) {
		super();
		this.houseOwner = owner;
		this.houseRate = houseRate;
//		super.district = district;
		this.location = location;
	}
	
	public House(){
		
	}
	
//	public House(String  owner, String fullLocation) {
	public House(String  owner, int location, int state, Color color) {
		this.houseRate = 0 ;
		this.houseOwner = owner;
		this.location = location;
		this.houseOwnerState = state;
		this.houseColor = Color.ORANGE;
//		this.fullLocation = fullLocation;
	}
	
	
	
	public int getLocation(){
		return location;
	}
	
	///////////////////////////////////////////////////
	// ���ݵ�ǰ��ַ����ȡ����
	public char getDistrict() {
		if(location>0 && location<29) {
			return 't';
		} else if(location>29 && location<36) {
			return 'r';
		} else if(location> 36 && location<66) {
			return 'b';
		} else {
			throw new RuntimeException("������Ϊ��ػ������������õأ�û�з����ۣ�");
		}
	}
	// ���ݵ�ǰ��ַ����ȡ ��ǰ �ؼ�
	public int getPerMoney() {
		if(location>0 && location<28) {
			return 200;
		} else if(location>=29 && location<=34) {
			return 500;
		} else if(location>=36 && location<63) {
			return 300;
		} else {
			throw new RuntimeException("������Ϊ��ػ������������õأ�û�з����ۣ�");
		}
	}
	
	///////////////////////////////////////////////////
	
	public int getHouseOwnerState() {
		return houseOwnerState;
	}

	public void setHouseOwnerState(int houseOwnerState) {
		this.houseOwnerState = houseOwnerState;
	}

	public String getHouseOwner() {
		return houseOwner;
	}

	public void setHouseOwner(String houseOwner) {
		this.houseOwner = houseOwner;
	}

	// ��ȡ��ǰ���ݵļ۸�
	public int getHouseMoney(){
		return getPerMoney() * (houseRate+1);
	}
	
	// ��ǰ���ݵ�Ӧ��ȡ�Ĺ�·��
	public int getPassByCost() {
		return getHouseMoney()/2;
	}

	// ���ݵĵȼ�
	public int getHouseRate() {
		return houseRate;
	}

	public void setHouseRate(int houseRate) {
		this.houseRate = houseRate;
	}

	public Color getHouseColor() {
		return houseColor;
	}

	public void setHouseColor(Color houseColor) {
		this.houseColor = houseColor;
	}

	public void setLocation(int location) {
		this.location = location;
	}
	
	
	
}
