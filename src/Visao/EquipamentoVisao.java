/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;
 
import Controle.EquipamentoControle;
import Modelo.Equipamento;
import Modelo.EquipamentoDAO;
import Modelo.Manutencao;
import Modelo.ManutencaoDAO;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author 5927951
 */
public class EquipamentoVisao implements Initializable{
    
    @FXML
    private TextField txtNomeEquipamento;
    @FXML
    private TextField txtNumeroPatrimonio;
    @FXML
    private TextField txtValor;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //txtNomeEquipamento.setText("Olá Mundo");
    }
//    public void onClickBotao(){
//        String nome = txtNomeEquipamento.getText();
//        String numero = txtNumeroPatrimonio.getText();
//        String valor = txtValor.getText();
//        Float valorEmFloat = Float.parseFloat(valor);
//        
//        EquipamentoControle.receberFormularioCadastroEquipamento(nome, numero, null, null, valorEmFloat);
//        
//    }
    
    public void onClickSalvar(){
        //System.out.print("ola");
        String nome = txtNomeEquipamento.getText();
        String patrimonio = txtNumeroPatrimonio.getText();
        String valor = txtValor.getText();
        
        System.out.println(nome);
    }
    
    
    public static void exibirFormularioCadastroEquipamento(){
        System.out.println("=== TELA DE CADASTRO DE EQUIPAMENTO ===");
        Scanner  entrada = new Scanner(System.in);
        String nome, patrimonio;
        Date dataAquisicao, dataTerminoGarantia;
        float valor;
        
        System.out.println("Informe o nome");
        nome = entrada.nextLine();                                              // LEITURA COMO STRING
        System.out.println("Informe o numero de patrimonio");
        patrimonio = entrada.nextLine();
        System.out.println("Informe a data de aquisicao");
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        formatadorData.setLenient(false);
        do{
        try{
            dataAquisicao = formatadorData.parse(entrada.nextLine());           // VERIFICA SE É O FORMATO CORRETO PARA A DATA
            break;
        }catch(Exception e){
            System.out.println("Data invalida. Digite Novamente");
        }
        }while(true);
        
        System.out.println("Informe a data de termino da garantia");
        do{
            try{
                dataTerminoGarantia = formatadorData.parse(entrada.nextLine());
                if(dataTerminoGarantia.after(dataAquisicao)){ //VERIFICA SE A DATA DA GARANTIA É MAIOR DO Q A DATA DE AQUISIÇÃO
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
            
        EquipamentoControle.receberFormularioCadastroEquipamento(nome, patrimonio, dataTerminoGarantia, dataAquisicao, valor);
        Menu.exibirMenu();        
    }
    
    public static void exibirListagemEquipamentos(){
        System.out.println("=== TELA DE LISTAGEM DE EQUIPAMENTOS ===");
        System.out.println("NOME \t NÚMERO PATROMONIO \t NÚMERO MANUTENÇÕES \t TOTAL GASTO");
        //int i=0;
        for(Equipamento obj : EquipamentoControle.obterListaEquipamentos()){
            ArrayList<Manutencao> listaDeManutencoes = ManutencaoDAO.obterLista(obj);
            System.out.println(obj.getNome() + "\t " + obj.getPatrimonio()+"\t " + listaDeManutencoes.size() + "\t " + obj.getTotalGastoManutencoes());
            //i++;
        }
 
//          ArrayList<Equipamento> lista = EquipamentoDAO.obterLista();
//          
//          for(int i=0; i<lista.size();i++){
//              Equipamento obj = null;
//              ArrayList<Manutencao> listaDeManutencoes = ManutencaoDAO.obterLista(obj);
//              System.out.println(lista.get(i).getNome()+"\t"+lista.get(i).getPatrimonio()+"\t"+listaDeManutencoes.size()+"\t"+listaDeManutencoes.get(i).getValor());
//          }
//        System.out.println("Nome: \t Numero do Patrimonio: \t Data Inicio Garantia \t Data Termino Garantia \t Gasto com Manutenções ");
//        
//        try{
//            Path caminhoArquivo = Paths.get("Equipamento.txt");
//            for(String linha : Files.readAllLines(caminhoArquivo)){
//                linha.split("; ");
//                System.out.println(linha);
//            }
//        }catch(Exception e){
//        
//        }    
        System.out.println("O que deseja fazer?");
        System.out.println("0) Voltar ao menu");
        System.out.println("Número do patrimônio) Cadastrar manutenção para o equipamento");
        
        Scanner entrada = new Scanner(System.in);
        String valorDigitado = entrada.nextLine();
        
        if(entrada.equals("0")){
            Menu.exibirMenu();
        }else{
            Equipamento encontrado = EquipamentoControle.obterEquipamentoPeloNumeroPatrimonio(valorDigitado);
            if(encontrado == null){
               System.out.println("ERRO! Equipamento não encontrado");
               Menu.exibirMenu();
            }else{
                ManutencaoVisao.exibirFormularioCadastroManutencao(valorDigitado);
            }
        }
   
    }

    
}
