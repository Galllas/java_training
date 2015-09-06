package net.ganzhao.cracking.OneWay;

public class OneWay {

	public static boolean isOneWay(String s1, String s2){
		
		if ( s1.length() < s2.length()) return isOneWay(s2, s1);
		
		int index1 = 0;
		int index2 = 0;
		int count = 0;
		
		while (index1 < s1.length() && index2 < s2.length()){
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (count == 1) return false;
				count = 1;
				if ( s1.length() != s2.length()){
				index1 ++;
				}		
				else{
					index1 ++;
					index2 ++;
				}
			}
			else
			{
				index1 ++;
				index2 ++;
			}	
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isOneWay("act", "Tact"));

	}

}
