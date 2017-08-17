/**
 * 
 */
package com.metacube.webservice;

import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

/**
 * A webservice client that calls a temperature conversion webservice 
 * @author Gaurav Tak
 *
 */
public class TemperatureConverterClient {
	/**
	 * to create a web service object by locating weservice and call temperature convertion method
	 * @param args default main command line argument
	 */
    public static void main(String[] args) {
        FahranheitToCelsiusServiceLocator fahranheitToCelsiusServiceLocator=
        		new FahranheitToCelsiusServiceLocator();						// for retrieving a handle to the service
        fahranheitToCelsiusServiceLocator.setFahranheitToCelsiusEndpointAddress(
        		"http://localhost:8080/SOAPWebService/services/FahranheitToCelsius");  //the uri to access webservice
        do{
            try{
                FahranheitToCelsius fahranheitToCelsius=fahranheitToCelsiusServiceLocator.getFahranheitToCelsius();
                System.out.print("Enter temperature in fahraenheit : ");
                double convertedValue=fahranheitToCelsius.convertFahranheitToCelsius(new Scanner(System.in).nextDouble());
                convertedValue=Math.round(convertedValue*100.0)/100.0;
                System.out.println("Temperature in Celsius : "+convertedValue);
            }catch(RemoteException | ServiceException e){
                System.out.println("Error connecting server");
                System.exit(0);
            }catch(InputMismatchException e){
                	System.out.println("Enter temperature in numeric only");
            }
        }while(true);		// loop until client exits 
    }
}
