package pack;

import java.util.ArrayList;

public class Leaderboard {
	private int capacity;
	private ArrayList<Score> scoreboard;
	public Leaderboard(int capacit) {
		capacity = capacit;
		ArrayList<Score> scoreboard = new ArrayList<>(capacity);
	}
	public void addScore(String name, int score) {
		if (scoreboard.size()+1 > capacity) {
			return;
		}
		Score s = new Score(name, score);
		for (int i = 0; i < scoreboard.size(); i++) {
			if (score > scoreboard.get(i).getScore()){
				scoreboard.add(i, s);
			}
		}
	}
	public int getHighScore() {
		int highest = scoreboard.get(0).getScore();
		for (int i = 1; i < scoreboard.size(); i++) {
			if (highest < scoreboard.get(i).getScore()) {
				highest = scoreboard.get(i).getScore();
			}
		}
		return highest;
	}
	public int getAverageScore() {
		int average = 0;
		int count = 0;
		for (int i = 0; i < scoreboard.size(); i++) {
			average += scoreboard.get(i).getScore();
			count++;
		}
		return average/count;
	}
	public boolean break1000() {
		for (int i = 0; i < scoreboard.size(); i++) {
			if (scoreboard.get(i).getScore() >= 1000) {
				return true;
			}
		}
		return false;
	}
	public void printLeaderboard() {
		System.out.println("Leaderboard: ");
		for (int i = 0; i < scoreboard.size(); i++) {
			System.out.println(scoreboard.get(i).getName() + ": " + scoreboard.get(i).getScore());
		}
	}
}
