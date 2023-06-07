package net.imprex.holoentities.component;

import dev.imprex.holoentities.engine.HoloEntitiesComponent;

public class EntityIdComponent extends HoloEntitiesComponent {

	private int id;

	public EntityIdComponent(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
}
