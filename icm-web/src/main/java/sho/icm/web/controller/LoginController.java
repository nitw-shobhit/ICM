package sho.icm.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.google.api.Google;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sho.icm.web.helper.login.SocialContext;
import sho.icm.web.helper.login.SocialType;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private SocialContext socialContext;

	@RequestMapping(value = "/social", method = RequestMethod.GET)
	public ModelAndView redirectToUserProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SocialType type = socialContext.isSignedIn(request, response);
		if (type != null) {
			@SuppressWarnings("unused")
			String email = getEmailForUser(type);
			// Do whatever you want with the email.
		} else {
			//Redirect to the login page.
		}

		return null;
	}

	private String getEmailForUser(SocialType type) {
		String emailId = null;
		if(SocialType.FACEBOOK.equals(type)) {
			Facebook facebook = socialContext.getFacebook();
			emailId = facebook.userOperations().getUserProfile().getEmail();
		} else if(SocialType.GOOGLE.equals(type)) {
			Google google = socialContext.getGoogle();
			emailId = google.plusOperations().getGoogleProfile().getAccountEmail();
		} else if(SocialType.LINKEDIN.equals(type)) {
			LinkedIn linkedIn = socialContext.getLinkedIn();
			linkedIn.profileOperations().getUserProfile().getEmailAddress();
		} else if(SocialType.TWITTER.equals(type)) {
			Twitter twitter = socialContext.getTwitter();
			emailId = (String) twitter.userOperations().getUserProfile().getExtraData().get("email");
		}
		
		return emailId;
	}
}