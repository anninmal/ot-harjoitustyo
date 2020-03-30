package charactersheetgenerator5e.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    
 //   private Integer id;
    private String name;
    private Integer speed;
    private List<String> traitlist;
    
    public Race(String name, Integer speed) {
        //this.id = id;
        this.name = name;
        this.speed = speed;
        this.traitlist = new ArrayList<>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getSpeed() {
        return this.speed;
    }
    
    public List<String> getTraits() {
        return this.traitlist;
    }
    
    public void addTrait(String trait) {
        this.traitlist.add(trait);
    }
}
