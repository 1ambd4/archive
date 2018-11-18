package com.libgdx.learnlibgdx.test;

import com.badlogic.gdx.Game;

public class GameTest extends Game{
	public static final float WORLD_WIDTH = 720;
	public static final float WORLD_HEIGHT = 1080;
	
	private StartScreen startScreen;
	
	private GameScreen gameScreen;
	
	@Override
	public void create() {
		// 创建场景
		startScreen = new StartScreen(this);
		// 创建主场景
		gameScreen = new GameScreen();
		// 设置当前长江为开始场景
		setScreen(startScreen);
	}
	
	public void showGameScreen() {
		// 设置当前场景为主场景
		setScreen(gameScreen);
		
		if (startScreen != null) {
			// 由于 startScreen 只有在游戏启动的时候展示一下,之后都不在需要了
			// 所以在启动完 GameScreen 后手动调用 dispose() 方法销毁场景
			startScreen.dispose();
			
			// 场景销毁后,场景变量置空,防止二次误调用 dispose() 方法
			startScreen = null;
		}
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		if (startScreen != null) {
			startScreen.dispose();
			startScreen = null;
		}
		if (gameScreen != null) {
			gameScreen.dispose();
			gameScreen = null;
		}
	}
}
