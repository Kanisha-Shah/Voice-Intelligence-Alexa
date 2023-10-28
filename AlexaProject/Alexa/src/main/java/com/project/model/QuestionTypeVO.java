package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "questiontypesequence", sequenceName = "questiontypesequence", allocationSize = 1)
@Table(name = "question_Type_table")
public class QuestionTypeVO {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "question_type_id")
  private int questionTypeId;
  
  @Column(name = "question_type_name")
  private String questionTypeName;
  
  @Column(name = "question_type_description")
  private String questionTypeDescription;
  
  @ManyToOne
  @JoinColumn(name = "skill_id")
  private SkillVO skillVO;
 
  @Column(name = "question_type_status")
  private boolean status=true;

  public int getQuestionTypeId() {
    return questionTypeId;
  }

  public void setQuestionTypeId(int questionTypeId) {
    this.questionTypeId = questionTypeId;
  }

  public String getQuestionTypeName() {
    return questionTypeName;
  }

  public void setQuestionTypeName(String questionTypeName) {
    this.questionTypeName = questionTypeName;
  }

  public String getQuestionTypeDescription() {
    return questionTypeDescription;
  }

  public void setQuestionTypeDescription(String questionTypeDescription) {
    this.questionTypeDescription = questionTypeDescription;
  }

  public SkillVO getSkillVO() {
    return skillVO;
  }

  public void setSkillVO(SkillVO skillVO) {
    this.skillVO = skillVO;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
