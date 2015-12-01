package com.prefect.gameworld;

public class Player {
	
	private int life, score, level, words;
	private String name;
	private boolean checkedScore;

	public Player(String s) {
		life = 1000;
		words = 0;
		score = 0;
		level = 1;
		name = s;
		checkedScore = false;
	}

	public void scored(int amt) {
		score += amt;
	}

	public void reset() {
		life = 100;
		words = 0;
		score = 0;
		level = 1;
		checkedScore = false;
	}

	public void damaged(int amt) {
		life -= amt;
	}

	public String getName() {
		return name;
	}

	public int getLife() {
		return life;
	}

	public int getScore() {
		return score;
	}

	public int getLevel() {
		return level;
	}
	
	
	public void giveLife(int amt) {
		if (life <= 145) {
		    life += amt;
		}
	}


	public void levelUp() {
		level += 1;
		words = 0; 
	}

	public int getWords() {
		return words;
	}

	public void incWords() {
		words++;
	}

	public void checkScore() {
		checkedScore = true;
	}

	public boolean hasCheckedScore() {
		return checkedScore;
	}


}
