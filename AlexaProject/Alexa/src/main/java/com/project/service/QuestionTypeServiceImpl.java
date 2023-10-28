package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.QuestionTypeDAO;
import com.project.model.QuestionTypeVO;
import com.project.model.SkillVO;

@Service
@Transactional
public class QuestionTypeServiceImpl implements QuestionTypeService{
  
  @Autowired
  private QuestionTypeDAO questionTypeDAO;
  
  @Override
  public void save(QuestionTypeVO questionTypeVO){
    this.questionTypeDAO.save(questionTypeVO);
  }
  
  @Override
  public List<QuestionTypeVO> search(){
    return this.questionTypeDAO.search();
  }
  
  @Override
  public List<QuestionTypeVO> findById(int id){
    return this.questionTypeDAO.findById(id);
  }
  
  @Override
  public List<QuestionTypeVO> findBySkillId(int skillId){
	  return this.questionTypeDAO.findBySkillId(skillId);

  }
  
}
