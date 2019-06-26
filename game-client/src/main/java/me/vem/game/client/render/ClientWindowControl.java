package me.vem.game.client.render;

import java.awt.Graphics;

import me.vem.game.graphics.WindowControl;

public class ClientWindowControl extends WindowControl{

	private static ClientWindowControl instance;
	public static ClientWindowControl getInstance() {
		if(instance == null)
			instance = new ClientWindowControl();
		return instance;
	}
	
	private ClientWindowControl() { super(); }
	
	@Override
	public void render(Graphics g) {
		//TODO DO RENDER
		
	}
}
