package com.libgdx.learnlibgdx.action;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		float scale = 0.6F;
		
		config.width = (int)(MainGame.WORLD_WIDTH * scale);
		config.height = (int)(MainGame.WORLD_HEIGHT * scale);
		
		config.resizable = false;
		
		new LwjglApplication(new MainGame(), config);
	}

}
