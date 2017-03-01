package formbuilder.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;

@Entity
@Table(name = "item_selection")
public class ItemSelection extends Item implements Serializable{


    @OneToMany
    @Column(name="selection")
    private List<Selection> selections;
    
    @OneToOne
    private ItemSelectionAnswer answer_mapped;
    
    @Column(name="min")
    private int minRequirements; // (ex. Needs to pick at least 1)
    
    @Column(name="max")
    private int maxSelectionNum; //(ex. maximum number to select, can be select 2 out of 5, so max=2)}
    
    public List<Selection> getSelections() {
        return selections;
    }

    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }

    public Integer getMinRequirements() {
        return minRequirements;
    }

    public void setMinRequirements(Integer minRequirements) {
        this.minRequirements = minRequirements;
    }

    public ItemSelectionAnswer getAnswer() {
        return answer_mapped;
    }

    public void setAnswer(ItemSelectionAnswer answer) {
        this.answer_mapped = answer;
    }

    public int getMaxSelectionNum() {
        return maxSelectionNum;
    }

    public void setMaxSelectionNum(int maxSelectionNum) {
        this.maxSelectionNum = maxSelectionNum;
    }

    public void setMinRequirements(int minRequirements) {
        this.minRequirements = minRequirements;
    }
    
}

