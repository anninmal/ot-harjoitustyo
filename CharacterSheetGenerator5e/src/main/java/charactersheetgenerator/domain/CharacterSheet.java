package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Class responsible for storing, creating, and processing information related to the player character.
 */

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
    
    /**
    * Initial setup which stores the needed information for race, class, background, and alignment.
    */
    public void setUpSheet() {
        createRaces();
        createClasses();
        createBackgrounds();
        createAlignments();
    }
    
    /**
     * Calls methods which randomize and pick the necessary information for the player character.
     * 
     * @param   race   Name of desired race
     * @param   cclass   Name of desired class
     * @param   background   Name of desired background
     * @param   alignment   Name of desired alignment
     */
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
        assignProficiencyMarkers();
        assignSavesAndSkills();
        assignSpells();
    }
    
    /**
     * Method calls for the race file to be read and stores the created instances in a list.
     */
    public void createRaces() {
        this.raceList = reader.loadRaces("/races/races.txt");
    }
    
    public List<Race> getRaces() {
        return this.raceList;
    }
    
    public Race getRace() {
        return this.race;
    }
    
    /**
     * Method calls for the class file to be read and stores the created instances in a list.
     */
    public void createClasses() {
        this.cclassList = reader.loadClasses("/classes/classes.txt");
    }
    
    public List<CharacterClass> getClasses() {
        return this.cclassList;
    }
    
    public CharacterClass getCClass() {
        return this.cclass;
    }
    
    /**
     * Method calls for the background file to be read and stores the created instances in a list.
     */
    public void createBackgrounds() {
        this.backgroundList = reader.loadBackgrounds("/backgrounds/backgrounds.txt");
    }
    
    public List<Background> getBackgrounds() {
        return this.backgroundList;
    }
    
    public Background getBackground() {
        return this.background;
    }
    
    /**
     * Method creates a list of alignments.
     */
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
    
    /**
     * Method sets the race in accordance with the name given, or picks race randomly if parameter is null.
     * 
     * @param   race   Name of desired race
     */
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
    
    /**
     * Method sets the class in accordance with the name given, or picks class randomly if parameter is null.
     * 
     * @param   cclass   Name of desired class
     */
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
    
    /**
     * Method sets the background in accordance with the name given, or picks background randomly if parameter is null.
     * 
     * @param   background   Name of desired background
     */
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
    
    /**
     * Method sets the alignment in accordance with the name given, or picks alignment randomly if parameter is null.
     * 
     * @param   alignment   Name of desired alignment
     */
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
    
    /**
     * Method returns random characteristic from given list.
     * 
     * @param   characteristics   List of characteristics
     * 
     * @return randomly chosen characteristic
     */
    public String getRandomCharacteristic(List<String> characteristics) {
        String characteristic = "";
        if (!characteristics.isEmpty()) {
            int ind = this.random.nextInt(characteristics.size());
            characteristic = characteristics.get(ind);
        }
        return characteristic;
    }
    
    /**
     * Method clears any existing ability scores, then rolls new ability scores.
     */
    public void generateAbilityScores() {
        this.abilityScores.clear();
        List<Integer> rolls = new ArrayList<>();
        rollAbilityScores(rolls);
    }
    
    /**
     * Method generates 6 random ability scores based on 4 randomly generated numbers from 1 to 6,
     * with the smallest number removed and the remaining 3 added together, and stores the numbers in a list variable.
     * 
     * @param   rolls   List to store rolls in
     */
    public void rollAbilityScores(List<Integer> rolls) {
        int score = 0;
        int ind = 1;
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
    
    /**
     * Method clears any existing ability scores, then assigns a default value of 10 to all ability scores,
     * method is intended for testing purposes.
     */
    public void generateDefaultAbilityScores() {
        this.abilityScores.clear();
        for (int i = 0; i < 6; i++) {
            this.abilityScores.add(10);
        }
    }
    
    /**
     * Method applies the appropriate ability score bonuses for each race.
     */
    public void applyRacialBonuses() {
        if (this.race.getRacialBonuses() != null) {
            for (Integer ind : this.race.getRacialBonuses().keySet()) {
                this.abilityScores.set(ind, this.abilityScores.get(ind) + this.race.getRacialBonuses().get(ind));
                if (this.abilityScores.get(ind) > 20) {
                    this.abilityScores.set(ind, 20);
                }
            }    
        }
    }
    
    /**
     * Method generates appropriate ability score modifiers based on previously generated ability scores,
     * and stores them in a list variable.
     */
    public void generateAbilityScoreModifiers() {
        this.abilityScoreModifiers.clear();
        int listInd = 0;
        int scoreInd = 4;
        int modInd = -3;
        while (listInd < 6) {
            scoreInd = 4;
            modInd = -3;
            while (scoreInd <= 20) {
                if (this.abilityScores.get(listInd) == scoreInd) {
                    this.abilityScoreModifiers.add(modInd);
                } else if (this.abilityScores.get(listInd) == (scoreInd + 1)) {
                    this.abilityScoreModifiers.add(modInd);
                }
                scoreInd = scoreInd + 2;
                modInd++;
            }
            listInd++;
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
    
    /**
     * Method gets equipment from both class and background and stores them in one list.
     */
    public void assignEquipment() {
        this.equipment.clear();
        for (String ce: this.cclass.getEquipment()) {
            this.equipment.add(ce);
        }
        for (String bge: this.background.getEquipment()) {
            this.equipment.add(bge);
        }
    }
    
    /**
     * Method returns a string of the character's equipment, with appropriate comma placement.
     * 
     * @return String of the character's equipment
     */
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
    
    /**
     * Method gets equipment from background, class and race, and stores them in one list.
     */
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
    
    /**
     * Method returns a string of the character's proficiencies, with appropriate comma placement.
     * 
     * @return String of the character's proficiencies
     */
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
        
    /**
     * Method returns a string of the character's traits and features, with appropriate comma spacing.
     * 
     * @return String of the character's traits and features
     */
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
    
    public void assignSpells() {
        this.spells.clear();
        if (this.cclass.getCantripsKnown() != null) {
            for (int i = 0; i < this.cclass.getCantripsKnown();) {
                int ind = this.random.nextInt(this.cclass.getCantrips().size());
                if (!this.spells.contains("0" + this.cclass.getCantrips().get(ind))) {
                    this.spells.add("0" + this.cclass.getCantrips().get(ind));
                    i++;
                }
            }
        }
        if (this.cclass.getSpellsKnown() != null) {
            for (int i = 0; i < this.cclass.getSpellsKnown();) {
                int ind = this.random.nextInt(this.cclass.getSpells().size());
                if (!this.spells.contains("1" + this.cclass.getSpells().get(ind))) {
                    this.spells.add("1" + this.cclass.getSpells().get(ind));
                    i++;
                }
            }
        }
    }
    
    public String getCantrips() {
        String cantrips = "";
        if (this.cclass.getCantripsKnown() == null) {
            cantrips = "-";
        } else {
            for (int i = 0; i < this.cclass.getCantripsKnown(); i++) {
                if (this.spells.get(i).startsWith("0")) {
                    if (i == 0) {
                        cantrips = cantrips + this.spells.get(i).substring(2);
                    } else {
                        cantrips = cantrips + "\n" + this.spells.get(i).substring(2);
                    }
                }
            }
        }
        return addRacialSpells(cantrips);
    }
    
    public String addRacialSpells(String spells) {
        if (this.race.getName().equals("Tiefling")) {
            spells = spells + "\nThaumaturgy";
        }
        if (spells.length() > 1 && spells.contains("-")) {
            spells = spells.substring(2);
        }
        return spells;
    }
    
    public String getLevel1Spells() {
        String l1Spells = "";
        boolean indicator = false;
        if (this.cclass.getSpellsKnown() == null) {
            l1Spells = "-";
        } else {
            for (int i = 0; i < this.cclass.getSpellsKnown(); i++) {
                if (this.spells.get(i).startsWith("1")) {
                    if (indicator == false) {
                        l1Spells = l1Spells + this.spells.get(i).substring(2);
                        indicator = true;
                    } else {
                        l1Spells = l1Spells + "\n" + this.spells.get(i).substring(2);
                    }
                }
            }
        }
        return l1Spells;
    }
    
    /**
     * Creates a list of visual markers detailing which saving throws and skills a character is proficient in,
     * based on the character's background and class.
     */
    public void assignProficiencyMarkers() {
        this.skillMarkers.clear();
        String[] abilities = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
        String[] skills = {"Acrobatics", "Animal Handling", "Arcana", "Athletics", "Deception", "History", "Insight", "Intimidation", "Investigation", "Medicine", "Nature", "Perception", "Performance", "Persuasion", "Religion", "Sleight of Hand", "Stealth", "Survival"};
        for (int i = 0; i < 24; i++) {
            this.skillMarkers.add("  ");
        }
        assignSavingThrowProficiencyMarkers(abilities);
        if (this.cclass.getSkills().size() > 0) {
            int ind = 0;
            int ind2 = 0;
            assignSkillProficiencyMarkers(skills, ind, ind2);    
        }
        
    }
    
    public void assignSavingThrowProficiencyMarkers(String[] abilities) {
        for (int i = 0; i < 6; i++) {
            if (this.cclass.getSavingThrows().contains(abilities[i])) {
                this.skillMarkers.set(i, "o");
            }
        }
    }
    
    public void assignSkillProficiencyMarkers(String[] skills, Integer ind, Integer ind2) {
        for (int i = 0; i < 18; i++) {
            if (this.background.getSkills().contains(skills[i])) {
                this.skillMarkers.set((i + 6), "o");
            }
        }
        for (int j = 0; j < this.cclass.getSkillNumber(); j++) {
            ind2 = this.random.nextInt(this.cclass.getSkills().size());
            if (!this.background.getSkills().contains(this.cclass.getSkills().get(ind2))) {
                for (int i = 0; i < 18; i++) {
                    if (this.cclass.getSkills().get(ind2).equals(skills[i])) {
                        this.skillMarkers.set((i + 6), "o");
                    }
                }
            }
        }
    }
    
    /**
     * Method reads the list of markers detailing which saving throws and skills a character is proficient in,
     * and creates a list of the numerical values of the saving throws and skills,
     * with proficiency bonus added to the values with a corresponding proficiency marker.
     */
    public void assignSavesAndSkills() {
        this.savesAndSkills.clear();
        Integer[] abilityIndexes = {0, 1, 2, 3, 4, 5, 1 , 4, 3, 0, 5, 3, 4, 5, 3, 4, 3, 4, 5, 5, 3, 1, 1, 4};
        for (int i = 0; i < 24; i++) {
            if (this.skillMarkers.get(i).equals("o")) {
                this.savesAndSkills.add(this.abilityScoreModifiers.get(abilityIndexes[i]) + 2);
            } else {
                this.savesAndSkills.add(this.abilityScoreModifiers.get(abilityIndexes[i]));
            }
        }
    }
    
    public List<String> getSkillMarkers() {
        return this.skillMarkers;
    }
    
    public List<Integer> getSavesAndSkills() {
        return this.savesAndSkills;
    }
}