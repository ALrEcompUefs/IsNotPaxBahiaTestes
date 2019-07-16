package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExameTeste {
    private Exame ex1;
    private Especialidade es1;
    
    @Before
    public void setUp() throws Exception{
        es1 = new Especialidade(2, "Cardiologista");
        ex1 = new Exame("Teste Recomendação", "teste Restrição", es1);
    }
    
    @Test
    public void testBasic() {
        assertEquals("Teste Recomendação", ex1.getRecomendacao());
        assertEquals("teste Restrição", ex1.getRestricao());
        assertEquals(es1, ex1.getEspecialidade());
        
        assertEquals(2, ex1.getEspecialidade().getId());
        assertEquals("Cardiologista", ex1.getEspecialidade().getNome());
        
        ex1.setRecomendacao("Outra recomendação");
        assertEquals("Outra recomendação", ex1.getRecomendacao());
        ex1.setRestricao("Restrição2");
        assertEquals("Restrição2", ex1.getRestricao());
    }
}
