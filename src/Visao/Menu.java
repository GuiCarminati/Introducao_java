/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.Equipamento;
import Modelo.EquipamentoDAO;
import static com.sun.jmx.mbeanserver.Util.cast;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 *
 * @author 5927951
 */
public class Menu implements Initializable {
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    public void abrirTelaEquipamento(ActionEvent e) throws IOException{
        
        Button quemFoi =(Button) e.getSource();
        Scene cenaAtual = quemFoi.getScene();
        Stage palcoAtual =(Stage) cenaAtual.getWindow();

        Pane elementoPrincipalDoNovoPalco = FXMLLoader.load(getClass().getResource("EquipamentoCadastro.fxml"));
        Scene novaCena = new Scene(elementoPrincipalDoNovoPalco);
        palcoAtual.setScene(novaCena);
        palcoAtual.show();
    
    }
    public void abrirTelaManutencao(ActionEvent e) throws IOException{
        
        Button quemFoi =(Button) e.getSource();
        Scene cenaAtual = quemFoi.getScene();
        Stage palcoAtual =(Stage) cenaAtual.getWindow();

        Pane elementoPrincipalDoNovoPalco = FXMLLoader.load(getClass().getResource("ManutencaoCadastro.fxml"));
        Scene novaCena = new Scene(elementoPrincipalDoNovoPalco);
        palcoAtual.setScene(novaCena);
        palcoAtual.show();
    
    }
    public void onClickListagemEquipamento(ActionEvent event) throws IOException{
        Button botaoQueClicou = (Button) event.getSource();
        Stage palco = (Stage) botaoQueClicou.getScene().getWindow();
        Pane principal = FXMLLoader.load(getClass().getResource("ListaEquipamentosTela.fxml"));
        Scene novaCena = new Scene(principal);
        palco.setScene(novaCena);
        palco.show();
    }    
  
}