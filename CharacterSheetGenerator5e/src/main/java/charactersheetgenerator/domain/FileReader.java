package charactersheetgenerator.domain;

import java.util.Scanner;

public class FileReader {
    
    public Race loadRace(String file) {
        Race race = new Race();
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("NAM")) {
                    race.addName(line.substring(3));
                } else if (line.startsWith("SPE")) {
                    race.addSpeed(Integer.parseInt(line.substring(3)));
                } else if (line.startsWith("TRA")) {
                    race.addTrait(line.substring(3));
                } else if (line.startsWith("PRO")) {
                    race.addProficiency(line.substring(3));
                }
            }
        } catch (Exception e) {
        }
        return race;
    }
    
    public CharacterClass loadClass(String file) {
        CharacterClass cclass = new CharacterClass();
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("NAM")) {
                    cclass.addName(line.substring(3));
                } else if (line.startsWith("HID")) {
                    cclass.addHitdie(Integer.parseInt(line.substring(3)));
                } else if (line.startsWith("SKN")) {
                    cclass.addSkillNumber(Integer.parseInt(line.substring(3)));
                } else if (line.startsWith("SVT")) {
                    cclass.addSavingThrow(line.substring(3));
                } else if (line.startsWith("PRO")) {
                    cclass.addProficiency(line.substring(3));
                } else if (line.startsWith("EQU")) {
                    cclass.addEquipment(line.substring(3));
                } else if (line.startsWith("SKI")) {
                    cclass.addSkill(line.substring(3));
                } else if (line.startsWith("FEA")) {
                    cclass.addFeature(line.substring(3));
                }
            }
        } catch (Exception e) {
        }
        return cclass;
    }
    
    public Background loadBackground(String file) {
        Background background = new Background();
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("NAM")) {
                    background.addName(line.substring(3));
                } else if (line.startsWith("GOP")) {
                    background.addGP(Integer.parseInt(line.substring(3)));
                } else if (line.startsWith("FEA")) {
                    background.setFeature(line.substring(3));
                } else if (line.startsWith("SKI")) {
                    background.addSkill(line.substring(3));
                } else if (line.startsWith("PRO")) {
                    background.addProficiency(line.substring(3));
                } else if (line.startsWith("EQU")) {
                    background.addEquipment(line.substring(3));
                } else if (line.startsWith("PER")) {
                    background.addPersonalityTrait(line.substring(3));
                } else if (line.startsWith("IDE")) {
                    background.addIdeal(line.substring(3));
                } else if (line.startsWith("BON")) {
                    background.addBond(line.substring(3));
                } else if (line.startsWith("FLA")) {
                    background.addFlaw(line.substring(3));
                }
            }
        } catch (Exception e) {
        }
        return background;
    }
}
