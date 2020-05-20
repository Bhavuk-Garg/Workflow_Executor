package com.mysqlExample.kuroko.controller;

import com.mysqlExample.kuroko.database.model.TaskNameEntity;
import com.mysqlExample.kuroko.database.repository.TaskNameRepository;
import com.mysqlExample.kuroko.config.uiDataConfig.TaskDropdownConfig;
import com.mysqlExample.kuroko.service.TaskNameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class TaskNameController {
    @Autowired
    TaskDropdownConfig taskDropdownConfig;

    @Autowired
    TaskNameService taskNameService;
    /*
    *   Form have input field with allowed tasknames list
    */
    @ModelAttribute("allowedTaskNames")
    public List<String> getAvailableTaskList(){
        return taskDropdownConfig.getAllowedTaskNames();
    }

    @GetMapping(value="/allNames")
    public String getTaskNames(Model model){
        model.addAttribute("availableTaskList", taskNameService.getTaskNameEntities());
        return "taskNamesView";
    }

    @PostMapping("/allNames")
    public String addTaskName(TaskNameEntity taskNameEntity){
       taskNameService.save(taskNameEntity);
       return "redirect:/allNames";
    }

    @GetMapping("/editTaskName/{taskId}")
    public String editTaskNameForm(Model model){
        return "editNameForm";
    }

    @PostMapping("/editTaskName/{taskId}")
    public String editTaskName(@PathVariable("taskId") Integer id,
                               @RequestParam String name){
        taskNameService.override(id,name);
        return "redirect:/allNames";
    }

}