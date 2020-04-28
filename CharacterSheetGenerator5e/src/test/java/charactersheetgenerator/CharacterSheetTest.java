package charactersheetgenerator;

import charactersheetgenerator.domain.CharacterSheet;
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
    public void createRacesCreatesRaces() {
        sheet.createRaces();
        assertEquals("Hill Dwarf", sheet.getRaces().get(0).getName());
        assertTrue("Race list should not be null.", sheet.getRaces() != null);
        assertTrue("Race list should not be empty.", sheet.getRaces().size() > 0);
    }
    
    @Test
    public void createClassesCreatesClasses() {
        sheet.createClasses();
        assertEquals("Fighter", sheet.getClasses().get(0).getName());
        assertTrue("Class list should not be null.", sheet.getClasses() != null);
        assertTrue("Class list should not be empty.", sheet.getClasses().size() > 0);
    }
    
    @Test
    public void createBackgroundsCreatesBackgrounds() {
        sheet.createBackgrounds();
        assertEquals("Acolyte", sheet.getBackgrounds().get(0).getName());
        assertTrue("Backgrounds list should not be null.", sheet.getBackgrounds() != null);
        assertTrue("Backgrounds list should not be empty.", sheet.getBackgrounds().size() > 0);
    }
    
    @Test
    public void createAlignmentsCreatesTheRightAlignments() {
        sheet.createAlignments();
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
        sheet.createRaces();
        String r = null;
        sheet.pickRace(r);
        assertTrue("Race should be picked.", sheet.getRace() != null);
    }
    
    @Test
    public void pickRacePicksRace() {
        sheet.createRaces();
        sheet.pickRace("Hill Dwarf");
        assertEquals("Hill Dwarf", sheet.getRace().getName());
    }
    
    @Test
    public void pickClassRandomlyPicksClass() {
        sheet.createClasses();
        String c = null;
        sheet.pickClass(c);
        assertTrue("Class should be picked.", sheet.getCClass() != null);
    }
    
    @Test
    public void pickClassPicksClass() {
        sheet.createClasses();
        sheet.pickClass("Fighter");
        assertEquals("Fighter", sheet.getCClass().getName());
    }
    
    @Test
    public void pickBackgroundRandomlyPicksBackground() {
        sheet.createBackgrounds();
        String b = null;
        sheet.pickBackground(b);
        assertTrue("Background should be picked.", sheet.getBackground() != null);
    }
    
    @Test
    public void pickBackgroundPicksBackground() {
        sheet.createBackgrounds();
        sheet.pickBackground("Acolyte");
        assertEquals("Acolyte", sheet.getBackground().getName());
    }
    
    @Test
    public void pickAlignmentRandomlyPicksAlignment() {
        sheet.createAlignments();
        String a = null;
        sheet.pickAlignment(a);
        assertTrue("Alignment should be picked.", sheet.getAlignment() != null);
    }
    
    @Test
    public void pickAlignmentPicksAlignment() {
        sheet.createAlignments();
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
    public void eraseAbilityScoresClearsAbilityScoreAndModifierLists() {
        sheet.generateAbilityScores();
        sheet.generateAbilityScoreModifiers();
        sheet.eraseAbilityScores();
        
        assertEquals("[]", sheet.getAbilityScores().toString());
        assertEquals("[]", sheet.getAbilityScoreModifiers().toString());
    }
    
    @Test
    public void getEquipmentReturnsStringOfEquipment() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        sheet.assignEquipment();
        assertTrue("Method should return a string, which contains commas.", sheet.getEquipment().contains(","));
    }
    
    @Test
    public void getProficienciesReturnsStringOfProficiencies() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        sheet.assignProficiencies();
        assertTrue("Method should return a string, which contains commas.", sheet.getProficiencies().contains(","));
    }
    @Test
    public void getTraitsAndFeaturesReturnsStringOfTraitsAndFeatures() {
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
        sheet.assignEquipment();
        assertTrue("Method should return a string, which contains line breaks.", sheet.getTraitsAndFeatures().contains("\n"));
    }
}
