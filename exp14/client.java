/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author NIKITHA
 */
import ex14.NewWebService;
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(view());
    }

    private static String view() {
        ex14.NewWebService_Service service = new ex14.NewWebService_Service();
        ex14.NewWebService port = service.getNewWebServicePort();
        return port.view();
    }
    
}