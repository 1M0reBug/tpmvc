package com.ninja_squad.tpmvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ninja_squad.iut.tpjpa.model.Spectacle;
import com.ninja_squad.iut.tpjpa.model.TypeDeSpectacle;
import com.ninja_squad.iut.tpjpa.service.SpectacleService;


@Controller
@RequestMapping("/spectacle")
public class SpectacleController {

    @Autowired
    private SpectacleService spectacleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("id") Long id) {
        Spectacle spectacle = spectacleService.findById(id);
        ModelAndView result = new ModelAndView("spectacle");
        result.addObject("spectacle", spectacle);
        return result;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute Spectacle spectacle) {
        return "createSpectacle";
    }

    @ModelAttribute("typesDeSpectacle")
    public List<TypeDeSpectacle> typesDeSpectacle() {
        return Arrays.asList(TypeDeSpectacle.values());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Spectacle spectacle, BindingResult bindingResult) {
        ValidationUtils.rejectIfEmpty(bindingResult, "titre", "titre.empty");
        ValidationUtils.rejectIfEmpty(bindingResult, "artiste", "artiste.empty");
        ValidationUtils.rejectIfEmpty(bindingResult, "type", "type.empty");

        if (bindingResult.hasErrors()) {
            return "createSpectacle";
        }
        spectacleService.createSpectacle(spectacle);
        return "redirect:/";
    }
}
