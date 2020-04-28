package charactersheetgenerator.ui;

import charactersheetgenerator.domain.CharacterSheet;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * User interface class.
 */

public class CSG5eUi extends Application {
    private Scene startScene;
    private Scene sheetScene;
    
    private VBox fullSheet;
    private Label sheetNameLabel;
    private CharacterSheet characterSheet;
    
    @Override
    public void init() throws Exception {
        this.characterSheet = new CharacterSheet();
        this.characterSheet.setUpSheet();
    }
    
    public void createCharacterSheet() {
        HBox sheetTopField1 = new HBox(20);
        HBox sheetTopField2 = new HBox(20);
        VBox sheetColumn1 = new VBox(5);
        VBox sheetColumn2 = new VBox(5);
        VBox sheetColumn3 = new VBox(5);
        VBox sheetColumn4 = new VBox(5);
        HBox columns = new HBox(10);
        
        columns.getChildren().add(sheetColumn1);
        columns.getChildren().add(sheetColumn2);
        columns.getChildren().add(sheetColumn3);
        columns.getChildren().add(sheetColumn4);
        fullSheet.getChildren().add(sheetTopField1);
        fullSheet.getChildren().add(sheetTopField2);
        fullSheet.getChildren().add(columns);
        
        Label sheetClassLabel = new Label(this.characterSheet.getCClass().getName() + " 1");
        Label sheetBackgroundLabel = new Label(this.characterSheet.getBackground().getName());
        Label sheetRaceLabel = new Label(this.characterSheet.getRace().getName());
        Label sheetAlignmentLabel = new Label(this.characterSheet.getAlignment());
        
        sheetClassLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        sheetBackgroundLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        sheetRaceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        sheetAlignmentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        sheetNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        sheetTopField1.getChildren().add(sheetClassLabel);
        sheetTopField1.getChildren().add(sheetBackgroundLabel);
        sheetTopField1.getChildren().add(sheetNameLabel);
        sheetTopField2.getChildren().add(sheetRaceLabel);
        sheetTopField2.getChildren().add(sheetAlignmentLabel);
        
        Label strLabel = new Label("Strength");
        strLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Label dexLabel = new Label("Dexterity");
        dexLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Label conLabel = new Label("Constitution");
        conLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Label intLabel = new Label("Intelligence");
        intLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Label wisLabel = new Label("Wisdom");
        wisLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        Label chaLabel = new Label("Charisma");
        chaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        
        Label strScoreLabel = new Label("(" + characterSheet.getAbilityScores().get(0).toString() + ")");
        Label dexScoreLabel = new Label("(" + characterSheet.getAbilityScores().get(1).toString() + ")");
        Label conScoreLabel = new Label("(" + characterSheet.getAbilityScores().get(2).toString() + ")");
        Label intScoreLabel = new Label("(" + characterSheet.getAbilityScores().get(3).toString() + ")");
        Label wisScoreLabel = new Label("(" + characterSheet.getAbilityScores().get(4).toString() + ")");
        Label chaScoreLabel = new Label("(" + characterSheet.getAbilityScores().get(5).toString() + ")");
        
        Label strModLabel = new Label(characterSheet.getAbilityScoreModifiers().get(0).toString());
        Label dexModLabel = new Label(characterSheet.getAbilityScoreModifiers().get(1).toString());
        Label conModLabel = new Label(characterSheet.getAbilityScoreModifiers().get(2).toString());
        Label intModLabel = new Label(characterSheet.getAbilityScoreModifiers().get(3).toString());
        Label wisModLabel = new Label(characterSheet.getAbilityScoreModifiers().get(4).toString());
        Label chaModLabel = new Label(characterSheet.getAbilityScoreModifiers().get(5).toString());
        
        strScoreLabel.setFont(Font.font("Arial", 14));
        dexScoreLabel.setFont(Font.font("Arial", 14));
        conScoreLabel.setFont(Font.font("Arial", 14));
        intScoreLabel.setFont(Font.font("Arial", 14));
        wisScoreLabel.setFont(Font.font("Arial", 14));
        chaScoreLabel.setFont(Font.font("Arial", 14));
        
        strModLabel.setFont(Font.font("Arial", 24));
        dexModLabel.setFont(Font.font("Arial", 24));
        conModLabel.setFont(Font.font("Arial", 24));
        intModLabel.setFont(Font.font("Arial", 24));
        wisModLabel.setFont(Font.font("Arial", 24));
        chaModLabel.setFont(Font.font("Arial", 24));
        
        sheetColumn1.getChildren().add(strLabel);
        sheetColumn1.getChildren().add(strModLabel);
        sheetColumn1.getChildren().add(strScoreLabel);
        sheetColumn1.getChildren().add(dexLabel);
        sheetColumn1.getChildren().add(dexModLabel);
        sheetColumn1.getChildren().add(dexScoreLabel);
        sheetColumn1.getChildren().add(conLabel);
        sheetColumn1.getChildren().add(conModLabel);
        sheetColumn1.getChildren().add(conScoreLabel);
        sheetColumn1.getChildren().add(intLabel);
        sheetColumn1.getChildren().add(intModLabel);
        sheetColumn1.getChildren().add(intScoreLabel);
        sheetColumn1.getChildren().add(wisLabel);
        sheetColumn1.getChildren().add(wisModLabel);
        sheetColumn1.getChildren().add(wisScoreLabel);
        sheetColumn1.getChildren().add(chaLabel);
        sheetColumn1.getChildren().add(chaModLabel);
        sheetColumn1.getChildren().add(chaScoreLabel);
        
        Label proficiencyBonusLabel = new Label("PPROFICIENCY BONUS: 2");
        Label savingThrowsLabel = new Label("\nSAVING THROWS: ");
        Label savingThrows = new Label(this.characterSheet.getSkillMarkers().get(0) + " " + this.characterSheet.getSavesAndSkills().get(0) + " Strength\n" + this.characterSheet.getSkillMarkers().get(1) + " " + this.characterSheet.getSavesAndSkills().get(1) + " Dexterity\n" + this.characterSheet.getSkillMarkers().get(2) + " " + this.characterSheet.getSavesAndSkills().get(2) + " Constitution\n" + this.characterSheet.getSkillMarkers().get(3) + " " + this.characterSheet.getSavesAndSkills().get(3) + " Intelligence\n" + this.characterSheet.getSkillMarkers().get(4) + " " + this.characterSheet.getSavesAndSkills().get(4) + " Wisdom\n" + this.characterSheet.getSkillMarkers().get(5) + " " + this.characterSheet.getSavesAndSkills().get(5) + " Charisma");
        Label skillsLabel = new Label("\nSKILLS: ");
        Label skills = new Label(this.characterSheet.getSkillMarkers().get(6) + " " + this.characterSheet.getSavesAndSkills().get(6) + " Acrobatics (Dex)\n" + this.characterSheet.getSkillMarkers().get(7) + " " + this.characterSheet.getSavesAndSkills().get(7) + " Animal Handling (Wis)\n" + this.characterSheet.getSkillMarkers().get(8) + " " + this.characterSheet.getSavesAndSkills().get(8) + " Arcana (Int)\n" + this.characterSheet.getSkillMarkers().get(9) + " " + this.characterSheet.getSavesAndSkills().get(9) + " Athletics (Str)\n" + this.characterSheet.getSkillMarkers().get(10) + " " + this.characterSheet.getSavesAndSkills().get(10) + " Deception (Cha)\n" + this.characterSheet.getSkillMarkers().get(11) + " " + this.characterSheet.getSavesAndSkills().get(11) + " History (Int)\n" + this.characterSheet.getSkillMarkers().get(12) + " " + this.characterSheet.getSavesAndSkills().get(12) + " Insight (Wis)\n" + this.characterSheet.getSkillMarkers().get(13) + " " + this.characterSheet.getSavesAndSkills().get(13) + " Intimidation (Cha)\n" + this.characterSheet.getSkillMarkers().get(14) + " " + this.characterSheet.getSavesAndSkills().get(14) + " Investigation (Int)\n" + this.characterSheet.getSkillMarkers().get(15) + " " + this.characterSheet.getSavesAndSkills().get(15) + " Medicine (Wis)\n" + this.characterSheet.getSkillMarkers().get(16) + " " + this.characterSheet.getSavesAndSkills().get(16) + " Nature (Int)\n" + this.characterSheet.getSkillMarkers().get(17) + " " + this.characterSheet.getSavesAndSkills().get(17) + " Perception (Wis)\n" + this.characterSheet.getSkillMarkers().get(18) + " " + this.characterSheet.getSavesAndSkills().get(18) + " Performance (Cha)\n" + this.characterSheet.getSkillMarkers().get(19) + " " + this.characterSheet.getSavesAndSkills().get(19) + " Persuasion (Cha)\n" + this.characterSheet.getSkillMarkers().get(20) + " " + this.characterSheet.getSavesAndSkills().get(20) + " Religion (Int)\n" + this.characterSheet.getSkillMarkers().get(21) + " " + this.characterSheet.getSavesAndSkills().get(21) + " Sleight of Hand (Dex)\n" + this.characterSheet.getSkillMarkers().get(22) + " " + this.characterSheet.getSavesAndSkills().get(22) + " Stealth (Dex)\n" + this.characterSheet.getSkillMarkers().get(23) + " " + this.characterSheet.getSavesAndSkills().get(23) + " Survival (Wis)");
        Label proficienciesLabel = new Label("\nPROFICIENCIES: ");
        Text proficienciesText = new Text(this.characterSheet.getProficiencies());
        proficienciesText.setWrappingWidth(150);
        
        sheetColumn2.getChildren().add(proficiencyBonusLabel);
        sheetColumn2.getChildren().add(savingThrowsLabel);
        sheetColumn2.getChildren().add(savingThrows);
        sheetColumn2.getChildren().add(skillsLabel);
        sheetColumn2.getChildren().add(skills);
        sheetColumn2.getChildren().add(proficienciesLabel);
        sheetColumn2.getChildren().add(proficienciesText);
        
        Label armorClass = new Label("ARMOR CLASS: " + (10 + this.characterSheet.getAbilityScoreModifiers().get(1)) + " (+ armor)");
        Label intitiative = new Label("\nINITIATIVE: " + (2 + this.characterSheet.getAbilityScoreModifiers().get(1)));
        Label speed = new Label("\nSPEED: " + this.characterSheet.getRace().getSpeed());
        Label hitPoints = new Label("\nHIT POINTS: " + (this.characterSheet.getCClass().getHitdie() + this.characterSheet.getAbilityScoreModifiers().get(2)));
        Label hitDice = new Label("\nHIT DICE: 1d" + this.characterSheet.getCClass().getHitdie());
        Label equipmentLabel = new Label("\nEQUIPMENT: ");
        Text equipmentText = new Text(this.characterSheet.getEquipment());
        equipmentText.setWrappingWidth(150);
        Label currencyLabel = new Label("\nCP: \nSP: \nGP: " + this.characterSheet.getBackground().getGP() + "\nEP: \nPP: ");
        
        sheetColumn3.getChildren().add(armorClass);
        sheetColumn3.getChildren().add(intitiative);
        sheetColumn3.getChildren().add(speed);
        sheetColumn3.getChildren().add(hitPoints);
        sheetColumn3.getChildren().add(hitDice);
        sheetColumn3.getChildren().add(equipmentLabel);
        sheetColumn3.getChildren().add(equipmentText);
        sheetColumn3.getChildren().add(currencyLabel);
        
        Label personalityTraits = new Label("PERSONALITY TRAITS: ");
        Label ideals = new Label("\nIDEALS: ");
        Label bonds = new Label("\nBONDS: ");
        Label flaws = new Label("\nFLAWS: ");
        Label featuresTraits = new Label("\nFEATURES & TRAITS: ");
        Text personalityTraitsText = new Text(this.characterSheet.getRandomCharacteristic(this.characterSheet.getBackground().getPersonalityTraits()));
        Text idealsText = new Text(this.characterSheet.getRandomCharacteristic(this.characterSheet.getBackground().getIdeals()));
        Text bondsText = new Text(this.characterSheet.getRandomCharacteristic(this.characterSheet.getBackground().getBonds()));
        Text flawsText = new Text(this.characterSheet.getRandomCharacteristic(this.characterSheet.getBackground().getFlaws()));
        Text featuresTraitsText = new Text(this.characterSheet.getTraitsAndFeatures());
        personalityTraitsText.setWrappingWidth(400);
        idealsText.setWrappingWidth(400);
        bondsText.setWrappingWidth(400);
        flawsText.setWrappingWidth(400);
        featuresTraitsText.setWrappingWidth(400);
        
        sheetColumn4.getChildren().add(personalityTraits);
        sheetColumn4.getChildren().add(personalityTraitsText);
        sheetColumn4.getChildren().add(ideals);
        sheetColumn4.getChildren().add(idealsText);
        sheetColumn4.getChildren().add(bonds);
        sheetColumn4.getChildren().add(bondsText);
        sheetColumn4.getChildren().add(flaws);
        sheetColumn4.getChildren().add(flawsText);
        sheetColumn4.getChildren().add(featuresTraits);
        sheetColumn4.getChildren().add(featuresTraitsText);
    }
    
    public void redrawCharacterSheet() {
        this.fullSheet.getChildren().clear();
        createCharacterSheet();
    }
    
    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("D&D 5e Random Character Sheet Generator");
        // start scene
        BorderPane startLayout = new BorderPane();
        VBox content = new VBox();
        
        Label title = new Label("Dungeons & Dragons 5th Edition" + "\n" + "Random Character Sheet Generator");
        Label instructions = new Label("Pick race, class, alignment, and background for your character!\nOptions left empty will be randomized.\nPicking a name is optional.\n\n");
        Label nameLabel = new Label("Name:");
        Label raceLabel = new Label("Race:");
        Label classLabel = new Label("Class:");
        Label alignmentLabel = new Label("Alignment:");
        Label backgroundLabel = new Label("Background:");
        
        TextField nameField = new TextField();
        ChoiceBox raceChoice = new ChoiceBox();
        ChoiceBox classChoice = new ChoiceBox();
        ChoiceBox alignmentChoice = new ChoiceBox();
        ChoiceBox backgroundChoice = new ChoiceBox();
        
        raceChoice.getItems().add(null);
        this.characterSheet.getRaces().forEach(race-> {
            raceChoice.getItems().add(race.getName());
        }); 
        
        classChoice.getItems().add(null);
        this.characterSheet.getClasses().forEach(cclass-> {
            classChoice.getItems().add(cclass.getName());
        }); 
        
        alignmentChoice.getItems().add(null);
        this.characterSheet.getAlignments().forEach(alignment-> {
            alignmentChoice.getItems().add(alignment);
        }); 
        
        backgroundChoice.getItems().add(null);
        this.characterSheet.getBackgrounds().forEach(background-> {
            backgroundChoice.getItems().add(background.getName());
        }); 

        sheetNameLabel = new Label("");
        
        Button generateButton = new Button("Generate!");
        
        content.setSpacing(15);
        
        content.getChildren().add(title);
        content.getChildren().add(instructions);
        content.getChildren().add(nameLabel);
        content.getChildren().add(nameField);
        content.getChildren().add(raceLabel);
        content.getChildren().add(raceChoice);
        content.getChildren().add(classLabel);
        content.getChildren().add(classChoice);
        content.getChildren().add(alignmentLabel);
        content.getChildren().add(alignmentChoice);
        content.getChildren().add(backgroundLabel);
        content.getChildren().add(backgroundChoice);
        content.getChildren().add(generateButton);
        
        startLayout.setCenter(content);
        
        generateButton.setOnAction((event) -> {
            this.characterSheet.generateSheet((String) raceChoice.getValue(), (String) classChoice.getValue(), (String) backgroundChoice.getValue(), (String) alignmentChoice.getValue());
            sheetNameLabel.setText(nameField.getText());
            redrawCharacterSheet();
            window.setScene(sheetScene);
        });
        
        startScene = new Scene(startLayout);
        
        // character sheet scene
        fullSheet = new VBox(15);
        BorderPane sheetLayout = new BorderPane();
        VBox fullView = new VBox();
        HBox buttons = new HBox();
        
//        ScrollPane scrollPane = new ScrollPane();
//        scrollPane.setContent(fullSheet);
//        fullView.getChildren().add(scrollPane);
        fullView.getChildren().add(fullSheet);
        fullView.getChildren().add(buttons);
        
        Button backButton = new Button("Back");
        Button generateAgainButton = new Button("Generate!");
        Button saveButton = new Button("Save Sheet");
        
        buttons.getChildren().add(backButton);
        buttons.getChildren().add(generateAgainButton);
        buttons.getChildren().add(saveButton);
        
        backButton.setOnMouseClicked((event) -> {
            window.setScene(startScene);
        });
        
        generateAgainButton.setOnAction((event) -> {
            this.characterSheet.generateSheet((String) raceChoice.getValue(), (String) classChoice.getValue(), (String) backgroundChoice.getValue(), (String) alignmentChoice.getValue());
            redrawCharacterSheet();
        });
        
        sheetLayout.setCenter(fullView);
        sheetScene = new Scene(sheetLayout);
        
        window.setScene(startScene);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
