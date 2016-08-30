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
        
        Scanner entrada = new Scanner(System.in);
        int opcao =0;
        do{
            System.out.println("O que voce deseja fazer?");
            try{                                                  // FUNÇÃO DE VERIFICAÇÃO 
                opcao = Integer.parseInt(entrada.nextLine());     // nextLine le uma string e o integer.parse transforma em int 
                System.out.println("O usuario digitou " +opcao);
            }catch(Exception e){                                  //USA A CLASSE EXCEPTION PARA RECEBER QUALQUER VALOR
                System.out.println("Nao deu certo informe novamente"); // ENTRA NO CATCH SE NAO FOR POSSIVEL COVERTER O VALOR DIGITADO PARA INT
        }
        }while(opcao != 1 && opcao != 2);
        if(opcao ==1){
            EquipamentoVisao.exibirFormularioCadastroEquipamento();
        }
        
    }
}
