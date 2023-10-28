package com.project.service;

import java.util.List;

import com.project.model.SkillVO;

public interface SkillService {
  
  void save(SkillVO skillVO);
  
  List<SkillVO> search();
  
  List<SkillVO> findById(int id);
  
  Long getSkillCount();
}
