package com.libgdx.learnlibgdx.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class StartScreen implements Screen {

	// 为了方便交互, 将MainGame 作为参数传进来
	private GameTest gameTest;
	
	private Texture logoTexture;
	
	private Stage stage;
	
	private MyActor logoActor;
	
	// 场景渲染时间累计变量(当前场景被展示的时间总和)
	private float deltaSum;
	
	public StartScreen(GameTest gameTest) {
		this.gameTest = gameTest;
		
		// 创建纹理(图片尺寸300 * 50)
		logoTexture = new Texture(Gdx.files.internal("libgdx.jpg"));
		
		// 使用伸展视口创建舞台
		stage = new Stage(new StretchViewport(GameTest.WORLD_WIDTH, GameTest.WORLD_HEIGHT));
		
		logoActor = new MyActor(new TextureRegion(logoTexture));
		
		// 把演员设置在舞台中间
		logoActor.setPosition(stage.getWidth() / 2 - logoActor.getWidth() / 2, stage.getHeight() / 2 - logoActor.getHeight() / 2);
		
		stage.addActor(logoActor);
	}
	
	@Override
	public void show() {
		deltaSum = 0;
	}
	
	@Override
	public void render(float delta) {
		deltaSum += delta;
		
		if (deltaSum > 2F) {
			// 场景展示超过 3秒,启动主界面
			if (gameTest != null) {
				gameTest.showGameScreen();
				return ;
			}
		}
		
		Gdx.gl.glClearColor(0.75F, 1, 0.98F, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// 更新舞台逻辑
		stage.act();
		// 绘制舞台
		stage.draw();
	}
	
	@Override
	public void resize(int width, int height) {
		
	}
	
	@Override
	public void pause() {
		
	}
	
	@Override
	public void resume() {
		
	}
	
	@Override
	public void hide() {
		
	}
	
	@Override
	public void dispose() {
		if (stage != null) {
			stage.dispose();
		}
		if (logoTexture != null) {
			logoTexture.dispose();
		}
	}
}
