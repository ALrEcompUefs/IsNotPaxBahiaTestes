package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConsultaTeste {
    private Consulta c1;
    private Especialidade es1;
    
    @Before
    public void setUp() throws Exception{
        es1 = new Especialidade(1, "Oftalmologista");
        c1 = new Consulta(es1);
    }
    
    @Test
    public void testBasic() {
        assertEquals(es1, c1.getEspecialidade());
        assertEquals(1, c1.getEspecialidade().getId());
        assertEquals("Oftalmologista", c1.getEspecialidade().getNome());
    }
}
