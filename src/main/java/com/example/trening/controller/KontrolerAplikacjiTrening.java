package com.example.trening.controller;

import com.example.trening.dao.TreningDao;
import com.example.trening.model.Seria;
import com.example.trening.model.Trening;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class KontrolerAplikacjiTrening {
    private TreningDao treningDao;

    public KontrolerAplikacjiTrening(TreningDao treningDao) {
        this.treningDao = treningDao;
    }

    @GetMapping("/")
    public String pokazStroneGlowno(Model model)
    {
        List<Trening> listaTreningow = treningDao.znajdzWszystkiePosortowane(8);
        model.addAttribute("listaTreningow", listaTreningow);
        return "index";
    }

    @GetMapping("/dodaj")
    public String rozpocznijTrening(Model model)
    {
        LocalDate localDate = LocalDate.now();
        String data = localDate.toString();
        Trening trening = new Trening(data, 8);
        treningDao.save(trening);
        return "redirect:/";
    }

    @GetMapping("/usun/{id}")
    public String usunTrening(@PathVariable(name = "id") int id)
    {
        treningDao.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/notatka/{treningID}")
    public ModelAndView dodajLubEdytujNotatkę(Model model, @PathVariable(name = "treningID") int treiningID)
    {
        ModelAndView mav = new ModelAndView("dodajEdytujNotetke");
        Trening trening = treningDao.findById(treiningID).get();
        mav.addObject("trening", trening);
        model.addAttribute("treningID", treiningID);
        return mav;
    }

    @RequestMapping("/zapiszZmianyNotatka/{treningID}")
    public String zapiszZmianyNotatka(@ModelAttribute("trening") Trening trening, @PathVariable(name="treningID") int treningID)
    {
        Trening treningDB = treningDao.findById(treningID).get();

        System.out.println(trening.getOpis_treningu());
        System.out.println(trening);

        trening.setId(treningDB.getId());
        trening.setData(treningDB.getData());
        trening.setUzytkownik_id(treningDB.getUzytkownik_id());
        treningDao.save(trening);
        return "redirect:/";
    }
}
