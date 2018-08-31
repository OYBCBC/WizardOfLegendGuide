package com.oybc.wizardoflegendguide.service.entitiy;
 
public class Relics  implements java.io.Serializable{

    private int relicsId;
    private String relicsName;
    private String relicsType;//offense, defense, misc
    private String relicsPic;
    private String relicsDescription;

    public int getRelicsId() {
        return relicsId;
    }

    public void setRelicsId(int relicsId) {
        this.relicsId = relicsId;
    }

    
    public String getRelicsName() {
        return relicsName;
    }

    public void setRelicsName(String relicsName) {
        this.relicsName = relicsName;
    }

    public String getRelicsType() {
        return relicsType;
    }

    public void setRelicsType(String relicsType) {
        this.relicsType = relicsType;
    }

    public String getRelicsPic() {
        return relicsPic;
    }

    public void setRelicsPic(String relicsPic) {
        this.relicsPic = relicsPic;
    }

    public String getRelicsDescription() {
        return relicsDescription;
    }

    public void setRelicsDescription(String relicsDescription) {
        this.relicsDescription = relicsDescription;
    }
    

  


    
}
