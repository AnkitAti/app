package com.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.factory.beans.User;

@Controller
public class SearchController {
	
	@RequestMapping(value="/searchCook" , method = {RequestMethod.POST, RequestMethod.GET})
	public List<User> searchCook(@RequestParam String place) {
		return null;
	}
	
}
