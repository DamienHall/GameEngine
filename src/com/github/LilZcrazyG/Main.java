package com.github.LilZcrazyG;

import com.github.LilZcrazyG.GameEngine.GameEngine;
import com.github.LilZcrazyG.GameEngine.GameStateManager;
import com.github.LilZcrazyG.GameEngine.GraphicsEngine;
import com.github.LilZcrazyG.GameEngine.InputManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Main {
    static GameStateManager gameStateManager = new GameStateManager() {
        @Override
        public void tick() {
        }

        @Override
        public void render() {
            GraphicsEngine.clearScreen();
            GraphicsEngine.show();
        }
    };
    static InputManager inputManager = new InputManager() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            InputManager.setKey( e.getKeyChar(), true );
        }

        @Override
        public void keyReleased(KeyEvent e) {
            InputManager.setKey( e.getKeyChar(), false );
        }
    };

    public static void main(String[] args) {
        InputManager.initialize();
        GameEngine.createWindow( 200, 200, "Hello :)" );
        GraphicsEngine.setBackgroundColor( Color.BLACK );
        GameEngine.addInputManager( inputManager );
        GameEngine.run( 1000/60, gameStateManager );
    }
}
