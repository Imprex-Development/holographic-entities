package net.imprex.holoentities.component;

import org.bukkit.World;

import dev.imprex.holoentities.engine.HoloEntitiesComponent;

public class PositionComponent extends HoloEntitiesComponent {

	private World world;
	private double x;
	private double y;
	private double z;

	

	public PositionComponent(World world, double x, double y, double z) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;

		this.setDirty();
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
		this.setDirty();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
		this.setDirty();
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
		this.setDirty();
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
		this.setDirty();
	}
}
