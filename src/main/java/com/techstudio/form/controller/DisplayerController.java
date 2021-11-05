package com.techstudio.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayerController {

	@RequestMapping("/mainMenu")
	public String showIndex() {
		return "main-menu";
	}
}
