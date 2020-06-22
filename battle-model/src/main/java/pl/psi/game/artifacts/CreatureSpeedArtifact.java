package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;

class CreatureSpeedArtifact extends CreatureBuffArtifact{
    private final int speed;

    CreatureSpeedArtifact(int aSpeed){
        speed = aSpeed;
    }

    @Override
    void buffCreature(Creature c) {
        c.increaseMoveRange(speed);
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getMagicResistance() { return 0; }

    @Override
    public String getSpellImmunityName() { return "NONE"; }
}
