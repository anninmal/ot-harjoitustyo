package charactersheetgenerator;

import charactersheetgenerator.domain.CharacterSheet;
import charactersheetgenerator.domain.SheetSaver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SheetSaverTest {
    
    SheetSaver saver;
    CharacterSheet sheet;
    
    @Before
    public void setUp() {
        saver = new SheetSaver("testFile.txt");
        sheet = new CharacterSheet();
        sheet.setUpSheet();
        sheet.generateSheet(null, null, null, null);
    }
    
    @Test
    public void buildTextSheetReturnsString() {
        assertTrue("Method should return String containing line breaks.", saver.buildTextSheet(sheet, "Name", "Personality", "Ideal", "Bond", "Flaw").contains("\n"));
    }
    
    @Test
    public void saveSheetReturnsTrueOnSuccess() {
        assertTrue("Method should return true.", saver.saveSheet(sheet, "Name", "Personality", "Ideal", "Bond", "Flaw"));
    }
    
    @Test
    public void saveSheetReturnsFalseOnFailure() {
        SheetSaver badsaver = new SheetSaver("");
        assertTrue("Method should return false.", !badsaver.saveSheet(sheet, "Name", "Personality", "Ideal", "Bond", "Flaw"));
    }
}
