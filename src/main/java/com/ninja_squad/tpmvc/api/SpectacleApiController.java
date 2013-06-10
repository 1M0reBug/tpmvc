package com.ninja_squad.tpmvc.api;

import com.ninja_squad.iut.tpjpa.model.Representation;
import com.ninja_squad.iut.tpjpa.model.Spectacle;
import com.ninja_squad.iut.tpjpa.service.SpectacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/api/spectacles")
public class SpectacleApiController {

    @Autowired
    private SpectacleService spectacleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Spectacle> list() {
        return spectacleService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Spectacle view(@PathVariable("id") Long id) {
        return spectacleService.findById(id);
    }

    @RequestMapping(value = "/{id}/representations", method = RequestMethod.GET)
    public @ResponseBody Set<Representation> representations(@PathVariable("id") Long id) {
        Spectacle spectacle = spectacleService.findById(id);
        if (spectacle == null) {
            return Collections.emptySet();
        }

        return spectacle.getRepresentations();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Spectacle create(@ModelAttribute Spectacle spectacle, BindingResult bindingResult) {
        ValidationUtils.rejectIfEmpty(bindingResult, "titre", "titre.empty");
        ValidationUtils.rejectIfEmpty(bindingResult, "artiste", "artiste.empty");
        ValidationUtils.rejectIfEmpty(bindingResult, "type", "type.empty");

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException();
        }
        return spectacleService.createSpectacle(spectacle);
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String whenInvalidRequest() {
        return "invalid data";
    }
}
