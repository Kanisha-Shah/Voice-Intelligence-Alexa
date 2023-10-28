package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.SkillVO;

@Repository
public class SkillDAOImpl implements SkillDAO{

  
  @Autowired
  private  SessionFactory sessionFactory;
  
  @Override
  public void save(SkillVO skillVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(skillVO);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public List<SkillVO> search(){
    List<SkillVO> userList = new ArrayList<SkillVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SkillVO where status = true" );
        userList = (List<SkillVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return userList;
  }
  
  @Override
  public List<SkillVO> findById(int id){
    List<SkillVO> skillVOList = new ArrayList<SkillVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from SkillVO where status = true and skillId="+id);
        
        skillVOList = (List<SkillVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return skillVOList; 
  }

  @Override
  public Long getSkillCount() {
	  Long count=null;
	  try {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("select count(*)from SkillVO where status = true");
	        
	        count = (Long)query.list().get(0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	  
	  return count;
  }
}
