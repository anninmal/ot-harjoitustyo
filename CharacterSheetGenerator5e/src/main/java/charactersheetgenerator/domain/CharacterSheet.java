package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CharacterSheet {
    
    private Random random;
    private FileReader reader;
    private Race race;
    private CharacterClass cclass;
    private Background background;
    private String alignment;
    private List<Integer> abilityScores;
    private List<Integer> abilityScoreModifiers;
    private List<Race> raceList;
    private List<CharacterClass> cclassList;
    private List<Background> backgroundList;
    private List<String> alignmentList;
    private List<Integer> savesAndSkills;
    private List<String> equipment;
    private List<String> proficiencies;
    private List<String> features;
    private List<String> skillMarkers;
    private List<String> spells;
    
    public CharacterSheet() {
        this.random = new Random();
        this.reader = new FileReader();
        this.raceList = new ArrayList<>();
        this.cclassList = new ArrayList<>();
        this.backgroundList = new ArrayList<>();
        this.abilityScores = new ArrayList<>();
        this.abilityScoreModifiers = new ArrayList<>();
        this.alignmentList = new ArrayList<>();
        this.savesAndSkills = new ArrayList<>();
        this.equipment = new ArrayList<>();
        this.proficiencies = new ArrayList<>();
        this.features = new ArrayList<>();
        this.skillMarkers = new ArrayList<>();
        this.spells = new ArrayList<>();
    }
    
    public void setUpSheet() {
        createRaces();
        createClasses();
        createBackgrounds();
        createAlignments();
    }
    
    public void generateSheet(String race, String cclass, String background, String alignment) {
        pickRace(race);
        pickClass(cclass);
        pickBackground(background);
        pickAlignment(alignment);
        generateAbilityScores();
        applyRacialBonuses();
        generateAbilityScoreModifiers();
        assignEquipment();
        assignProficiencies();
        assignSkillMarkers();
        assignSavesAndSkills();
    }
    
    public void createRaces() {
        String[] races = {"/races/hilldwarf.txt", "/races/mountaindwarf.txt", "/races/tiefling.txt"};
        for (int i = 0; i < races.length; i++) {
            this.raceList.add(reader.loadRace(races[i]));
        }
    }
    
    public List<Race> getRaces() {
        return this.raceList;
    }
    
    public Race getRace() {
        return this.race;
    }
    
    public void createClasses() {
        String[] classes = {"/classes/fighter.txt", "/classes/rogue.txt"};
        for (int i = 0; i < classes.length; i++) {
            this.cclassList.add(reader.loadClass(classes[i]));
        }
    }
    
    public List<CharacterClass> getClasses() {
        return this.cclassList;
    }
    
    public CharacterClass getCClass() {
        return this.cclass;
    }
    
    public void createBackgrounds() {
        String[] bgs = {"/backgrounds/acolyte.txt", "/backgrounds/charlatan.txt", "/backgrounds/criminal.txt", "/backgrounds/entertainer.txt"};
        for (int i = 0; i < bgs.length; i++) {
            this.backgroundList.add(reader.loadBackground(bgs[i]));
        }
    }
    
    public List<Background> getBackgrounds() {
        return this.backgroundList;
    }
    
    public Background getBackground() {
        return this.background;
    }
    
    public void createAlignments() {
        String[] alignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
        for (int i = 0; i < 9; i++) {
            this.alignmentList.add(alignments[i]);
        }
    }
    
    public List<String> getAlignments() {
        return this.alignmentList;
    }
    
    public String getAlignment() {
        return this.alignment;
    }
    
    public void pickRace(String race) {
        this.race = null;
        if (!this.raceList.isEmpty()) {
            if (race == null) {
                int ind = this.random.nextInt(this.raceList.size());
                this.race = this.raceList.get(ind);
            } else {
                for (Race ra: this.raceList) {
                    if (ra.getName().equals(race)) {
                        this.race = ra;
                    }
                }
            }
        }
    }
    
    public void pickClass(String cclass) {
        this.cclass = null;
        if (!this.cclassList.isEmpty()) {
            if (cclass == null) {
                int ind = this.random.nextInt(this.cclassList.size());
                this.cclass = this.cclassList.get(ind);
            } else {
                for (CharacterClass cc: this.cclassList) {
                    if (cc.getName().equals(cclass)) {
                        this.cclass = cc;
                    }
                }
            }
        }
    }
    
    public void pickBackground(String background) {
        this.background = null;
        if (!this.backgroundList.isEmpty()) {
            if (background == null) {
                int ind = this.random.nextInt(this.backgroundList.size());
                this.background = this.backgroundList.get(ind);
            } else {
                for (Background bg: this.backgroundList) {
                    if (bg.getName().equals(background)) {
                        this.background = bg;
                    }
                }
            }
        }
    }
    
    public void pickAlignment(String alignment) {
        this.alignment = null;
        if (!this.alignmentList.isEmpty()) {
            if (alignment == null) {
                int ind = this.random.nextInt(this.alignmentList.size());
                this.alignment = this.alignmentList.get(ind);
            } else {
                this.alignment = alignment;
            }
        }
    }
    
    public String getRandomCharacteristic(List<String> characteristics) {
        String characteristic = "";
        if (!characteristics.isEmpty()) {
        int ind = this.random.nextInt(characteristics.size());
        characteristic = characteristics.get(ind);
        }
        return characteristic;
    }
    
    public void generateAbilityScores() {
        if (this.abilityScores != null) {
            this.abilityScores.clear();
        }
        int score = 0;
        int ind = 1;
        List<Integer> rolls = new ArrayList<>();
        while (this.abilityScores.size() < 6) {
            ind = 1;
            while (ind < 5) {
                int roll = this.random.nextInt(6) + 1;
                rolls.add(roll);
                ind++;
            }
            Collections.sort(rolls);
            rolls.remove(0);
            for (int roll: rolls) {
                score = score + roll;
            }
            this.abilityScores.add(score);
            score = 0;
            rolls.clear();
        }
    }
    
    public void applyRacialBonuses() {
        if (!this.raceList.isEmpty()) {
            if (this.race.getName().equals("Hill Dwarf")) {
                this.abilityScores.set(2, (this.abilityScores.get(2) + 2));
                this.abilityScores.set(4, (this.abilityScores.get(4) + 1));
            } else if (this.race.getName().equals("Mountain Dwarf")) {
                this.abilityScores.set(2, (this.abilityScores.get(2) + 2));
                this.abilityScores.set(4, (this.abilityScores.get(0) + 2));
            } else if (this.race.getName().equals("Tiefling")) {
                this.abilityScores.set(5, (this.abilityScores.get(5) + 2));
                this.abilityScores.set(3, (this.abilityScores.get(3) + 1));
            }
        }
    }
    
    public void generateAbilityScoreModifiers() {
        if (this.abilityScoreModifiers != null) {
            this.abilityScoreModifiers.clear();
        }
        for (int as: this.abilityScores) {
            if (as == 4 || as == 5) {
                this.abilityScoreModifiers.add(-3);
            } else if (as == 6 || as == 7) {
                this.abilityScoreModifiers.add(-2);
            } else if (as == 8 || as == 9) {
                this.abilityScoreModifiers.add(-1);
            } else if (as == 10 || as == 11) {
                this.abilityScoreModifiers.add(0);
            } else if (as == 12 || as == 13) {
                this.abilityScoreModifiers.add(1);
            } else if (as == 14 || as == 15) {
                this.abilityScoreModifiers.add(2);
            } else if (as == 16 || as == 17) {
                this.abilityScoreModifiers.add(3);
            } else if (as == 18 || as == 19) {
                this.abilityScoreModifiers.add(4);
            } else {
                this.abilityScoreModifiers.add(5);
            }
        }
    }
    
    public List<Integer> getAbilityScores() {
        return this.abilityScores;
    }
    
    public List<Integer> getAbilityScoreModifiers() {
        return this.abilityScoreModifiers;
    }
    
    public void eraseAbilityScores() {
        this.abilityScores.clear();
        this.abilityScoreModifiers.clear();
    }
    
    public void assignEquipment() {
        this.equipment.clear();
        for (String ce: this.cclass.getEquipment()) {
            this.equipment.add(ce);
        }
        for (String bge: this.background.getEquipment()) {
            this.equipment.add(bge);
        }
    }
    
    public String getEquipment() {
        String equipment = "";
        for (int i = 0; i < this.equipment.size(); i++) {
            if (i == 0) {
                equipment = equipment + this.equipment.get(i);
            } else {
                equipment = equipment + ", " + this.equipment.get(i);
            }
        }
        return equipment;
    }
    
    public void assignProficiencies() {
        this.proficiencies.clear();
        for (String bgp: this.background.getProficiencies()) {
            this.proficiencies.add(bgp);
        }
        for (String cp: this.cclass.getProficiencies()) {
            this.proficiencies.add(cp);
        }
        for (String rp: this.race.getProficiencies()) {
            this.proficiencies.add(rp);
        }
    }
    
    public String getProficiencies() {
        String proficiencies = "";
        for (int i = 0; i < this.proficiencies.size(); i++) {
            if (i == 0) {
                proficiencies = proficiencies + this.proficiencies.get(i);
            } else {
                proficiencies = proficiencies + ", " + this.proficiencies.get(i);
            }
        }
        return proficiencies;
    }
        
    public String getTraitsAndFeatures() {
        String features = "";
        for (String f: this.race.getTraits()) {
            features = features + f + "\n\n";
        }
        for (String f: this.cclass.getFeatures()) {
            features = features + f + "\n\n";
        }
        features = features + this.background.getFeature();
        return features;
    }
    
    public void assignSkillMarkers() {
        this.skillMarkers.clear();
        for (int i = 0; i < 24; i++) {
            this.skillMarkers.add("  ");
        }
        if (this.cclass.getSavingThrows().contains("Strength")) {
            this.skillMarkers.set(0, "o");
        }
        if (this.cclass.getSavingThrows().contains("Dexterity")) {
            this.skillMarkers.set(1, "o");
        }
        if (this.cclass.getSavingThrows().contains("Constitution")) {
            this.skillMarkers.set(2, "o");
        }
        if (this.cclass.getSavingThrows().contains("Intelligence")) {
            this.skillMarkers.set(3, "o");
        }
        if (this.cclass.getSavingThrows().contains("Wisdom")) {
            this.skillMarkers.set(4, "o");
        }
        if (this.cclass.getSavingThrows().contains("Charisma")) {
            this.skillMarkers.set(5, "o");
        }   
        if (this.background.getSkills().contains("Acrobatics")) {
            this.skillMarkers.set(6, "o");
        }
        if (this.background.getSkills().contains("Animal Handling")) {
            this.skillMarkers.set(7, "o");
        }
        if (this.background.getSkills().contains("Arcana")) {
            this.skillMarkers.set(8, "o");
        }
        if (this.background.getSkills().contains("Athletics")) {
            this.skillMarkers.set(9, "o");
        }
        if (this.background.getSkills().contains("Deception")) {
            this.skillMarkers.set(10, "o");
        }
        if (this.background.getSkills().contains("History")) {
            this.skillMarkers.set(11, "o");
        }
        if (this.background.getSkills().contains("Insight")) {
            this.skillMarkers.set(12, "o");
        }
        if (this.background.getSkills().contains("Intimidation")) {
            this.skillMarkers.set(13, "o");
        }
        if (this.background.getSkills().contains("Investigation")) {
            this.skillMarkers.set(14, "o");
        }
        if (this.background.getSkills().contains("Medicine")) {
            this.skillMarkers.set(15, "o");
        }
        if (this.background.getSkills().contains("Nature")) {
            this.skillMarkers.set(16, "o");
        }
        if (this.background.getSkills().contains("Perception")) {
            this.skillMarkers.set(17, "o");
        }
        if (this.background.getSkills().contains("Performance")) {
            this.skillMarkers.set(18, "o");
        }
        if (this.background.getSkills().contains("Persuasion")) {
            this.skillMarkers.set(19, "o");
        }
        if (this.background.getSkills().contains("Religion")) {
            this.skillMarkers.set(20, "o");
        }
        if (this.background.getSkills().contains("Sleight of Hand")) {
            this.skillMarkers.set(21, "o");
        }
        if (this.background.getSkills().contains("Stealth")) {
            this.skillMarkers.set(22, "o");
        }
        if (this.background.getSkills().contains("Survival")) {
            this.skillMarkers.set(23, "o");
        }
        int ind = 0;
        int ind2 = 0;
        while (ind < this.cclass.getSkillNumber()) {
            ind2 = this.random.nextInt(this.cclass.getSkills().size());
            if (!this.background.getSkills().contains(this.cclass.getSkills().get(ind2))) {
                if (this.cclass.getSkills().get(ind2).equals("Acrobatics")) {
                    this.skillMarkers.set(6, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Animal Handling")) {
                    this.skillMarkers.set(7, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Arcana")) {
                    this.skillMarkers.set(8, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Athletics")) {
                    this.skillMarkers.set(9, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Deception")) {
                    this.skillMarkers.set(10, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("History")) {
                    this.skillMarkers.set(11, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Insight")) {
                    this.skillMarkers.set(12, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Intimidation")) {
                    this.skillMarkers.set(13, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Investigation")) {
                    this.skillMarkers.set(14, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Medicine")) {
                    this.skillMarkers.set(15, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Nature")) {
                    this.skillMarkers.set(16, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Perception")) {
                    this.skillMarkers.set(17, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Performance")) {
                    this.skillMarkers.set(18, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Persuasion")) {
                    this.skillMarkers.set(19, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Religion")) {
                    this.skillMarkers.set(20, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Sleight of Hand")) {
                    this.skillMarkers.set(21, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Stealth")) {
                    this.skillMarkers.set(22, "o");
                } else if (this.cclass.getSkills().get(ind2).equals("Survival")) {
                    this.skillMarkers.set(23, "o");
                } 
                ind++;
            }
        }
    }
    
    public void assignSavesAndSkills() {
        this.savesAndSkills.clear();
        if (this.skillMarkers.get(0).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(0) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(0));
        }
        if (this.skillMarkers.get(1).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(1) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(1));
        }
        if (this.skillMarkers.get(2).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(2) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(2));
        }
        if (this.skillMarkers.get(3).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3));
        }
        if (this.skillMarkers.get(4).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4));
        }
        if (this.skillMarkers.get(5).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(5) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(5));
        }
        if (this.skillMarkers.get(6).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(1) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(1));
        }
        if (this.skillMarkers.get(7).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4));
        }
        if (this.skillMarkers.get(8).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3));
        }
        if (this.skillMarkers.get(9).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(0) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(0));
        }
        if (this.skillMarkers.get(10).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(5) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(5));
        }
        if (this.skillMarkers.get(11).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3));
        }
        if (this.skillMarkers.get(12).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4));
        }
        if (this.skillMarkers.get(13).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(5) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(5));
        }
        if (this.skillMarkers.get(14).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3));
        }
        if (this.skillMarkers.get(15).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4));
        }
        if (this.skillMarkers.get(16).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3));
        }
        if (this.skillMarkers.get(17).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4));
        }
        if (this.skillMarkers.get(18).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(5) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(5));
        }
        if (this.skillMarkers.get(19).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(5) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(5));
        }
        if (this.skillMarkers.get(20).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(3));
        }
        if (this.skillMarkers.get(21).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(1) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(1));
        }
        if (this.skillMarkers.get(22).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(1) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(1));
        }
        if (this.skillMarkers.get(23).equals("o")) {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4) + 2);
        } else {
            this.savesAndSkills.add(this.abilityScoreModifiers.get(4));
        }
    }
    
    public List<String> getSkillMarkers() {
        return this.skillMarkers;
    }
    
    public List<Integer> getSavesAndSkills() {
        return this.savesAndSkills;
    }
}
