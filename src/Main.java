import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static String[] layout = {"-", "", "abc","def","ghi","jkl","mno", "pqrs","tuv","wxyz"};
	static HashMap<Character, KeyPress> keyboard = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buildKeyboard();
		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		
		while (!word.equals("halt")) {
			int t = getInputTime(word);
			System.out.println(t);
			word = sc.nextLine();
		}
	}

	private static void buildKeyboard() {
		// TODO Auto-generated method stub
		for (int i=0;i<layout.length;i++) {
			String s = layout[i];
			for (int j=0;j<s.length();j++) {
				KeyPress keyPress = new KeyPress(i, j);
				keyboard.put(s.charAt(j), keyPress);
			}
		}
	}

	private static int getInputTime(String word) {
		// TODO Auto-generated method stub
		int t = 0;
		int lastKey = -1;
		for (int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			KeyPress keyPress = keyboard.get(c);
			
			t+=keyPress.pos+1;
			if (keyPress.key == lastKey)
				t+=2;
			lastKey = keyPress.key;
		}
		return t;
	}

}

class KeyPress {
	int key;
	int pos;
	
	public KeyPress(int key, int pos) {
		this.key = key;
		this.pos = pos;
	}
}
