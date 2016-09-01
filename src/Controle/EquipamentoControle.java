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
import Modelo.Manutencao;

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
        
        objetoEquipamento.salvar();
    }
    
    public static ArrayList<Equipamento> obterListaEquipamentos(){
        return Equipamento.obterLista();
    }
    
    public static Equipamento obterEquipamentoPeloNumeroPatrimonio(String numeroPatrimonio){
        return Equipamento.obterPeloNumero(numeroPatrimonio);
    }
    public static void receberDadosNovaManutencao(String numeroPatrimonio, String descricao, Date data, float valor){
        Equipamento encontrado = Equipamento.obterPeloNumero(numeroPatrimonio);
        Manutencao novaManutencao = new Manutencao();
        novaManutencao.setData(data);
        novaManutencao.setDescricao(descricao);
        novaManutencao.setValor(valor);
        
       
        encontrado.adicionaManutencao(novaManutencao);
        //encontrado.salvar();
        //método salvar não necessário por enquanto pois, como os dados estão em memória, o próprio objeto manipulado é o mesmo do meio de armazenamento
    }
}
