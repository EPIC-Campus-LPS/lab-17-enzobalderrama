package pack;
import java.util.ArrayList;
import java.util.Scanner;

public class Chat {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<>();
		System.out.print("Enter a sentence: ");
		String sent = scan.nextLine();
		while (!(sent.equals("STOP"))) {
			String[] senten = sent.split(" ");
			for (int i = 0; i < senten.length; i++) {
				words.add(senten[i]);
			}
			System.out.print("Enter a sentence: ");
			sent = scan.nextLine();
		}
		
		int total = 0;
		int unique = 0;
		ArrayList<String> uniqu = new ArrayList<>();
		int the = 0;
		boolean lower = true;
		String longest = words.get(0);
		for (int i = 0; i < words.size(); i++) {
			total++;
			if (!(words.get(i).toLowerCase().equals(words.get(i)))) {
				lower = false;
			}
			words.set(i, words.get(i).toLowerCase());
			if (words.get(i).equals("the")){
				the++;
			}
			if (words.get(i).length() > longest.length()) {
				longest = words.get(i);
			}
			boolean uni = true;
			for (int j = 0; j < i; j++) {
				if (words.get(j).equals(words.get(i))){
					uni = false;
				}
			}
			if (uni == true) {
				unique++;
				uniqu.add(words.get(i));
			}
		}
		
		System.out.println("Chat Report:");
		System.out.println("You used " + total + " words.");
		System.out.println("You used " + unique + " unique words.");
		System.out.println("You used \"the\" " + the + " times.");
		System.out.println("\"" + longest + "\" was the longest word.");
		System.out.println("Are all words lowercase? " + lower);
		System.out.println("\nCondensed Chat History");
		for (int i = 0; i < uniqu.size(); i++) {
			System.out.println(uniqu.get(i));
		}
		
	}
}
