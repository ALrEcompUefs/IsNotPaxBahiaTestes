package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ConsultaTeste {
    private Consulta c1;
    private Medico m1, m2;
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception{
        m1 = new Medico("Maria", 1995, "feminino", "9900-1131", "Oftalmologista", 1234);
        m2 = new Medico("José", 1980, "masculino", "1123-4569", "Cardiologista", 4321);
        
        c1 = new Consulta(1101, m1);
    }
    
    /**
     * Teste de unidade que verifica se os atributos de uma consulta são
     * atribuídos corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals(1101, c1.getId());
        assertEquals(m1, c1.getMedico());
        
        assertEquals(m1.getEspecialidade(), c1.getEspecialidade());
        
    }
    
    /**
     * Teste de unidade que verifica se o método
     * que compara duas consultas foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        Consulta temp = new Consulta(1101, m1);
        assertTrue(temp.equals(c1));
        
        temp = new Consulta(3, m2);
        assertFalse(temp.equals(c1));
    }
}
