package charactersheetgenerator.ui;

import charactersheetgenerator.domain.CharacterSheet;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CSG5eUi extends Application {
    private Scene startScene;
    private Scene sheetScene;
    
    private VBox fullSheet;
    private CharacterSheet characterSheet;
    
    @Override
    public void init() throws Exception {
        this.characterSheet = new CharacterSheet();
    }
    
    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("D&D 5e Random Character Sheet Generator");
        // start scene
        
        BorderPane startLayout = new BorderPane();
        VBox content = new VBox();
        
        Label title = new Label("Dungeons & Dragons 5e" + "\n" + "Random Character Sheet Generator");
        Label instructions = new Label("Pick race, class, alignment, and background for your character!\nOptions left empty will be randomized.\nPicking a name is optional.\n[APP CURRENTLY ONLY SUPPORTS RANDOM GENERATION]\n\n");
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
        
//        raceChoice.getItems().add("Random");
        raceChoice.getItems().add("Hill Dwarf");
//        raceChoice.getItems().add("Elf");
//        raceChoice.getItems().add("Halfling");
//        raceChoice.getItems().add("Human");
//        raceChoice.getItems().add("Dragonborn");
//        raceChoice.getItems().add("Gnome");
//        raceChoice.getItems().add("Half-Elf");
//        raceChoice.getItems().add("Half-Orc");
        raceChoice.getItems().add("Tiefling");
        
//        classChoice.getItems().add("Random");
//        classChoice.getItems().add("Barbarian");
//        classChoice.getItems().add("Bard");
//        classChoice.getItems().add("Cleric");
//        classChoice.getItems().add("Druid");
        classChoice.getItems().add("Fighter");
//        classChoice.getItems().add("Monk");
//        classChoice.getItems().add("Paladin");
//        classChoice.getItems().add("Ranger");
        classChoice.getItems().add("Rogue");
//        classChoice.getItems().add("Sorcerer");
//        classChoice.getItems().add("Warlock");
//        classChoice.getItems().add("Wizard");
        
//        alignmentChoice.getItems().add("Random");
        alignmentChoice.getItems().add("Lawful Good");
        alignmentChoice.getItems().add("Neutral Good");
        alignmentChoice.getItems().add("Chaotic Good");
        alignmentChoice.getItems().add("Lawful Neutral");
        alignmentChoice.getItems().add("True Neutral");
        alignmentChoice.getItems().add("Chaotic Neutral");
        alignmentChoice.getItems().add("Lawful Evil");
        alignmentChoice.getItems().add("Neutral Evil");
        alignmentChoice.getItems().add("Chaotic Evil");
        
//        backgroundChoice.getItems().add("Random");
        backgroundChoice.getItems().add("Acolyte");
        backgroundChoice.getItems().add("Charlatan");
//        backgroundChoice.getItems().add("Criminal");
//        backgroundChoice.getItems().add("Entertainer");
//        backgroundChoice.getItems().add("Folk Hero");
//        backgroundChoice.getItems().add("Guild Artisan");
//        backgroundChoice.getItems().add("Hermit");
//        backgroundChoice.getItems().add("Noble");
//        backgroundChoice.getItems().add("Outlander");
//        backgroundChoice.getItems().add("Sage");
//        backgroundChoice.getItems().add("Sailor");
//        backgroundChoice.getItems().add("Soldier");
//        backgroundChoice.getItems().add("Urchin");

        Label sheetNameLabel = new Label("");
        
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
            //this.characterSheet.generateSheet((String) raceChoice.getValue(),(String) classChoice.getValue(),(String) backgroundChoice.getValue(),(String) alignmentChoice.getValue());
            sheetNameLabel.setText(nameField.getText());
            window.setScene(sheetScene);
        });
        
        startScene = new Scene(startLayout);
        //The method call below is temporary. it will be connected to the "Generate!" button once I figure out how to get it to work...
        this.characterSheet.generateSheet(null, null, null, null);
        
        // character sheet scene
        
        BorderPane sheetLayout = new BorderPane();
        HBox sheetTopField1 = new HBox(20);
        HBox sheetTopField2 = new HBox(20);
        VBox sheetColumn1 = new VBox(5);
        VBox sheetColumn2 = new VBox(15);
        VBox sheetColumn3 = new VBox(15);
        VBox sheetColumn4 = new VBox(15);
        HBox columns = new HBox(10);
        HBox buttons = new HBox();
        VBox fullView = new VBox();
        fullSheet = new VBox(15);
        
        columns.getChildren().add(sheetColumn1);
        columns.getChildren().add(sheetColumn2);
        columns.getChildren().add(sheetColumn3);
        columns.getChildren().add(sheetColumn4);
        fullSheet.getChildren().add(sheetTopField1);
        fullSheet.getChildren().add(sheetTopField2);
        fullSheet.getChildren().add(columns);
        fullView.getChildren().add(fullSheet);
        fullView.getChildren().add(buttons);
        
        Label sheetClassLabel = new Label(this.characterSheet.getCClass().getName() + " 1");
        Label sheetBackgroundLabel = new Label(this.characterSheet.getBackground().getName());
        Label sheetRaceLabel = new Label(this.characterSheet.getRace().getName());
        Label sheetAlignmentLabel = new Label(this.characterSheet.getAlignment());
        
        sheetTopField1.getChildren().add(sheetClassLabel);
        sheetTopField1.getChildren().add(sheetBackgroundLabel);
        sheetTopField1.getChildren().add(sheetNameLabel);
        sheetTopField2.getChildren().add(sheetRaceLabel);
        sheetTopField2.getChildren().add(sheetAlignmentLabel);
        
        Label strLabel = new Label("Strength");
        strLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 12));
        Label dexLabel = new Label("Dexterity");
        dexLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 12));
        Label conLabel = new Label("Constitution");
        conLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 12));
        Label intLabel = new Label("Intelligence");
        intLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 12));
        Label wisLabel = new Label("Wisdom");
        wisLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 12));
        Label chaLabel = new Label("Charisma");
        chaLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 12));
        
        characterSheet.generateAbilityScores();
        characterSheet.generateAbilityScoreModifiers();
        
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
        
        strScoreLabel.setFont(Font.font("Monospaced", 14));
        dexScoreLabel.setFont(Font.font("Monospaced", 14));
        conScoreLabel.setFont(Font.font("Monospaced", 14));
        intScoreLabel.setFont(Font.font("Monospaced", 14));
        wisScoreLabel.setFont(Font.font("Monospaced", 14));
        chaScoreLabel.setFont(Font.font("Monospaced", 14));
        
        strModLabel.setFont(Font.font("Monospaced", 24));
        dexModLabel.setFont(Font.font("Monospaced", 24));
        conModLabel.setFont(Font.font("Monospaced", 24));
        intModLabel.setFont(Font.font("Monospaced", 24));
        wisModLabel.setFont(Font.font("Monospaced", 24));
        chaModLabel.setFont(Font.font("Monospaced", 24));
        
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
        
        //Saves and skills are completely messed up...
        Label proficiencyBonusLabel = new Label("Proficiency Bonus: 2");
        Label savingThrowsLabel = new Label("Saving Throws: ");
        Label savingThrows = new Label(this.characterSheet.getSkillMarkers().get(0) + " " + this.characterSheet.getSavesAndSkills().get(0) + " Strength\n" + this.characterSheet.getSkillMarkers().get(1) + " " + this.characterSheet.getSavesAndSkills().get(1) + " Dexterity\n" + this.characterSheet.getSkillMarkers().get(2) + " " + this.characterSheet.getSavesAndSkills().get(2) + " Constitution\n" + this.characterSheet.getSkillMarkers().get(3) + " " + this.characterSheet.getSavesAndSkills().get(3) + " Intelligence\n" + this.characterSheet.getSkillMarkers().get(4) + " " + this.characterSheet.getSavesAndSkills().get(4) + " Wisdom\n" + this.characterSheet.getSkillMarkers().get(5) + " " + this.characterSheet.getSavesAndSkills().get(5) + " Charisma");
        Label skillsLabel = new Label("Skills: ");
        Label skills = new Label(this.characterSheet.getSkillMarkers().get(6) + " " + this.characterSheet.getSavesAndSkills().get(6) + " Acrobatics (Dex)\n" + this.characterSheet.getSkillMarkers().get(7) + " " + this.characterSheet.getSavesAndSkills().get(7) + " Animal Handling (Wis)\n" + this.characterSheet.getSkillMarkers().get(8) + " " + this.characterSheet.getSavesAndSkills().get(8) + " Arcana (Int)\n" + this.characterSheet.getSkillMarkers().get(9) + " " + this.characterSheet.getSavesAndSkills().get(9) + " Athletics (Str)\n" + this.characterSheet.getSkillMarkers().get(10) + " " + this.characterSheet.getSavesAndSkills().get(10) + " Deception (Cha)\n" + this.characterSheet.getSkillMarkers().get(11) + " " + this.characterSheet.getSavesAndSkills().get(11) + " History (Int)\n" + this.characterSheet.getSkillMarkers().get(12) + " " + this.characterSheet.getSavesAndSkills().get(12) + " Insight (Wis)\n" + this.characterSheet.getSkillMarkers().get(13) + " " + this.characterSheet.getSavesAndSkills().get(13) + " Intimidation (Cha)\n" + this.characterSheet.getSkillMarkers().get(14) + " " + this.characterSheet.getSavesAndSkills().get(14) + " Investigation (Int)\n" + this.characterSheet.getSkillMarkers().get(15) + " " + this.characterSheet.getSavesAndSkills().get(15) + " Medicine (Wis)\n" + this.characterSheet.getSkillMarkers().get(16) + " " + this.characterSheet.getSavesAndSkills().get(16) + " Nature (Int)\n" + this.characterSheet.getSkillMarkers().get(17) + " " + this.characterSheet.getSavesAndSkills().get(17) + " Perception (Wis)\n" + this.characterSheet.getSkillMarkers().get(18) + " " + this.characterSheet.getSavesAndSkills().get(18) + " Performance (Cha)\n" + this.characterSheet.getSkillMarkers().get(19) + " " + this.characterSheet.getSavesAndSkills().get(19) + " Persuasion (Cha)\n" + this.characterSheet.getSkillMarkers().get(20) + " " + this.characterSheet.getSavesAndSkills().get(20) + " Religion (Int)\n" + this.characterSheet.getSkillMarkers().get(21) + " " + this.characterSheet.getSavesAndSkills().get(21) + " Sleight of Hand (Dex)\n" + this.characterSheet.getSkillMarkers().get(22) + " " + this.characterSheet.getSavesAndSkills().get(22) + " Stealth (Dex)\n" + this.characterSheet.getSkillMarkers().get(23) + " " + this.characterSheet.getSavesAndSkills().get(23) + " Survival (Wis)");
        Label proficienciesLabel = new Label("Proficiencies: ");
        Text proficienciesText = new Text(this.characterSheet.getProficiencies());
        proficienciesText.setWrappingWidth(150);
        
        sheetColumn2.getChildren().add(proficiencyBonusLabel);
        sheetColumn2.getChildren().add(savingThrowsLabel);
        sheetColumn2.getChildren().add(savingThrows);
        sheetColumn2.getChildren().add(skillsLabel);
        sheetColumn2.getChildren().add(skills);
        sheetColumn2.getChildren().add(proficienciesLabel);
        sheetColumn2.getChildren().add(proficienciesText);
//        sheetColumn2.getChildren().add(new Label(this.characterSheet.getAbilityScoreModifiers().toString()));
        
        Label armorClass = new Label("Armor Class: ");
        Label intitiative = new Label("Intitiative: " + (2 + this.characterSheet.getAbilityScoreModifiers().get(1)));
        Label speed = new Label("Speed: " + this.characterSheet.getRace().getSpeed());
        Label hitPoints = new Label("Hit Points: " + (this.characterSheet.getCClass().getHitdie() + this.characterSheet.getAbilityScoreModifiers().get(2)));
        Label hitDice = new Label("Hit Dice: 1d" + this.characterSheet.getCClass().getHitdie());
        Label equipmentLabel = new Label("Equipment: ");
        Text equipmentText = new Text(this.characterSheet.getEquipment());
        equipmentText.setWrappingWidth(150);
        Label currencyLabel = new Label("CP: \nSP: \nGP: " + this.characterSheet.getBackground().getGP() + "\nEP: \nPP: ");
        
        sheetColumn3.getChildren().add(armorClass);
        sheetColumn3.getChildren().add(intitiative);
        sheetColumn3.getChildren().add(speed);
        sheetColumn3.getChildren().add(hitPoints);
        sheetColumn3.getChildren().add(hitDice);
        sheetColumn3.getChildren().add(equipmentLabel);
        sheetColumn3.getChildren().add(equipmentText);
        sheetColumn3.getChildren().add(currencyLabel);
        
        Label personalityTraits = new Label("Personality Traits: ");
        Label ideals = new Label("Ideals: ");
        Label bonds = new Label("Bonds: ");
        Label flaws = new Label("Flaws: ");
        Label featuresTraits = new Label("Features & Traits: ");
        Text personalityTraitsText = new Text("");
        Text idealsText = new Text("");
        Text bondsText = new Text("");
        Text flawsText = new Text("");
        Text featuresTraitsText = new Text(this.characterSheet.getTraitsAndFeatures());
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
        
        Button backButton = new Button("Back");
        Button generateAgainButton = new Button("Generate!");
        Button saveButton = new Button("Save Sheet");
        
        buttons.getChildren().add(backButton);
        buttons.getChildren().add(generateAgainButton);
        buttons.getChildren().add(saveButton);
        
        backButton.setOnMouseClicked((event) -> {
            window.setScene(startScene);
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
