package com.kwing.game.desktop;

import org.lwjgl.opengl.Display;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kwing.game.main.Game;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Kwing";
		config.width = 800;
		config.height = 1280;
		config.resizable = false;
		config.y = 10;
		new LwjglApplication(new Game(), config);
		
	}
}
