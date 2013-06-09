package com.ninja_squad.tpmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ninja_squad.iut.tpjpa.service.SpectacleService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private SpectacleService spectacleServiceImpl;

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("spectacles", spectacleServiceImpl.findAll());
        return "index";
    }
}
