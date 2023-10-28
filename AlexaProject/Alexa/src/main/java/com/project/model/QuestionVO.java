package com.project.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "questionsequence", sequenceName = "questionsequence", allocationSize = 1)
@Table(name = "question_table")
public class QuestionVO {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "question_id")
  private int questionId;

  @ManyToOne
  @JoinColumn(name = "skill_id")
  private SkillVO skillVO;

  @ManyToOne
  @JoinColumn(name = "question_type_id")
  private QuestionTypeVO questionTypeVO;

  @Column(name = "question")
  private String question;

  @Column(name = "question_description")
  private String questionDescription;

  @Column(name = "answer")
  private String answer;

  @Column(name = "answer_description")
  private String answerDescription;
  
  private String optionValue1;
  private String optionValue2;
  private String optionValue3;
  private String optionValue4;
  
  @Column(name = "status")
  private boolean status=true;
  
  public String getOptionValue1() {
    return optionValue1;
  }

  public void setOptionValue1(String optionValue1) {
    this.optionValue1 = optionValue1;
  }

  public String getOptionValue2() {
    return optionValue2;
  }

  public void setOptionValue2(String optionValue2) {
    this.optionValue2 = optionValue2;
  }

  public String getOptionValue3() {
    return optionValue3;
  }

  public void setOptionValue3(String optionValue3) {
    this.optionValue3 = optionValue3;
  }

  public String getOptionValue4() {
    return optionValue4;
  }

  public void setOptionValue4(String optionValue4) {
    this.optionValue4 = optionValue4;
  }

  public String getAnswerDescription() {
    return answerDescription;
  }

  public void setAnswerDescription(String answerDescription) {
    this.answerDescription = answerDescription;
  }

  public int getQuestionId() {
    return questionId;
  }

  public void setQuestionId(int questionId) {
    this.questionId = questionId;
  }

  public SkillVO getSkillVO() {
    return skillVO;
  }

  public void setSkillVO(SkillVO skillVO) {
    this.skillVO = skillVO;
  }

  public QuestionTypeVO getQuestionTypeVO() {
    return questionTypeVO;
  }

  public void setQuestionTypeVO(QuestionTypeVO questionTypeVO) {
    this.questionTypeVO = questionTypeVO;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getQuestionDescription() {
    return questionDescription;
  }

  public void setQuestionDescription(String questionDescription) {
    this.questionDescription = questionDescription;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

}
