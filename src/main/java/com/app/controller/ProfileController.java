package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.constants.ApplicationConstants;
import com.app.constants.PropertiesConstants;
import com.app.error.ApplicationException;
import com.app.factory.beans.UserDescription;
import com.app.service.ProfileService;
import com.app.util.AppConfig;
import com.app.util.CommonHelper;

@Controller
public class ProfileController {

	@Autowired private ProfileService service;
	
	@RequestMapping(value="/profile", method={RequestMethod.GET, RequestMethod.POST })
	public ModelAndView displayProfile(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(!CommonHelper.isLoggedIn(request)) {
			request.getSession().setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY, AppConfig.getProperty(PropertiesConstants.LOGIN_ERROR_REQUIRED));
			return new ModelAndView("redirect:/login?redirect=profile");
		}
		String userName = (String) session.getAttribute(ApplicationConstants.USERNAME_KEY);
		if(StringUtils.isBlank(userName)) {
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY, "Something went wrong. Please login again");
			return new ModelAndView("index");
		}
		try {
			ModelAndView mView = new ModelAndView();
			UserDescription userDesc = service.fetchProfileDetails(userName);
			mView.addObject(ApplicationConstants.USER_DESC, userDesc);
			mView.setViewName("user/profile");
			return mView;
		} catch(ApplicationException e) {
			return new ModelAndView("user/home");
		}
	}
	
	@RequestMapping(value="/edit_profile",  method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView editProfile(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(!CommonHelper.isLoggedIn(request)) {
			request.getSession().setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY, AppConfig.getProperty(PropertiesConstants.LOGIN_ERROR_REQUIRED));
			return new ModelAndView("redirect:/login?redirect=profile/edit");
		}
		String username = (String) session.getAttribute(ApplicationConstants.USERNAME_KEY);
		if(StringUtils.isBlank(username)) {
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY, "Something went wrong. Please login again");
			return new ModelAndView("index");
		}
		try {
			ModelAndView mView = new ModelAndView();
			UserDescription userDesc = service.fetchProfileDetails(username);
			mView.addObject(ApplicationConstants.USER_DESC, userDesc);
			mView.setViewName("user/edit_profile");
			return mView;
		} catch(ApplicationException ex) {
			return new ModelAndView("user/home");
		}
	}
}
