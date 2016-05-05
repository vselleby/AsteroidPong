package com.mygdx.game.view.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.WifiDirectInterface;

/**
 * Created by johanmansson on 16-04-20.
 */
public class MenuState extends com.mygdx.game.view.States.State {
    private Texture button1;
    private Texture button2;
    private Texture button3;
    private Texture text1;



    public MenuState(StateManager stateManager, WifiDirectInterface wifiDirect) {
        super(stateManager, StateManager.STATE_NAME.MENU_STATE, wifiDirect);
        button1 = new Texture("buttonCG.png");
        button2 = new Texture("buttonFG.png");
        button3= new Texture("buttonTM.png");
        text1 = new Texture("text1.png");


    }

    @Override
    public boolean isActive() {
        return (this.stateManager.getActiveState().equals(this.stateName));
    }

    @Override
    public void update() {
        handleInput();

    }

    @Override
    public void render(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer) {

        spriteBatch.begin();

        Color c = spriteBatch.getColor();
        spriteBatch.draw(text1, (Gdx.graphics.getWidth() / 2) - (text1.getWidth() / 2), (Gdx.graphics.getHeight() / 4));

        spriteBatch.draw(button1, (Gdx.graphics.getWidth() / 2) - (button1.getWidth() / 2), (Gdx.graphics.getHeight() / 2) + 50);

        spriteBatch.setColor(c.r, c.g, c.b, 0.3f);
        spriteBatch.draw(button2, (Gdx.graphics.getWidth() / 2) - (button2.getWidth() / 2), (Gdx.graphics.getHeight() / 2) + 70 + (button1.getHeight()));
        spriteBatch.draw(button3, (Gdx.graphics.getWidth() / 2) - (button3.getWidth() / 2), (Gdx.graphics.getHeight() / 2) + 90 + (button1.getHeight()) + (button2.getHeight()));
        spriteBatch.setColor(c.r, c.g, c.b, 1f);


        spriteBatch.end();

    }

    public void handleInput() {

        if(Gdx.input.justTouched()) {
            float x = Gdx.input.getX();
            float y = Gdx.input.getY();

            float x1 = (Gdx.graphics.getWidth() / 2) - (button1.getWidth() / 2);
            float x2 = (Gdx.graphics.getWidth() / 2) + (button1.getWidth() / 2);

            float y11 = (Gdx.graphics.getHeight() / 2) + 50;
            float y12 = (Gdx.graphics.getHeight() / 2) + 50 + button1.getHeight();

            float y21 = (Gdx.graphics.getHeight() / 2) + 70 + (button1.getHeight());
            float y22 = (Gdx.graphics.getHeight() / 2) + 70 + 2*(button1.getHeight());

            float y31 = (Gdx.graphics.getHeight() / 2) + 90 + (button1.getHeight()) + (button2.getHeight());
            float y32 = (Gdx.graphics.getHeight() / 2) + 90 + (button1.getHeight()) + 2*(button2.getHeight());


            if(x > x1 && x < x2 && y > y11 && y < y12) { // && wifiDirect.isConnected()) {
                System.out.println("Button1 pressed");

                stateManager.push(new HowToPlayState(stateManager, wifiDirect));

            }

            if(x > x1 && x < x2 && y > y21 && y < y22) {
                System.out.println("Button2 pressed");


            }

            if(x > x1 && x < x2 && y > y31 && y < y32) {
                System.out.println("Button3 pressed");


                //behövs metod här för att sätta GameState till singleplayer

                //stateManager.pop();


            }


        }

    }
}
