/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 5927951
 */
public class EquipamentoVisao {
    
    public static void exibirFormularioCadastroEquipamento(){
        System.out.println("=== TELA DE CADASTRO DE EQUIPAMENTO ===");
        Scanner  entrada = new Scanner(System.in);
        String nome, patrimonio;
        Date dataAquisicao, dataTerminoGarantia;
        float valor;
        
        
        System.out.println("Informe o nome");
        nome = entrada.nextLine();
        System.out.println("Informe o numero de patrimonio");
        patrimonio = entrada.nextLine();
        System.out.println("Informe a data de aquisicao");
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        formatadorData.setLenient(false);
        do{
        try{
            dataAquisicao = formatadorData.parse(entrada.nextLine());
            break;
        }catch(Exception e){
            System.out.println("Data invalida. Digite Novamente");
        }
        }while(true);
        
        System.out.println("Informe a data de termino da garantia");
        do{
            try{
                dataTerminoGarantia = formatadorData.parse(entrada.nextLine());
                if(dataTerminoGarantia.after(dataAquisicao)){
                    break;
                }else{
                    System.out.println("Data de garantia deve ser maior do que data de aquisicao");
                }
                
            }catch(Exception e){
                System.out.println("Data invalida. Digite Novamente");
            }
        }while(true);
        
        System.out.println("Informe o valor");
        do{
            try{
                valor = Float.parseFloat(entrada.nextLine());
                break;
            }catch(Exception e){
                System.out.println("Valor Invalido!! Digite Novamente");
            }
        }while(true);
            
        
    }
}
