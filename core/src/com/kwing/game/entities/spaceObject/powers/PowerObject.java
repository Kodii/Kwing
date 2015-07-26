package com.kwing.game.entities.spaceObject.powers;

import com.kwing.game.entities.spaceObject.SpaceObject;

public abstract class PowerObject extends SpaceObject {
	
	protected int power;
	protected boolean visible;
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
