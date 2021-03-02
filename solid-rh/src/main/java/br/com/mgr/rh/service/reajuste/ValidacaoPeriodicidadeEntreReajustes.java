package br.com.mgr.rh.service.reajuste;

import br.com.mgr.rh.ValidacaoException;
import br.com.mgr.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {
    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        final LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        final LocalDate dataAtual = LocalDate.now();
        final long mesesDesdoUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (mesesDesdoUltimoReajuste < 6 ) {
            throw new ValidacaoException("Intervalo entre reajuste deve ser no minimo de 6 meses!");
        }
    }
}
