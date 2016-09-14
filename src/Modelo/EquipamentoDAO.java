/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Armazenamento.MeioArmazenamento;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5927951
 */
public class EquipamentoDAO { // DATA ACESS OBJECT
    public static void salvar(Equipamento paraSalvar){
        //MeioArmazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS.add(this);
        try{
            Path caminhoArquivo = Paths.get("Equipamento.txt");
            //String separadorLinha = System.getProperty("Line.separator");
            String linhaEquip;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            linhaEquip =(paraSalvar.getNome()+";"+paraSalvar.getPatrimonio()+";"+sdf.format(paraSalvar.getDataAquisicao())+";"+sdf.format(paraSalvar.getDataTerminoGarantia())+";"+paraSalvar.getValor())+"\r\n";
            Files.write(caminhoArquivo, linhaEquip.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        
        }catch(Exception e){
            
        }
    }
    public static ArrayList<Equipamento> obterLista(){ //   REPETIÇÃO METODO obterListaArquivos
        //return MeioArmazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS;
        ArrayList<Equipamento> retorno = new ArrayList<>();
        try{
            Path caminhoArquivo = Paths.get("Equipamento.txt");
            for(String linhaAtual : Files.readAllLines(caminhoArquivo)){
                String[] dado = linhaAtual.split(";");
                Equipamento objeto = new Equipamento();
                SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
                objeto.setNome(dado[0]);
                objeto.setPatrimonio(dado[1]);
                objeto.setDataAquisicao(formatadorData.parse(dado[2]));
                objeto.setDataTerminoGarantia(formatadorData.parse(dado[3]));
                objeto.setValor(Float.parseFloat(dado[4]));
                
                retorno.add(objeto);
            }
            }catch(Exception e){ // NECESSARIO MUDAR POR CAUSA DA TRANSFORMAÇÃO DA DATA
                Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, e);
            }
        return retorno;
        
    } 
    
    public static int contaObjetos(){
        int contador =0;
        try{
            Path caminhoArquivo = Paths.get("Equipamento.txt");
            if(caminhoArquivo.toFile().exists()){
                for(String linhaAtual : Files.readAllLines(caminhoArquivo)){
                    contador++;
                }
            }
        }catch(Exception e){
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        return contador;
    }
//    public static ArrayList<Equipamento> obterListaArquivo(){
//        //ArrayList lista = new ArrayList<>();
//        MeioArmazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS = new ArrayList<>();
//        String[] atributos;
//        try {
//            Path caminhoArquivo = Paths.get("Equipamento.txt");
//        
//            for(String linha : Files.readAllLines(caminhoArquivo)){
//                atributos =linha.split(";");
//                Equipamento e = new Equipamento();
//                e.nome = atributos[0];
//                e.patrimonio = atributos[1];
//                SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
//                e.dataAquisicao = formatadorData.parse(atributos[2]);
//                e.dataTerminoGarantia = formatadorData.parse(atributos[3]);
//                e.valor = Float.parseFloat(atributos[4]);
//                
//                MeioArmazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS.add(e);
//            }
//        } catch (IOException | ParseException ex) {
//            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return MeioArmazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS;
//    }
    public static Equipamento obterPeloNumero(String numeroPatrimonio){
        for(Equipamento obj : EquipamentoDAO.obterLista()){
            if(obj.getPatrimonio().equals(numeroPatrimonio)){
                return obj;
            }
        }
        return null;
    }
}
