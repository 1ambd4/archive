package com.libgdx.learnlibgdx.test;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main(String[] args) {
		
		// 创建窗体配置
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width = 480;
		config.height = 720;
		// 设置窗体大小不可变
		config.resizable = false;
		
		// 创建游戏主程序启动入口类,传入 config 配置并启动
		new LwjglApplication(new MainGame(), config);
	}
}
