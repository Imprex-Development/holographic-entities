package net.imprex.holoentities.component;

import org.bukkit.entity.EntityType;

import dev.imprex.holoentities.engine.HoloEntitiesComponent;

public class EntityTypeComponent extends HoloEntitiesComponent {

	private EntityType entityType;

	public EntityTypeComponent(EntityType entityType) {
		this.entityType = entityType;
	}

	public EntityType getEntityType() {
		return this.entityType;
	}
}
