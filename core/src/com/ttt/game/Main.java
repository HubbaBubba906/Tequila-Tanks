package com.ttt.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends ApplicationAdapter {

    SpriteBatch batch;
    Texture Tank1, floor, back, gasmoney;
    float TankX = 0, TankY = 0;
    float SpriteSpeed = 155f;
    double dSpeed = 0, dGravity = 0.1;
    int dGas;

    public void create() {
        batch = new SpriteBatch();
        Tank1 = new Texture("Tanks.png");
        floor = new Texture("floor.jpg");
        back = new Texture("back.jpg");
        gasmoney = new Texture("green.png");
        TankX = 500;
        TankY = 500;
        dSpeed = 0;
        dGas = 500;
    }

    public void render() {
        batch.begin();
        if (TankY >= 100) { //Gravity
            dSpeed += dGravity;
        } else if (TankY <= 100) {
            TankY = 100;
        }
        if (dGas <= 400) {
            SpriteSpeed = 0;
            dGas = 500;
        }
        TankY -= dSpeed;
        batch.draw(back, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(gasmoney, TankX, TankY + 100, dGas - 400, 10);
        batch.draw(Tank1, TankX, TankY, 100, 100);
        if (TankY <= 100) {
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) && TankX > 0) {
                TankX -= Gdx.graphics.getDeltaTime() * SpriteSpeed;
                if (SpriteSpeed > 1) {
                    dGas -= 1;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) && TankX < Gdx.graphics.getWidth()) {
                TankX += Gdx.graphics.getDeltaTime() * SpriteSpeed;
                if (SpriteSpeed > 1) {
                    dGas -= 1;
                }
            }
        }
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        Tank1.dispose();
    }
}
