package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ExameTeste {
    private Exame ex1;
    private Medico m1, m2;
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception{
        m1 = new Medico("José", 1980, "masculino", "1123-4569", "Cardiologista", 4321);
        m2 = new Medico("Maria", 1995, "feminino", "9900-1131", "Oftalmologista", 1234);
        ex1 = new Exame("Teste Recomendação", "teste Restrição", 1002, m1);
    }
    
    /**
     * Teste de unidade que verifica se os atributos de uma opção de exame são 
     * atribuídos e modificados corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("Teste Recomendação", ex1.getRecomendacao());
        assertEquals("teste Restrição", ex1.getRestricao());
        
        assertEquals(1002, ex1.getId());
        assertEquals(m1, ex1.getMedico());
        
        
        ex1.setRecomendacao("Outra recomendação");
        assertEquals("Outra recomendação", ex1.getRecomendacao());
        ex1.setRestricao("Restrição2");
        assertEquals("Restrição2", ex1.getRestricao());
    }
    
    /**
     * Teste de unidade que verifica se o método
     * que compara dois exames foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        Exame temp = new Exame("Teste Recomendação", "teste Restrição", 1002, m1);
        assertTrue(temp.equals(ex1));
        
        temp = new Exame("Recomendação teste", "restrição teste", 1002, m2);
        assertFalse(temp.equals(ex1));
    }
}
