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
    private List<CharacterClass> classlist;
    private Background background;
    private List<Background> backgroundlist;
    private String alignment;
    private List<String> alignmentlist;
    private List<Integer> savesAndSkills;
    private List<String> equipment;
    private List<String> proficiencies;
    private List<String> spells;
    
    public CharacterSheet() {
        this.random = new Random();
        this.racelist = new ArrayList<>();
        this.classlist = new ArrayList<>();
        this.backgroundlist = new ArrayList<>();
        this.abilityScores = new ArrayList<>();
        this.abilityScoreModifiers = new ArrayList<>();
    }
    
    public void createRaces() {
        Race dwarf = new Race("Dwarf", 25);
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
    
    public void createClasses() {
        CharacterClass fighter = new CharacterClass("Fighter", "d10");
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
        this.classlist.add(fighter);
        
        CharacterClass rogue = new CharacterClass("Rogue", "d8");
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
        this.classlist.add(rogue);
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
    
    public void pickRace() {
        int ind = this.random.nextInt(this.racelist.size() - 1);
        this.race = this.racelist.get(ind);
    }
    
    public void pickClass() {
        int ind = this.random.nextInt(this.classlist.size() - 1);
        this.cclass = this.classlist.get(ind);
    }
    
    public void pickBackground() {
        int ind = this.random.nextInt(this.backgroundlist.size() - 1);
        this.background = this.backgroundlist.get(ind);
    }
    
    public void pickAlignment() {
        int ind = this.random.nextInt(this.alignmentlist.size() - 1);
        this.alignment = this.alignmentlist.get(ind);
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
    
    public void assignProficiencies() {
        this.proficiencies.clear();
        for (String cp: this.cclass.getProficiencies()) {
            this.proficiencies.add(cp);
        }
        for (String rp: this.race.getProficiencies()) {
            this.proficiencies.add(rp);
        }
        for (String bgp: this.background.getProficiencies()) {
            this.proficiencies.add(bgp);
        }
    }
}
