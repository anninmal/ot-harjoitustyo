package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents a player character's class, and stores information related to the class.
 */

public class CharacterClass {
    
    private String name;
    private Integer hitdie;
    private Integer skillNumber;
    private Integer spellsKnown;
    private Integer cantripsKnown;
    private List<String> savingthrowList;
    private List<String> proficiencyList;
    private List<String> equipmentSkillsAndFeaturesList;
    private List<String> spellList;
    
    public CharacterClass() {
        this.savingthrowList = new ArrayList<>();
        this.proficiencyList = new ArrayList<>();
        this.equipmentSkillsAndFeaturesList = new ArrayList<>();
        this.spellList = new ArrayList<>();
    }
    
    public void sortClassInfo(String line) {
        if (line.startsWith("NAM")) {
            addName(line.substring(3));
        } else if (line.startsWith("SVT")) {
            addSavingThrow(line.substring(3));
        } else if (line.startsWith("PRO")) {
            addProficiency(line.substring(3));
        } else if (line.startsWith("EQU") || line.startsWith("SKI") || line.startsWith("FEA")) {
            addEquipmentSkillOrFeature(line);
        } else if (line.startsWith("HID")) {
            addHitdie(Integer.parseInt(line.substring(3)));
        } else if (line.startsWith("SKN")) {
            addSkillNumber(Integer.parseInt(line.substring(3)));
        } else if (line.startsWith("SPE")) {
            addSpell(line.substring(3));
        } else if (line.startsWith("SPK")) {
            setSpellsKnown(Integer.parseInt(line.substring(3, 4)), Integer.parseInt(line.substring(4)));
        }
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
        this.savingthrowList.add(save);
    }
    
    public void addProficiency(String proficiency) {
        this.proficiencyList.add(proficiency);
    }
    
    public void addEquipmentSkillOrFeature(String equipment) {
        this.equipmentSkillsAndFeaturesList.add(equipment);
    }
    
    public void addSpell(String spell) {
        this.spellList.add(spell);
    }
    
    public void setSpellsKnown(Integer cantrips, Integer spells) {
        this.cantripsKnown = cantrips;
        this.spellsKnown = spells;
    }
    
    public List<String> getSavingThrows() {
        return this.savingthrowList;
    }
    
    public List<String> getProficiencies() {
        return this.proficiencyList;
    }
    
    public List<String> getEquipment() {
        List<String> equipment = new ArrayList<>();
        for (String e : this.equipmentSkillsAndFeaturesList) {
            if (e.startsWith("EQU")) {
                equipment.add(e.substring(3));
            }
        }
        return equipment;
    }
    
    public List<String> getSkills() {
        List<String> skills = new ArrayList<>();
        for (String s : this.equipmentSkillsAndFeaturesList) {
            if (s.startsWith("SKI")) {
                skills.add(s.substring(3));
            }
        }
        return skills;
    }
    
    public List<String> getFeatures() {
        List<String> features = new ArrayList<>();
        for (String f : this.equipmentSkillsAndFeaturesList) {
            if (f.startsWith("FEA")) {
                features.add(f.substring(3));
            }
        }
        return features;
    }
    
    public List<String> getCantrips() {
        List<String> cantrips = new ArrayList<>();
        for (String c : this.spellList) {
            if (c.startsWith("0")) {
                cantrips.add(c);
            }
        }
        return cantrips;
    }
    
    public List<String> getSpells() {
        List<String> spells = new ArrayList<>();
        for (String s : this.spellList) {
            if (s.startsWith("1")) {
                spells.add(s);
            }
        }
        return spells;
    }
    
    public Integer getCantripsKnown() {
        return this.cantripsKnown;
    }
    
    public Integer getSpellsKnown() {
        return this.spellsKnown;
    }
}
