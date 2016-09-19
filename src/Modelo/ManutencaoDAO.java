/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Micro Solution
 */
public class ManutencaoDAO {
     public static ArrayList<Manutencao> obterLista(Equipamento equipamento){
        ArrayList<Manutencao> retorno = new ArrayList<>();
        try {
            Path localManutencoes = Paths.get("Armazenamento/manutencoes_equipamento_"+equipamento.getPatrimonio()+".txt");
            if(localManutencoes.toFile().exists()){
                for(String linhaManutencao : Files.readAllLines(localManutencoes)){
                    String dadosManutencao[] = linhaManutencao.split(";");
                    Manutencao manutencao = new Manutencao();
                    manutencao.setDescricao(dadosManutencao[0]);
                    DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                    manutencao.setData(formatador.parse(dadosManutencao[1]));
                    manutencao.setValor(Float.parseFloat(dadosManutencao[2]));
                    retorno.add(manutencao);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManutencaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public static void salvar(Equipamento equipamento){
        try {
            Path local = Paths.get("Armazenamento/manutencoes_equipamento_"+equipamento.getPatrimonio()+".txt");
            String separadorLinha = System.getProperty("line.separator");
            String manutencoesString = "";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for(Manutencao manutencao : equipamento.getListaManutencao()){
                 manutencoesString = manutencoesString + manutencao.getDescricao()+";"+sdf.format(manutencao.getData())+";"+manutencao.getValor()+separadorLinha;
            }
            Files.write(local, manutencoesString.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(ManutencaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
