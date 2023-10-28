package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.QuestionTypeVO;
import com.project.model.QuestionVO;
import com.project.model.SkillVO;
import com.project.service.QuestionService;
import com.project.service.QuestionTypeService;
import com.project.service.SkillService;

@Controller
public class QuestionController {

  @Autowired
  private SkillService skillService;

  @Autowired
  private QuestionService questionService;

  @Autowired
  private QuestionTypeService questionTypeService;
  
  @GetMapping(value = "admin/insertQuestion")
  public ModelAndView loadAddQuestion() {

    List<SkillVO> skillVOList = this.skillService.search();
    List<QuestionTypeVO> questionTypeVOList = this.questionTypeService.search();
  
    return new ModelAndView("admin/addQuestion", "questionVO", new QuestionVO()).addObject("skillVOList", skillVOList)
        .addObject("questionTypeVOList", questionTypeVOList);
  }
  
  @PostMapping(value = "admin/saveQuestion")
  public ModelAndView saveQuestion(HttpServletRequest request, @ModelAttribute QuestionVO questionVO){
    
    this.questionService.save(questionVO);
    
    return new ModelAndView("redirect:/admin/insertQuestion");
  }

  @GetMapping(value = "admin/viewQuestions")
  public ModelAndView loadShowQuestion() {
    
    List<QuestionVO> questionVOList = this.questionService.search();
    
    return new ModelAndView("admin/viewQuestions","questionVOList", questionVOList);
  }
  
  @GetMapping(value = "admin/deleteQuestion")
  public ModelAndView deleteQuestion(@RequestParam int id) {
    
    List<QuestionVO> questionVOList=this.questionService .findById(id);
    
    QuestionVO questionVO=questionVOList.get(0);
    
    questionVO.setStatus(false);
    
    this.questionService.save(questionVO);
    
    return new ModelAndView("redirect:/admin/viewQuestions");
  }
  
  @GetMapping(value = "admin/editQuestion")
  public ModelAndView editQuestion(@RequestParam int id) {
    
    List<QuestionVO> questionVOList=this.questionService .findById(id);
    
    QuestionVO questionVO=questionVOList.get(0);
    List<SkillVO> skillVOList = this.skillService.search();
    List<QuestionTypeVO> questionTypeVOList = this.questionTypeService.search();
    
    return new ModelAndView("admin/addQuestion", "questionVO", questionVO).addObject("skillVOList", skillVOList)
        .addObject("questionTypeVOList", questionTypeVOList);
  }
  
  @GetMapping(value = "admin/getQuestionDetails")
  public ResponseEntity getTheQuestionDetails(@RequestParam int questionId) {
	  
	  List<QuestionVO> questionList = this.questionService.findById(questionId);
	  return new ResponseEntity<>(questionList, HttpStatus.OK); 
  }
  
  

  
}
