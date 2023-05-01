/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import servicepack.NewWebService;
public class JavaApplication3 {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(view());
    }

    private static String view() {
        servicepack.NewWebService_Service service = new servicepack.NewWebService_Service();
        servicepack.NewWebService port = service.getNewWebServicePort();
        return port.view();
    }
    
}
