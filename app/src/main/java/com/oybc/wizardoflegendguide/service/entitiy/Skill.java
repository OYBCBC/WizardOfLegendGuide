package com.oybc.wizardoflegendguide.service.entitiy;

import java.io.Serializable;

public class Skill implements Serializable {


    /**
     * skillId : 1
     * skillName : 火焰吐息
     * skillType : 远攻
     * skillNature : 火
     * skillNote : 喷出火焰
     * skillPic : K:\mysql\wol\分裂的护身符.png
     * skillDescription : 试试
     * skillDamage : 试试
     * skillEnhanceDamage : 试试
     */

    private int skillId;
    private String skillName;
    private String skillType;
    private String skillNature;
    private String skillNote;
    private String skillPic;
    private String skillDescription;
    private String skillDamage;
    private String skillEnhanceDamage;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillNature() {
        return skillNature;
    }

    public void setSkillNature(String skillNature) {
        this.skillNature = skillNature;
    }

    public String getSkillNote() {
        return skillNote;
    }

    public void setSkillNote(String skillNote) {
        this.skillNote = skillNote;
    }

    public String getSkillPic() {
        return skillPic;
    }

    public void setSkillPic(String skillPic) {
        this.skillPic = skillPic;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getSkillDamage() {
        return skillDamage;
    }

    public void setSkillDamage(String skillDamage) {
        this.skillDamage = skillDamage;
    }

    public String getSkillEnhanceDamage() {
        return skillEnhanceDamage;
    }

    public void setSkillEnhanceDamage(String skillEnhanceDamage) {
        this.skillEnhanceDamage = skillEnhanceDamage;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                ", skillType='" + skillType + '\'' +
                ", skillNature='" + skillNature + '\'' +
                ", skillNote='" + skillNote + '\'' +
                ", skillPic='" + skillPic + '\'' +
                ", skillDescription='" + skillDescription + '\'' +
                ", skillDamage='" + skillDamage + '\'' +
                ", skillEnhanceDamage='" + skillEnhanceDamage + '\'' +
                '}';
    }
}
