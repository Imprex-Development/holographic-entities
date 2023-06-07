package dev.imprex.holoentities.engine;

import java.util.ArrayList;
import java.util.List;

public class HoloEntitiesEngine implements Runnable {

	private final HoloEntitiesRegistry registry = new HoloEntitiesRegistry();

	private final List<HoloEntitiesSystem> systemList = new ArrayList<>();

	@Override
	public void run() {
		this.systemList.forEach(system -> system.update(this.registry));
	}

	public void addSystem(HoloEntitiesSystem system) {
		if (this.systemList.contains(system)) {
			throw new IllegalStateException("System was already registered");
		}
		this.systemList.add(system);
	}

	public boolean removeSystem(HoloEntitiesSystem system) {
		return this.systemList.remove(system);
	}
}