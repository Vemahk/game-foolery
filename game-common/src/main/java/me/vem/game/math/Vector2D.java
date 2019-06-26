package me.vem.game.math;

import java.nio.ByteBuffer;

import me.vem.game.utils.Serializable;

public final class Vector2D implements Serializable{

	public static final Vector2D ORIGIN = new Vector2D(0,0);
	
	private final float x, y;
	
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getXPos() { return x; }
	public float getYPos() { return y; }
	
	public Vector2D add(Vector2D to) {
		return new Vector2D(x + to.x, y + to.y);
	}
	
	public Vector2D sub(Vector2D from) {
		return new Vector2D(x - from.x, y - from.y);
	}
	
	public float dot(Vector2D with) {
		return x * with.x + y * with.y;
	}
	
	public float getMagnetude() {
		return (float) Math.sqrt(getMagnetudeSqr());
	}
	
	public float getMagnetudeSqr() {
		return dot(this);
	}
	
	public float angleBetween(Vector2D other) {
		return (float) Math.acos(dot(other) / getMagnetude() / other.getMagnetude());
	}

	@Override
	public byte[] serialize() {
		byte[] result = new byte[8];
		ByteBuffer tmp = ByteBuffer.wrap(result);
		
		tmp.putFloat(x).putFloat(y);
		
		return result;
	}
}