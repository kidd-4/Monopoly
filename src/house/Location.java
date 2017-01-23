package house;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Queue;

public  class Location {
//	protected String district;		// ��������ĵض�
					// ��Ϊ t��(top),b��(bottom),r��(right),l��(left)
	protected int location;		// ���׼ȷ�ĵ�ַ
					// ������+ ���Ӻ����
//	protected String fullLocation;
		// ���ݵص��ȡ����
	
	private String isHouseState;		// "isPlain"�յ�,"isStartPlace"�����,
									// 	"isHouse"�з�, "isToolHouse" ������,"isGiftHouse"��Ʒ��,"isMagicHouse"ħ����,
									// "isPrison"�м���,"isHospital"��ҽԺ
	private String isToolState;			// "isRoadBlock"��·��,"isBomb"��ը��,isForbid ���ܷ���tool���ܷ���tool�ĵص�ֻ����isEmpty״̬
	
	
	private Queue<Color> colorQueue;
	

	public Location() {
		
	}
	
	
	public Location(int location,String state, String state1) {
		this.location = location;
		this.isHouseState = state;
		this.colorQueue = new ArrayDeque<>();
//		this.colorQueue.add(new Color(238,238,238));
		this.isToolState = state1;
	}

	
//	private int districtLandPerMoney;	// ������������ĵؿ鵥�۵���
//	��ǰ�ضεĵ�λ�ؼ�
//	public int getPerMoney() {
//		if(district.equals("t"))  {
//			return 200;
//		}else if(district.equals("r")){
//			return 500;
//		}else 
//			return 500;
//	}
	
	
	public static int getLandMoney(int location) {
	
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
	
	
	
	public char getDistrict() {
		if(location>0 && location<28 && location!=14) {
			return 't';
		} else if(location>=29 && location<=34) {
			return 'r';
		} else if(location>35 && location<63) {
			return 'b';
		} else{
//			throw new RuntimeException("������Ϊ��ػ������������õأ�û�з����ۣ�");
			return 'N';
		}
	}
		

//	public void setDistrict(String district) {
//		this.district = district;
//	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	
	public String getIsHouseState() {
		return isHouseState;
	}

	public void setIsHouseState(String isHouseState) {
		this.isHouseState = isHouseState;
	}

	public String getIsToolState() {
		return isToolState;
	}

	public void setIsToolState(String isToolState) {
		this.isToolState = isToolState;
	}


	public Queue<Color> getColorQueue() {
		return colorQueue;
	}


	public void setColorQueue(Queue<Color> colorQueue) {
		this.colorQueue = colorQueue;
	}




	
	
	
	
}
 