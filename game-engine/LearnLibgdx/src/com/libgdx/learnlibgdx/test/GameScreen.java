package com.libgdx.learnlibgdx.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameScreen extends ScreenAdapter {
	
	private Texture manTexture;
	
	private Stage stage;
	
	private MyActor manActor;
	
	public GameScreen() {
		// 创建纹理
		manTexture = new Texture(Gdx.files.internal("lttzz.jpg"));
		
		// 使用伸展视口创建舞台
		stage = new Stage(new StretchViewport(GameTest.WORLD_WIDTH, GameTest.WORLD_HEIGHT));
		
		// 创建演员
		manActor = new MyActor(new TextureRegion(manTexture));
		
		// 添加演员到舞台上去
		stage.addActor(manActor);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		if (stage != null) {
			stage.dispose();
		}
		if (manTexture != null) {
			manTexture.dispose();
		}
	}
}
