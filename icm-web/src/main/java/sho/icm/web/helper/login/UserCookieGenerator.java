package sho.icm.web.helper.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.CookieGenerator;

public final class UserCookieGenerator {

	private final CookieGenerator cookieFactory = new CookieGenerator();

	public UserCookieGenerator() {
		cookieFactory.setCookieName("icm-cookie");
	}

	public void addCookie(String userId, HttpServletResponse response) {
		cookieFactory.addCookie(response, userId);
	}

	public void removeCookie(HttpServletResponse response) {
		cookieFactory.addCookie(response, "");
	}

	public String readCookieValue(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieFactory.getCookieName())) {
				return cookie.getValue();
			}
		}
		return null;
	}

}