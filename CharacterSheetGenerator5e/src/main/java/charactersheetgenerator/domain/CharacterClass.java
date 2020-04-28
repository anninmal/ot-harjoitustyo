package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.List;

public class CharacterClass {
    
    private String name;
    private Integer hitdie;
    private Integer skillNumber;
    private List<String> savingthrowlist;
    private List<String> proficiencylist;
    private List<String> equipmentlist;
    private List<String> skillist;
    private List<String> featurelist;
    
    public CharacterClass(String name, Integer hitdie, Integer skillNumber) {
        this.name = name;
        this.hitdie = hitdie;
        this.skillNumber = skillNumber;
        this.savingthrowlist = new ArrayList<>();
        this.proficiencylist = new ArrayList<>();
        this.equipmentlist = new ArrayList<>();
        this.skillist = new ArrayList<>();
        this.featurelist = new ArrayList<>();
    }
    
    public CharacterClass() {
        this.savingthrowlist = new ArrayList<>();
        this.proficiencylist = new ArrayList<>();
        this.equipmentlist = new ArrayList<>();
        this.skillist = new ArrayList<>();
        this.featurelist = new ArrayList<>();
    }
    
    public void addName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void addHitdie(Integer hitdie) {
        this.hitdie = hitdie;
    }
    
    public Integer getHitdie() {
        return this.hitdie;
    }
    
    public void addSkillNumber(Integer skillnumber) {
        this.skillNumber = skillnumber;
    }
    
    public Integer getSkillNumber() {
        return this.skillNumber;
    }
    
    public void addSavingThrow(String save) {
        this.savingthrowlist.add(save);
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
    
    public List<String> getSavingThrows() {
        return this.savingthrowlist;
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
