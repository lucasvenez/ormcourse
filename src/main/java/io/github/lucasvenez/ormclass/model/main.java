
package io.github.lucasvenez.ormclass.model;

import io.github.lucasvenez.dao.OrderDAOTest;
import java.util.Scanner;

/**
 *
 * @author Nikolas Lencioni
 */
public class main {
    
    public static void main (String [] args){
        
        Scanner scanf = new Scanner(System.in);
       
        OrderDAOTest order = new OrderDAOTest();
        
        System.out.printf("Nome:\n");
        String nome = scanf.nextLine();
        
        System.out.printf("Cidade:\n");
        String cidade = scanf.nextLine();
        
        System.out.printf("Estado:\n");
        String estado = scanf.nextLine();
        
        System.out.printf("País:\n");
        String pais = scanf.nextLine();
        
        order.setUp(nome, cidade, estado, pais);
    }
}
