package charactersheetgenerator;

import charactersheetgenerator.domain.Background;
import charactersheetgenerator.domain.CharacterClass;
import charactersheetgenerator.domain.CharacterSheet;
import charactersheetgenerator.domain.Race;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CharacterSheetTest {
    
    CharacterSheet sheet;
         
    @Before
    public void setUp() {
        sheet = new CharacterSheet();
    }
    
    @Test
    public void setUpSheetCreatesRaces() {
        sheet.setUpSheet();
        assertEquals("Dwarf", sheet.getRaces().get(0).getName());
        assertTrue("Race list should not be null.", sheet.getRaces() != null);
        assertTrue("Race list should not be empty.", sheet.getRaces().size() > 0);
    }
    
    @Test
    public void racesHaveAppropriateInformation() {
        sheet.setUpSheet();
        for (Race r : sheet.getRaces()) {
            assertTrue("Race should have a name.", r.getName() != null);
            assertTrue("Race should have a speed of 30 or 25.", r.getSpeed() == 30 || r.getSpeed() == 25);
            assertTrue("Race should have at least one ability score bonus.", r.getRacialBonuses() != null);
            assertTrue("Race should have at least one trait.", r.getTraits() != null);
            assertTrue("Race should have at least one proficiecy.", r.getProficiencies() != null);
        }
    }
    
    @Test
    public void setUpSheetCreatesClasses() {
        sheet.setUpSheet();
        assertEquals("Barbarian", sheet.getClasses().get(0).getName());
        assertTrue("Class list should not be null.", sheet.getClasses() != null);
        assertTrue("Class list should not be empty.", sheet.getClasses().size() > 0);
    }
    
    @Test
    public void classesHaveAppropriateInformation() {
        sheet.setUpSheet();
        for (CharacterClass c : sheet.getClasses()) {
            assertTrue("Class should have a name.", c.getName() != null);
            assertTrue("There should be a number for the hit die.", c.getHitdie() == 6 || c.getHitdie() == 8 || c.getHitdie() == 10 || c.getHitdie() == 12);
            assertTrue("There should be a number representing the amount of skill proficiencies.", c.getSkillNumber() != null);
            assertTrue("There should be two saving throws", c.getSavingThrows().size() == 2);
            assertTrue("List of proficiencies should not be empty.", c.getProficiencies() != null);
            assertTrue("List of equipment should not be empty.", c.getEquipment() != null);
            assertTrue("List of skills should not be empty.", c.getSkills() != null);
            assertTrue("List of features should not be empty.", c.getFeatures() != null);
        }
    }
    
    @Test
    public void setUpSheetCreatesBackgrounds() {
        sheet.setUpSheet();
        assertEquals("Acolyte", sheet.getBackgrounds().get(0).getName());
        assertTrue("Backgrounds list should not be null.", sheet.getBackgrounds() != null);
        assertTrue("Backgrounds list should not be empty.", sheet.getBackgrounds().size() > 0);
    }
    
    @Test
    public void backgroundsHaveAppropriateInformation() {
        sheet.setUpSheet();
        for (Background b : sheet.getBackgrounds()) {
            assertTrue("Background should have a name.", b.getName() != null);
            assertTrue("Background should have gold pieces.", b.getGP() != null);
            assertTrue("Background should have a feature.", b.getFeature() != null);
            assertTrue("Background should have at least one proficiency.", b.getProficiencies() != null);
            assertTrue("Background should have two skill proficiencies.", b.getSkills().size() == 2);
            assertTrue("Background should have equipment.", b.getEquipment() != null);
            assertTrue("Background should have persoanlity traits.", b.getPersonalityTraits() != null);
            assertTrue("Background should have ideals.", b.getIdeals() != null);
            assertTrue("Background should have bonds.", b.getBonds() != null);
            assertTrue("Background should have flaws.", b.getFlaws() != null);
        }
    }
    
    @Test
    public void setUpSheetCreatesTheRightAlignments() {
        sheet.setUpSheet();
        assertTrue("There should be alignments on the alignment list.", sheet.getAlignments().size() == 9);
        assertEquals("Lawful Good", sheet.getAlignments().get(0));
        assertEquals("Neutral Good", sheet.getAlignments().get(1));
        assertEquals("Chaotic Good", sheet.getAlignments().get(2));
        assertEquals("Lawful Neutral", sheet.getAlignments().get(3));
        assertEquals("True Neutral", sheet.getAlignments().get(4));
        assertEquals("Chaotic Neutral", sheet.getAlignments().get(5));
        assertEquals("Lawful Evil", sheet.getAlignments().get(6));
        assertEquals("Neutral Evil", sheet.getAlignments().get(7));
        assertEquals("Chaotic Evil", sheet.getAlignments().get(8));
    }
    
    @Test
    public void pickRaceRandomlyPicksRace() {
        sheet.setUpSheet();
        String r = null;
        sheet.pickRace(r);
        assertTrue("Race should be picked.", sheet.getRace() != null);
    }
    
    @Test
    public void pickRacePicksRace() {
        sheet.setUpSheet();
        sheet.pickRace("Dwarf");
        assertEquals("Dwarf", sheet.getRace().getName());
    }
    
    @Test
    public void pickClassRandomlyPicksClass() {
        sheet.setUpSheet();
        String c = null;
        sheet.pickClass(c);
        assertTrue("Class should be picked.", sheet.getCClass() != null);
    }
    
    @Test
    public void pickClassPicksClass() {
        sheet.setUpSheet();
        sheet.pickClass("Fighter");
        assertEquals("Fighter", sheet.getCClass().getName());
    }
    
    @Test
    public void pickBackgroundRandomlyPicksBackground() {
        sheet.setUpSheet();
        String b = null;
        sheet.pickBackground(b);
        assertTrue("Background should be picked.", sheet.getBackground() != null);
    }
    
    @Test
    public void pickBackgroundPicksBackground() {
        sheet.setUpSheet();
        sheet.pickBackground("Acolyte");
        assertEquals("Acolyte", sheet.getBackground().getName());
    }
    
    @Test
    public void pickAlignmentRandomlyPicksAlignment() {
        sheet.setUpSheet();
        String a = null;
        sheet.pickAlignment(a);
        assertTrue("Alignment should be picked.", sheet.getAlignment() != null);
    }
    
    @Test
    public void pickAlignmentPicksAlignment() {
        sheet.setUpSheet();
        sheet.pickAlignment("Lawful Good");
        assertEquals("Lawful Good", sheet.getAlignment());
    }
    
    @Test
    public void generateAbilityScoresGeneratesSixRandomScoresBetween4And18() {
        sheet.generateAbilityScores();
        List<Integer> scores = sheet.getAbilityScores();
        
        assertTrue("There should be 6 numbers in the abilityScores list.", scores.size() == 6);
        
        for (int s: scores) {
            assertTrue("Ability scores should be between 4 and 18.", s >=4 && s <= 18);
        }
    }
    
    @Test
    public void generateCharacterSheetPicksRace() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        assertTrue("Race should be picked.", sheet.getRace() != null);
    }
    
    @Test
    public void generateCharacterSheetPicksClass() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        assertTrue("Class should be picked.", sheet.getCClass() != null);
    }
    
    @Test
    public void generateCharacterSheetPicksBackground() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        assertTrue("Background should be picked.", sheet.getBackground() != null);
    }
    
    @Test
    public void generateCharacterSheetPicksAlignment() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        assertTrue("Alignment should be picked.", sheet.getAlignment() != null);
    }
    
    @Test
    public void generateAbilityScoreModifiersGeneratesAppropriateModifiersForAbilityScores() {
        sheet.generateAbilityScores();
        sheet.generateAbilityScoreModifiers();
        List<Integer> scores = sheet.getAbilityScores();
        List<Integer> mods = sheet.getAbilityScoreModifiers();
        
        assertTrue("There should be 6 numbers in the abilityScoreModifiers list.", mods.size() == 6);
        
        for (int i = 0; i < 6; i++) {
            if (scores.get(i) == 4 || scores.get(i) == 5) {
                assertEquals("-3", mods.get(i).toString());
            } else if (scores.get(i) == 6 || scores.get(i) == 7) {
                assertEquals("-2", mods.get(i).toString());
            } else if (scores.get(i) == 8 || scores.get(i) == 9) {
                assertEquals("-1", mods.get(i).toString());
            } else if (scores.get(i) == 10 || scores.get(i) == 11) {
                assertEquals("0", mods.get(i).toString());
            } else if (scores.get(i) == 12 || scores.get(i) == 13) {
                assertEquals("1", mods.get(i).toString());
            } else if (scores.get(i) == 14 || scores.get(i) == 15) {
                assertEquals("2", mods.get(i).toString());
            } else if (scores.get(i) == 16 || scores.get(i) == 17) {
                assertEquals("3", mods.get(i).toString());
            } else if (scores.get(i) == 18 || scores.get(i) == 19) {
                assertEquals("4", mods.get(i).toString());
            } else if (scores.get(i) == 20){
                assertEquals("5", mods.get(i).toString());
            }
        }
    }
    
    @Test
    public void applyRacialBonusesDoesNotRaiseAbilityScoreAbove20() {
        sheet.setUpSheet();
        sheet.pickRace(null);
        sheet.generateDefaultAbilityScores(19);
        sheet.applyRacialBonuses();
        for (Integer i : sheet.getAbilityScores()) {
            assertTrue("Scores should not exceed 20.", (i <= 20));
        }
    }
    
    @Test
    public void getEquipmentReturnsStringOfEquipment() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        sheet.assignEquipment();
        assertTrue("Method should return a string which contains commas.", sheet.getEquipment().contains(","));
    }
    
    @Test
    public void getProficienciesReturnsStringOfProficiencies() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        sheet.assignProficiencies();
        assertTrue("Method should return a string which contains commas.", sheet.getProficiencies().contains(","));
    }
    @Test
    public void getTraitsAndFeaturesReturnsStringOfTraitsAndFeatures() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        sheet.assignEquipment();
        assertTrue("Method should return a string which contains line breaks.", sheet.getTraitsAndFeatures().contains("\n"));
    }
    
    @Test
    public void getCantripsGetsCantrips() {
        sheet.setUpSheet();
        sheet.generateSheet("Dwarf", "Bard", null, null);
        assertTrue("Method should return a string which contains line breaks.", sheet.getCantrips().contains("\n"));
    }
    
    @Test
    public void getLevel1SpellsGetsSpells() {
        sheet.setUpSheet();
        sheet.generateSheet("Dwarf", "Bard", null, null);
        assertTrue("Method should return a string which contains line breaks.", sheet.getLevel1Spells().contains("\n"));
    }
    
        @Test
    public void getCantripsReturnsDashIfClassHasNoCantrips() {
        sheet.setUpSheet();
        sheet.generateSheet("Dwarf", "Monk", null, null);
        assertTrue("Method should return '-'.", sheet.getCantrips().equals("-"));
    }
    
    @Test
    public void getLevel1SpellsReturnsDashIfClassHasNoSpells() {
        sheet.setUpSheet();
        sheet.generateSheet("Dwarf", "Monk", null, null);
        assertTrue("Method should return '-'.", sheet.getLevel1Spells().equals("-"));
    }
    
    @Test
    public void addRacialSpellsAddsSpell() {
        sheet.setUpSheet();
        sheet.generateSheet("Tiefling", "Monk", null, null);
        assertTrue("getCantrips() should return a racial spell.", sheet.getCantrips().equals("Thaumaturgy"));
    }
    
    @Test
    public void getRadomCharacteristicReturnsString() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        assertTrue("Method should return a String", sheet.getRandomCharacteristic(sheet.getBackground().getPersonalityTraits()).contains("."));
        assertTrue("Method should return a String", sheet.getRandomCharacteristic(sheet.getBackground().getIdeals()).contains("."));
        assertTrue("Method should return a String", sheet.getRandomCharacteristic(sheet.getBackground().getBonds()).contains("."));
        assertTrue("Method should return a String", sheet.getRandomCharacteristic(sheet.getBackground().getFlaws()).contains("."));
    }
    
    @Test
    public void generateDefaultAbilityScoresGeneratesAListOfSix10s() {
        sheet.generateDefaultAbilityScores(8);
        for (Integer i : sheet.getAbilityScores()) {
            assertTrue("Value should be 8.", i == 8);
        }
    }
    
    @Test
    public void assignProficiencyMarkersCreatesAppropriateList() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        for (String s : sheet.getProficiencyMarkers()) {
            assertTrue("Marker should either be '  ' or 'o'.", s == "  " || s == "o");
        }
    }
    
    @Test
    public void assignSavesAndSkillsAppliesBonuses() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        sheet.generateDefaultAbilityScores(10);
        sheet.generateAbilityScoreModifiers();
        sheet.assignProficiencies();
        sheet.assignProficiencyMarkers();
        sheet.assignSavesAndSkills();
        for (int i = 0; i < 24; i++) {
            assertTrue("Value should either be 0 or 2, and value 2 should correspond to 'o' in proficiency marker list", (sheet.getProficiencyMarkers().get(i) == "  " && sheet.getSavesAndSkills().get(i) == 0) || (sheet.getProficiencyMarkers().get(i) == "o" && sheet.getSavesAndSkills().get(i) == 2));
        }
    }
    
    @Test
    public void pickRaceDoesNotTryToPickIfListIsEmpty() {
        sheet.pickRace(null);
        assertTrue("", sheet.getRace() == null);
    }
    
    @Test
    public void pickClassDoesNotTryToPickIfListIsEmpty() {
        sheet.pickClass(null);
        assertTrue("", sheet.getCClass()== null);
    }
    
    @Test
    public void pickBackgroundDoesNotTryToPickIfListIsEmpty() {
        sheet.pickBackground(null);
        assertTrue("", sheet.getBackground() == null);
    }
    
    @Test
    public void pickAlignmentDoesNotTryToPickIfListIsEmpty() {
        sheet.pickAlignment(null);
        assertTrue("", sheet.getAlignment() == null);
    }
    
    @Test
    public void getRandomCharacteristicDoesNotTryToPickFromEmptyList() {
        assertEquals("", sheet.getRandomCharacteristic(new ArrayList<>()));
    }
}
