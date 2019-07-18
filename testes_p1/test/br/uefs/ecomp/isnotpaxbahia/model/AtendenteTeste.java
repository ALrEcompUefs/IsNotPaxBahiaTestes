package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AtendenteTeste {
    private Atendente a1;
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception{
        a1 = new Atendente("Rosa", 1999, "feminino", "8871-1025", 4567);
    }
    
    /**
     * Teste de unidade que verifica se os atributos de um atendente são
     * atribuídos corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("Rosa", a1.getNome());
        assertEquals(1999, a1.getAnoNascimento());
        assertEquals("feminino", a1.getSexo());
        assertEquals("8871-1025", a1.getTelefone());
        assertEquals(4567, a1.getIdentificacao());
    }
    
    /**
     * Teste de unidade que verifica se o método
     * que compara dois atendentes foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        Atendente temp = new Atendente("Rosa", 1999, "feminino", "8871-1025", 4567);
        assertTrue(temp.equals(a1));
        
        temp = new Atendente("Romário", 1976, "masculino", "5555-1234", 2222);
        assertFalse(temp.equals(a1));
    }
    
}
