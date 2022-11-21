import java.util.Scanner;

public class Main {
	static String[] keyboard = {"-", "", "abc","def","ghi","jkl","mno", "pqrs","tuv","wxyz"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		
		while (!word.equals("halt")) {
			int t = getInputTime(word);
			System.out.println(t);
			word = sc.nextLine();
		}
	}

	private static int getInputTime(String word) {
		// TODO Auto-generated method stub
		int t = 0;
		int lastKey = -1;
		for (int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			int key = getKey(c);
			String keyString = keyboard[key];
			int cPosition = keyString.indexOf(c);
			t+=cPosition+1;
			if (key == lastKey)
				t+=2;
			lastKey = key;
		}
		return t;
	}

	private static int getKey(char c) {
		// TODO Auto-generated method stub
		for (int i=0;i<keyboard.length;i++) {
			String s=keyboard[i];
			if (s.indexOf(c)>=0) {
				return i;
			}
		}
		return -2;
	}

}
