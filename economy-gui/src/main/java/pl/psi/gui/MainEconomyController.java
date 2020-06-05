package pl.psi.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pl.psi.game.EconomyEngine;
import pl.psi.game.hero.economyHero.EconomyHero;

import java.net.URL;
import java.util.ResourceBundle;


public class MainEconomyController {

    @FXML
    public Button buySpellButton;
    @FXML
    public Button buyArtifactButton;
    @FXML
    public Button passTurnButton;
    @FXML
    public Button buySpecialSkillButton;

    @FXML
    private Button buyCreatureButton;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    private final EconomyHero economyHero1;
    private final EconomyHero economyHero2;
    private final EconomyEngine economyEngine;

    public MainEconomyController(){
        economyHero1 = EconomyHero.builder().aGold(3000).build();
        economyHero2 = EconomyHero.builder().aGold(3000).build();
        economyEngine = new EconomyEngine(economyHero1, economyHero2);
    }


    @FXML
    private void handleBuyCreature(ActionEvent event)
    {
        System.out.println("Clicked buy creature button;");
        buyCreatureButton.setText("Buy creature button clicked");
    }


    @FXML
    private void initialize()
    {
    }

    public void handleBuySpell(ActionEvent actionEvent) {
        System.out.println("Clicked buy spell button;");
        buySpellButton.setText("Buy spell button clicked");
    }

    public void handleBuyArtifact(ActionEvent actionEvent) {
        System.out.println("Clicked buy artifact button;");
        buyArtifactButton.setText("Buy artifact button clicked");
    }

    public void handlePassTurn(ActionEvent actionEvent) {
        System.out.println("Clicked pass turn  button;");
        passTurnButton.setText("Pass turn  button clicked");
    }

    public void handleBuySpecialSkill(ActionEvent actionEvent) {
        System.out.println("Clicked buy special skill button;");
        buySpecialSkillButton.setText("Buy special skill button clicked");
    }
}
