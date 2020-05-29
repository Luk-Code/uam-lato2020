package pl.psi.game.converter;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.*;
import pl.psi.game.hero.HeroInfo;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBook;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {

    private EconomyHero economyHero;
    private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
    void InitializeEconomyHero()
    {
        economyHero = EconomyHero.builder().build();
        //economyHero = EconomyHero.builder().aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();
    }
    @Test
    @Disabled
    void ConvertOneEconomyCreatureToBattleCreature()
    {
        InitializeEconomyHero();
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);
        ////economyHero.addCreatureInfo(creatureInfo,creatureCount);
        Hero hero = Hero.builder().build();

        hero = HeroEcoBattleConverter.convert(economyHero);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);

        assertEquals(creature,hero.getCreatures());
    }
    @Test
    @Disabled
    //Wait for amount change method
    void ConvertStackEconomyCreatureToBattleCreature()
    {
        InitializeEconomyHero();
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);
        ////economyHero.addCreatureInfo(creatureInfo,creatureCount);
        Hero hero = Hero.builder().build();

        hero = HeroEcoBattleConverter.convert(economyHero);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);

        assertEquals(creature,hero.getCreatures().get(0));
    }
    @Test
    @Disabled
    void ConvertEconomySpellToBattleSpell()
    {
        InitializeEconomyHero();
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        ////economyHero.addCreatureInfo(creatureInfo,creatureCount);
        Hero hero = Hero.builder().build();

        hero = HeroEcoBattleConverter.convert(economyHero);
//        Spell spell = Spell.builder().build();
//        //Spell spell = SpellBook.getSpellByName(SpellBookInfoFactory.MAGIC_ARROW);
//
//        assertEquals(spell,hero.getSpells().get(0));
    }
    @Test
    @Disabled
    //Wait GetArtifact public to change converter
    void AppliedArtifactOnHeroChangeHeroStats()
    {
        InitializeEconomyHero();
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN);
        Hero hero = Hero.builder().build();

        hero = HeroEcoBattleConverter.convert(economyHero);

        //assertEquals(hero.getKnowledge(),2);
    }
    @Test
    @Disabled
    void AppliedArtifactOnHeroChangeCreatureStats()
    {
        //change later
    }
    @Test
    @Disabled
    void AppliedArtifactOnHeroChangeSpell()
    {
        //later if exist
    }
    @Test
    @Disabled
    void CheckManaConversion() {
        InitializeEconomyHero();
        ////economyHero.addCreatureInfo(creatureInfo,creatureCount);
        Hero hero = Hero.builder().build();

        hero = HeroEcoBattleConverter.convert(economyHero);

        assertEquals(10,hero.getMana());
    }

}
