package com.kwing.game.entities.spaceObject.powers;

import com.kwing.game.entities.spaceObject.SpaceObject;

public abstract class PowerObject extends SpaceObject {
	
	protected int power;

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
