package pl.psi.game.hero.economyHero;

import lombok.Builder;
import lombok.Getter;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfo;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.skills.SkillInfo;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class EconomyHero {

    private List<CreatureInfo> creatures;
    private List<ArtifactInfo> artifacts;
    private List<SpellInfo> spells;
    private List<SkillInfo> skills;
    private int gold = 2000;
    private HeroInfo heroInfo;


    @Builder
    EconomyHero(int aGold, HeroInfo aHeroInfo) {
        gold = aGold;
        creatures = new ArrayList<>();
        artifacts = new ArrayList<>();
        spells = new ArrayList<>();
        skills = new ArrayList<>();
        this.heroInfo = aHeroInfo;
    }

    void increaseGold(int gold) {

        this.gold += gold;
    }

    void decreaseGold(int gold) {

        if (gold < 0) {
            String output = "You can't decrease a negative gold";
            throw new IllegalStateException(output);
        }
        int secgold = this.getGold() - gold;

        if (secgold < 0) {
            String output = "Not enough gold to decrease";
            throw new IllegalStateException(output);
        }
        this.gold -= gold;


    }

    public boolean buyCreature(CreatureInfo creature) throws IllegalStateException {
        if (this.getGold() >= creature.getCost()) {

            this.decreaseGold(creature.getCost());
            this.creatures.add(creature);
            return true;
        } else {
            String output = String.format("Not enough gold to buy creature: %s", creature.getName());
            throw new IllegalStateException(output);
        }

    }

    void sellCreature(CreatureInfo creature) throws IllegalStateException {

        if (!this.creatures.contains(creature)) {
            String output = String.format("Hero doesn't have creature: %s", creature.getName());
            throw new IllegalStateException(output);
        }
        int sellCreatureValue = (int) (creature.getCost() * 0.75);

        this.increaseGold(sellCreatureValue);
        this.creatures.remove(creature);

    }


    public boolean buyArtifact(ArtifactInfo artifact) throws IllegalStateException {

        if (this.isSlotEmpty(artifact.getLocation().toString())) {
            String output = String.format("Location: %s is taken.", artifact.getLocation().toString());
            throw new IllegalStateException(output);

        }

        if (this.getGold() >= artifact.getCost()) {
            this.decreaseGold(artifact.getCost());
            this.artifacts.add(artifact);
            return true;

        } else {
            String output = String.format("Not enough gold to buy %s", artifact.getName());
            throw new IllegalStateException(output);


        }


    }
    public boolean buyArt(ArtifactInfo artifact) throws IllegalStateException{
        return true;
    }

    void sellArtifact(ArtifactInfo artifact) throws IllegalStateException {
        if (!this.artifacts.contains(artifact)) {
            String output = String.format("Hero doesn't have artifact: %s", artifact.getName());
            throw new IllegalStateException(output);
        }
        int sellArtifactValue = (int) (artifact.getCost() * 0.75);
        this.increaseGold(sellArtifactValue);
        this.artifacts.remove(artifact);
    }


    boolean isSlotEmpty(String location) {
        return this.artifacts.stream().anyMatch(artifact -> artifact.getLocation().toString().equals(location));
    }


    ArtifactInfo getArtifact(String name) {
        return this.artifacts.stream().filter(artifact -> artifact.getName().equals(name)).findAny().orElse(null);
    }


    ArtifactInfo getArtifactByLocation(ArtifactInfo.Location location) {
        return this.artifacts.stream().filter(artifact -> artifact.getLocation() == location).findAny().orElseThrow();
    }


    public void sellSpell(SpellInfo spell) throws IllegalStateException {
        if (!this.spells.contains(spell)) {
            String output = String.format("Hero doesn't have spell: %s", spell.getName());
            throw new IllegalStateException(output);
        }
        int sellSpellValue = (int) (spell.getCost() * 0.75);
        this.increaseGold(sellSpellValue);
        this.spells.remove(spell);
    }

    public boolean buySpell(SpellInfo spell) throws IllegalStateException {
        if (this.spells.contains(spell)) {
            String output = String.format("Hero has got this spell %s ", spell.getName());
            throw new IllegalStateException(output);
        }
        if (getGold() >= spell.getCost()) {
            this.decreaseGold(spell.getCost());
            this.spells.add(spell);
            return true;
        }
        return false;
    }


    public boolean buySkill(SkillInfo skill) throws IllegalStateException {
        if (this.skills.contains(skill)) {
            String output = String.format("Hero has got this skill %s ", skill.getName());
            throw new IllegalStateException(output);
        }
        if (getGold() >= skill.getCost()) {
            this.decreaseGold(skill.getCost());
            this.skills.add(skill);
            return true;
        }
        return false;
    }


    public List<SpellInfo> getSpells() {
        return this.spells;
    }

    public List<ArtifactInfo> getArtifacts() {
        return this.artifacts;
    }

    public List<CreatureInfo> getCreatures() {
        return this.creatures;
    }

    public List<SkillInfo> getSkills() {
        return this.skills;
    }


    List<ArtifactInfo.Location> getArtifactsLocations() {
        return this.artifacts.stream().map(ArtifactInfo::getLocation).collect(Collectors.toList());
    }

    void addCreature(CreatureInfo creature) {
        this.creatures.add(creature);
    }

    void addArtifact(ArtifactInfo artifact) {
        this.artifacts.add(artifact);
    }

    void addSpell(SpellInfo spell) {
        this.spells.add(spell);
    }

    void addSkill(SkillInfo skill) {
        this.skills.add(skill);
    }


    //methods from heroInfo

    FractionsInfoAbstractFactory.Fractions getFraction() {
        return heroInfo.getFraction();
    }

    HeroInfo getHeroInfo() {
        return heroInfo;
    }

    String getName() {
        return this.heroInfo.getName();
    }

    public int getAttack() {
        System.out.println("I am in the getAttack");
        return this.heroInfo.getAttack();
    }

    public int getDefence() {
        return this.heroInfo.getDefence();
    }

    public int getPower() {
        return this.heroInfo.getPower();
    }

    public int getKnowledge() {
        return this.heroInfo.getKnowledge();
    }

}
