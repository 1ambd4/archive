package com.libgdx.learnlibgdx.test;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainGame implements ApplicationListener{
	
	// 纹理画布
	private SpriteBatch batch;
	// 纹理
	private Texture texture;
	
	private Pixmap pixmap;
	
	private TextureRegion region;
	
	// 精灵
	private Sprite sprite;
	
	private MyActor actor;
	
	private Stage stage;
	
	private Group group;
	
	private MyActor actor1;
	
	private MyActor actor2;
	
	// 当应用被创建时调用一次。
	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.debug(MainGame.class.getSimpleName(), "create()");
		
		batch = new SpriteBatch();
		// 使用 assets 目录下的资源创建纹理
		// 文件路径是相对于 assets 根目录的
		texture = new Texture("lttzz.jpg");
		// texture = new Texture(Gdx.files.internal("lttzz.jpg"));
		
		pixmap = new Pixmap(256, 256,Pixmap.Format.RGBA8888);
		
		// 白色填充
		pixmap.setColor(1, 1, 1, 1);
		pixmap.fill();
		
		// 绘制红色的圆
		pixmap.setColor(1, 0, 0, 1);
		pixmap.drawCircle(64, 64, 32);
		
		// 绿色线段,(0,0)~(256,128)
		pixmap.setColor(Color.GREEN);
		pixmap.drawLine(0, 0, 256, 128);
		
		pixmap.setColor(Color.BLUE);
		pixmap.drawRectangle(128, 128, 64, 64);
		
		// 黄色填充一个三角形,三点(0,256),(0,128),(128,128)
		pixmap.setColor(Color.YELLOW);
		pixmap.fillTriangle(0, 256, 0, 128, 128, 128);
		
		// pixmap 处理完成后转换成纹理
		texture = new Texture(pixmap);
		pixmap.dispose();
		
		// 创建纹理区域, region 表示在 texture 中坐标(0,0)为起点,宽高均为128的矩形区域
		texture = new Texture("lttzz.jpg");
		region = new TextureRegion(texture, 0, 0, 128, 128);
		
		sprite = new Sprite(texture);
		sprite.setPosition(128, 320);
		sprite.setOrigin(0, 0);
		sprite.setRotation(15.0F);
		sprite.setScale(0.5F, 0.5F);
		sprite.flip(true, false);
		
		Gdx.app.debug(MainGame.class.getSimpleName(), "" + texture.getWidth() + "; " + texture.getHeight());
		
		FileHandle[] files = Gdx.files.local("..").list();
		for (FileHandle file : files) {
			System.out.println(file);
		}
		
		// 文件路径是相对于项目根目录的
		{
			FileHandle file = Gdx.files.local("test.txt");
			file.writeString("libgdx is so funny.", false);
		}
		{
			FileHandle file = Gdx.files.internal("test.txt");
			System.out.println(file.readString());
		}
		
		batch = new SpriteBatch();
		
		texture = new Texture("lttzz.jpg");
		
		// 创建演员
		actor = new MyActor(new TextureRegion(texture));
		
		// 设置演员的坐标
		actor.setPosition(100, 250);
		
		// 设置演员旋转个缩放支点, 也就是演员左下角的坐标
		actor.setOrigin(0, 0);
		
		// 设置演员缩放比
		actor.setScale(0.5F, 1.0F);
		
		// 顺时针旋转 5 度, 逆时针为正方向
		actor.setRotation(-5);
		
		stage = new Stage();
		
		stage.addActor(actor);
		
		// 这侧输入处理器,将输入的处理设置给舞台,这样舞台才能接收到输入事件,分发给相应的演员或自己相应
		Gdx.input.setInputProcessor(stage);
		
		// 给舞台添加监听器
		stage.addListener(new MyInputListener());
		
		// 给演员添加监听器
		actor.addListener(new MyClickListener());
		
		// 创建演员组
		group = new Group();
		
		// 演员组添加到舞台(演员组其实可以理解为就是封装后的演员数组)
		stage.addActor(group);
		
		// 创建演员
		actor1 = new MyActor(new TextureRegion(texture));
		actor1.setScale(0.5F);
		actor1.setPosition(100, 100);
		
		actor2 = new MyActor(new TextureRegion(texture));
		actor2.setScale(0.25F);
		actor2.setPosition(100, 100);
		actor2.setRotation(45);		// 演员逆时针旋转 45 度
		
		
		// 把演员添加到演员组, 后添加的后绘制,也可以通过设置 ZIndex 属性手动设置绘制顺序,值越大越后绘制
		group.addActor(actor1);
		group.addActor(actor2);
		
		// ZIndex 就是演员在演员组中的索引位置
		// 当使用 setZIndex 改变其中某个的索引时,实际就是把数组中的演员移动到指定的索引位置,可能会导致其他演员的索引值跟着改变
		// 始终保证索引值 ZIndex 是从零开始的连续自然数
		// ZIndex 需要在演员添加到演员组之后再进行设置,否则无效
		actor1.setZIndex(5);
		// 此时 actor1 索引值是 1, actor2 的索引值是0
		
		Gdx.app.log(MyActor.class.getName(), "actor1: " + actor1.getZIndex() + ", actor2:" + actor2.getZIndex());
		
		// 视口是用来解决不同屏幕分辨率,长宽比不同的问题的 
		// 视口负责管理游戏相机并处理世界(代码/逻辑中所认为的内容显示边界)坐标与实际屏幕坐标之间的一种映射关系
		Viewport stretchViewPort = new StretchViewport(256, 512);
		
		stage = new Stage(stretchViewPort);
		
		stage.addActor(actor);
	}
	
	// 游戏循环渲染方法，每时每刻都在被调用。游戏逻辑的更新通常也是在这个方法中被执行。
	@Override
	public void render() {
		Gdx.gl.glClearColor(1,  0, 0, 1);
		// 清屏
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// 有意思,知道了舞台刷新频率,岂不是可以估算 鼠标/手指/按键 点击速度?
		// 持续监听
		if (Gdx.input.isTouched()) {
			Gdx.app.log(MainGame.class.getName(), "isTouched: " + Gdx.input.getX() + ", " + Gdx.input.getY());
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.B)) {
			Gdx.app.log(MainGame.class.getName(), "isKeyPressed: B键被按下");
		}
		
		if (Gdx.input.justTouched()) {
			Gdx.app.log(MainGame.class.getName(), "justTouched: " + Gdx.input.getX() + ", " + Gdx.input.getY());
			
			if (Gdx.input.getX() < Gdx.graphics.getWidth() / 2) {
				Gdx.app.log(MainGame.class.getName(), "左半边屏幕被按下");
			} else {
				Gdx.app.log(MainGame.class.getName(), "右半边屏幕被按下");
			}
		}
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
			Gdx.app.log(MainGame.class.getName(), "isJustPressed: B键刚刚别按下");
		}
		
		batch.begin();
		// 在屏幕左下角开始绘制纹理
		batch.draw(texture, 0, 0);
		batch.end();
		
		batch.begin();
		// batch.draw(region, 0, Gdx.graphics.getHeight() - region.getRegionHeight());
		batch.end();
		
		batch.begin();
		// sprite.draw(batch);
		batch.end();
		
		// 更新演员逻辑
		// actor.act(Gdx.graphics.getDeltaTime());
		batch.begin();
		// actor.draw(batch, 1.0F);
		batch.end();
		
		// 更新舞台逻辑,并批处理舞台中的演员(自动逐个调用演员的act()方法更新演员逻辑)
		stage.act();
		// 绘制舞台,并批处理舞台中的演员(自动逐个调用演员的draw()方法绘制演员)
		stage.draw();
	}
	
	// 游戏屏幕尺寸改变并且不处于暂停状态将被调用，在 create() 方法之后也会被调用一次。
	@Override
	public void resize(int width, int height) {
		Gdx.app.debug(MainGame.class.getSimpleName(), "resize()");
	}
	
	// 被其他界面覆盖后（pause 状态后），重新回到游戏界面时，该方法被调用。
	@Override
	public void resume() {
		Gdx.app.debug(MainGame.class.getSimpleName(), "resume");
	}
	
	// 当游戏界面被新的一个界面覆盖时（例如按下 Home 键回到主界面时被主界面覆盖，来电时被来电界面覆盖），该方法将被调用。通常在这里保存暂停时的游戏状态。
	@Override
	public void pause() {
		Gdx.app.debug(MainGame.class.getSimpleName(), "pause()");
	}

	// 当应用被销毁时调用。
	@Override
	public void dispose() {
		Gdx.app.debug(MainGame.class.getSimpleName(), "dispose()");
		
		if (texture != null) {
			texture.dispose();
		}
		if (batch != null) {
			batch.dispose();
		}
		if (stage != null) {
			stage.dispose();
		}
	}
	
	/**
	 * 输入事件监听器
	 */
	private class MyInputListener extends InputListener {
		
		/*
		 * 当有按键被按下时调用,参数keycode是被按下的键的键值
		 * 键值表定义在 com.badlogic.gdx.Input.Kays 类中
		 */
		@Override
		public boolean keyDown(InputEvent event, int keycode) {
			
			switch (keycode) {
			case Input.Keys.UP: {
				Gdx.app.log(MainGame.class.getName(), "方向上键");
				break;
			}
			case Input.Keys.DOWN: {
				Gdx.app.log(MainGame.class.getName(), "方向下键");
				break;
			}
			case Input.Keys.A: {
				Gdx.app.log(MainGame.class.getName(), "A");
				break;
			}
			case Input.Keys.ENTER: {
				Gdx.app.log(MainGame.class.getName(), "回车键");
				break;
			}
			default: {
				Gdx.app.log(MainGame.class.getName(), "" + keycode);
				break;
			}
			}
			return false;
		}
		
		/*
		 * 
		 * @param pointer
		 * 			按下时手指的id, 用于多点触控下辨别按下的是第几根手指
		 */
		@Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
			Gdx.app.log(MainGame.class.getName(), "touchdown: " + x + ", " + y + "; ponter" + pointer);
			return true;
		}
		
		// 手指/鼠标 按下时调用
		@Override
		public void touchDragged(InputEvent event, float x, float y, int pointer) {
			Gdx.app.log(MainGame.class.getName(), "touchDragged: " + x + ", " + y + "; pointer: " + pointer);
		}
		
		// 手指/鼠标 抬起时调用
		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
			Gdx.app.log(MainGame.class.getName(), "touchUp: " + x + ", " + y + "; pointer: " + pointer);
		}
	}
	
	private class MyClickListener extends ClickListener {
		public void Clicked(InputEvent event, float x, float y) {
			Actor actor = event.getListenerActor();
			Gdx.app.log(MainGame.class.getName(), "被点击: " + x + ", " + y + "; Actor: " + actor.getClass());
		}
	}
}
