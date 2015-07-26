package com.kwing.game.entities;

import com.kwing.game.entities.spaceObject.meteors.Meteor;
import com.kwing.game.entities.spaceObject.player.Player;
import com.kwing.game.entities.spaceObject.powers.PowerUp;
import com.kwing.game.entities.spaceObject.powers.RegenPill;
import com.kwing.game.entities.spaceObject.projectile.Projectile;

public class Collision {

	public static boolean checkPlayerTouchedMeteor(Player player, Meteor meteor){
		boolean statement;
		if(player.getRectangle().overlaps(meteor.getRectangle())){
			statement = true;
		}else
			statement = false;
		return statement;
	}
	
	public static boolean checkProjectileTouchedVisibleMeteor(Projectile projectile, Meteor meteor){
		boolean statement;
		if(projectile.getRectangle().overlaps(meteor.getRectangle()) 
				&&	projectile.isVisible())
			statement = true;
		else
			statement = false;
		return statement;
	}
	
	public static boolean checkPlayerTouchedRegenPill(Player player, RegenPill regenPill) {
		boolean statement;
		if(player.getRectangle().overlaps(regenPill.getRectangle())){
			statement = true;
		}
		else
			statement = false;
		return statement;
	}
	
	public static boolean checkPlayerTouchedPowerUp(Player player, PowerUp powerUp) {
		boolean statement;
		if(player.getRectangle().overlaps(powerUp.getRectangle())){
			statement = true;
		}
		else
			statement = false;
		return statement;
	}
}
