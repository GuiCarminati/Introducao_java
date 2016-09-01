/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Armazenamento.MeioArmazenamento;
import java.util.Scanner;
/**
 *
 * @author 5927951
 */
public class Menu {
    public static void exibirMenu(){
        do{
            System.out.println("==== MENU PRINCIPAL ====");
            System.out.println("Número de equipamentos: "+MeioArmazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS.size());

            System.out.println("Seleciona a opção:");
            System.out.println("1) Cadastro equipamento");
            System.out.println("2) Listagem de equipamentos");
            System.out.println("Outro valor) Sair");
            System.out.println("\nO que você deseja fazer?");

            Scanner entrada = new Scanner( System.in );
            int opcao = 0;
            try{
                opcao = Integer.parseInt(entrada.nextLine());
                System.out.println("O usuario digitou "+opcao);
            }catch(Exception e){
                System.out.println("Não foi possível converter para inteiro");
            }
            if(opcao == 1){
                EquipamentoVisao.exibirFormularioCadastroEquipamento();
            }else if(opcao == 2){
                EquipamentoVisao.exibirListagemEquipamentos();
            }else{
                System.exit(0);
            }
        }while(true);
        
    }
}