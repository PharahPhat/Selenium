package com.globalMethods.core;



import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AdditionalInfo {
	//public String Functionality();
	public String module();
}
