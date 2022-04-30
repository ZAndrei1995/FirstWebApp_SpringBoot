package com.example.firstwebapp_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ApplicationController {
    @Autowired
    private ProductService productService ;


    @RequestMapping("/")
    public String viewHomePage ( Model model ) {
        List<tipurimasini> listProducts = productService.listAll();
        model.addAttribute("listProducts",listProducts);
        return "index" ;
    }

    @RequestMapping("/new")
    public String adaugaMasinaNoua(Model model) {
        tipurimasini tipurimasini = new tipurimasini() ;
        model.addAttribute("tipurimasini", tipurimasini) ;
        return "masina_noua";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveCarInDataBase(@ModelAttribute("tipurimasini") tipurimasini tipurimasini) {
        productService.save(tipurimasini);

        return "redirect:/" ;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editeazaMasinaNoua(@PathVariable(name="id") int id) {

        ModelAndView modelAndView = new ModelAndView("editeazamasina");
        tipurimasini tipurimasini = productService.getID(id) ;
        modelAndView.addObject("tipurimasini", tipurimasini) ;

        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar (@PathVariable(name="id") int id ) {
        productService.deleteFromDB(id);

        return "redirect:/" ;
    }

}
