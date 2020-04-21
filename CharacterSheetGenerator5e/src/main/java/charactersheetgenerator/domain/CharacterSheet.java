package charactersheetgenerator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CharacterSheet {
    
    private Random random;
    private List<Integer> abilityScores;
    private List<Integer> abilityScoreModifiers;
    private Race race;
    private List<Race> racelist;
    private CharacterClass cclass;
    private List<CharacterClass> cclasslist;
    private Background background;
    private List<Background> backgroundlist;
    private String alignment;
    private List<String> alignmentlist;
    private List<Integer> savesAndSkills;
    private List<String> equipment;
    private List<String> proficiencies;
    private List<String> features;
    private List<String> skillMarkers;
    private List<String> spells;
    
    public CharacterSheet() {
        this.random = new Random();
        this.racelist = new ArrayList<>();
        this.cclasslist = new ArrayList<>();
        this.backgroundlist = new ArrayList<>();
        this.abilityScores = new ArrayList<>();
        this.abilityScoreModifiers = new ArrayList<>();
        this.alignmentlist = new ArrayList<>();
        this.savesAndSkills = new ArrayList<>();
        this.equipment = new ArrayList<>();
        this.proficiencies = new ArrayList<>();
        this.features = new ArrayList<>();
        this.skillMarkers = new ArrayList<>();
        this.spells = new ArrayList<>();
    }
    
    public void generateSheet(String race, String cclass, String background, String alignment) {
        createRaces();
        createClasses();
        createBackgrounds();
        createAlignments();
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
    
    //will probably read the text in the "createXYZ" methods from a file in the finished version... somehow...
    public void createRaces() {
        Race dwarf = new Race("Hill Dwarf", 25);
        dwarf.addTrait("[Darkvision] Accustomed to life Underground, you have superior vision in dark and dim Conditions. You can see in dim light within 60 feet of you as if it were bright light, and in Darkness as if it were dim light. You can't discern color in Darkness, only Shades of Gray.");
        dwarf.addTrait("[Dwarven Resilience] You have advantage on Saving Throws against poison, and you have Resistance against poison damage.");
        dwarf.addTrait("[Dwarven Combat Training] You have proficiency with the Battleaxe, Handaxe, Light Hammer, and Warhammer.");
        dwarf.addTrait("[Tool Proficiency] You gain proficiency with the artisan's tools of your choice: smith's tools, brewer's supplies, or mason's tools.");
        dwarf.addTrait("[Stonecunning] Whenever you make an Intelligence (History) check related to the Origin of stonework, you are considered proficient in the History skill and add double your Proficiency Bonus to the check, instead of your normal Proficiency Bonus.");
        dwarf.addTrait("[Dwarven Toughness] Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.");
        dwarf.addProficiency("battleaxe");
        dwarf.addProficiency("handaxe");
        dwarf.addProficiency("light hammer");
        dwarf.addProficiency("warhammer");
        dwarf.addProficiency("artisan's tools");
        dwarf.addProficiency("Common");
        dwarf.addProficiency("Dwarven");
        this.racelist.add(dwarf);
        
        Race tiefling = new Race("Tiefling", 30);
        tiefling.addTrait("[Darkvision] Thanks to your Infernal heritage, you have superior vision in dark and dim Conditions. You can see in dim light within 60 feet of you as if it were bright light, and in Darkness as if it were dim light. You can't discern color in Darkness, only Shades of Gray.");
        tiefling.addTrait("[Hellish Resistance] You have Resistance to fire damage.");
        tiefling.addTrait("[Infernal Legacy] You know the Thaumaturgy cantrip. When you reach 3rd Level, you can cast the Hellish Rebuke spell as a 2nd-level spell once with this trait and regain the ability to do so when you finish a Long Rest. When you reach 5th Level, you can cast the Darkness spell once with this trait and regain the ability to do so when you finish a Long Rest. Charisma is your Spellcasting Ability for these Spells.");
        tiefling.addProficiency("Common");
        tiefling.addProficiency("Infernal");
        this.racelist.add(tiefling);
    }
    
    public List<Race> getRaces() {
        return this.racelist;
    }
    
    public Race getRace() {
        return this.race;
    }
    
    public void createClasses() {
        CharacterClass fighter = new CharacterClass("Fighter", 10, 2);
        fighter.addSavingThrow("Strength");
        fighter.addSavingThrow("Constitution");
        fighter.addProficiency("all armor");
        fighter.addProficiency("shields");
        fighter.addProficiency("simple weapons");
        fighter.addProficiency("martial weapons");
        fighter.addEquipment("chain mail OR leather armor + longbow + 20 arrows");
        fighter.addEquipment("martial weapon + shield OR two martial weapons");
        fighter.addEquipment("light crossbow + 20 bolts OR two handaxes");
        fighter.addEquipment("dungeoneer's pack OR exporer's pack");
        fighter.addSkill("Acrobatics");
        fighter.addSkill("Animal Handling");
        fighter.addSkill("Athletics");
        fighter.addSkill("History");
        fighter.addSkill("Insight");
        fighter.addSkill("Intimidation");
        fighter.addSkill("Perception");
        fighter.addSkill("Survival");
        fighter.addFeature("[Fighting Style] You adopt a particular style of fighting as your specialty. Choose a Fighting Style from the list of optional features. You can't take the same Fighting Style option more than once, even if you get to choose again.");
        fighter.addFeature("[Second Wind] You have a limited well of stamina that you can draw on to protect yourself from harm. On Your Turn, you can use a Bonus Action to regain Hit Points equal to 1d10 + your Fighter level. Once you use this feature, you must finish a short or Long Rest before you can use it again.");
        this.cclasslist.add(fighter);
        
        CharacterClass rogue = new CharacterClass("Rogue", 8, 4);
        rogue.addSavingThrow("Dexterity");
        rogue.addSavingThrow("Intelligence");
        rogue.addProficiency("light armor");
        rogue.addProficiency("simple weapons");
        rogue.addProficiency("hand crossbows");
        rogue.addProficiency("longswords");
        rogue.addProficiency("rapiers");
        rogue.addProficiency("shortswords");
        rogue.addProficiency("thieves' tools");
        rogue.addEquipment("rapier OR shortsword");
        rogue.addEquipment("shortbow + quiver of 20 arrows OR shortsword");
        rogue.addEquipment("burglar's pack OR dungeoneer's pack OR explorer's pack");
        rogue.addEquipment("leather armor");
        rogue.addEquipment("two daggers");
        rogue.addEquipment("thieves' tools");
        rogue.addSkill("Acrobatics");
        rogue.addSkill("Athletics");
        rogue.addSkill("Deception");
        rogue.addSkill("Insight");
        rogue.addSkill("Intimidation");
        rogue.addSkill("Investigation");
        rogue.addSkill("Perception");
        rogue.addSkill("Performance");
        rogue.addSkill("Persuasion");
        rogue.addSkill("Sleight of Hand");
        rogue.addSkill("Stealth");
        rogue.addFeature("[Expertise] At 1st Level, choose two of your skill Proficiencies, or one of your skill Proficiencies and your proficiency with Thieves' Tools. Your Proficiency Bonus is doubled for any ability check you make that uses either of the chosen Proficiencies. At 6th level, you can choose two more of your Proficiencies (in Skills or with thieves' tools) to gain this benefit.");
        rogue.addFeature("[Sneak Attack] Beginning at 1st Level, you know how to strike subtly and exploit a foe's distraction. Once per turn, you can deal an extra 1d6 damage to one creature you hit with an Attack if you have advantage on the Attack roll. The Attack must use a Finesse or a ranged weapon. You don't need advantage on the Attack roll if another enemy of the target is within 5 feet of it, that enemy isn't Incapacitated, and you don't have disadvantage on the Attack roll. The amount of the extra damage increases as you gain levels in this class, as shown in the Sneak Attack column of the Rogue table.");
        rogue.addFeature("[Thieves' Cant] During your rogue Training you learned thieves' cant, a Secret mix of dialect, jargon, and code that allows you to hide messages in seemingly normal conversation. Only another creature that knows thieves' cant understands such messages. It takes four times longer to convey such a Message than it does to speak the same idea plainly. In addition, you understand a set of Secret signs and symbols used to convey short, simple messages, such as whether an area is dangerous or the territory of a thieves' guild, whether loot is nearby, or whether the people in an area are easy marks or will provide a Safe House for thieves on the run.");
        this.cclasslist.add(rogue);
    }
    
    public List<CharacterClass> getClasses() {
        return this.cclasslist;
    }
    
    public CharacterClass getCClass() {
        return this.cclass;
    }
    
    public void createBackgrounds() {
        Background acolyte = new Background("Acolyte", 15);
        acolyte.setFeature("[Shelter of the Faithful] As an acolyte, you Command the respect of those who share your faith, and you can perform the religious ceremonies of your deity. You and your Adventuring companions can expect to receive free Healing and care at a Temple, shrine, or other established presence of your faith, though you must provide any material Components needed for Spells. Those who share your Religion will support you (but only you) at a modest lifestyle. You might also have ties to a specific Temple dedicated to your chosen deity or pantheon, and you have a residence there. This could be the Temple where you used to serve, if you remain on good terms with it, or a Temple where you have found a new home. While near your Temple, you can call upon the Priests for assistance, provided the assistance you ask for is not hazardous and you remain in good standing with your Temple.");
        acolyte.addProficiency("Two languages of your choice");
        acolyte.addSkill("Insight");
        acolyte.addSkill("Religion");
        acolyte.addEquipment("holy symbol");
        acolyte.addEquipment("prayer book");
        acolyte.addEquipment("5 sticks of incense");
        acolyte.addEquipment("vestments");
        acolyte.addEquipment("set of common clothes");
        this.backgroundlist.add(acolyte);
        
        Background charlatan = new Background("Charlatan", 15);
        charlatan.setFeature("[False Identity] You have created a second identity that includes documentation, established acquaintances, and disguises that allow you to assume that persona. Additionally, you can forge documents including official papers and personal letters, as long as you have seen an example of the kind of document or the handwriting you are trying to copy.");
        charlatan.addProficiency("disguise kit");
        charlatan.addProficiency("forgery kit");
        charlatan.addSkill("Deception");
        charlatan.addSkill("Sleight of Hand");
        charlatan.addEquipment("set of fine clothes");
        charlatan.addEquipment("disguise kit");
        charlatan.addEquipment("tools of the con");
        this.backgroundlist.add(charlatan);
    }
    
    public List<Background> getBackgrounds() {
        return this.backgroundlist;
    }
    
    public Background getBackground() {
        return this.background;
    }
    
    public void createAlignments() {
        this.alignmentlist.add("Lawful Good");
        this.alignmentlist.add("Neutral Good");
        this.alignmentlist.add("Chaotic Good");
        this.alignmentlist.add("Lawful Neutral");
        this.alignmentlist.add("True Neutral");
        this.alignmentlist.add("Chaotic Neutral");
        this.alignmentlist.add("Lawful Evil");
        this.alignmentlist.add("Neutral Evil");
        this.alignmentlist.add("Chaotic Evil");
    }
    
    public List<String> getAlignments() {
        return this.alignmentlist;
    }
    
    public String getAlignment() {
        return this.alignment;
    }
    
    public void pickRace(String race) {
        if (race == null) {
            int ind = this.random.nextInt(this.racelist.size());
            this.race = this.racelist.get(ind);
        } else {
            for (Race ra: this.racelist) {
                if (ra.getName().equals(race)) {
                    this.race = ra;
                }
            }
        }
    }
    
    public void pickClass(String cclass) {
        if (cclass == null) {
            int ind = this.random.nextInt(this.cclasslist.size());
            this.cclass = this.cclasslist.get(ind);
        } else {
            for (CharacterClass cc: this.cclasslist) {
                if (cc.getName().equals(cclass)) {
                    this.cclass = cc;
                }
            }
        }
    }
    
    public void pickBackground(String background) {
        if (background == null) {
            int ind = this.random.nextInt(this.backgroundlist.size());
            this.background = this.backgroundlist.get(ind);
        } else {
            for (Background bg: this.backgroundlist) {
                if (bg.getName().equals(background)) {
                    this.background = bg;
                }
            }
        }
    }
    
    public void pickAlignment(String alignment) {
        if (alignment == null) {
            int ind = this.random.nextInt(this.alignmentlist.size());
            this.alignment = this.alignmentlist.get(ind);
        } else {
            this.alignment = alignment;
        }
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
        if (this.race.getName().equals("Hill Dwarf")) {
            this.abilityScores.set(2, (this.abilityScores.get(2) + 2));
            this.abilityScores.set(4, (this.abilityScores.get(4) + 1));
        } else if (this.race.getName().equals("Tiefling")) {
            this.abilityScores.set(5, (this.abilityScores.get(5) + 2));
            this.abilityScores.set(3, (this.abilityScores.get(3) + 1));
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
