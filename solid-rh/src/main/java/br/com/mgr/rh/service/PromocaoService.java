package br.com.mgr.rh.service;

import br.com.mgr.rh.ValidacaoException;
import br.com.mgr.rh.model.Cargo;
import br.com.mgr.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, Boolean metaBatida){
        final Cargo cargoAtual = funcionario.getCargo();
        if (Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerente nao pode ser promovido!");
        }

        if (metaBatida){
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("Funcionario nao bateu a meta!");
        }
    }
}
