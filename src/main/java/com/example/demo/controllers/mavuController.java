/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author raphael
 */
@Controller
public class mavuController {

   @RequestMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/hey")
   public String sayHello(@RequestParam("name") String name, Model model) {
      model.addAttribute("name", name);
      return "hey";
   }
}

