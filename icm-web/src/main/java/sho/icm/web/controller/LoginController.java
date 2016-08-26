package sho.icm.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = "/social", method = RequestMethod.GET)
	public ModelAndView redirectToUserProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return null;
	}
}