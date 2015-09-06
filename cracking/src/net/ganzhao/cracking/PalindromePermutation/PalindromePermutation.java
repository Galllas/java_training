package net.ganzhao.cracking.PalindromePermutation;

public class PalindromePermutation {

	public static boolean isPalindromePermutation(String str){
		
		int checker = 0;
		
		for (char c : str.toCharArray()){
			int value = getCharNumber(c);
			if (value < 0) continue;
			else 
			{
				checker ^= 1 << value;
				}
			
		}
		return (checker & (checker -1)) == 0;
	}
	
	public static int getCharNumber(Character c){
		
		int a = 'a';
		int z = 'z';
		int A = 'A';
		int Z = 'Z';
		int val = c;
		
		if ( val >= a && val <= z) return val - a;
		else if ( val >= A && val <= Z) return val-A;
		
		return -1;
	}

	
	public static void main(String[] args) {
		System.out.println(isPalindromePermutation("Tact Coa"));	
	}

}
