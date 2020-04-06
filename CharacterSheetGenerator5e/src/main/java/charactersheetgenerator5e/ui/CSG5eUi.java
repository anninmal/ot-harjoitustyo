package charactersheetgenerator5e.ui;

import charactersheetgenerator5e.domain.CharacterSheet;
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
        // start scene
        
        BorderPane startLayout = new BorderPane();
        VBox content = new VBox();
        
        Label title = new Label("Dungeons & Dragons 5e" + "\n" + "Random Character Sheet Generator");
        Label instructions = new Label("instructions here" + "\n" + "\n");
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
        
        raceChoice.getItems().add("Random");
        raceChoice.getItems().add("Dwarf");
        raceChoice.getItems().add("Elf");
        raceChoice.getItems().add("Halfling");
        raceChoice.getItems().add("Human");
        raceChoice.getItems().add("Dragonborn");
        raceChoice.getItems().add("Gnome");
        raceChoice.getItems().add("Half-Elf");
        raceChoice.getItems().add("Half-Orc");
        raceChoice.getItems().add("Tiefling");
        
        classChoice.getItems().add("Random");
        classChoice.getItems().add("Barbarian");
        classChoice.getItems().add("Bard");
        classChoice.getItems().add("Cleric");
        classChoice.getItems().add("Druid");
        classChoice.getItems().add("Fighter");
        classChoice.getItems().add("Monk");
        classChoice.getItems().add("Paladin");
        classChoice.getItems().add("Ranger");
        classChoice.getItems().add("Rogue");
        classChoice.getItems().add("Sorcerer");
        classChoice.getItems().add("Warlock");
        classChoice.getItems().add("Wizard");
        
        alignmentChoice.getItems().add("Random");
        alignmentChoice.getItems().add("Lawful Good");
        alignmentChoice.getItems().add("Neutral Good");
        alignmentChoice.getItems().add("Chaotic Good");
        alignmentChoice.getItems().add("Lawful Neutral");
        alignmentChoice.getItems().add("True Neutral");
        alignmentChoice.getItems().add("Chaotic Neutral");
        alignmentChoice.getItems().add("Lawful Evil");
        alignmentChoice.getItems().add("Neutral Evil");
        alignmentChoice.getItems().add("Chaotic Evil");
        
        backgroundChoice.getItems().add("Random");
        backgroundChoice.getItems().add("Acolyte");
        backgroundChoice.getItems().add("Charlatan");
        backgroundChoice.getItems().add("Criminal");
        backgroundChoice.getItems().add("Entertainer");
        backgroundChoice.getItems().add("Folk Hero");
        backgroundChoice.getItems().add("Guild Artisan");
        backgroundChoice.getItems().add("Hermit");
        backgroundChoice.getItems().add("Noble");
        backgroundChoice.getItems().add("Outlander");
        backgroundChoice.getItems().add("Sage");
        backgroundChoice.getItems().add("Sailor");
        backgroundChoice.getItems().add("Soldier");
        backgroundChoice.getItems().add("Urchin");
        
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
        
        generateButton.setOnMouseClicked((event) -> {
            window.setScene(sheetScene);
        });
        
        startScene = new Scene(startLayout);
        
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
        
        //placeholders will be replaced by strings taken from the class CharacterSheet once it's functional.
        Label sheetClassLabel = new Label("(Class)" + " 1");
        Label sheetBackgroundLabel = new Label("(Background)");
        Label sheetRaceLabel = new Label("(Race)");
        Label sheetAlignmentLabel = new Label("(Alignment)");
        Label sheetNameLabel = new Label(nameField.getText());
        
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
        
        Label proficiencyBonusLabel = new Label("Proficiency Bonus: 2");
        Label savingThrowsLabel = new Label("Saving Throws: ");
        Label skillsLabel = new Label("Skills: ");
        
        sheetColumn2.getChildren().add(proficiencyBonusLabel);
        sheetColumn2.getChildren().add(savingThrowsLabel);
        sheetColumn2.getChildren().add(skillsLabel);
        
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
