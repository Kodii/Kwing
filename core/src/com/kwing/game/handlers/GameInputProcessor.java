package com.kwing.game.handlers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class GameInputProcessor implements InputProcessor {

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.LEFT)
			GameKeys.setKey(GameKeys.LEFT, true);
		if (keycode == Keys.RIGHT)
			GameKeys.setKey(GameKeys.RIGHT, true);
		if (keycode == Keys.SPACE)
			GameKeys.setKey(GameKeys.SPACE, true);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT)
			GameKeys.setKey(GameKeys.LEFT, false);
		if (keycode == Keys.RIGHT)
			GameKeys.setKey(GameKeys.RIGHT, false);
		if (keycode == Keys.SPACE)
			GameKeys.setKey(GameKeys.SPACE, false);
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}


}
