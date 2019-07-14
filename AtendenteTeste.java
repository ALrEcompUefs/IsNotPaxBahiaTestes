package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AtendenteTeste {
    private Atendente a1;
    
    @Before
    public void setUp() throws Exception{
        a1 = new Atendente("Rosa", 1999, "feminino", "8871-1025", "999.999.999-99");
    }
    
    @Test
    public void testBasic() {
        assertEquals("Rosa", a1.getNome());
        assertEquals(1999, a1.getAnoNascimento());
        assertEquals("feminino", a1.getSexo());
        assertEquals("8871-1025", a1.getTelefone());
        assertEquals("999.999.999-99", a1.getIdentificacao());
    }
    
    @Test
    public void testEquals() {
        Atendente temp = new Atendente("Rosa", 1999, "feminino", "8871-1025", "999.999.999-99");
        assertTrue(temp.equals(a1));
        
        temp = new Atendente("Romário", 1976, "masculino", "5555-1234", "158.513.442-27");
        assertFalse(temp.equals(a1));
    }
    
}
