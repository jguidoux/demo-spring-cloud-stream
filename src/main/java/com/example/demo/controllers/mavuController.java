/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author raphael
 */
@Controller
public class mavuController {

   @RequestMapping("/index.html")
   public String index() {
      System.out.println("tentative d'afficher index.html");
     return "index";
   }

   @GetMapping("/hey/{name}")
   public String sayHello(@PathVariable("name") String name, Model model) {
      model.addAttribute("name", name);
      return "hey";
   }
}

