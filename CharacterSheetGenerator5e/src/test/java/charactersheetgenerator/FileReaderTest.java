package charactersheetgenerator;

import charactersheetgenerator.domain.Background;
import charactersheetgenerator.domain.CharacterClass;
import charactersheetgenerator.domain.FileReader;
import charactersheetgenerator.domain.Race;
import java.util.List;
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
    
    @Test
    public void loadRaceLoadsRace() {
        List<Race> list = reader.loadRaces("/races/races.txt");
        assertTrue("List should not be null.", list != null);
        assertEquals("Dwarf", list.get(0).getName());
    }
    
    @Test
    public void loadClassLoadsClass() {
        List<CharacterClass> list = reader.loadClasses("/classes/classes.txt");
        assertTrue("List should not be null.", list != null);
        assertEquals("Barbarian", list.get(0).getName());
    }
    
    @Test
    public void loadBackgroundLoadsBackground() {
        List<Background> list = reader.loadBackgrounds("/backgrounds/backgrounds.txt");
        assertTrue("List should not be null.", list != null);
        assertEquals("Acolyte", list.get(0).getName());
    }
    
    @Test
    public void loadRaceExceptionResultsInNullList() {
        List<Race> list = reader.loadRaces("nothing.txt");
        assertTrue("List should be null.", list == null);
    }
    
    @Test
    public void loadClassExceptionResultsInNullList() {
        List<CharacterClass> list = reader.loadClasses("nothing.txt");
        assertTrue("List should be null.", list == null);
    }
    
    @Test
    public void loadBackgroundExceptionResultsInNullList() {
        List<Background> list = reader.loadBackgrounds("nothing.txt");
        assertTrue("List should be null.", list == null);
    }
}
