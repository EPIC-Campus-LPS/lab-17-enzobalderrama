package pack;

import java.util.ArrayList;

public class Leaderboard {
	private int capacity;
	private ArrayList<Score> scoreboard;
	public Leaderboard(int capacit) {
		capacity = capacit;
		scoreboard = new ArrayList<>(capacity);
	}
	public void addScore(String name, int score) {
		Score s = new Score(name, score);
		scoreboard.add(s);
		if (scoreboard.size()+1 > capacity) {
			scoreboard.remove(s);
		}
		for (int i = 0; i < scoreboard.size(); i++) {
            for (int j = 0; j < scoreboard.size() - 1 - i; j++) {
                if (scoreboard.get(j).getScore() > scoreboard.get(j + 1).getScore()) {
                    int tempvar = j;
                    Score tempscore = scoreboard.get(tempvar);
                    scoreboard.set(j, scoreboard.get(j + 1));
                    scoreboard.set(j + 1, tempscore);
                }
            }
        }
	}
	public int getHighScore() {
		int highest = scoreboard.get(0).getScore();
		for (int i = 1; i < scoreboard.size(); i++) {
			if (highest <= scoreboard.get(i).getScore()) {
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
		System.out.println(scoreboard.toString());
	}
}
