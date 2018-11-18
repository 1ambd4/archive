package com.libgdx.learnlibgdx.animation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


// 游戏主进程的启动入口类
public class MainGame extends ApplicationAdapter{
	
	public static final int WORLD_WIDTH = 720;
	public static final int WORLD_HEIGHT = 1080;
	
	private SpriteBatch batch;
	
	private Texture texture;
	
	// 行走动画
	private Animation animation;
	
	private TextureRegion currentFrame;
	
	// 状态时间,渲染时间步 delta 的累加值
	private float stateTime;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		
		// 创建纹理,animation_sheet.png 256*256, 由 5行 6列不同状态的小人组成
		texture = new Texture(Gdx.files.internal("animation_sheet.png"));
		
		// 小人单元格的列数
		int frameCols = 6;
		// 小人单元格的行数
		int frameRows = 5;
		
		// 计算没一个小人单元格的高和宽
		int preCellWidth = texture.getWidth() / frameCols;
		int preCellHeight = texture.getHeight() / frameRows;
		
		// 按照指定的宽高作为一个单元格分割大图纹理,分割后的结果作为一个 5*6 的纹理区域二维数组
		// 数组中的元素是分割出来的小人单元格
		TextureRegion[][] cellRegions = TextureRegion.split(texture, preCellWidth, preCellHeight);
		
		// 把二维数组变成一维数组
		// 因为 Animation 只能接收一维数组作为关键帧序列,数组中的一个元素表示一个关键帧
		TextureRegion[] walkFrams = new TextureRegion[frameRows * frameCols];
		int index = 0;
		// 顺手把内层循环的 frameCol 写成 frameRows 了,找了好半天到底那儿缺了 5帧(我真是傻啊,还能有那儿?只能是这儿吧...
		for (int row = 0; row < frameRows; row++) {
			for (int col = 0; col < frameCols; col++) {
				walkFrams[index++] = cellRegions[row][col];
				Gdx.app.log(MainGame.class.getName(), ""+ index);
			}
		}
		
		// 使用关键帧(纹理区域)数组创建一个动画实例,每一帧播放 0.05s
		animation = new Animation(0.05F, walkFrams);
		
        /*
         * 设置播放模式:
         * 
         * Animation.PlayMode.NORMAL: 正常播放一次（默认）
         * Animation.PlayMode.REVERSED: 倒序播放一次
         * 
         * Animation.PlayMode.LOOP: 正常循环播放
         * Animation.PlayMode.LOOP_REVERSED: 倒序循环播放
         * 
         * Animation.PlayMode.LOOP_RANDOM: 随机循环播放
         * Animation.PlayMode.LOOP_PINGPONG: 开关式（先正序再倒序）循环播放
         */	
		animation.setPlayMode(Animation.PlayMode.LOOP);
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(0.75F, 1, 0.98F, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// 累加时间步(stateTime也可以表示游戏的运行时间)
		stateTime += Gdx.graphics.getDeltaTime();
		
		// 根据当前播放模式获取当前关键帧,就是在 stateTime 这个时刻应该播放哪一帧
		currentFrame = animation.getKeyFrame(stateTime);
		
		batch.begin();
		
		if (currentFrame != null) {
			// 绘制当前关键帧
			batch.draw(currentFrame, 100, 250);	
		}
		
		batch.end();
	}
	
	@Override
	public void dispose() {
		
		if (texture != null) {
			texture.dispose();
		}
		if (batch != null) {
			batch.dispose();
		}
	}
}
