package com.eir.commercial.domains;

public class Score {
 private int Score;
 private int isscore;
 
public int getIsscore() {
	return isscore;
}

public void setIsscore(int isscore) {
	this.isscore = isscore;
}

public int getScore() {
	return Score;
}

public void setScore(int score) {
	Score = score;
}

@Override
public String toString() {
	return "Score [Score=" + Score + ", isscore=" + isscore + "]";
}

}
