package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents a player character's background, and stores information related to the background.
 */

public class Background {
    
    private String name;
    private Integer gp;
    private List<String> proficiencylist;
    private List<String> equipmentlist;
    private List<String> skillist;
    private String feature;
    private List<String> personalitylist;
    private List<String> ideallist;
    private List<String> bondlist;
    private List<String> flawlist;
    
    public Background() {
        this.proficiencylist = new ArrayList<>();
        this.equipmentlist = new ArrayList<>();
        this.skillist = new ArrayList<>();
        this.personalitylist = new ArrayList<>();
        this.ideallist = new ArrayList<>();
        this.bondlist = new ArrayList<>();
        this.flawlist = new ArrayList<>();
    }
    
    public void addName(String name) {
        this.name = name;
    }
    
    public void addGP(Integer gp) {
        this.gp = gp;
    }
    
    public void addProficiency(String proficiency) {
        this.proficiencylist.add(proficiency);
    }
    
    public void addEquipment(String equipment) {
        this.equipmentlist.add(equipment);
    }
    
    public void addSkill(String skill) {
        this.skillist.add(skill);
    }
    
    public void setFeature(String feature) {
        this.feature = feature;
    }
    
    public void addPersonalityTrait(String personalitytrait) {
        this.personalitylist.add(personalitytrait);
    }
    
    public void addIdeal(String ideal) {
        this.ideallist.add(ideal);
    }
    
    public void addBond(String bond) {
        this.bondlist.add(bond);
    }
    
    public void addFlaw(String flaw) {
        this.flawlist.add(flaw);
    }
    
    public String getName() {
        return this.name;
    }
    
    public Integer getGP() {
        return this.gp;
    }
    
    public List<String> getProficiencies() {
        return this.proficiencylist;
    }
    
    public List<String> getEquipment() {
        return this.equipmentlist;
    }
    
    public List<String> getSkills() {
        return this.skillist;
    }
    
    public String getFeature() {
        return this.feature;
    }
    
    public List<String> getPersonalityTraits() {
        return this.personalitylist;
    }
    
    public List<String> getIdeals() {
        return this.ideallist;
    }
    
    public List<String> getBonds() {
        return this.bondlist;
    }
    
    public List<String> getFlaws() {
        return this.flawlist;
    }
}
