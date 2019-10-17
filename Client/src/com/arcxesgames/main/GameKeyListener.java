package com.arcxesgames.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			System.out.println("Left");
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			System.out.println("Right");
		}
		
		if(key == KeyEvent.VK_UP) {
			System.out.println("Up");
		}
		
		if(key == KeyEvent.VK_DOWN) {
			System.out.println("Down");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
