package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.List;

public class CharacterClass {
    
    private String name;
    private String hitdie;
    private List<String> proficiencylist;
    private List<String> equipmentlist;
    private List<String> skillist;
    private List<String> featurelist;
    
    public CharacterClass(String name, String hitdie) {
        this.name = name;
        this.hitdie = hitdie;
        this.proficiencylist = new ArrayList<>();
        this.equipmentlist = new ArrayList<>();
        this.skillist = new ArrayList<>();
        this.featurelist = new ArrayList<>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getHitdie() {
        return this.hitdie;
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
    
    public void addFeature(String feature) {
        this.featurelist.add(feature);
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
    
    public List<String> getFeatures() {
        return this.featurelist;
    }
}
