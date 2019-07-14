package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MedicoTeste {
    private Medico m1;
    private Especialidade es1, es2;
    
    @Before
    public void setUp() throws Exception {
        es1 = new Especialidade(1, "Oftalmologista");
        es2 = new Especialidade(2, "Cardiologista");
        
        m1 = new Medico("Maria", 1995, "feminino", "9900-1131", es1, "000.000.000-01");
    }
    
    @Test
    public void testBasic() {
        assertEquals("Maria", m1.getNome());
        assertEquals(1995, m1.getAnoNascimento());
        assertEquals("feminino", m1.getSexo());
        assertEquals("9900-1131", m1.getTelefone());
        assertEquals(es1, m1.getEspecialidade());
        assertEquals("000.000.000-01", m1.getIdentificacao());
        
        m1.setEspecialidade(es2);
        assertEquals(es2, m1.getEspecialidade());
    }
    
    @Test
    public void testEquals() {
        Medico temp = new Medico("Maria", 1995, "feminino", "9900-1131", es1, "000.000.000-01");
        assertTrue(temp.equals(m1));
        
        temp = new Medico("George", 1990, "masculino", "5555-4432", es2, "555.123.321-00");
        assertFalse(temp.equals(m1));
    }
    
}
