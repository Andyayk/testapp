package com.example.springmvcboot;

import com.example.springmvcboot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
    @Autowired
    Alienrepo repo;

    @ModelAttribute
    public void modelData(Model m){
        m.addAttribute("name", "Aliens");
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m){
        int num3 = i + j;
        m.addAttribute("num3", num3);

        return "result";
    }

    @GetMapping("getAliens")
    public String getAlien(Model m){
        m.addAttribute("aliensresults", repo.findAll());
        return "showAliens";
    }

    @GetMapping("getAlien")
    public String getAlien(@RequestParam int aid, Model m){
        m.addAttribute("aliensresults", repo.getOne(aid));
        return "showAliens";
    }

    @PostMapping("addAlien")
    public String addAlien(@ModelAttribute("alien") Alien a){
        repo.save(a);
        return "result";
    }
}
