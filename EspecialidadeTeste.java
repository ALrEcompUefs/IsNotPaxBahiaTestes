package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class EspecialidadeTeste {
    private Especialidade es1, es2;
    
    @Before
    public void setUp() throws Exception{
        es1 = new Especialidade(1, "Oftalmologista");
        es2 = new Especialidade(2, "Cardiologista");
    }
    
    @Test
    public void testBasic() {
        assertEquals(1, es1.getId());
        assertEquals(2, es2.getId());
        
        assertEquals("Oftalmologista", es1.getNome());
        assertEquals("Cardiologista", es2.getNome());
    }
    
    @Test
    public void testEquals() {
        Especialidade temp = new Especialidade(2, "Cardiologista");
        
        assertTrue(temp.equals(es2));
        assertFalse(temp.equals(es1));
        
        temp = new Especialidade(1, "Oftalmologista");
        
        assertFalse(temp.equals(es2));
        assertTrue(temp.equals(es1));
    }
    
}
