package charactersheetgenerator;

import charactersheetgenerator.domain.Background;
import charactersheetgenerator.domain.CharacterClass;
import charactersheetgenerator.domain.FileReader;
import charactersheetgenerator.domain.Race;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {
    
    FileReader reader;
    
    @Before
    public void setUp() {
        reader = new FileReader();
    }
    
//    @Test
//    public void loadRaceLoadsRace() {
//        Race dwarf = reader.loadRaces("/races/races.txt");
//        assertTrue("Race should not be null.", dwarf != null);
//        assertEquals("Hill Dwarf", dwarf.getName());
//    }
//    
//    @Test
//    public void loadClassLoadsClass() {
//        CharacterClass fighter = reader.loadClasses("/classes/fighter.txt");
//        assertTrue("Race should not be null.", fighter != null);
//        assertEquals("Fighter", fighter.getName());
//    }
//    
//    @Test
//    public void loadBackgroundLoadsBackground() {
//        Background acolyte = reader.loadBackground("/backgrounds/acolyte.txt");
//        assertTrue("Race should not be null.", acolyte != null);
//        assertEquals("Acolyte", acolyte.getName());
//    } 
}
