package com.example.trening.controller;

import com.example.trening.dao.CwiczenieDao;
import com.example.trening.dao.CwiczenieNazwaDao;
import com.example.trening.dao.TreningDao;
import com.example.trening.model.Cwiczenie;
import com.example.trening.model.NazwaCwiczenia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class KontrolerAplikacjiCwiczenie {
    private CwiczenieDao cwiczenieDao;
    private CwiczenieNazwaDao cwiczenieNazwaDao;
    private TreningDao treningDao;

    public KontrolerAplikacjiCwiczenie(CwiczenieDao cwiczenieDao, CwiczenieNazwaDao cwiczenieNazwaDao, TreningDao treningDao) {
        this.cwiczenieDao = cwiczenieDao;
        this.cwiczenieNazwaDao = cwiczenieNazwaDao;
        this.treningDao = treningDao;
    }

    @GetMapping("/edytujTrening/{treningID}")
    public String wyswietlCwiczeniaWTreningu(Model model,@PathVariable(name="treningID") int treningID)
    {
        List<Cwiczenie> listaCwiczen = cwiczenieDao.znajdzCwiczeniaZTreningu(treningID);
        String dataTreningu = treningDao.findById(treningID).get().getData();
        model.addAttribute("listaCwiczen", listaCwiczen);
        model.addAttribute("treningID", treningID);
        model.addAttribute("dataTreningu", dataTreningu);
        return "widokCwiczen";
    }

    @GetMapping("/dodajCwiczenie/{treningId}")
    public ModelAndView wyswietlOknoDodaniaCwiczenia(Model model, @PathVariable(name="treningId") int treningID)
    {
        ModelAndView mav = new ModelAndView("dodajCwiczenie");
        Cwiczenie cwiczenie = new Cwiczenie();
        cwiczenie.setTrening_id(treningID);
        System.out.println(cwiczenie);
        List<NazwaCwiczenia> listaNazw = cwiczenieNazwaDao.findAll();
        model.addAttribute("listaNazw", listaNazw);
        mav.addObject("cwiczenie", cwiczenie);
        model.addAttribute("treningID", treningID);
        return mav;
    }

    @RequestMapping(value ="/zapiszCwiczenie/{treningId}", method = RequestMethod.POST)
    public String zapiszNoweCwiczenie(@ModelAttribute("cwiczenie") Cwiczenie cwiczenie, @PathVariable(name="treningId") int treningID)
    {
        System.out.println("Przed: "+ cwiczenie);
        cwiczenie.setTrening_id(treningID);
        System.out.println("Po: " + cwiczenie);
        cwiczenieDao.save(cwiczenie);
        return "redirect:/edytujTrening/"+treningID;
    }

    @GetMapping("/usunCwiczenie/{id}")
    public String usunCwiczenie(@PathVariable(name = "id") int id)
    {
        Optional<Cwiczenie> cwiczenie = cwiczenieDao.findById(id);
        int treningID = cwiczenie.get().getTrening_id();
        cwiczenieDao.deleteById(id);
        return "redirect:/edytujTrening/"+treningID;
    }

    @RequestMapping("/powrótDoListyCwiczen/{cwiczenieID}")
    public String powrotDoListyCwiczen(@PathVariable (name = "cwiczenieID") int cwiczenieID)
    {
        int treningID = cwiczenieDao.findById(cwiczenieID).get().getTrening_id();
        return "redirect:/edytujTrening/"+ treningID;
    }
}

