package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.QuestionTypeVO;
import com.project.model.SkillVO;

@Repository
public class QuestionTypeDAOImpl implements QuestionTypeDAO {


  @Autowired
  private  SessionFactory sessionFactory;
  
  @Override
  public void save(QuestionTypeVO questionTypeVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(questionTypeVO);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public List<QuestionTypeVO> search(){
    List<QuestionTypeVO> questionTypeList = new ArrayList<QuestionTypeVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from QuestionTypeVO where status = true" );
        questionTypeList = (List<QuestionTypeVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return questionTypeList;
  }
  
  @Override
  public List<QuestionTypeVO> findById(int id){
    List<QuestionTypeVO> questionTypeList = new ArrayList<QuestionTypeVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("searching Question type with id::"+id);
        Query query = session.createQuery("from QuestionTypeVO where status = true and questionTypeId="+id);
        
        questionTypeList = (List<QuestionTypeVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return questionTypeList; 
  }
  
  @Override
  public List<QuestionTypeVO> findBySkillId(int skillId){
    List<QuestionTypeVO> questionTypeList = new ArrayList<QuestionTypeVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("searching Question type with id::"+skillId);
        Query query = session.createQuery("from QuestionTypeVO where status = true and skillVO ="+skillId);
        
        questionTypeList = (List<QuestionTypeVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return questionTypeList; 
  }
  

}
