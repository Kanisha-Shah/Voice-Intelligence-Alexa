package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.QuestionDAO;
import com.project.model.QuestionVO;

@Service
@Transactional
public class QuestionServiceImp implements QuestionService {
  
  
  @Autowired
  private QuestionDAO questionDAO;
  
  @Override
  public void save(QuestionVO questionVO){
    this.questionDAO.save(questionVO);
  }
  
  public List<QuestionVO> search(){
    return this.questionDAO.search();
  }
  
  public List<QuestionVO> findById(int questionId){
    return this.questionDAO.findById(questionId);
  }
  
  public Long getQuestionCount() {
	  return this.questionDAO.getQuestionCount();
  }
}
