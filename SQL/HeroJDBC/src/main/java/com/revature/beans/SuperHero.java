package com.revature.beans;

public class SuperHero {
	private int heroID;
	private String heroName;
	public SuperHero() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuperHero(int heroID, String heroName) {
		super();
		this.heroID = heroID;
		this.heroName = heroName;
	}
	public int getHeroID() {
		return heroID;
	}
	public void setHeroID(int heroID) {
		this.heroID = heroID;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	@Override
	public String toString() {
		return "SuperHero [heroID=" + heroID + ", heroName=" + heroName + "]";
	}
	
}