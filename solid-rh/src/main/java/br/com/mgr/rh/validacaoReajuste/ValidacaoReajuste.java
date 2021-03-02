package br.com.mgr.rh.validacaoReajuste;

import br.com.mgr.rh.model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {

    void validar(Funcionario funcionario, BigDecimal aumento);
}
