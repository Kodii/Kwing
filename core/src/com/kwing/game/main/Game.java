package com.kwing.game.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kwing.game.handlers.GameInputProcessor;
import com.kwing.game.handlers.GameStateManager;

public class Game implements ApplicationListener {
	
	public static int V_WIDTH;;
	public static int V_HEIGHT;
	
	private SpriteBatch sb;
	private OrthographicCamera cam;
	
	private GameStateManager gsm;
	
	
	@Override
	public void create () {
		
		sb = new SpriteBatch();
		
		V_WIDTH = Gdx.graphics.getWidth();
		V_HEIGHT = Gdx.graphics.getHeight();
		
		cam = new OrthographicCamera(V_WIDTH, V_HEIGHT);
		cam.translate(V_WIDTH / 2, V_HEIGHT / 2);
		cam.update();
		
		gsm = new GameStateManager(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render();
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public SpriteBatch getSpriteBatch(){
		return sb;
	}
	
	public OrthographicCamera getCamera(){
		return cam;
	}
}
