package com.eksad.latihanspringmvc.controller;

import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.latihanspringmvc.model.Brand;
import com.eksad.latihanspringmvc.repository.BrandRevositoryDAO;

@Controller
@RequestMapping("brand")
public class BrandController {

private BrandController brandcontroller;

	@Autowired
	BrandRevositoryDAO brandRevositoryDAO;
	
	@RequestMapping("")
	public String index(Model model) {
		List<Brand> listBrand = brandRevositoryDAO.findAll();
		model.addAttribute("listBrand", listBrand);
		return "listBrand";
	}
	

	@RequestMapping("/addBrand")
	public String addBrand(Model model) {

		Brand brand = new Brand();

		model.addAttribute("brand", brand);
		return "addBrand";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Brand brand) {
		brandRevositoryDAO.save(brand);

		return "redirect:/brand";
	}
	 
	@RequestMapping(value = "/editBrand{id}", method = RequestMethod.GET)
	public String editBrand(Model model, @PathVariable int id) {
	   String idAsString = Integer.toString(id);
	    model.addAttribute("brand",brandcontroller.getBrandById(idAsString));
	    return "editBrand{id}";
}
	private Object getBrandById(String idAsString) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping("/deleteBrand")
	public String delete(Model model) {

		Brand brand = new Brand();
		model.addAttribute("brand", brand);
		return "deleteBrand";
	
}
}
	
	/* CARA LAIN
	@RequestMapping(value = "editBrand{id}", method = RequestMethod.POST)
	public String updateBrand(@PathVariable int id, 
	        HttpServletRequest request, Brand brand) {
		 brandcontroller.updateBrand(id, request, brand);
		    return "editBrand";
		}
	}
	
	*/