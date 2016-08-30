/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Armazenamento.MeioArmazenamento;
import java.util.Date;
import Modelo.Equipamento;
import java.util.ArrayList;

/**
 *
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
}
