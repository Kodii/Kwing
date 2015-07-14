package com.kwing.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.kwing.game.main.Game;

public class Ship extends SpaceObject{
	
	//need this variable for send an object ship with choosen ship number to PlayState.
	
	private boolean state;
	private Vector3 touchPos;
	
	private OrthographicCamera cam;
	
	public Ship(String s, int width, int height, int x, int y, OrthographicCamera cam){
		super(s, width, height, x, y);
		initObject();
		this.cam = cam;
		state = false;
		touchPos = new Vector3();
		
//		shipTexture1 = new Texture(Gdx.files.internal("PNG/playerShip1_blue.png"));
//		shipRectangle1 = new Rectangle();
//		shipRectangle1.width = 99;
//		shipRectangle1.height = 75;
//		shipRectangle1.x = 150;
//		shipRectangle1.y = (Game.V_HEIGHT / 2 - 30) - shipRectangle1.height / 2;
		
//		shipTexture2 = new Texture(Gdx.files.internal("PNG/playerShip2_blue.png"));
//		shipRectangle2 = new Rectangle();
//		shipRectangle2.width = 99;
//		shipRectangle2.height = 75;
//		shipRectangle2.x = Game.V_WIDTH / 2 - shipRectangle2.width / 2;
//		shipRectangle2.y = (Game.V_HEIGHT / 2 - 30) - shipRectangle2.height / 2;
//		
//		shipTexture3 = new Texture(Gdx.files.internal("PNG/playerShip3_blue.png"));
//		shipRectangle3 = new Rectangle();
//		shipRectangle3.width = 99;
//		shipRectangle3.height = 75;
//		shipRectangle3.x = Game.V_WIDTH  - shipRectangle1.x - shipRectangle3.width;
//		shipRectangle3.y = (Game.V_HEIGHT / 2 - 30) - shipRectangle3.height / 2;
	}
	
	public void update(float dt){
		if (Gdx.input.isTouched()) {

			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			cam.unproject(touchPos);
			
			if (touchPos.x > rectangle.x
					&& touchPos.x < (rectangle.x + rectangle.width)
					&& touchPos.y > rectangle.y
					&& touchPos.y < (rectangle.y + rectangle.height)) {
				state = true;
			}
		}
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		sb.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		sb.end();
	}
	
	public boolean getState(){
		return state;
	}
	
	public void setState(boolean b){
		state = b;
	}



}
