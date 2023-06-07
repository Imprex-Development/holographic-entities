package dev.imprex.neonseer.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.imprex.holoentities.engine.HoloEntitiesComponent;
import dev.imprex.holoentities.engine.HoloEntitiesRegistry;
import dev.imprex.holoentities.engine.HoloEntity;

public class EntityRegistryTest {

    private HoloEntitiesRegistry entityRegistry;

    @BeforeEach
    public void setup() {
        entityRegistry = new HoloEntitiesRegistry();
    }

    @Test
    public void testCreateEntity() {
        HoloEntity entity = entityRegistry.createEntity();
        Assertions.assertNotNull(entity);
    }

    @Test
    public void testRemoveEntity() {
    	HoloEntity entity = entityRegistry.createEntity();
        entityRegistry.removeEntity(entity);
    }

    @Test
    public void testAddComponent() {
    	HoloEntity entity = entityRegistry.createEntity();
        ComponentA componentA = new ComponentA();

        entityRegistry.addComponent(entity, componentA);

        Assertions.assertEquals(1, entityRegistry.getComponent(ComponentA.class).count());
    }

    @Test
    public void testRemoveComponent() {
    	HoloEntity entity = entityRegistry.createEntity();
        ComponentA componentA = new ComponentA();

        entityRegistry.addComponent(entity, componentA);
        entityRegistry.removeComponent(entity, ComponentA.class);

        Assertions.assertEquals(0, entityRegistry.getComponent(ComponentA.class).count());
    }

    @Test
    public void testGetComponentSingle() {
    	HoloEntity entity = entityRegistry.createEntity();
        ComponentA componentA = new ComponentA();
        entityRegistry.addComponent(entity, componentA);

        Assertions.assertEquals(componentA, entityRegistry.getComponent(ComponentA.class).findFirst().orElse(null));
    }

    @Test
    public void testGetComponentMultiple() {
    	HoloEntity entity1 = entityRegistry.createEntity();
        HoloEntity entity2 = entityRegistry.createEntity();
        ComponentA componentA1 = new ComponentA();
        ComponentA componentA2 = new ComponentA();
        entityRegistry.addComponent(entity1, componentA1);
        entityRegistry.addComponent(entity2, componentA2);

        Assertions.assertEquals(2, entityRegistry.getComponent(ComponentA.class).count());
    }

    @Test
    public void testGetComponentTuple() {
    	HoloEntity entity1 = entityRegistry.createEntity();
        HoloEntity entity2 = entityRegistry.createEntity();
        ComponentA componentA1 = new ComponentA();
        ComponentB componentB1 = new ComponentB();
        ComponentA componentA2 = new ComponentA();
        ComponentB componentB2 = new ComponentB();
        entityRegistry.addComponent(entity1, componentA1);
        entityRegistry.addComponent(entity1, componentB1);
        entityRegistry.addComponent(entity2, componentA2);
        entityRegistry.addComponent(entity2, componentB2);

        Assertions.assertEquals(2, entityRegistry.getComponent(ComponentA.class, ComponentB.class).count());
    }


    private static class ComponentA extends HoloEntitiesComponent {}

    private static class ComponentB extends HoloEntitiesComponent {}
}