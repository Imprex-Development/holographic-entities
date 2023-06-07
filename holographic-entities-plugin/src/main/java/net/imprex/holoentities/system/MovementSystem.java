package net.imprex.holoentities.system;

import dev.imprex.holoentities.engine.HoloEntitiesRegistry;
import dev.imprex.holoentities.engine.HoloEntitiesSystem;
import dev.imprex.holoentities.engine.tuple.Tuple3;
import net.imprex.holoentities.component.EntityIdComponent;
import net.imprex.holoentities.component.PositionComponent;
import net.imprex.holoentities.component.RotationComponent;

public class MovementSystem implements HoloEntitiesSystem {

	@Override
	public void update(HoloEntitiesRegistry registry) {
		registry.getComponent(EntityIdComponent.class, PositionComponent.class, RotationComponent.class)
			.filter(Tuple3::areSomeDirty)
			.forEach(tuple -> this.update(tuple.f0(), tuple.f1(), tuple.f2()));
	}

	public void update(EntityIdComponent entityId, PositionComponent position, RotationComponent rotation) {
		
	}
}