package com.project.dao;

import java.util.List;

import com.project.model.QuestionTypeVO;

public interface QuestionTypeDAO {
  
  void save(QuestionTypeVO questionTypeVO);
  
  List<QuestionTypeVO> search();
  
  List<QuestionTypeVO> findById(int id);
  
  List<QuestionTypeVO> findBySkillId(int skillId);

}
