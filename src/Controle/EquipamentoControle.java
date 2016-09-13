/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Armazenamento.MeioArmazenamento;
import java.util.ArrayList;
import java.util.Date;
import Modelo.Equipamento;
import Modelo.EquipamentoDAO;
import Modelo.Manutencao;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**  Classe Controle recebe os valores digitados pelo usuário
 *   Onde o objeto é instanciado com os valores fornecidos   
 * @author 5927951
 */
public class EquipamentoControle {
    
    public static void receberFormularioCadastroEquipamento(String nome, String patrimonio, Date dataTerminoGarantia, Date dataAquisicao, float valor ){
        Equipamento objetoEquipamento = new Equipamento(); // CHAMADA DO CONSTRUTOR
        objetoEquipamento.setNome(nome);
        objetoEquipamento.setPatrimonio(patrimonio);
        objetoEquipamento.setDataAquisicao(dataAquisicao);
        objetoEquipamento.setDataTerminoGarantia(dataTerminoGarantia);
        objetoEquipamento.setValor(valor);
        
        EquipamentoDAO.salvar(objetoEquipamento);
    }
    
//    public static ArrayList obterVetor(){
//    
//    return Equipamento.obterListaArquivo();
//    
//    }
    public static ArrayList<Equipamento> obterListaEquipamentos(){
       return EquipamentoDAO.obterLista();
    }
//    public static ArrayList<Equipamento> obterListaArquivo(){
//    
//        ArrayList lista = new ArrayList<>();
//        try{
//            Path caminhoArquivo = Paths.get("Equipamento.txt");
//            for(String linha : Files.readAllLines(caminhoArquivo)){
//                linha.split("; ");
//                //System.out.println(linha);
//            }
//        }catch(Exception e){
//        
//        }
//        return lista;
//    }
    public static Equipamento obterEquipamentoPeloNumeroPatrimonio(String numeroPatrimonio){
        return EquipamentoDAO.obterPeloNumero(numeroPatrimonio);
    }
    public static void receberDadosNovaManutencao(String numeroPatrimonio, String descricao, Date data, float valor){
        Equipamento encontrado = EquipamentoDAO.obterPeloNumero(numeroPatrimonio);
        Manutencao novaManutencao = new Manutencao();
        novaManutencao.setData(data);
        novaManutencao.setDescricao(descricao);
        novaManutencao.setValor(valor);
        
       
        encontrado.adicionaManutencao(novaManutencao);
        //encontrado.salvar();
        //método salvar não necessário por enquanto pois, como os dados estão em memória, o próprio objeto manipulado é o mesmo do meio de armazenamento
    }
    
}
