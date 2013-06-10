package com.ninja_squad.tpmvc.api;

import com.ninja_squad.iut.tpjpa.model.Representation;
import com.ninja_squad.iut.tpjpa.model.Spectacle;
import com.ninja_squad.iut.tpjpa.service.SpectacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Set;


@Controller
@RequestMapping("/api/spectacle")
public class SpectacleApiController {

    @Autowired
    private SpectacleService spectacleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Spectacle view(@PathVariable("id") Long id) {
        return spectacleService.findById(id);
    }

    @RequestMapping(value = "/{id}/representations", method = RequestMethod.GET)
    public @ResponseBody
    Set<Representation> representations(@PathVariable("id") Long id) {
        Spectacle spectacle = spectacleService.findById(id);
        if (spectacle == null) {
            return Collections.emptySet();
        }

        return spectacle.getRepresentations();
    }

}
