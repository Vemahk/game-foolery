package me.vem.game.world;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import me.vem.game.objs.GameObject;

public class WorldState {

	private static WorldState state;
	public static WorldState getWorldState() {
		if(state == null)
			state = new WorldState();
		return state;
	}
	
	private WorldState() { }
	
	private boolean isInitialized = false;
	private Set<GameObject> loadedObjects;
	
	public boolean init() {
		if(isInitialized)
			return false;
		
		loadedObjects = Collections.synchronizedSet(new HashSet<>());
		//TODO
		
		return isInitialized = true;
	}
	
	public boolean unloadObject(GameObject object) {
		if(!loadedObjects.remove(object))
			return false;
		
		byte[] serialized = object.serialize();
		//TODO Save
		
		return true;
	}
	
}
