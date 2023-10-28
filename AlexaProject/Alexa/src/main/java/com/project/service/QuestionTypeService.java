package com.project.service;

import java.util.List;

import com.project.model.QuestionTypeVO;


public interface QuestionTypeService {
  
void save(QuestionTypeVO questionTypeVO);
  
  List<QuestionTypeVO> search();
  
  List<QuestionTypeVO> findById(int id);

  List<QuestionTypeVO> findBySkillId(int skillId);
}
