package charactersheetgenerator.domain;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Class responsible for formatting and writing text files.
 */

public class SheetSaver {
    
    private String path;
    
    public SheetSaver(String filePath) {
        this.path = filePath;
    }
    
    /**
     * Method that calls for a formatted String to be written to a file.
     * 
     * @param   sheet   Character sheet to format
     * @param   name   Name of the character
     * @param   personalityTrait   The character's personality trait
     * @param   ideal   The character's ideal
     * @param   bond   The character's bond
     * @param   flaw   The character's flaw
     * @return   boolean value denoting success (true) or failure (false)
     */
    public boolean saveSheet(CharacterSheet sheet, String name, String personalityTrait, String ideal, String bond, String flaw) {
        try {
            writeToFile(buildTextSheet(sheet, name, personalityTrait, ideal, bond, flaw));
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    /**
     * Method formats a String based on the given information
     * 
     * @param   sheet   Character sheet to format
     * @param   name   Name of the character
     * @param   personalityTrait   The character's personality trait
     * @param   ideal   The character's ideal
     * @param   bond   The character's bond
     * @param   flaw   The character's flaw
     * @return 
     */
    public String buildTextSheet(CharacterSheet sheet, String name, String personalityTrait, String ideal, String bond, String flaw) {
        String sheetText = name + "\n" + sheet.getRace().getName() + " | " + sheet.getCClass().getName() + " 1\n" + sheet.getBackground().getName() + " | " + sheet.getAlignment() + "\n\n" + 
                "STR " + sheet.getAbilityScores().get(0) + " [" + sheet.getAbilityScoreModifiers().get(0) + "] / DEX " + sheet.getAbilityScores().get(1) + " [" + sheet.getAbilityScoreModifiers().get(1) + "] / CON " + sheet.getAbilityScores().get(2) + " [" + sheet.getAbilityScoreModifiers().get(2) + "] / INT " + sheet.getAbilityScores().get(3) + " [" + sheet.getAbilityScoreModifiers().get(3) + "] / WIS " + sheet.getAbilityScores().get(4) + " [" + sheet.getAbilityScoreModifiers().get(4) + "] / CHA " + sheet.getAbilityScores().get(5) + " [" + sheet.getAbilityScoreModifiers().get(5) + "]\n\n" +
                "Hit Points: " + (sheet.getCClass().getHitdie() + sheet.getAbilityScoreModifiers().get(2)) + "\nHit Dice: 1d" + sheet.getCClass().getHitdie() + "\n\nProficiency Bonus: 2\nArmor Class: " + (10 + sheet.getAbilityScoreModifiers().get(1)) + " (+ armor)\nInitiative: " + (2 + sheet.getAbilityScoreModifiers().get(1)) + "\nSpeed: " + sheet.getRace().getSpeed() +
                "\n\nSaving Throws:\n" + sheet.getProficiencyMarkers().get(0) + " " + sheet.getSavesAndSkills().get(0) + " Strength\n" + sheet.getProficiencyMarkers().get(1) + " " + sheet.getSavesAndSkills().get(1) + " Dexterity\n" + sheet.getProficiencyMarkers().get(2) + " " + sheet.getSavesAndSkills().get(2) + " Constitution\n" + sheet.getProficiencyMarkers().get(3) + " " + sheet.getSavesAndSkills().get(3) + " Intelligence\n" + sheet.getProficiencyMarkers().get(4) + " " + sheet.getSavesAndSkills().get(4) + " Wisdom\n" + sheet.getProficiencyMarkers().get(5) + " " + sheet.getSavesAndSkills().get(5) + " Charisma\n\nSkills:\n" +
                sheet.getProficiencyMarkers().get(6) + " " + sheet.getSavesAndSkills().get(6) + " Acrobatics (Dex)\n" + sheet.getProficiencyMarkers().get(7) + " " + sheet.getSavesAndSkills().get(7) + " Animal Handling (Wis)\n" + sheet.getProficiencyMarkers().get(8) + " " + sheet.getSavesAndSkills().get(8) + " Arcana (Int)\n" + sheet.getProficiencyMarkers().get(9) + " " + sheet.getSavesAndSkills().get(9) + " Athletics (Str)\n" + sheet.getProficiencyMarkers().get(10) + " " + sheet.getSavesAndSkills().get(10) + " Deception (Cha)\n" + sheet.getProficiencyMarkers().get(11) + " " + sheet.getSavesAndSkills().get(11) + " History (Int)\n" + 
                sheet.getProficiencyMarkers().get(12) + " " + sheet.getSavesAndSkills().get(12) + " Insight (Wis)\n" + sheet.getProficiencyMarkers().get(13) + " " + sheet.getSavesAndSkills().get(13) + " Intimidation (Cha)\n" + sheet.getProficiencyMarkers().get(14) + " " + sheet.getSavesAndSkills().get(14) + " Investigation (Int)\n" + sheet.getProficiencyMarkers().get(15) + " " + sheet.getSavesAndSkills().get(15) + " Medicine (Wis)\n" + sheet.getProficiencyMarkers().get(16) + " " + sheet.getSavesAndSkills().get(16) + " Nature (Int)\n" + sheet.getProficiencyMarkers().get(17) + " " + sheet.getSavesAndSkills().get(17) + " Perception (Wis)\n" + 
                sheet.getProficiencyMarkers().get(18) + " " + sheet.getSavesAndSkills().get(18) + " Performance (Cha)\n" + sheet.getProficiencyMarkers().get(19) + " " + sheet.getSavesAndSkills().get(19) + " Persuasion (Cha)\n" + sheet.getProficiencyMarkers().get(20) + " " + sheet.getSavesAndSkills().get(20) + " Religion (Int)\n" + sheet.getProficiencyMarkers().get(21) + " " + sheet.getSavesAndSkills().get(21) + " Sleight of Hand (Dex)\n" + sheet.getProficiencyMarkers().get(22) + " " + sheet.getSavesAndSkills().get(22) + " Stealth (Dex)\n" + sheet.getProficiencyMarkers().get(23) + " " + sheet.getSavesAndSkills().get(23) + " Survival (Wis)" + 
                "\n\nProficiencies:\n" + sheet.getProficiencies() + "\n\nEquipment:\n" + sheet.getEquipment() + "\n\nCP:\nSP:\nGP: " + sheet.getBackground().getGP() + "\nEP:\nPP:\n\nPersonality Traits:\n" + personalityTrait + "\n\nIdeals:\n" + ideal + "\n\nBonds:\n" + bond + "\n\nFlaws:\n" + flaw + "\n\nFeatures & Traits:\n" + sheet.getTraitsAndFeatures() + "\n\nSpells:\n0:\n" + sheet.getCantrips() + "\n\n1:\n" + sheet.getLevel1Spells();
        return sheetText;
    }
    
    /**
     * Method responsible for writing the file
     * 
     * @param   textLine   String to write
     * @throws IOException 
     */
    public void writeToFile(String textLine) throws IOException {
        FileWriter writer = new FileWriter(this.path, false);
        PrintWriter printLine = new PrintWriter(writer);
        printLine.printf("%s" , textLine);
        printLine.close();
    }
}
