package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class responsible for reading necessary files and creating instances based on the information read.
 */

public class FileReader {
    
    /**
     * Method reads a race file and inserts the information it contains into Race instances, and compiles the instances into a List.
     * 
     * @param   file   File name
     * 
     * @return List of Race instances containing appropriate information
     */
    public List<Race> loadRaces(String file) {
        List<Race> raceList = new ArrayList<>();
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("START")) {
                    Race race = new Race();
                    while (!line.startsWith("STOP")) {
                        line = scanner.nextLine();
                        race.sortRaceInfo(line);
                    }
                    raceList.add(race);
                }
            }
        } catch (Exception e) {
        }
        return raceList;
    }
    
    /**
     * Method reads a class file and inserts the information it contains into CharacterClass instances, and compiles the instances into a List.
     * 
     * @param   file   File name
     * 
     * @return List of CharacterClass instances containing appropriate information
     */
    public List<CharacterClass> loadClasses(String file) {
        List<CharacterClass> cclassList = new ArrayList<>();
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("START")) {
                    CharacterClass cclass = new CharacterClass();
                    while (!line.startsWith("STOP")) {
                        line = scanner.nextLine();
                        cclass.sortClassInfo(line);
                    }
                    cclassList.add(cclass);
                }
            }
        } catch (Exception e) {
        }
        return cclassList;
    }
    
    /**
     * Method reads a background file and inserts the information it contains into Background instances, and compiles the instances into a List.
     * 
     * @param   file   File name
     * 
     * @return List of Background instances containing appropriate information
     */
    public List<Background> loadBackgrounds(String file) {
        List<Background> backgroundList = new ArrayList<>();
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("START")) {
                    Background background = new Background();
                    while (!line.startsWith("STOP")) {
                        line = scanner.nextLine();
                        background.sortBackgroundInfo(line);
                    }
                    backgroundList.add(background);
                }
            }
        } catch (Exception e) {
        }
        return backgroundList;
    }
}
