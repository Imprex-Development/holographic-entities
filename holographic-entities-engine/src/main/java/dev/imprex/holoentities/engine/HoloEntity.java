package dev.imprex.holoentities.engine;

import java.util.HashMap;
import java.util.Map;

public class HoloEntity {

	final int index;

	final Map<Class<?>, Object> components = new HashMap<>();

	public HoloEntity(int index) {
		this.index = index;
	}

	boolean addComponent(Object component) {
		if (this.components.put(component.getClass(), component) != null) {
			System.out.println("Added duplicated component " + component.getClass());
		}
		return true;
	}

	boolean removeComponent(Class<?> component) {
		return this.components.remove(component) != null;
	}

	public <T> T getComponent(Class<T> component) {
		Object componentInstance = this.components.get(component);
		return componentInstance != null ? component.cast(componentInstance) : null;
	}
}