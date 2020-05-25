package com.uca.capas.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Importancia;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteDAO estudianteDAO;
	@Autowired
	private ImportanciaDAO importanciaDAO;
	@Autowired
	private ContribuyenteDAO contribuyenteDAO;
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		
		List<Contribuyente> contribuyentes = null;
		try {
			
			contribuyentes = contribuyenteDAO.findAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("listado");
		
		return mav;
	}
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias = null;
		try {
			importancias = importanciaDAO.findAll();
		}catch (Exception e){
			e.printStackTrace();
		}
		mav.addObject("ListImportancia", importancias);
		mav.addObject("contribuyente", new Contribuyente());
		mav.setViewName("index");
		return mav;
	}
	
	@PostMapping("/saveContribuyente")
	public ModelAndView formProducto(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
	    Date date = new Date();  
		
		if(!result.hasErrors()) {
			try {
				contribuyente.setFecha(date);
				contribuyenteDAO.insert(contribuyente);
				mav.setViewName("exito");
				
			}catch (Exception e) {
				e.printStackTrace();
				mav.setViewName("index");
			}
			
			contribuyente = new Contribuyente();
			mav.addObject("contribuyente", contribuyente);
			
		}
		
		
		
		return mav;
		
	}
	
	@RequestMapping("/formEstudiante")
	public ModelAndView formProducto(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if(!result.hasErrors()) {
			try {
				
				estudianteDAO.insert(estudiante);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			estudiante = new Estudiante();
			mav.addObject("estudiante", estudiante);
			
		}
		
		mav.setViewName("index");
		
		return mav;
		
	}
	
	@RequestMapping("/deleteContribuyente")
	public String delete(@RequestParam Integer codigo) {
		Contribuyente estudiante = contribuyenteDAO.findOne(codigo);
			try {
				
				contribuyenteDAO.delete(estudiante);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		return "redirect:/listado";
		
	}

}