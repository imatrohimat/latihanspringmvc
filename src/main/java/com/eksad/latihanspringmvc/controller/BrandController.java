package com.eksad.latihanspringmvc.controller;

import java.util.List;
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

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBrand(@PathVariable Long id, Model model) {
		Brand brand = brandRevositoryDAO.findOne(id);
		model.addAttribute("brand", brand);

		return "addBrand";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		brandRevositoryDAO.delete(id);
		return "redirect:/brand";

	}
}