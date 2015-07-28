package com.kwing.game.entities.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.kwing.game.entities.Resources;
import com.kwing.game.handlers.GameStateManager;
import com.kwing.game.main.Game;

public class Menu {
	
	private static final int TITLE_WIDTH = Game.V_WIDTH / 2;
	private static final int TITLE_HEIGHT = 87;

	private Texture titleTexture;
	private Rectangle titleRectangle;
	
	private Texture startTexture;
	private Rectangle startRectangle;
	
	private Texture scoreTexture;
	private Rectangle scoreRectangle;
	
	private Texture authorTexture;
	private Rectangle authorRectangle;
	
	private Vector3 touchPos;
	private OrthographicCamera cam;
	
	private int state;
	private int delay = 0;
	
	public Menu(OrthographicCamera cam) {

		this.cam = cam;
		state = -1;
		
		touchPos = new Vector3();
		
		titleTexture = Resources.Textures.getTitle();
		titleRectangle = new Rectangle();
		titleRectangle.width = TITLE_WIDTH;
		titleRectangle.height = TITLE_HEIGHT;
		titleRectangle.x = Game.V_WIDTH / 2 - titleRectangle.width / 2;
		titleRectangle.y = Game.V_HEIGHT - titleRectangle.height * 4;
		
		startTexture = Resources.Textures.getStartButton();
		startRectangle = new Rectangle();
		startRectangle.width = 200;
		startRectangle.height = 78;
		startRectangle.x = Game.V_WIDTH / 2 - startRectangle.width / 2;
		startRectangle.y = Game.V_HEIGHT / 2 - startRectangle.height / 2;
		
		scoreTexture = Resources.Textures.getScoreButton();
		scoreRectangle = new Rectangle();
		scoreRectangle.width = 200;
		scoreRectangle.height = 78;
		scoreRectangle.x = Game.V_WIDTH / 2 - startRectangle.width / 2;
		scoreRectangle.y = startRectangle.y - scoreRectangle.height - 20;

		authorTexture = Resources.Textures.getAuthorButton();
		authorRectangle = new Rectangle();
		authorRectangle.width = 200;
		authorRectangle.height = 78;
		authorRectangle.x = Game.V_WIDTH / 2 - startRectangle.width / 2;
		authorRectangle.y = scoreRectangle.y - authorRectangle.height - 20;
	}

	public void update(float dt) {

		if (Gdx.input.isTouched()) {
			

			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			cam.unproject(touchPos);

			if (touchPos.x > startRectangle.x
					&& touchPos.x < (startRectangle.x + startRectangle.width)
					&& touchPos.y > (startRectangle.y)
					&& touchPos.y < (startRectangle.y + startRectangle.height)) {
				state = GameStateManager.CHOSESTATE;
			}
			
			if (touchPos.x > scoreRectangle.x
					&& touchPos.x < (scoreRectangle.x + scoreRectangle.width)
					&& touchPos.y > (scoreRectangle.y)
					&& touchPos.y < (scoreRectangle.y + scoreRectangle.height)) {
				state = GameStateManager.SCORESTATE;
			}
			
			delay++;
			if(delay > 2){
				if (touchPos.x > authorRectangle.x
						&& touchPos.x < (authorRectangle.x + authorRectangle.width)
						&& touchPos.y > (authorRectangle.y)
						&& touchPos.y < (authorRectangle.y + authorRectangle.height)) {
					Gdx.net.openURI("https://www.facebook.com/xKodi");
					delay = 0;
				}
			}
		}
	}

	public void render(SpriteBatch sb) {

		sb.begin();
		sb.draw(titleTexture, titleRectangle.x, titleRectangle.y, titleRectangle.width
				, titleRectangle.height);
		sb.draw(startTexture, startRectangle.x, startRectangle.y, startRectangle.width,
				startRectangle.height);
		sb.draw(scoreTexture, scoreRectangle.x, scoreRectangle.y, scoreRectangle.width,
				scoreRectangle.height);
		sb.draw(authorTexture, authorRectangle.x, authorRectangle.y, authorRectangle.width,
				authorRectangle.height);
		
		sb.end();

	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
