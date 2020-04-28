package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents a player character's race, and stores information related to the race.
 */

public class Race {

    private String name;
    private Integer speed;
    private List<String> traitlist;
    private List<String> proficiencylist;
    
    public Race() {
        this.traitlist = new ArrayList<>();
        this.proficiencylist = new ArrayList<>();
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
        return this.traitlist;
    }
    
    public List<String> getProficiencies() {
        return this.proficiencylist;
    }
    
    public void addTrait(String trait) {
        this.traitlist.add(trait);
    }
    
    public void addProficiency(String proficiency) {
        this.proficiencylist.add(proficiency);
    }
}
