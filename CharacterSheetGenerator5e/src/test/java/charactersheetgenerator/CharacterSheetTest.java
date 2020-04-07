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
    public void generateAbilityScoresGeneratesSixRandomScoresBetween4And18() {
        sheet.generateAbilityScores();
        List<Integer> scores = sheet.getAbilityScores();
        
        assertTrue("There should be 6 numbers in the abilityScores list.", scores.size() == 6);
        
        for (int s: scores) {
            assertTrue("Ability scores should be between 4 and 18.", s >=4 && s <= 18);
        }
    }
    
    @Test
    public void generateAbilityScoreModifiersGeneratesAppropriateModifiersForAbilityScores() {
        sheet.generateAbilityScores();
        sheet.generateAbilityScoreModifiers();
        List<Integer> scores = sheet.getAbilityScores();
        List<Integer> mods = sheet.getAbilityScoreModifiers();
        
        assertTrue("There should be 6 numbers in the abilityScoreModifiers list.", mods.size() == 6);
        
        for (int i = 0; i <= 5; i++) {
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
}
