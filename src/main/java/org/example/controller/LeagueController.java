package org.example.controller;
import org.example.League;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/league")
public class LeagueController {
    @GetMapping("/showForm")
    public String showForm()
    {
        return "show-form";
    }
    @PostMapping("/processForm")
    public String processForm(@RequestParam("lName") String name, @RequestParam("lYear") Integer year, @RequestParam("lSeason") String season, Model theModel)
    {
        League league=new League(name,year,season);

        theModel.addAttribute("LEAGUE",league);

        return "process-form";
    }

}
