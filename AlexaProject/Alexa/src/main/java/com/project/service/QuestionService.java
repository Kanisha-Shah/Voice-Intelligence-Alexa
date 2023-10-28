package com.project.service;

import java.util.List;

import com.project.model.QuestionVO;

public interface QuestionService {
  
void save(QuestionVO questionVO);

  List<QuestionVO> search();
  
  List<QuestionVO> findById(int questionId);
  
  Long getQuestionCount();
}
