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
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    @FXML
    private DatePicker dataAquisicao;
    @FXML
    private DatePicker dataGarantia;
    
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
  public void voltaMenu(ActionEvent e) throws IOException{
    
        Button quemFoi =(Button) e.getSource();
        Scene cenaAtual = quemFoi.getScene();
        Stage palcoAtual =(Stage) cenaAtual.getWindow();
        
        // RETORNO AO MENU
        Pane elementoPrincipalDoNovoPalco = FXMLLoader.load(getClass().getResource("MenuTela.fxml"));
        Scene novaCena = new Scene(elementoPrincipalDoNovoPalco);
        palcoAtual.setScene(novaCena);
        palcoAtual.show();
    } 
    public void onClickSalvar() throws IOException{
        String nome = txtNomeEquipamento.getText();
        String patrimonio = txtNumeroPatrimonio.getText();
        String valor = txtValor.getText();
        Float valorFloat = Float.parseFloat(valor); 
        
        //TRANSFORMAR localDate em Instatnt
        
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAquisicaoFinal = null, dataTerminoGarantia = null;
      
        String dataAquisicaoString = dataAquisicao.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dataGarantiaString = dataGarantia.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        try {
            dataAquisicaoFinal = formatadorData.parse(dataAquisicaoString);
            
        } catch (Exception ex) {
            
        }
        try {
            dataTerminoGarantia = formatadorData.parse(dataGarantiaString);
        } catch (Exception ex) {
            Logger.getLogger(EquipamentoVisao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //LEVA PARA O CONTROLE CRIAR O EQUIPAMENTO

        //System.out.println(dataAquisicaoFinal);
        
        if(!EquipamentoDAO.verficaPatrimonio(patrimonio)){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERRO");
            alerta.setContentText("Numero de Patrimonio ja existe");
            alerta.showAndWait();
        
        }else    
        if(dataTerminoGarantia.before(dataAquisicaoFinal)){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERRO");
            alerta.setContentText("Data de Aquisicão Menor que a data do Término de garantia");
            alerta.showAndWait();
        }else    
        if(dataAquisicaoFinal.after(new Date())){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERRO");
            alerta.setContentText("Data de Aquisição ainda não chegou");
            alerta.showAndWait();
        }else{
            EquipamentoControle.receberFormularioCadastroEquipamento(nome, patrimonio, dataAquisicaoFinal ,dataTerminoGarantia , valorFloat);
        }
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
            
        //EquipamentoControle.receberFormularioCadastroEquipamento(nome, patrimonio, dataTerminoGarantia, dataAquisicao, valor);
        //Menu.exibirMenu();        
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
            //Menu.exibirMenu();
        }else{
            Equipamento encontrado = EquipamentoControle.obterEquipamentoPeloNumeroPatrimonio(valorDigitado);
            if(encontrado == null){
               System.out.println("ERRO! Equipamento não encontrado");
               //Menu.exibirMenu();
            }else{
                ManutencaoVisao.exibirFormularioCadastroManutencao(valorDigitado);
            }
        }
   
    }

    
}
