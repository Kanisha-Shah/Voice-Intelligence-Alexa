package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.SkillDAO;
import com.project.model.SkillVO;


@Service
@Transactional
public class SkillServiceImpl implements SkillService{
  
  @Autowired
  private SkillDAO skillDAO;
  
  @Override
  public void save(SkillVO skillVO){
    this.skillDAO.save(skillVO);
  }
  
  public List<SkillVO> search(){
    return this.skillDAO.search();
  }
  
  public List<SkillVO> findById(int id){
    return this.skillDAO.findById(id);
  }
  
  public Long getSkillCount() {
	  return this.skillDAO.getSkillCount();
  }
}
