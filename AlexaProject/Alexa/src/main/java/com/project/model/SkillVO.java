package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "skillsequence", sequenceName = "skillsequence", allocationSize = 1)
@Table(name = "skill_table")
public class SkillVO {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "skill_id")
  private int skillId;
  
  @Column(name = "skill_name")
  private String skillName;
  
  @Column(name = "skil_description")
  private String skillDescription;
  
  @Column(name = "skill_status")
  private boolean status=true;

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

  public String getSkillDescription() {
    return skillDescription;
  }

  public void setSkillDescription(String skillDescription) {
    this.skillDescription = skillDescription;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
  
  
}
