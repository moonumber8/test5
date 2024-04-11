package com.example.demo.controller;

import com.example.demo.model.Emp;
import com.example.demo.service.EmpService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class MainController {
    private static final Logger LOG = LogManager.getLogger(MainController.class);

    @Autowired
    EmpService empService;

    @GetMapping(value = "/")
    public String index(ModelMap model) {
        HashMap<String, String> listPosition = new HashMap<String, String>();
        listPosition.put("Managing Director", "Managing Director");
        listPosition.put("Manager", "Manager");
        listPosition.put("Supervisor", "Supervisor");
        listPosition.put("Clerk", "Clerk");
        listPosition.put("Salesman", "Salesman");
        model.addAttribute("position", listPosition);

        return "index";
    }

    @PostMapping(value = "/saveData")
    @ResponseBody
    public String saveData(@RequestBody String reqBody) {
        JSONObject req = new JSONObject(reqBody);
        String empName = req.getString("EmpName");
        String empNum = req.getString("EmpNum");
        String position = req.getString("Position");
        Emp emp = new Emp();
        emp.setEmpName(empName);
        emp.setEmpNum(empNum);
        emp.setPosition(position);
        EmpService.save(emp);
        return "ok";
    }
}
