package me.vem.game.graphics;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;

public abstract class WindowControl {
	
	private GraphicsConfiguration gc;
	private Frame window;
	
	public WindowControl() {
		this(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
	}
	
	public WindowControl(GraphicsDevice device) {
		this.gc = device.getDefaultConfiguration();
		window = new Frame(gc);
		window.setUndecorated(true);
		window.setSize(new Dimension(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight()));
		window.setResizable(false);
		
		window.setVisible(true);
		window.createBufferStrategy(2);
	}
	
	public void render() {
		BufferStrategy strat = window.getBufferStrategy();
		if(!strat.contentsLost()) {
			Graphics g = null;
			
			try {
				g = strat.getDrawGraphics();
				render(g);
			}finally {
				g.dispose();
			}
			
			strat.show();
		}
	}
	
	public abstract void render(Graphics g);
}
