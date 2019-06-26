package me.vem.game.utils;

import java.nio.ByteBuffer;

public interface Serializable {
	default void writeTo(ByteBuffer buffer) {
		for(byte b : serialize())
			buffer.put(b);
	}
	
	byte[] serialize();
}