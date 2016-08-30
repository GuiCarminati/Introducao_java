/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Armazenamento.MeioArmazenamento;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 5927951
 */
public class Equipamento {
    private String nome, patrimonio;
    private Date dataAquisicao, dataTerminoGarantia;
    private float valor;
    private ArrayList<Manutencao> listaManutencoes;   //CADA EQUIPAMENTO PODE ALCANÇAR UMA LISTA DE MANUTENÇÕES PROPRIA
    
    public Equipamento(){ //CONSTRUTOR
        this.listaManutencoes = new ArrayList();
    }
    
    public static Equipamento obterPeloNumero(String numeroPatrimonio){
        for(Equipamento obj : Equipamento.obterLista()){
            if(obj.getPatrimonio().equals(numeroPatrimonio)){
                return obj;
            }
        }
        return null;
    }
    
    public static ArrayList<Equipamento> obterLista(){
        return MeioArmazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS;
    }
    
    public void salvar(){
        MeioArmazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS.add(this);
        
    }
    public ArrayList<Manutencao> getListaManutencao(){
        return this.listaManutencoes;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome o nome para atribuir ao equipamento
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the patrimonio
     */
    public String getPatrimonio() {
        return patrimonio;
    }

    /**
     * @param patrimonio the patrimonio to set
     */
    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    /**
     * @return the dataAquisicao
     */
    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    /**
     * @param dataAquisicao the dataAquisicao to set
     */
    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    /**
     * @return the dataTerminoGarantia
     */
    public Date getDataTerminoGarantia() {
        return dataTerminoGarantia;
    }

    /**
     * @param dataTerminoGarantia the dataTerminoGarantia to set
     */
    public void setDataTerminoGarantia(Date dataTerminoGarantia) {
        this.dataTerminoGarantia = dataTerminoGarantia;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
