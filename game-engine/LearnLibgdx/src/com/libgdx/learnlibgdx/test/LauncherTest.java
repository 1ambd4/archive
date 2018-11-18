package com.libgdx.learnlibgdx.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class LauncherTest {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		float scale = 0.6F;
		
		config.width = (int)(GameTest.WORLD_WIDTH * scale);
		config.height = (int)(GameTest.WORLD_HEIGHT * scale);
		
		config.resizable = false;
		
		new LwjglApplication(new GameTest(), config);
	}
}
