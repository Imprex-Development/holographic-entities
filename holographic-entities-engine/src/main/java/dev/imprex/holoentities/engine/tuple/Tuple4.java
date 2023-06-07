package dev.imprex.holoentities.engine.tuple;

import dev.imprex.holoentities.engine.HoloEntitiesComponent;

public record Tuple4<
	T0 extends HoloEntitiesComponent,
	T1 extends HoloEntitiesComponent,
	T2 extends HoloEntitiesComponent,
	T3 extends HoloEntitiesComponent>(
		T0 f0, T1 f1, T2 f2, T3 f3) {

	public boolean areNoneNull() {
		return this.f0 != null && this.f1 != null && this.f2 != null && this.f3 != null;
	}

	public boolean areSomeDirty() {
		return this.areNoneNull() && (this.f0.isDirty() || this.f1.isDirty() || this.f2.isDirty() || this.f3.isDirty());
	}
}