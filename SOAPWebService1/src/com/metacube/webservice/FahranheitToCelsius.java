package com.metacube.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
/***
 * a webservice class to define methods of the service 
 * @author Gaurav Tak
 *
 */
@WebService
public class FahranheitToCelsius {
	/**
	 * 
	 * @param temperature input from client in faranheit
	 * @return a double value of temperature in celsius
	 */
    @WebMethod
    public double convertFahranheitToCelsius(double temperature) {
        return ((temperature-32)*5)/9;
    }
}
