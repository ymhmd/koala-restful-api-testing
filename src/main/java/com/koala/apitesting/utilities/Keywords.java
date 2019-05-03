package com.koala.apitesting.utilities;

public class Keywords {
	//New keywords
	public static String TIMESTAMP = "TIMESTAMP";
	public static String STEP = "STEP";
	public static String EMPTY_STRING = "EMPTY_STRING";
	public static String EXECUTION_ID = "EXECUTION_ID";
	//Correlation APIs keywords 
	public static String PREV_BODY = "@body_response";
	public static String PREV_HEADER = "@headers_response";
	public static String PREV_COOKIE = "@cookies_response";
	public static String GLOBAL_VARS = "@global_vars";
	//Validate Headers, Cookies keywords
	public static String NO_VALIDATION = "null";
	public static String VALIDATE_HEADER = "header:";
	public static String VALIDATE_COOKIE = "cookie:";
}
