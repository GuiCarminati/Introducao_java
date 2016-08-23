/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import java.util.Scanner;

/**
 *
 * @author 5927951
 */
public class Menu {
    public static void exibirMenu(){
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("Selecione a opção:");
        System.out.println("1) Cadastrar equipamento");
        System.out.println("2) Listagem de equipamentos");
        System.out.println("O qeu voce deseja fazer?");
        
        Scanner entrada = new Scanner(System.in);
        
        try{ 
            int opcao = entrada.nextInt();
            System.out.println("O usuario digitou " +opcao);
        }catch(Exception e){                                                    // exception classe mais abrangente
            System.out.println("Nao deu certo porque "+e.getMessage());
        }
        
    }
}
