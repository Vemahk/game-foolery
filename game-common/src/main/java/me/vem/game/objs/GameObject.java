package me.vem.game.objs;

import me.vem.game.math.Vector2D;
import me.vem.game.utils.Serializable;

public abstract class GameObject implements Serializable{

	private Vector2D pos;
	private int zIndex;

	private boolean visible;

	protected GameObject() {
		pos = Vector2D.ORIGIN;
		zIndex = 0;

		visible = true;
	}

	public float getX() {
		return pos.getXPos();
	}

	public float getY() {
		return pos.getYPos();
	}

	public int getZIndex() {
		return zIndex;
	}

	public void setPosition(Vector2D newPos) {
		this.pos = newPos;
	}
	
	public void setZIndex(int newZIndex) {
		this.zIndex = newZIndex;
	}

	public void move(Vector2D by) {
		this.pos = this.pos.add(by);
	}

	public void setVisible(boolean value) {
		visible = value;
	}

	public boolean toggleVisible() {
		return (visible = !visible);
	}

	public boolean isVisible() {
		return visible;
	}
}