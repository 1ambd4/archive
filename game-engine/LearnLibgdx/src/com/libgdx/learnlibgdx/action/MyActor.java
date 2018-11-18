package com.libgdx.learnlibgdx.action;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyActor extends Actor{

	// 自定义演员(绘制时处理 位置,尺寸,缩放比,旋转角度个 color/alpha 等属性)
	private TextureRegion region;
	
	public MyActor(TextureRegion region) {
		super();
		this.region = region;
		setSize(this.region.getRegionWidth(), this.region.getRegionHeight());
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
		if (region ==  null || !isVisible()) {
			return ;
		}
		
		// 暂时保存 batch 的 color,便于在后面修改之后可以再修改回去
		Color tempBatchColor = batch.getColor();
		
		/*
         * 实际上演员并没有单独的 alpha 属性, alpha 包含在颜色(color)属性中, rgba color 中的 a 表示 alpha;
         * 演员有 alpha 值, 而父节点(舞台/演员组)中也有 alpha 值(parentAlpha)。 由于最终在演员节点中才真正把纹理
         * 绘制在屏幕上, 才是真正绘制的地方, 而父节点一般用于组织演员, 不会直接绘制任何纹理, 透明度 alpha 值只有在绘制
         * 时才能体现出来, 所以父节点无法体现自己的 alpha 值, 因此父节点会将自己的 alpha 值(就是draw方法中的参数 parentAlpha)
         * 传递给它自己的所有子节点，即最终直接绘制纹理的演员, 让演员结合自身的 alpha 值在绘制时综合体现。
         */
		Color color = getColor();
		
		// 处理 color/alpha 属性,即将演员的 rgba color 设置到纹理画布 batch
		// 其中的 alpha 需要结合演员和父节点的 alpha, 即演员的 alpha 和父节点的 alpha 相乘
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		
		batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		
		// 把 batch 原来的 color 设置回去
		batch.setColor(tempBatchColor);
	}
}
