package com.project.dao;

import java.util.List;

import com.project.model.SkillVO;

public interface SkillDAO {
  
  void save(SkillVO skillVO);
  
  List<SkillVO> search();
  
  List<SkillVO> findById(int id);
  
  Long getSkillCount();
}
