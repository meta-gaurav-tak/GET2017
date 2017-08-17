package com.metacube.webservice;

public class FahranheitToCelsiusProxy implements com.metacube.webservice.FahranheitToCelsius {
  private String _endpoint = null;
  private com.metacube.webservice.FahranheitToCelsius fahranheitToCelsius = null;
  
  public FahranheitToCelsiusProxy() {
    _initFahranheitToCelsiusProxy();
  }
  
  public FahranheitToCelsiusProxy(String endpoint) {
    _endpoint = endpoint;
    _initFahranheitToCelsiusProxy();
  }
  
  private void _initFahranheitToCelsiusProxy() {
    try {
      fahranheitToCelsius = (new com.metacube.webservice.FahranheitToCelsiusServiceLocator()).getFahranheitToCelsius();
      if (fahranheitToCelsius != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fahranheitToCelsius)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fahranheitToCelsius)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fahranheitToCelsius != null)
      ((javax.xml.rpc.Stub)fahranheitToCelsius)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.webservice.FahranheitToCelsius getFahranheitToCelsius() {
    if (fahranheitToCelsius == null)
      _initFahranheitToCelsiusProxy();
    return fahranheitToCelsius;
  }
  
  public double convertFahranheitToCelsius(double temperature) throws java.rmi.RemoteException{
    if (fahranheitToCelsius == null)
      _initFahranheitToCelsiusProxy();
    return fahranheitToCelsius.convertFahranheitToCelsius(temperature);
  }
  
  
}