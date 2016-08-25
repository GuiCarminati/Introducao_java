/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.Date;
import Modelo.Equipamento;

/**
 *
 * @author 5927951
 */
public class EquipamentoControle {
    
    public static void receberFormularioCadastroEquipamento(String nome, String patrimonio, Date dataTerminoGarantia, Date dataAquisicao, float valor ){
        Equipamento objetoEquipamento = new Equipamento();
        objetoEquipamento.setNome(nome);
        objetoEquipamento.setPatrimonio(patrimonio);
        objetoEquipamento.setDataAquisicao(dataAquisicao);
        objetoEquipamento.setDataTerminoGarantia(dataTerminoGarantia);
        objetoEquipamento.setValor(valor);
        
        objetoEquipamento.salvar();
    }
}
