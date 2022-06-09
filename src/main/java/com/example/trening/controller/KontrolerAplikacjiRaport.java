package com.example.trening.controller;

import com.example.trening.dao.CwiczenieNazwaDao;
import com.example.trening.dao.TreningDao;
import com.example.trening.model.Cwiczenie;
import com.example.trening.model.NazwaCwiczenia;
import com.example.trening.model.PostepSilowy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class KontrolerAplikacjiRaport {
    private TreningDao treningDao;
    private CwiczenieNazwaDao cwiczenieNazwaDao;

    public KontrolerAplikacjiRaport(TreningDao treningDao, CwiczenieNazwaDao cwiczenieNazwaDao) {
        this.treningDao = treningDao;
        this.cwiczenieNazwaDao = cwiczenieNazwaDao;
    }

    @RequestMapping("/raport")
    public ModelAndView wyswietlWyborRaportuZCwiczenia(Model model)
    {
        ModelAndView mav = new ModelAndView("stronaRaportu");
        Cwiczenie cwiczenie = new Cwiczenie();
        List<NazwaCwiczenia> listaNazw = cwiczenieNazwaDao.findAll();
        model.addAttribute("listaNazw", listaNazw);
        mav.addObject("cwiczenie", cwiczenie);
        return mav;
    }

    @RequestMapping(value ="/wyswietlenieRaportu",method = RequestMethod.POST)
    public String wyswietlenieRaportu(Model model, @ModelAttribute("cwiczenie") Cwiczenie cwiczenie)
    {
        int nazwaID = cwiczenie.getNazwa_cwiczenia().getId();
        String nazwaNazwa = cwiczenie.getNazwa_cwiczenia().getNazwa();
        List<Object[]> listaPosrednia = treningDao.znajdzPostepyWCwiczeniu(nazwaID);
        List<PostepSilowy> listaWynikow = new LinkedList<>();
        for (Object[] object: listaPosrednia)
        {
            listaWynikow.add(new PostepSilowy(object));
        }
        model.addAttribute("listaWynikow", listaWynikow);
        model.addAttribute("nazwaNazwa", nazwaNazwa);
        return "widokRaportu";
    }
}
