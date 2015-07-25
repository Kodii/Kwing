package com.kwing.game.entities.score;

public class Score {

	private String id;
	private String name;
	private String score;
	
	public Score(String id, String name, String score){
		this.id = id;
		this.name = name;
		this.score = score;
	}
	
	public void print(){
		System.out.println("\tID: " + id + "\tNAME: " + name + "\tSCORE: " + score + "\n");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	
}
