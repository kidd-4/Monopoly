package others;

import house.House;
import house.Location;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainT {
	
	public static String[] Names = {"�𱴱�","������","��С��","Ǯ����"};
	public static String defaultChar = "SHTGPM$";
	
//	public static String defaultUnInt = ""
	
//	public String[] 
		// ���ݵ�ַ�����з��ݶ�����map����ȡ��
	public static Map<Integer, House> allHouseMap = new HashMap<>();
	
	public static Map<Integer, Location> markLocation = new HashMap<>();
	
	public static Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.GRAY};
	
	
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if(isNum.matches()) {
			return true;
		}
		return false;
	}
	
//	public static void main(String[] args) {
//		System.out.println(isNumeric("agdb132"));
//	}
	
}
