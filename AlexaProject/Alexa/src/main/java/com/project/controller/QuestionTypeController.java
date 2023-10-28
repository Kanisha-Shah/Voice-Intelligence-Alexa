
package com.project.controller;

import java.util.List;

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
import com.project.service.QuestionTypeService;
import com.project.service.SkillService;

@Controller
public class QuestionTypeController {

  @Autowired
  private QuestionTypeService questionTypeService;

  @Autowired
  private SkillService skillService;

  @GetMapping(value = "admin/addQuestionType")
  public ModelAndView loadAddQuestionType() {

    List<SkillVO> skillVOList = this.skillService.search();
    List<QuestionTypeVO> questionTypeList = this.questionTypeService.search();

    return new ModelAndView("admin/addQuestionType", "questionTypeVO", new QuestionTypeVO())
        .addObject("skillVOList", skillVOList);
  }

  @PostMapping(value = "admin/saveQuestionType")
  public ModelAndView loadSaveSkill(@ModelAttribute QuestionTypeVO questionTypeVO) {

    System.out.println("in SkillConroller loadSaveSkill()");
    this.questionTypeService.save(questionTypeVO);
    System.out.println("in SkillConroller after loadSaveSkill()");
    return new ModelAndView("redirect:/admin/addQuestionType");
  }

  @GetMapping(value = "admin/viewQuestionType")
  public ModelAndView loadViewSkill() {
    
    List<QuestionTypeVO> questionTypeList = this.questionTypeService.search();
    
    return new ModelAndView("admin/viewQuestionType","questionTypeList",questionTypeList);
  }

  @GetMapping(value = "admin/editQuestionType")
  public ModelAndView loadskillEdite(@RequestParam int id) {

    System.out.println("in SkillConroller loadEditSkill() :: question type id="+id);

    List<QuestionTypeVO> questionTypeVOList = this.questionTypeService.findById(id);

    int questionTypeId = questionTypeVOList.get(0).getQuestionTypeId();
    System.out.println(":: QuestionTypeId ::" + questionTypeId);

    QuestionTypeVO questionTypeVO = questionTypeVOList.get(0);
    List<SkillVO> skillVOList = this.skillService.search();
    System.out.println("::in QuestionTypeConroller loadEditQuestionType()" + questionTypeVO);

    return new ModelAndView("admin/addQuestionType", "questionTypeVO",questionTypeVO)
        .addObject("skillVOList", skillVOList);
  }

  @GetMapping(value = "admin/deleteQuestionType")
  public ModelAndView loadskillDelete(@RequestParam int id) {

    System.out.println("in SkillConroller loadDeltequestionTypeVO()");

    List<QuestionTypeVO> questionTypeVOList = this.questionTypeService.findById(id);
    QuestionTypeVO questionTypeVO = questionTypeVOList.get(0);

    questionTypeVO.setStatus(false);

    this.questionTypeService.save(questionTypeVO);

    return new ModelAndView("redirect:/admin/viewQuestionType");
  }
  
  
  @GetMapping(value = "admin/getQuestionTypeBySkillId")
  public ResponseEntity getTheQuestionDetails(@RequestParam int skillId) {
	  
	  List<QuestionTypeVO> questionTypeList = this.questionTypeService.findBySkillId(skillId);
//	  System.out.println(":=:=----------------->"+questionTypeList);
	  return new ResponseEntity<>(questionTypeList, HttpStatus.OK); 
  }
}
