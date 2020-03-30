package charactersheetgenerator5e;

import charactersheetgenerator5e.domain.CharacterSheet;
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
        
        for (int i = 0; i <= 5; i++) {
            assertTrue("Ability scores should be between 4 and 18.", scores.get(i) >=4 && scores.get(i) <= 18);
        }
    }
}
