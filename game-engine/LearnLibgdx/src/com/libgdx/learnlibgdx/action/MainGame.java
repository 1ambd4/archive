package com.libgdx.learnlibgdx.action;

import java.security.KeyStore.PrivateKeyEntry;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AfterAction;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeToAction;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/*
 * 动作执行原理(查看 Actor 和 Action 源码)
 * 
 * 实际上动作添加到了演员身上之后,动作被保存到一个数组中,然后在更新演员逻辑的 act() 方法中遍历存放动作的数组
 * 对没一个动作根据时间步 delta 改变演员相应的状态属性值,然后在绘制演员的 draw() 方法中绘制演员时使用新的状态属性值,
 * 和上一帧相比,就显得演员动了起来
 */


public class MainGame extends ApplicationAdapter {
	
	private static final String TAG = MainGame.class.getSimpleName();
	
	public static final float WORLD_WIDTH = 720;
	public static final float WORLD_HEIGHT = 1080;
	
	private SpriteBatch batch;
	
	private Texture texture;
	
	private Stage stage;
	
	private MyActor actor;
	
	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("badlogic.jpg"));
		
		stage = new Stage(new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT));
		
		actor = new MyActor(new TextureRegion(texture));
		
		stage.addActor(actor);
		
		/*
		 * 动作对象缓存
		 * 
		 * 
		 * 有些动作需要频繁使用,如果每一次使用动作都重新创建一个对象,会耗费性能
		 * Libgdx 对动作实例使用了缓存池,使用完的动作不会立即被系统回收
		 * 而是放到了缓存池中等待再次使用.
		 * 
		 * Libgdx 中的所有的动作实例的获取均通过 Actions 工具类中的静态方法获取(Actions 实现了对象缓存池)
		 * 
		 *  获取到一个动作对象后附加到 (addAction) 演员身上执行,动作执行完成后会自动从演员身上移除并放回对象池中缓存
		 *  动作也可以在没有执行完成时手动使用 removeAction 移除
		 */
		
		// 1.移动动作 
		//testMoveByAction();
		
		// 2.移动动作(相对)
		//testMoveByAction();
		
		// 3.旋转动作
		//testRotateToAction();
		
		// 4.旋转动作(相对)
		//testRotateByAction();
		
		// 5.缩放动作
		//testScaleToAction();
		
		// 6.缩放动作(相对)
		//testScaleByAction();
		
		// 7.尺寸改变动作
		//testSizeToAction();
		
		// 8.尺寸改变动作(相对)
		//testSizeByAction();
		
		// 9.透明度动作
		//testAlphaAction();
		
		// 10.并行动作
		//testParallelAction();
		
		// 11.顺序动作(带延迟)
		//testSequenceAction();
		
		// 12.重复动作
		testRepeatAction();
		
		// 13.Runnable 动作
		//testRunnableAction();
		
		// 14.After 动作
		//testAfterAction();
		
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(0.75F, 1, 0.98F, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		
		stage.draw();
	}
	
	@Override
	public void dispose() {
		if (stage != null) {
			stage.dispose();
		}
		if (texture != null) {
			texture.dispose();
		}
	}
	
	// 1.移动动作
	private void testMoveToAction() {
		// 初始位置
		actor.setPosition(0, 0);
		
		// 获取一个 MoveTo 动作, 3s 内移动到 (150, 300)的位置
		MoveToAction action = Actions.moveTo(150, 300, 3.0F);
		
		// 把动作附加到演员身上并执行动作
		actor.addAction(action);
	}
	
	// 2.移动动作(相对)
	private void testMoveByAction() {
		// 设置演员到舞台中心
		actor.setPosition(actor.getStage().getWidth() / 2 - actor.getWidth() / 2, actor.getStage().getHeight() / 2 - actor.getHeight() / 2);
		
		// 2s 内将演员在原位置的基础上,水平方向移动 100,竖直方向上移动 -200
		MoveByAction action = Actions.moveBy(100, -200, 2.0F);
		
		actor.addAction(action);
	}
	
	// 3.旋转动作
	private void testRotateToAction() {
		actor.setPosition(actor.getStage().getWidth() / 2 - actor.getWidth() / 2, actor.getStage().getHeight() / 2 - actor.getHeight());
		
		// 缩放和旋转支点设置到演员中心
		actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
		
		// 演员的初始角度为 -90度
		actor.setRotation(-90);
		
		// 2s 内从初始角度旋转到 -270度
		RotateToAction action = Actions.rotateTo(-270, 2.0F);
		
		actor.addAction(action);
	}
	
	// 4.旋转动作(相对)
	private void testRotateByAction() {
		actor.setPosition(actor.getStage().getWidth() / 2 - actor.getWidth() / 2, actor.getStage().getHeight() / 2 - actor.getHeight());
		
		// 缩放和旋转支点设置到演员中心
		actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
		
		// 演员的初始角度为 -90度
		actor.setRotation(-90);
		
		// 2s 内从原角度基础上增加 45度, 最终为 -90 + 45 = -45
		RotateByAction action = Actions.rotateBy(45, 2.0F);
		
		actor.addAction(action);
	}
	
	// 5.缩放动作
	private void testScaleToAction() {
		actor.setPosition(actor.getStage().getWidth() / 2 - actor.getWidth() / 2, actor.getStage().getHeight() / 2 - actor.getHeight());
		
		// 缩放和旋转支点设置到演员中心
		actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
		
		// 初始水平和竖直缩放比例分笔试 0.5 和 2
		actor.setScale(0.5F, 2.0F);
		
		// 2s 内水平和竖直方向缩放比例调整到 1 1
		ScaleToAction action = Actions.scaleTo(1.0F, 1.0F, 2.0F);
		
		actor.addAction(action);
	}
	
	// 6.缩放动作(相对)
	private void testScaleByAction() {
		actor.setPosition(actor.getStage().getWidth() / 2 - actor.getWidth() / 2, actor.getStage().getHeight() / 2 - actor.getHeight());
		
		// 缩放和旋转支点设置到演员中心
		actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
		
		actor.setScale(0.5F, 0.5F);
		
		// 2s 内谁飘过方向和竖直方向上从原缩放比例分别加上 0.5 0.5
		// 最后水平和竖直的缩放比例均为 0.5 + 0.5 = 1
		ScaleByAction action = Actions.scaleBy(0.5F, 0.5F, 2.0F);
		
		actor.addAction(action);
	}
	
	// 7.尺寸改变动作
	private void testSizeToAction() {
		actor.setPosition(0, 0);
		
		// 2s 内从原来的尺寸变为 150*300
		SizeToAction action = Actions.sizeTo(150, 300, 2.0F);
		
		actor.addAction(action);
	}
	
	// 8.尺寸改变动作
	private void testSizeByAction() {
		actor.setPosition(0, 0);
		
		// ２s 内宽高在原来的基础上分别增加 150 300
		SizeByAction action = Actions.sizeBy(150, 300, 2.0F);
		
		actor.addAction(action);
	}
	
	// 9.透明度动作
	private void testAlphaAction() {
		actor.setPosition(0, 0);
		
		// 设置演员初始 alpha 的值为1(完全不透明,默认就是1)
		actor.getColor().a = 1.0F;
		
		// 5s 内 alpha 变为 0(完全透明)
		AlphaAction action = Actions.alpha(0.0F, 5.0F);
		
		actor.addAction(action);
	}
	
	// 10.并行执行: 移动 缩放 旋转
	private void testParallelAction() {
		actor.setPosition(0, 0);
		actor.setScale(0.5F, 0.5F);
		actor.setRotation(0);
		
		actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
		
		// 移动
		MoveToAction moveTo = Actions.moveTo(150, 300, 3.0F);
		
		// 缩放
		ScaleToAction scaleTo = Actions.scaleTo(1.0F, 1.0F, 3.0F);
		
		// 旋转
		RotateByAction rotateBy = Actions.rotateBy(360.F, 3.0F);
		
		// 并行执行动作
		ParallelAction parallelAction = Actions.parallel(moveTo, scaleTo, rotateBy);
		
		actor.addAction(parallelAction);
	}
	
	// 11.顺序动作
	private void testSequenceAction() {
		actor.setPosition(0, 0);
		actor.setScale(1.0F, 1.0F);
		actor.setRotation(0);
		
		actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
		
		// 延时 3s
		// 先延时, 然后移动,再旋转并缩放
		DelayAction delay = Actions.delay(3.0F);
		
		MoveToAction moveTo = Actions.moveTo(150, 300, 3.0F);
		// 并行动作: 缩放 旋转
		ParallelAction parallel = Actions.parallel(Actions.scaleTo(0.5F, 0.5F, 3.0F), Actions.rotateBy(360.F, 3.0F));
		
		// 顺序动作: 延时 移动 缩放旋转
		SequenceAction sequenceAction = Actions.sequence(delay, moveTo, parallel);
		
		actor.addAction(sequenceAction);
	}
	
	// 12.重复动作
	private void testRepeatAction() {
		actor.setPosition(actor.getStage().getWidth() / 2 - actor.getWidth() / 2, actor.getStage().getHeight() / 2 - actor.getHeight());
		
		// 缩放和旋转支点设置到演员中心
		actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
		
		actor.setScale(1.0F, 1.0F);
		
		// 顺序动作 先缩小到0.5 再放大到1.0
		SequenceAction sequenceAction = Actions.sequence(Actions.scaleTo(0.5F, 0.5F, 2.0F), Actions.scaleTo(1.0F, 1.0F, 2.0F));
		
		// 重复动作: 重复执行 sequenceAction
		RepeatAction repeatAction = Actions.forever(sequenceAction);
		
		actor.addAction(repeatAction);
	}
	
	// 13.Runnable动作: 适当实际执行自己的代码, 与顺序动作一起使用可用于监听某个动作的完成
	private void testRunnableAction() {
		actor.setPosition(0, 0);
		
		MoveToAction moveToAction = Actions.moveTo(150, 300, 3.0F);
		
		RunnableAction runnableAction = Actions.run(new Runnable() {
			
			@Override
			public void run() {
				Gdx.app.log(TAG, "Runnable action is running...");
			}
		});
		
		SequenceAction sequenceAction = Actions.sequence(moveToAction, runnableAction);
		
		actor.addAction(sequenceAction);
	}
	
	// 14.After动作
	private void testAfterAction() {
		actor.setPosition(0, 0);
		actor.setRotation(0);
		
		// 缩放和旋转支点设置到演员中心
		actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
		
		MoveToAction moveToAction = Actions.moveTo(150, 300, 3.0F);
		
		RotateByAction rotateByAction = Actions.rotateBy(360.F, 2.0F);
		
		RunnableAction runnableAction = Actions.run(new Runnable() {
			
			@Override
			public void run() {
				Gdx.app.log(TAG, "actor 的其他动作已经执行完成.");
			}
		});
		
		AfterAction afterAction = Actions.after(runnableAction);
		
		actor.addAction(moveToAction);
		actor.addAction(rotateByAction);
		actor.addAction(afterAction);
	}
}
