package charactersheetgenerator5e.domain;

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
    private Background backgroud;
    private List<String> alignments;
    private List<Integer> savesAndSkills;
    private List<String> equipment;
    private List<String> proficiencies;
    private List<String> spells;
    
    public CharacterSheet() {
        this.random = new Random();
        this.racelist = new ArrayList<>();
        this.abilityScores = new ArrayList<>();
        this.abilityScoreModifiers = new ArrayList<>();
    }
    
    public void createRaces() {
        Race Dwarf = new Race("Dwarf", 25);
        Dwarf.addTrait("[Darkvision] Accustomed to life Underground, you have superior vision in dark and dim Conditions. You can see in dim light within 60 feet of you as if it were bright light, and in Darkness as if it were dim light. You can't discern color in Darkness, only Shades of Gray.");
        Dwarf.addTrait("[Dwarven Resilience] You have advantage on Saving Throws against poison, and you have Resistance against poison damage.");
        Dwarf.addTrait("[Dwarven Combat Training] You have proficiency with the Battleaxe, Handaxe, Light Hammer, and Warhammer.");
        Dwarf.addTrait("[Tool Proficiency] You gain proficiency with the artisan's tools of your choice: smith's tools, brewer's supplies, or mason's tools.");
        Dwarf.addTrait("[Stonecunning] Whenever you make an Intelligence (History) check related to the Origin of stonework, you are considered proficient in the History skill and add double your Proficiency Bonus to the check, instead of your normal Proficiency Bonus.");
        Dwarf.addTrait("[Dwarven Toughness] Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.");
        this.racelist.add(Dwarf);
        
        Race Tiefling = new Race("Tiefling", 30);
        Tiefling.addTrait("[Darkvision] Thanks to your Infernal heritage, you have superior vision in dark and dim Conditions. You can see in dim light within 60 feet of you as if it were bright light, and in Darkness as if it were dim light. You can't discern color in Darkness, only Shades of Gray.");
        Tiefling.addTrait("[Hellish Resistance] You have Resistance to fire damage.");
        Tiefling.addTrait("[Infernal Legacy] You know the Thaumaturgy cantrip. When you reach 3rd Level, you can cast the Hellish Rebuke spell as a 2nd-level spell once with this trait and regain the ability to do so when you finish a Long Rest. When you reach 5th Level, you can cast the Darkness spell once with this trait and regain the ability to do so when you finish a Long Rest. Charisma is your Spellcasting Ability for these Spells.");
        this.racelist.add(Tiefling);
    }
    
    public void createClasses() {
        CharacterClass Fighter = new CharacterClass("Fighter", "d10");
        Fighter.addProficiency("all armor");
        Fighter.addProficiency("shields");
        Fighter.addProficiency("simple weapons");
        Fighter.addProficiency("martial weapons");
        Fighter.addEquipment("chain mail OR leather armor + longbow + 20 arrows");
        Fighter.addEquipment("martial weapon + shield OR two martial weapons");
        Fighter.addEquipment("light crossbow + 20 bolts OR two handaxes");
        Fighter.addEquipment("dungeoneer's pack OR exporer's pack");
        Fighter.addSkill("Acrobatics");
        Fighter.addSkill("Animal Handling");
        Fighter.addSkill("Athletics");
        Fighter.addSkill("History");
        Fighter.addSkill("Insight");
        Fighter.addSkill("Intimidation");
        Fighter.addSkill("Perception");
        Fighter.addSkill("Survival");
        Fighter.addFeature("[Fighting Style] You adopt a particular style of fighting as your specialty. Choose a Fighting Style from the list of optional features. You can't take the same Fighting Style option more than once, even if you get to choose again.");
        Fighter.addFeature("[Second Wind] You have a limited well of stamina that you can draw on to protect yourself from harm. On Your Turn, you can use a Bonus Action to regain Hit Points equal to 1d10 + your Fighter level. Once you use this feature, you must finish a short or Long Rest before you can use it again.");
        this.classlist.add(Fighter);
        
        CharacterClass Rogue = new CharacterClass("Rogue", "d8");
        Rogue.addProficiency("light armor");
        Rogue.addProficiency("simple weapons");
        Rogue.addProficiency("hand crossbows");
        Rogue.addProficiency("longswords");
        Rogue.addProficiency("rapiers");
        Rogue.addProficiency("shortswords");
        Rogue.addProficiency("thieves' tools");
        Rogue.addEquipment("rapier OR shortsword");
        Rogue.addEquipment("shortbow + quiver of 20 arrows OR shortsword");
        Rogue.addEquipment("burglar's pack OR dungeoneer's pack OR explorer's pack");
        Rogue.addEquipment("leather armor");
        Rogue.addEquipment("two daggers");
        Rogue.addEquipment("thieves' tools");
        Rogue.addSkill("Acrobatics");
        Rogue.addSkill("Athletics");
        Rogue.addSkill("Deception");
        Rogue.addSkill("Insight");
        Rogue.addSkill("Intimidation");
        Rogue.addSkill("Investigation");
        Rogue.addSkill("Perception");
        Rogue.addSkill("Performance");
        Rogue.addSkill("Persuasion");
        Rogue.addSkill("Sleight of Hand");
        Rogue.addSkill("Stealth");
        Rogue.addFeature("[Expertise] At 1st Level, choose two of your skill Proficiencies, or one of your skill Proficiencies and your proficiency with Thieves' Tools. Your Proficiency Bonus is doubled for any ability check you make that uses either of the chosen Proficiencies. At 6th level, you can choose two more of your Proficiencies (in Skills or with thieves' tools) to gain this benefit.");
        Rogue.addFeature("[Sneak Attack] Beginning at 1st Level, you know how to strike subtly and exploit a foe's distraction. Once per turn, you can deal an extra 1d6 damage to one creature you hit with an Attack if you have advantage on the Attack roll. The Attack must use a Finesse or a ranged weapon. You don't need advantage on the Attack roll if another enemy of the target is within 5 feet of it, that enemy isn't Incapacitated, and you don't have disadvantage on the Attack roll. The amount of the extra damage increases as you gain levels in this class, as shown in the Sneak Attack column of the Rogue table.");
        Rogue.addFeature("[Thieves' Cant] During your rogue Training you learned thieves' cant, a Secret mix of dialect, jargon, and code that allows you to hide messages in seemingly normal conversation. Only another creature that knows thieves' cant understands such messages. It takes four times longer to convey such a Message than it does to speak the same idea plainly. In addition, you understand a set of Secret signs and symbols used to convey short, simple messages, such as whether an area is dangerous or the territory of a thieves' guild, whether loot is nearby, or whether the people in an area are easy marks or will provide a Safe House for thieves on the run.");
        this.classlist.add(Rogue);
    }
    
    public void pickRace() {
        int ind = this.random.nextInt(this.racelist.size() - 1);
        this.race = this.racelist.get(ind);
    }
    
    public void pickClass() {
        int ind = this.random.nextInt(this.classlist.size() - 1);
        this.cclass = this.classlist.get(ind);
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
            for(int roll: rolls) {
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
        
        for(int as: this.abilityScores) {
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
    }
    
}
