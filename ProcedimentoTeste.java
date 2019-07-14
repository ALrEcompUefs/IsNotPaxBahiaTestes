package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProcedimentoTeste {
    private Procedimento pr1;
    private Especialidade es1;
    
    @Before
    public void setUp() throws Exception{
        es1 = new Especialidade(3, "Dermatologista");
        pr1 = new Procedimento(es1);
    }
    
    @Test
    public void testBasic(){
        assertEquals(es1, pr1.getEspecialidade());
        
        assertEquals(3, pr1.getEspecialidade().getId());
        assertEquals("Dermatologista", pr1.getEspecialidade().getNome());
    }
}
