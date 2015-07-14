package com.kwing.game.entities.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.kwing.game.main.Game;

public class Menu {

	private boolean leftPressed;
	private boolean state;

	private Texture startTexture;

	private Rectangle startButton;

	private Vector3 touchPos;

	private OrthographicCamera cam;

	public Menu(OrthographicCamera cam) {

		this.cam = cam;
		state = false;
		
		touchPos = new Vector3();

		startTexture = new Texture(Gdx.files.internal("button.png"));
		startButton = new Rectangle();

		// Centering image (Game.V_HEIGHT / 2 * Game.SCALE +- half of its
		// width/height
		startButton.width = 200;
		startButton.height = 52;
		startButton.x = Game.V_WIDTH / 2 - startButton.width / 2;
		startButton.y = Game.V_HEIGHT / 2 - startButton.height / 2;

	}

	public void update(float dt) {

		if (Gdx.input.isTouched()) {
			

			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			cam.unproject(touchPos);
			System.out.println(startButton.y);
			System.out.println(touchPos.x + " " + touchPos.y);

			if (touchPos.x > startButton.x
					&& touchPos.x < (startButton.x + startButton.width)
					&& touchPos.y > (startButton.y)
					&& touchPos.y < (startButton.y + startButton.height)) {
				state = true;
			}
//			if (touchPos.x > startButton.x
//					&& touchPos.x < (startButton.x + startButton.width)
//					&& touchPos.y > (startButton.y)
//					&& touchPos.y < (startButton.y + startButton.height)) {
//				&& touchPos.y > (startButton.y - startButton.height)
//				state = true;
//				System.out.println("ship2");
//			}

		}
	}

	public void render(SpriteBatch sb) {

		sb.begin();
		sb.draw(startTexture, startButton.x, startButton.y, startButton.width,
				startButton.height);
		sb.end();

	}

	public void setLeftPressed(boolean b) {
		leftPressed = b;
	}
	public boolean getState(){
		return state;
	}
	public void setState(boolean b){
		state = b;
	}
}
