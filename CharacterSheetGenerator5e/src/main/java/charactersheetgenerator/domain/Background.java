package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents a player character's background, and stores information related to the background.
 */

public class Background {
    
    private String name;
    private Integer gp;
    private List<String> proficiencyList;
    private List<String> equipmentList;
    private List<String> skillList;
    private String feature;
    private List<String> characteristicList;
    
    public Background() {
        this.proficiencyList = new ArrayList<>();
        this.equipmentList = new ArrayList<>();
        this.skillList = new ArrayList<>();
        this.characteristicList = new ArrayList<>();
    }
    
    public void sortBackgroundInfo(String line) {
        if (line.startsWith("NAM")) {
            addName(line.substring(3));
        } else if (line.startsWith("GOP")) {
            addGP(Integer.parseInt(line.substring(3)));
        } else if (line.startsWith("FEA")) {
            setFeature(line.substring(3));
        } else if (line.startsWith("SKI")) {
            addSkill(line.substring(3));
        } else if (line.startsWith("PRO")) {
            addProficiency(line.substring(3));
        } else if (line.startsWith("EQU")) {
            addEquipment(line.substring(3));
        } else if (line.startsWith("PER") || line.startsWith("IDE") || line.startsWith("BON") || line.startsWith("FLA")) {
            addCharacteristic(line);
        }
    }
    
    public void addName(String name) {
        this.name = name;
    }
    
    public void addGP(Integer gp) {
        this.gp = gp;
    }
    
    public void addProficiency(String proficiency) {
        this.proficiencyList.add(proficiency);
    }
    
    public void addEquipment(String equipment) {
        this.equipmentList.add(equipment);
    }
    
    public void addSkill(String skill) {
        this.skillList.add(skill);
    }
    
    public void setFeature(String feature) {
        this.feature = feature;
    }
    
    public void addCharacteristic(String characteristic) {
        this.characteristicList.add(characteristic);
    }
    
    public String getName() {
        return this.name;
    }
    
    public Integer getGP() {
        return this.gp;
    }
    
    public List<String> getProficiencies() {
        return this.proficiencyList;
    }
    
    public List<String> getEquipment() {
        return this.equipmentList;
    }
    
    public List<String> getSkills() {
        return this.skillList;
    }
    
    public String getFeature() {
        return this.feature;
    }
    
    public List<String> getPersonalityTraits() {
        List<String> personalityTraits = new ArrayList<>();
        for (String p : this.characteristicList) {
            if (p.startsWith("PER")) {
                personalityTraits.add(p.substring(3));
            }
        }
        return personalityTraits;
    }
    
    public List<String> getIdeals() {
        List<String> ideals = new ArrayList<>();
        for (String i : this.characteristicList) {
            if (i.startsWith("IDE")) {
                ideals.add(i.substring(3));
            }
        }
        return ideals;
    }
    
    public List<String> getBonds() {
        List<String> bonds = new ArrayList<>();
        for (String b : this.characteristicList) {
            if (b.startsWith("BON")) {
                bonds.add(b.substring(3));
            }
        }
        return bonds;
    }
    
    public List<String> getFlaws() {
        List<String> flaws = new ArrayList<>();
        for (String f : this.characteristicList) {
            if (f.startsWith("FLA")) {
                flaws.add(f.substring(3));
            }
        }
        return flaws;
    }
}
