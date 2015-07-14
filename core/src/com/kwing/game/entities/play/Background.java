package com.kwing.game.entities.play;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.kwing.game.main.Game;

public class Background {

	private final TextureRegion textureRegion;
	private Rectangle textureRegionBounds1;
	private Rectangle textureRegionBounds2;
	private int speed = 100;

	public Background() {
		textureRegion = new TextureRegion(new Texture("Backgrounds/purple.png"));
		textureRegionBounds1 = new Rectangle(0, 0 - Game.V_HEIGHT / 2, Game.V_WIDTH, Game.V_HEIGHT);
		textureRegionBounds2 = new Rectangle(0, Game.V_WIDTH / 2, Game.V_WIDTH, Game.V_HEIGHT);
	}
	
	public void update(float dt) {

		if (leftBoundsReached(dt)) {
			resetBounds();
		} else {
			updateXBounds(-dt);
		}
	}
	
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(textureRegion, textureRegionBounds1.x, textureRegionBounds1.y, Game.V_WIDTH, Game.V_HEIGHT);
		sb.draw(textureRegion, textureRegionBounds2.x, textureRegionBounds2.y, Game.V_WIDTH, Game.V_HEIGHT);
		sb.end();

	}
	
	private boolean leftBoundsReached(float dt) {
		return (textureRegionBounds2.y - (dt * speed)) <= 0;
	}

	private void updateXBounds(float dt) {
		textureRegionBounds1.y += dt * speed;
		textureRegionBounds2.y += dt * speed;
	}

	private void resetBounds() {
		textureRegionBounds1 = textureRegionBounds2;
		textureRegionBounds2 = new Rectangle(0, Game.V_HEIGHT, Game.V_WIDTH, Game.V_HEIGHT);
	}

}
