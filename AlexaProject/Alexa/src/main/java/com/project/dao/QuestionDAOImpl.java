package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.QuestionVO;

@Repository
public class QuestionDAOImpl implements QuestionDAO{
  
  @Autowired
  private  SessionFactory sessionFactory;
  
  @Override
  public void save(QuestionVO questionVO) {
    try {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(questionVO);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
  @Override
  public List<QuestionVO> search(){
    List<QuestionVO> questionList = new ArrayList<QuestionVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from QuestionVO where status = true" );
        questionList = (List<QuestionVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return questionList;
  }
  
  @Override
  public List<QuestionVO> findById(int id){
    List<QuestionVO> questionList = new ArrayList<QuestionVO>();
    try {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from QuestionVO where status = true and questionId="+id);
        
        questionList = (List<QuestionVO>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return questionList; 
  }
  
  @Override
  public Long getQuestionCount() {
	
	  Long count=null;
	  
	  try {
	        
		  Session session = sessionFactory.getCurrentSession();
	      
		  Query query = session.createQuery("select count(*)from QuestionVO where status = true");
	        
	      
		  count = (Long)query.list().get(0);
	   
	  } catch (Exception e) {
	  
		  e.printStackTrace();
	    
	  } 
	  
	  return count;

  }
	}
