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
import javafx.stage.Stage;

public class CSG5eUi extends Application {
    
    private CharacterSheet characterSheet;
    
    @Override
    public void init() throws Exception {
        this.characterSheet = new CharacterSheet();
    }
    
    @Override
    public void start(Stage window) throws Exception {
        // start scene
        
        BorderPane layout = new BorderPane();
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
        
        layout.setCenter(content);
        
        generateButton.setOnMouseClicked((event) -> {
            
        });
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
