
import Visao.Menu;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 5927951
 */
public class Principal extends Application {
   
    public static void main(String[] args) {
//        File arquivo = new File("teste.txt");
//        try{
              //java 7-
//            Scanner entrada = new Scanner(arquivo);
//            int linhaAtual =0;
//            while(entrada.hasNextLine()){
//                String linha = entrada.nextLine();
//                System.out.println(linhaAtual+"  "+linha);
//                linhaAtual++;
              //java 7+
//            Path caminhoArquivo = Paths.get("teste.txt");
//            for(String linha : Files.readAllLines(caminhoArquivo)){
//            System.out.println(linha);
//            }
            //java 7-
//        PrintWriter escritor = new PrintWriter("teste2.txt");
//        escritor.println("OLA");
//        escritor.println("EU");
//        escritor.println("SOU");
//        escritor.println("O");
//        escritor.println("JAVA");
//        escritor.close();
            //java 7+ escrita
//            Path caminhoArquivo = Paths.get("teste2.txt");
//            ArrayList<String> listaLinhas = new ArrayList();
//            listaLinhas.add("Ola");
//            listaLinhas.add("Mundo");
//            listaLinhas.add("Cruel");
//            Files.write(caminhoArquivo, listaLinhas,StandardOpenOption.APPEND);// sem colocar o 3° parametro o arquivo inicia do zero
//                                                                               // este 3° parametro concatena as string passadas com o que ja esta no arquivo 
//            
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        
//        
//        
//        if(arquivo.exists()){
//            System.out.println("Existe");
//        
//        }else{
//            System.out.println("Não Existe");
//        }
//        String linha = "Ola Mundo eu sou o Java";
//        
        
        
        
       //Menu.exibirMenu();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane principal = FXMLLoader.load(getClass().getResource("Visao/MenuTela.fxml"));
        Scene cena = new Scene(principal);
        stage.setScene(cena); // COLOCA A CENA NO PALCO
        //stage.setHeight(450);
        //stage.setWidth(450);
        stage.show();
    }
}
