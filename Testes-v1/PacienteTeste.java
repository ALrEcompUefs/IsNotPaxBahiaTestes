package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PacienteTeste {
    private Paciente p1;
    
    @Before
    public void setUp() throws Exception{
        p1 = new Paciente("Carlos", 2001, "masculino", "1234-5678", "111.222.333-44");
    }
    
    @Test
    public void testBasic() {
        assertEquals("Carlos", p1.getNome());
        assertEquals(2001, p1.getAnoNascimento());
        assertEquals("masculino", p1.getSexo());
        assertEquals("1234-5678", p1.getTelefone());
        assertEquals("111.222.333-44", p1.getNumeroPlano());
    }
    
    @Test
    public void testEquals() {
        Paciente temp = new Paciente("Carlos", 2001, "masculino", "1234-5678", "111.222.333-44");
        assertTrue(temp.equals(p1));
        
        temp = new Paciente("Silvana", 1998, "feminino", "8816-2436", "777.898.135-90");
        assertFalse(temp.equals(p1));
    }
    
}
