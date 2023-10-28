package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.SkillVO;
import com.project.service.SkillService;

@Controller
public class SkillController {
  
  @Autowired
  private SkillService skillService;
  
  @GetMapping(value = "admin/addSkill")
  public ModelAndView loadAddSkill() {
    return new ModelAndView("admin/addSkill","skillVO", new SkillVO());
  }
  
  @PostMapping(value = "admin/saveSkill")
  public ModelAndView loadSaveSkill(@ModelAttribute SkillVO skillVO) {
    
    System.out.println("in SkillConroller loadSaveSkill()");
    this.skillService.save(skillVO);
    System.out.println("in SkillConroller after loadSaveSkill()");
    return new ModelAndView("redirect:/admin/addSkill");
  }
  
  @GetMapping(value = "admin/showSkill")
  public ModelAndView loadViewSkill() {
    
    List<SkillVO> skillVOList=this.skillService.search();
    System.out.println(skillVOList.get(0));
    
    return new ModelAndView("admin/viewSkill","skillVOList",skillVOList);
  }
  
  @GetMapping(value = "admin/editSkill")
  public ModelAndView loadskillEdite(@RequestParam int id) {
    
    
    System.out.println("in SkillConroller loadEditSkill()");
    
    List<SkillVO> skillVOList=this.skillService.findById(id);
    
    int skillId=skillVOList.get(0).getSkillId();
    System.out.println(":: skillId"+skillId);
    
    SkillVO skillVO=skillVOList.get(0);
    
    System.out.println("::in SkillConroller loadEditSkill()"+skillVO);
    
    return new ModelAndView("admin/addSkill","skillVO",skillVO);
  }
  
  @GetMapping(value = "admin/deleteSkill")
  public ModelAndView loadskillDelete(@RequestParam int id) {
    
    
    System.out.println("in SkillConroller loadSaveSkill()");
    
    List<SkillVO> skillVOList=this.skillService.findById(id);
    SkillVO skillVO=skillVOList.get(0);
    
    skillVO.setStatus(false);
    
    this.skillService.save(skillVO);

    return new ModelAndView("redirect:/admin/showSkill");
  }
}
