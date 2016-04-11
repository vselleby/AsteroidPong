package com.mygdx.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.model.Ball;
import com.mygdx.game.model.GameState;
import com.mygdx.game.model.Paddle;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;

	private GameState state;
	private ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();

		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		state = new GameState(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Ball ball = state.getBalls().get(0);
		Paddle paddle1 = state.getPaddles()[0];
		Paddle paddle2 = state.getPaddles()[1];

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.end();

		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.setColor(Color.WHITE);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.circle(ball.getX(), ball.getY(), ball.getRadius());
		shapeRenderer.rect(paddle1.getX(), paddle1.getY(), paddle1.getLength(), paddle1.getHeight());
		shapeRenderer.rect(paddle2.getX(), paddle2.getY(), paddle2.getLength(), paddle2.getHeight());

		shapeRenderer.setColor(Color.RED);
		shapeRenderer.circle(state.getPaddles()[0].getX(), state.getPaddles()[0].getY(), 10);
		shapeRenderer.end();

		state.update();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		state.getPaddles()[0].setX((float) screenX);
		state.getPaddles()[1].setX((float) screenX);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
