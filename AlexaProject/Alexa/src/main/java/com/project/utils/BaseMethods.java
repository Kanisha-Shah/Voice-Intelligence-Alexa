package com.project.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class BaseMethods {

	public static String getUsername() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUsername();
	}
	
	/*
	 * public static void setCreatedBy() { BaseMethods.cast(); }
	 */
	
	/*
	 * private static void cast(Object obj, Class<Object> class1) { class1 obj1 =
	 * (class1)obj; }
	 */
}
