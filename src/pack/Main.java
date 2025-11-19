package pack;

public class Main {
	public static void main(String[] args) {  
	    Leaderboard board = new Leaderboard(5);  
	  
	    board.addScore("ABC", 10);  
	    board.addScore("DEF", 20);  
	    board.addScore("JKL", 20);  
	    board.addScore("GHI", 10);  
	    board.addScore("MNO", 15);  
	  
	    System.out.println("High Score: " + board.getHighScore());  
	    System.out.println("Average Score: " + board.getAverageScore());  
	    System.out.println("Did a player break 1000 points?: " + board.break1000());  
	  
	    System.out.println("\nLeaderboard: ");  
	    board.printLeaderboard();  
	  
	    System.out.println("\nLeaderboard: ");  
	    board.addScore("PQR", 150);  
	  
	    board.printLeaderboard();  
	  
	}
}
