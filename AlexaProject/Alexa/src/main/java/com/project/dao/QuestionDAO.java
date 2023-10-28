package com.project.dao;

import java.util.List;

import com.project.model.QuestionVO;

public interface QuestionDAO {
  
void save(QuestionVO questionVO);
  
  List<QuestionVO> search();
  
  List<QuestionVO> findById(int questionId);
  
  Long getQuestionCount();
}
