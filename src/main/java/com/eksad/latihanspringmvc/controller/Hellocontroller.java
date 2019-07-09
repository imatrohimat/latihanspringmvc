/*
package com.eksad.latihanspringmvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hellocontroller {

	@RequestMapping("/hello")
	@ResponseBody
	public String sayhello () {
		return "hello world";
	}
		
		@RequestMapping("/myName")
		@ResponseBody
		public String myName(@RequestParam String myName) {
			return "hello   "+ myName;
	}
		
		@RequestMapping("/namaSaya/{myName}")
		@ResponseBody
		public String myName2(@PathVariable String myName) {
			return "hello   "+ myName;}
		
		@RequestMapping("/toGoogle")
		@ResponseBody
		public String toGoogle() {
			return "<a href='http://www.google.com'> Klik disini menuju Google </a>"
					+ "</br> <a href='https://www.youtube.com'>klik di sini menuju Youtube</a>";
		}
}

*/