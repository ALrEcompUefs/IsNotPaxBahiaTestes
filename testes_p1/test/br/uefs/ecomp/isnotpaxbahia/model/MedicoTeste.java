package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MedicoTeste {
    private Medico m1;
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        m1 = new Medico("Maria", 1995, "feminino", "9900-1131", "Oftalmologista", 1234);
    }
    
    /**
     * Teste de unidade que verifica se os atributos de um médico são
     * atribuídos corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("Maria", m1.getNome());
        assertEquals(1995, m1.getAnoNascimento());
        assertEquals("feminino", m1.getSexo());
        assertEquals("9900-1131", m1.getTelefone());
        assertEquals("Oftalmologista", m1.getEspecialidade());
        assertEquals(1234, m1.getIdentificacao());
        
        m1.setEspecialidade("Cardiologista");
        assertEquals("Cardiologista", m1.getEspecialidade());
    }
    
    /**
     * Teste de unidade que verifica se o método
     * que compara dois médicos foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        Medico temp = new Medico("Maria", 1995, "feminino", "9900-1131", "Oftalmologista", 1234);
        assertTrue(temp.equals(m1));
        
        temp = new Medico("George", 1990, "masculino", "5555-4432", "Oftalmologista", 3333);
        assertFalse(temp.equals(m1));
    }
    
}
