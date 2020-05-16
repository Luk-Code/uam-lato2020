package pl.psi.game.hero;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.NecropolisInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EconomyHeroTest {


//   @Test
//   //TODO: you should has CreatureInfo not Creature and map, not list (CreatureInfo + amount) or some wrapper list (wrapper means another object with int amount and CreatureInfo creature)
//   // HashMap should be default choice. Also there are factories for specific races. Maciek
//   void buyCreatureShouldTakeMoney (){
//      CreatureInfo creature = NecropolisInfoFactory.getCreature(NecropolisInfoFactory.SKELETON);
//      Map<CreatureInfo, Integer> creatureMap = Map.of(creature, creature.getCost());
//      EconomyHero hero = EconomyHero.builder().creature(creature).build();
//      int creatureCost = creatureMap.get(creature);
//      int currentMoney = 1000;
//      hero.buyCreature(creature);
//      assertEquals(hero.getGold(), 950);
//   }
//    @Test
//    void addGoldShouldAddGold() {
//        EconomyHero hero = EconomyHero.builder().gold(2000).build();
//        int howMuch = 50;
//        hero.addGold(howMuch);
//        assertEquals(hero.getGold(), 2050);
//    }
////
//    @Test
//    //single creature is sufficient for test. Maciek
//    void sellCreatureShouldReturn75PercentOfOriginalPrice() {
//        CreatureInfo creature = NecropolisInfoFactory.getCreature(NecropolisInfoFactory.SKELETON);
//        EconomyHero hero = EconomyHero.builder().gold(2000).creature(creature).build();
//        //(cost of Skeleton is 60)
//        hero.sellCreature(creature);
//        //TODO as above use concrete values not calculating in assertions
//        assertEquals(hero.getGold(), 2045);
//
//    }
//
//    @Test
//    //you don't need creatures to test selling of artifacts. Could specify artifact name. Maciek
//    void sellArtifactShouldReturn75PercentOfOriginalPrice() {
//        EconomyHero hero = EconomyHero.builder().gold(3000).build();
//        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN);
//        int artifactCost = 200;
//        hero.sellArtifact(artifact);
//        assertEquals(hero.getGold(), 3150);
//
//    }
//
//    //converted spell to spellinfo. Maciek.
//    @Test
//    void sellSpellShouldReturn75PercentOfOriginalPrice() {
//        EconomyHero hero = EconomyHero.builder().gold(3000).build();
//        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
//        int spellCost = 800;
//        hero.sellSpell(spell);
//        assertEquals(hero.getGold(), 3600);
//    }
//
//    @Test
//    //don't need a list of spells. Changed methods. Maciek
//    void successBuySpell() {
//        EconomyHero hero = EconomyHero.builder().gold(3000).build();
//        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
//        hero.buySpell(spell);
//        assertEquals(hero.getGold()-spell.getCost(), 9);
//        assertEquals(hero.getSpells().size() + 1, 1);

//    }
//
//@Test
//    void buyArtifactShouldNotAddArtifactIfLocationNotEmpty(){
//
//        //DON'T KNOW HOW TO ADD SINGLE ARTIFACT IN BUILDER
//        // I just created a list of artifacts and then added it to builder
//        List<ArtifactInfo> artifacts = new ArrayList<ArtifactInfo>();
//        ArtifactInfo artifactHelmet = ArtifactsInfoFactory.getArtifact("Collar of Conjurin");
//        artifacts.add(artifactHelmet);
//        EconomyHero hero = EconomyHero.builder().artifacts(artifacts).build();
//
//        //hero state before adding artifact
//        List<ArtifactInfo> artifactsBefore = hero.getArtifacts();
//        int moneyBefore = hero.getGold();
//    //wait for artifacts group to give us getter of artifact location
//    //  List<ArtifactInfo.Location> artifactsLocationsBefore = hero.getArtifactsLocations();
//
//        //create artifact to add
//        ArtifactInfo artifactToAdd = ArtifactsInfoFactory.getArtifact("Collar of Conjurin");
//        hero.buyArtifact(artifactToAdd);
//
//        assertEquals(moneyBefore, hero.getGold() );
//        assertEquals(artifactsBefore.size(), hero.getArtifacts().size());
//        assertNotEquals(hero.getArtifact("Hellstorm Helmet"), artifactToAdd);
//}@Test
//
//    void  buyArtifactShouldAddArtifactIfLocationEmpty(){
//        //DON'T KNOW HOW TO ADD SINGLE ARTIFACT IN BUILDER
//        // I just created a list of artifacts and then added it to builder
//        List<ArtifactInfo> artifacts = new ArrayList<ArtifactInfo>();
//        ArtifactInfo artifactHelmet = ArtifactsInfoFactory.getArtifact("Collar of Conjurin");
//        artifacts.add(artifactHelmet);
//        EconomyHero hero = EconomyHero.builder().artifacts(artifacts).build();
//
//        //hero state before adding artifact
//        List<ArtifactInfo> artifactsBefore = hero.getArtifacts();
//        int moneyBefore = hero.getGold();
//        //wait for artifacts group to give us getter of artifact location
//        //  List<ArtifactInfo.Location> artifactsLocationsBefore = hero.getArtifactsLocations();
//
//        //create artifact to add
//        ArtifactInfo artifactToAdd = ArtifactsInfoFactory.getArtifact("Buckler of the Gnoll King");
//        hero.buyArtifact(artifactToAdd);
//
//        assertEquals(moneyBefore - artifactToAdd.getCost(),hero.getGold());
//        assertEquals(artifactsBefore.size()+1, hero.getArtifacts().size());
//        assertEquals(hero.getArtifact("Buckler of the Gnoll King"), artifactToAdd);
//    }



    //metody, które jeszcze trzeba przetestować:
    //
//    generateCreaturesAvailableToBuy()
//    generateSpellsAvailableToBuy()
//    buyCharacterSpecialSkill()
//    freezeShop()
//    generateShops()


}
