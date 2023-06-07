package net.imprex.holoentities.component;

import dev.imprex.holoentities.engine.HoloEntitiesComponent;

public class RotationComponent extends HoloEntitiesComponent {

	private float yaw;
	private float pitch;

	public RotationComponent(float yaw, float pitch) {
		this.yaw = yaw;
		this.pitch = pitch;

		this.setDirty();
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
		this.setDirty();
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
		this.setDirty();
	}
}
