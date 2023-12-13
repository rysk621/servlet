package utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// utility class : method define 하여 다른 클래스에서 사용할 수 있음.
public class CookieManager {
	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {
		Cookie cookie = new Cookie(cName, cValue);
		cookie.setPath("/"); // 해당 경로 및 하위 경로에서 접근했을 때에만 쿠키 저장
		cookie.setMaxAge(cTime);
		response.addCookie(cookie);
	}
	
	public static String readCookie(HttpServletRequest request, String cName) {
		String cookieValue = "";
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName();
				if (cookieName.equals(cName)) {
					cookieValue = c.getValue();
				}
			}
		}
		return cookieValue;
	}
	
	public static void deleteCookie(HttpServletResponse response, String cName) {
		makeCookie(response, cName, "", 0); // cTime = 0으로 설정, 만들자마자 지움.
	}
}