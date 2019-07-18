package br.uefs.ecomp.isnotpaxbahia;

import br.uefs.ecomp.isnotpaxbahia.model.AgendamentoTeste;
import br.uefs.ecomp.isnotpaxbahia.model.AtendenteTeste;
import br.uefs.ecomp.isnotpaxbahia.model.ConsultaTeste;
import br.uefs.ecomp.isnotpaxbahia.model.ExameTeste;
import br.uefs.ecomp.isnotpaxbahia.model.LoteTeste;
import br.uefs.ecomp.isnotpaxbahia.model.MedicoTeste;
import br.uefs.ecomp.isnotpaxbahia.model.PacienteTeste;
import br.uefs.ecomp.isnotpaxbahia.model.SystemTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		AgendamentoTeste.class,
        AtendenteTeste.class,
        ConsultaTeste.class,
        ExameTeste.class,
        LoteTeste.class,
		MedicoTeste.class,
                PacienteTeste.class,
        SystemTest.class
})

public class AllTestes {
    
}
