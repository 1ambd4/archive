package com.libgdx.learnlibgdx.test;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyActor extends Actor {
	
	// 用于展示该 Actor 的纹理区域
	private TextureRegion region;
	
	public MyActor(TextureRegion region) {
		super();
		this.region = region;
		
		// 设置演员纹理区域宽高,默认为0 0
		setSize(this.region.getRegionWidth(), this.region.getRegionHeight());
		// setWidth(this.region.getRegionWidth());		这儿和上面
		// setHeight(this.region.getRegionHeight());	
	}
	
	public TextureRegion getRegion() {
		return region;
	}
	
	public void setRegion(TextureRegion region) {
		this.region = region;
		setSize(this.region.getRegionWidth(), this.region.getRegionHeight());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		// 如果 region 为 null 或者 act 不可见,直接返回
		if (region == null || !isVisible()) {
			return ;
		}
		
		batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
}
