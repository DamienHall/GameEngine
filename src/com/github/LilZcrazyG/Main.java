package com.github.LilZcrazyG;

import com.github.LilZcrazyG.GameEngine.GameEngine;
import com.github.LilZcrazyG.GameEngine.GameEngine.GraphicsEngine;
import com.github.LilZcrazyG.GameEngine.GameEngine.InputManager;
import com.github.LilZcrazyG.GameEngine.GameEngine.InputManager.KeyListener;
import com.github.LilZcrazyG.GameEngine.GameEngine.GameStateManager;
import com.github.LilZcrazyG.GameEngine.GameEngine.GameStateManager.GameState;
import com.github.LilZcrazyG.GameEngine.GameEngine.WindowEngine;
import com.github.LilZcrazyG.GameEngine.GameEngine.WindowEngine.Window;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {

    static int x = 0;
    static int y = 0;

    public static void main(String[] args) {
        WindowEngine.createWindow( "Game Window", new Window( "Game Window ") );
        GraphicsEngine.initialize( WindowEngine.getWindow( "Game Window" ) );
        InputManager.createKeyListener( WindowEngine.getWindow( "Game Window" ), new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        } );
        GameStateManager.createState( "primary", new GameState() {
            @Override
            public void tick() {
                x+=1;
            }
            @Override
            public void render() {
                GraphicsEngine.clearScreen();
                GraphicsEngine.setColor( Color.WHITE );
                GraphicsEngine.rectangleFilled( x, y, 50, 50 );
                GraphicsEngine.show();
            }
        } );
        GameStateManager.setCurrentState( "primary" );
        GraphicsEngine.setBackgroundColor( Color.BLACK );
        GameEngine.run();
    }
}
