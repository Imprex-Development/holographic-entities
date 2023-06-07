package dev.imprex.holoentities.engine.tuple;

import dev.imprex.holoentities.engine.HoloEntitiesComponent;

public record Tuple2<T0 extends HoloEntitiesComponent, T1 extends HoloEntitiesComponent>(T0 f0, T1 f1) {

	public boolean areNoneNull() {
		return this.f0 != null && this.f1 != null;
	}

	public boolean areSomeDirty() {
		return this.areNoneNull() && (this.f0.isDirty() || this.f1.isDirty());
	}
}