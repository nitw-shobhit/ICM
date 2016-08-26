package sho.icm.web.helper.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfile;
import org.springframework.social.linkedin.api.ProfileOperations;

@Configuration
public class LinkedInService {

	@Autowired
	private LinkedIn linkedIn;

	public LinkedInProfile getUserProfile() {
		ProfileOperations profileOperations = linkedIn.profileOperations();
		LinkedInProfile userProfile = profileOperations.getUserProfile();

		return userProfile;
	}
}
