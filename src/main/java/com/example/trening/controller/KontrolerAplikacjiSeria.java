package com.example.trening.controller;

import com.example.trening.dao.CwiczenieDao;
import com.example.trening.dao.SeriaDao;
import com.example.trening.model.Cwiczenie;
import com.example.trening.model.Seria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@Controller
public class KontrolerAplikacjiSeria {
    private SeriaDao seriaDao;
    private CwiczenieDao cwiczenieDao;

    public KontrolerAplikacjiSeria(SeriaDao seriaDao, CwiczenieDao cwiczenieDao) {
        this.seriaDao = seriaDao;
        this.cwiczenieDao = cwiczenieDao;
    }

    @RequestMapping("/wyswietlCwiczenie/{id}")
    public String wyswietlSerieDanegoCwiczenia(Model model, @PathVariable(name="id") int cwiczenieID)
    {
        List<Seria> listaSerii = seriaDao.znajdzSerieDanegoCwiczenia(cwiczenieID);
        String nazwaCwiczenia = cwiczenieDao.findById(cwiczenieID).get().getNazwa_cwiczenia().getNazwa();
        model.addAttribute("listaSerii", listaSerii);
        model.addAttribute("cwiczenieID", cwiczenieID);
        model.addAttribute("nazwaCwiczenia", nazwaCwiczenia);
        return "widokSerii";
    }

    @GetMapping("/dodajSerie/{cwiczenieID}")
    public ModelAndView wyswietlOknoDodaniaSerii(Model model, @PathVariable(name = "cwiczenieID") int cwiczenie_id)
    {
        ModelAndView mav = new ModelAndView("dodajSerie");
        Seria seria = new Seria();
        mav.addObject("seria", seria);
        model.addAttribute("cwiczenie_id", cwiczenie_id);
        return mav;
    }

    @RequestMapping(value ="/zapiszSerie/{cwiczenieId}", method = RequestMethod.POST)
    public String zapiszNowaSerie(@ModelAttribute("seria") Seria seria, @PathVariable(name="cwiczenieId") int cwiczenieID)
    {
        Optional<Cwiczenie> cwiczenie = cwiczenieDao.findById(cwiczenieID);
        seria.setCwiczenie(cwiczenie.get());
        seriaDao.save(seria);
        return "redirect:/wyswietlCwiczenie/"+cwiczenieID;
    }

    @RequestMapping("/usunSerie/{seriaId}")
    public String usunSerie(@PathVariable(name = "seriaId") int seriaID)
    {
        Seria seria = seriaDao.findById(seriaID).get();
        Cwiczenie cwiczenie = seria.getCwiczenie();
        seriaDao.delete(seria);
        return "redirect:/wyswietlCwiczenie/"+ cwiczenie.getId();
    }

    @RequestMapping("/edytujSerie/{seriaId}")
    public ModelAndView edytujSerie(Model model, @PathVariable(name = "seriaId") int seriaID)
    {
        ModelAndView mav = new ModelAndView("edytujSerie");
        Seria seria = seriaDao.findById(seriaID).get();
        seria.setId(seriaID);
        int cwiczenieID = seria.getCwiczenie().getId();
        mav.addObject("seria", seria);
        model.addAttribute("cwiczenie_id", cwiczenieID);
        return mav;
    }

    @RequestMapping(value ="/zapiszZmianySerii/{seriaId}", method = RequestMethod.POST)
    public String zapisEdycjiSeria(@ModelAttribute("seria") Seria seria, @PathVariable(name="seriaId") int seriaId)
    {
        Seria seriaDB = seriaDao.findById(seriaId).get();
        int cwiczenieID = seriaDB.getCwiczenie().getId();
        Cwiczenie cwiczenie = cwiczenieDao.findById(cwiczenieID).get();
        seria.setId(seriaId);
        seria.setCwiczenie(cwiczenie);
        seriaDao.save(seria);
        return "redirect:/wyswietlCwiczenie/"+cwiczenieID;
    }
}
