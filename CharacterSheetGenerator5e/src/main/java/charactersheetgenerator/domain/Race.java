package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class which represents a player character's race, and stores information related to the race.
 */

public class Race {

    private String name;
    private Integer speed;
    private List<String> traitList;
    private List<String> proficiencyList;
    private HashMap<Integer, Integer> racialBonuses;
    
    public Race() {
        this.traitList = new ArrayList<>();
        this.proficiencyList = new ArrayList<>();
        this.racialBonuses = new HashMap<>();
    }
    
    public void sortRaceInfo(String line) {
        if (line.startsWith("NAM")) {
            addName(line.substring(3));
        } else if (line.startsWith("SPE")) {
            addSpeed(Integer.parseInt(line.substring(3)));
        } else if (line.startsWith("TRA")) {
            addTrait(line.substring(3));
        } else if (line.startsWith("PRO")) {
            addProficiency(line.substring(3));
        } else if (line.startsWith("ASI")) {
            addRacialBonus(Integer.parseInt(Character.toString(line.charAt(3))), Integer.parseInt(Character.toString(line.charAt(4))));
        }
    }
    
    public void addName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void addSpeed(Integer speed) {
        this.speed = speed;
    }
    
    public int getSpeed() {
        return this.speed;
    }
    
    public List<String> getTraits() {
        return this.traitList;
    }
    
    public List<String> getProficiencies() {
        return this.proficiencyList;
    }
    
    public void addTrait(String trait) {
        this.traitList.add(trait);
    }
    
    public void addProficiency(String proficiency) {
        this.proficiencyList.add(proficiency);
    }
    
    public void addRacialBonus(Integer abilityScoreIndex, Integer bonus) {
        this.racialBonuses.put(abilityScoreIndex, bonus);
    }
    
    public HashMap<Integer, Integer> getRacialBonuses() {
        return this.racialBonuses;
    }
}
