package com.rev.model;

public class AnimalSound {
	private String sound;
	private double decibal;

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public double getDecibal() {
		return decibal;
	}

	public void setDecibal(double decibal) {
		this.decibal = decibal;
	}

	@Override
	public String toString() {
		return "AnimalSound [sound=" + sound + ", decibal=" + decibal + "]";
	}

	public AnimalSound(String sound, double decibal) {
		super();
		this.sound = sound;
		this.decibal = decibal;
	}

	public AnimalSound() {
		super();
		// TODO Auto-generated constructor stub
	}

}
