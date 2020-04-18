import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void putCreatureToBoard(){
        Board board = new Board();
        Creature c1 = Creature.builder().aName("C1").build();
        Creature c2 = Creature.builder().aName("C2").build();

        board.putCreature(1,1, c1);
        board.putCreature(2,2, c2);

        assertEquals(c1,board.getCreature(1,1));
        assertEquals(c2,board.getCreature(2,2));
    }
}