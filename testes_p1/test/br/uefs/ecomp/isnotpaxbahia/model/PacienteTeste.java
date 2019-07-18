package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PacienteTeste {
    private Paciente p1;
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception{
        p1 = new Paciente("Carlos", 2001, "masculino", "1234-5678", 1455);
    }
    
    /**
     * Teste de unidade que verifica se os atributos de um paciente são
     * atribuídos corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("Carlos", p1.getNome());
        assertEquals(2001, p1.getAnoNascimento());
        assertEquals("masculino", p1.getSexo());
        assertEquals("1234-5678", p1.getTelefone());
        assertEquals(1455, p1.getNumeroPlano());
    }
    
    /**
     * Teste de unidade que verifica se o método
     * que compara dois pacientes foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        Paciente temp = new Paciente("Carlos", 2001, "masculino", "1234-5678", 1455);
        assertTrue(temp.equals(p1));
        
        temp = new Paciente("Silvana", 1998, "feminino", "8816-2436", 2562);
        assertFalse(temp.equals(p1));
    }
    
}
