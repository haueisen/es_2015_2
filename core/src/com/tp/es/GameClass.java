package com.tp.es;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameClass extends Game {
	SpriteBatch batch;
	//Texture img;
	
	@Override
	public void create () {
		Assets.load();
		batch = new SpriteBatch();
		setScreen(new TelaTitulo(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
