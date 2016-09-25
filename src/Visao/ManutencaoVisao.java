/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.EquipamentoControle;
import Modelo.Equipamento;
import Modelo.EquipamentoDAO;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JComboBox;
/**
 *
 * @author 5927951
 */
public class ManutencaoVisao implements Initializable {
    
    @FXML
    private TextField txtDescricao;
    @FXML
    private TextField txtValorManutencao;
    @FXML
    private DatePicker dataManutencao;
    @FXML
    private ComboBox<Equipamento> txtListaEquipamentos;
    private ObservableList<Equipamento> listaEquimanetosDados = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        for(int i=0; i< EquipamentoDAO.obterLista().size();i++){
            listaEquimanetosDados.add(EquipamentoDAO.obterLista().get(i));
        }
        txtListaEquipamentos.setItems(listaEquimanetosDados);
    }
    
   public void onClickSalvarManutencao(ActionEvent e) throws IOException{
        String descricao = txtDescricao.getText();
        String valor = txtValorManutencao.getText();
        Float valorFloat = Float.parseFloat(valor);
        
        String numeroPatrimonio = txtListaEquipamentos.getValue().getPatrimonio();
        
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataManutencaoFinal = null;
        String dataManutencaoString = dataManutencao.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
   
        try {
            dataManutencaoFinal = formatadorData.parse(dataManutencaoString);
            System.out.println(dataManutencaoFinal);
        } catch (Exception ex) {
            
        }
        EquipamentoControle.receberDadosNovaManutencao(numeroPatrimonio, descricao, dataManutencaoFinal, valorFloat);
        
         Button quemFoi =(Button) e.getSource();
        Scene cenaAtual = quemFoi.getScene();
        Stage palcoAtual =(Stage) cenaAtual.getWindow();
        
        // RETORNO AO MENU
        Pane elementoPrincipalDoNovoPalco = FXMLLoader.load(getClass().getResource("MenuTela.fxml"));
        Scene novaCena = new Scene(elementoPrincipalDoNovoPalco);
        palcoAtual.setScene(novaCena);
        palcoAtual.show();
    }
    
   public static void exibirFormularioCadastroManutencao(String numeroPatrimonio){
        Scanner entrada = new Scanner( System.in );
        System.out.println("==== TELA DE CADASTRO DE MANUTENÇÃO DO EQUIPAMENTO "+numeroPatrimonio+" ====");
        String descricao;
        Date data;
        float valor;
                
        System.out.println("Informe a descrição: ");
        descricao = entrada.nextLine();
        System.out.println("Informe a data: ");
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        formatadorData.setLenient(false);
        do{
            try{
                data = formatadorData.parse(entrada.nextLine());
                break;
            }catch(Exception  e){
                System.out.println("Data inválida!!! Digite novamente!");
            }
        }while(true);
        System.out.println("Informe o valor: ");
        do{
            try{
                valor = Float.parseFloat(entrada.nextLine());
                break;
            }catch(Exception e){
                System.out.println("Valor inválido!!! Digite novamente!");
            }
            
        }while(true);
       
        EquipamentoControle.receberDadosNovaManutencao(numeroPatrimonio, descricao, data, valor);
  
    }

}
