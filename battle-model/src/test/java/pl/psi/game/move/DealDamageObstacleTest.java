package pl.psi.game.move;

import org.junit.Test;
import pl.psi.game.fractions.Creature;
import static org.junit.jupiter.api.Assertions.*;


public class DealDamageObstacleTest {
//TODO weź popraw te testy, żeby nie używać getCurrentHp będą wtedy bardziej czytelne
    @Test
    void walkingCreatureDealDamage(){

        Creature creature = Creature.builder().aMaxHp(10).aCanFly(false).build();
        ObstacleFactory obstacleFactory = new ObstacleFactory();
        Obstacle obstacle = obstacleFactory.createObstacle("lava");

        int hp = creature.getCurrentHp();
        obstacle.apply(creature);

        assertEquals(hp - 1, creature.getCurrentHp());

    }

    @Test
    void flyingCreature(){

        Creature creature = Creature.builder().aMaxHp(10).aCanFly(false).build();
        ObstacleFactory obstacleFactory = new ObstacleFactory();
        Obstacle obstacle = obstacleFactory.createObstacle("lava");

        obstacle.apply(creature);

        assertEquals(creature.getMaxHp(), creature.getCurrentHp());

    }
}