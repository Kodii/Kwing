package com.kwing.game.entities.backgrounds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.kwing.game.main.Game;

public class MenuBackground {

	private final TextureRegion textureRegion;
	private Rectangle textureRegionBounds1;
	private Rectangle textureRegionBounds2;
	private int speed = 100;

	public MenuBackground() {
		textureRegion = new TextureRegion(new Texture("Backgrounds/purple.png"));
		textureRegionBounds1 = new Rectangle(0 - Game.V_WIDTH / 2, 0,
				Game.V_WIDTH, Game.V_HEIGHT);
		textureRegionBounds2 = new Rectangle(Game.V_WIDTH / 2, 0, Game.V_WIDTH,
				Game.V_HEIGHT);
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
		sb.draw(textureRegion, textureRegionBounds1.x, textureRegionBounds1.y,
				Game.V_WIDTH, Game.V_HEIGHT);
		sb.draw(textureRegion, textureRegionBounds2.x, textureRegionBounds2.y,
				Game.V_WIDTH, Game.V_HEIGHT);
		sb.end();

	}

	private boolean leftBoundsReached(float dt) {
		return (textureRegionBounds2.x - (dt * speed)) <= 0;
	}

	private void updateXBounds(float dt) {
		textureRegionBounds1.x += dt * speed;
		textureRegionBounds2.x += dt * speed;
	}

	private void resetBounds() {
		textureRegionBounds1 = textureRegionBounds2;
		textureRegionBounds2 = new Rectangle(Game.V_WIDTH, 0,
				Game.V_WIDTH, Game.V_HEIGHT);
	}

}
