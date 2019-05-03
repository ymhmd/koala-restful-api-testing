package com.koala.apitesting.utilities;


public class Validation {
	public static boolean isMatched(String str, String regex){
        return str.matches(regex);
	}
}
