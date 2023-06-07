package dev.imprex.holoentities.engine;

public class HoloEntitiesComponent {

	private boolean dirty = false;

	public boolean isDirty() {
		return this.dirty;
	}

	public void setDirty() {
		this.dirty = true;
	}

	public void unsetDirty() {
		this.dirty = false;
	}
}