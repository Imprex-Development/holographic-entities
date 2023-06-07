package dev.imprex.holoentities.engine;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import dev.imprex.holoentities.engine.tuple.Tuple2;
import dev.imprex.holoentities.engine.tuple.Tuple3;
import dev.imprex.holoentities.engine.tuple.Tuple4;
import dev.imprex.holoentities.engine.tuple.Tuple5;

public class HoloEntitiesRegistry {

	private HoloEntity[] entities = new HoloEntity[256];
	private final BitSet entityIndex = new BitSet();

	private final Map<Class<?>, BitSet> components = new HashMap<>();

	public HoloEntity createEntity() {
		int index = entityIndex.nextClearBit(0);
		this.entityIndex.set(index);

		HoloEntity entity = new HoloEntity(index);

		if (this.entities.length <= index) {
			this.entities = Arrays.copyOf(this.entities, this.entities.length * 2);
		}
		this.entities[index] = entity;

		return entity;
	}

	public void removeEntity(HoloEntity entity) {
		int index = entity.index;

		this.entityIndex.clear(index);
		this.entities[index] = null;

		for (Class<?> component : entity.components.keySet()) {
			this.clearComponentBit(component, index);
		}
	}

	public void addComponent(HoloEntity entity, Object component) {
		if (entity.addComponent(component)) {
			BitSet compoentBitSet = this.components.computeIfAbsent(component.getClass(), key -> new BitSet());
			compoentBitSet.set(entity.index);
		}
	}

	public void removeComponent(HoloEntity entity, Class<?> component) {
		if (entity.removeComponent(component)) {
			this.clearComponentBit(component, entity.index);
		}
	}

	private void clearComponentBit(Class<?> component, int index) {
		BitSet componentBitSet = this.components.get(component);
		if (componentBitSet == null) {
			throw new NullPointerException("Tried to clear component bit for non existing component!");
		}

		componentBitSet.clear(index);
	}

	public <T0 extends HoloEntitiesComponent> Stream<T0> getComponent(Class<T0> component0) {
		BitSet componentBitSet = this.components.get(component0);
		if (componentBitSet == null) {
			return Stream.of();
		}

		return componentBitSet.stream()
				.mapToObj(index -> this.entities[index])
				.map(entity -> entity.getComponent(component0))
				.filter(Objects::nonNull);
	}

	public <
	T0 extends HoloEntitiesComponent,
	T1 extends HoloEntitiesComponent>
	Stream<Tuple2<T0, T1>> getComponent(Class<T0> component0, Class<T1> component1) {
		BitSet component0BitSet = this.components.get(component0);
		BitSet component1BitSet = this.components.get(component1);
		if (component0BitSet == null || component1BitSet == null) {
			return Stream.of();
		}

		BitSet mergeBitSet = (BitSet) component0BitSet.clone();
		mergeBitSet.and(component1BitSet);

		return mergeBitSet.stream()
				.mapToObj(index -> this.entities[index])
				.map(entity -> new Tuple2<>(
						entity.getComponent(component0),
						entity.getComponent(component1)))
				.filter(Tuple2::areNoneNull);
	}

	public <
	T0 extends HoloEntitiesComponent,
	T1 extends HoloEntitiesComponent,
	T2 extends HoloEntitiesComponent>
	Stream<Tuple3<T0, T1, T2>> getComponent(Class<T0> component0, Class<T1> component1, Class<T2> component2) {
		BitSet component0BitSet = this.components.get(component0);
		BitSet component1BitSet = this.components.get(component1);
		BitSet component2BitSet = this.components.get(component2);
		if (component0BitSet == null || component1BitSet == null || component2BitSet == null) {
			return Stream.of();
		}

		BitSet mergeBitSet = (BitSet) component0BitSet.clone();
		mergeBitSet.and(component1BitSet);
		mergeBitSet.and(component2BitSet);

		return mergeBitSet.stream()
				.mapToObj(index -> this.entities[index])
				.map(entity -> new Tuple3<>(
						entity.getComponent(component0),
						entity.getComponent(component1),
						entity.getComponent(component2)))
				.filter(Tuple3::areNoneNull);
	}

	public <
	T0 extends HoloEntitiesComponent,
	T1 extends HoloEntitiesComponent,
	T2 extends HoloEntitiesComponent,
	T3 extends HoloEntitiesComponent>
	Stream<Tuple4<T0, T1, T2, T3>> getComponent(Class<T0> component0, Class<T1> component1, Class<T2> component2, Class<T3> component3) {
		BitSet component0BitSet = this.components.get(component0);
		BitSet component1BitSet = this.components.get(component1);
		BitSet component2BitSet = this.components.get(component2);
		BitSet component3BitSet = this.components.get(component3);
		if (component0BitSet == null || component1BitSet == null || component2BitSet == null || component3BitSet == null) {
			return Stream.of();
		}

		BitSet mergeBitSet = (BitSet) component0BitSet.clone();
		mergeBitSet.and(component1BitSet);
		mergeBitSet.and(component2BitSet);
		mergeBitSet.and(component3BitSet);

		return mergeBitSet.stream()
				.mapToObj(index -> this.entities[index])
				.map(entity -> new Tuple4<>(
						entity.getComponent(component0),
						entity.getComponent(component1),
						entity.getComponent(component2),
						entity.getComponent(component3)))
				.filter(Tuple4::areNoneNull);
	}

	public <
	T0 extends HoloEntitiesComponent,
	T1 extends HoloEntitiesComponent,
	T2 extends HoloEntitiesComponent,
	T3 extends HoloEntitiesComponent,
	T4 extends HoloEntitiesComponent>
	Stream<Tuple5<T0, T1, T2, T3, T4>> getComponent(Class<T0> component0, Class<T1> component1, Class<T2> component2, Class<T3> component3, Class<T4> component4) {
		BitSet component0BitSet = this.components.get(component0);
		BitSet component1BitSet = this.components.get(component1);
		BitSet component2BitSet = this.components.get(component2);
		BitSet component3BitSet = this.components.get(component3);
		BitSet component4BitSet = this.components.get(component4);
		if (component0BitSet == null || component1BitSet == null || component2BitSet == null || component3BitSet == null
				|| component4BitSet == null) {
			return Stream.of();
		}

		BitSet mergeBitSet = (BitSet) component0BitSet.clone();
		mergeBitSet.and(component1BitSet);
		mergeBitSet.and(component2BitSet);
		mergeBitSet.and(component3BitSet);
		mergeBitSet.and(component4BitSet);

		return mergeBitSet.stream()
				.mapToObj(index -> this.entities[index])
				.map(entity -> new Tuple5<>(
						entity.getComponent(component0),
						entity.getComponent(component1),
						entity.getComponent(component2),
						entity.getComponent(component3),
						entity.getComponent(component4)))
				.filter(Tuple5::areNoneNull);
	}

	public <
	T0 extends HoloEntitiesComponent,
	T1 extends HoloEntitiesComponent,
	T2 extends HoloEntitiesComponent,
	T3 extends HoloEntitiesComponent,
	T4 extends HoloEntitiesComponent,
	T5 extends HoloEntitiesComponent>
	Stream<Tuple5<T0, T1, T2, T3, T4>> getComponent(Class<T0> component0, Class<T1> component1,
			Class<T2> component2, Class<T3> component3, Class<T4> component4, Class<T5> component5) {
		return this.getComponentIntern(component0, component1, component2, component3, component4)
				.map(entity -> new Tuple5<>(
						entity.getComponent(component0),
						entity.getComponent(component1),
						entity.getComponent(component2),
						entity.getComponent(component3),
						entity.getComponent(component4)))
				.filter(Tuple5::areNoneNull);
	}

	@SafeVarargs
	private <T> Stream<HoloEntity> getComponentIntern(Class<? extends HoloEntitiesComponent> component, Class<? extends HoloEntitiesComponent>... components) {
		BitSet firstBitSet = this.components.get(component);
		if (firstBitSet == null) {
			return Stream.of();
		}

		BitSet mergeBitSet = (BitSet) firstBitSet.clone();
		for (int i = 0; i < components.length; i++) {
			BitSet componentBitSet = this.components.get(components[i]);
			if (componentBitSet == null) {
				return Stream.of();
			}

			mergeBitSet.and(componentBitSet);
		}

		return mergeBitSet.stream().mapToObj(index -> this.entities[index]);
	}
}