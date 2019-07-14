package br.uefs.ecomp.isnotpaxbahia.model;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LoteTeste {
    private int quantidade;
    private Date data;
    private Especialidade es1;
    private Lote l1;
    
    @Before
    public void setUp() throws Exception{
        quantidade = 4;
        data = new Date();
        es1 = new Especialidade(1, "Oftalmologista");
        
        l1 = new Lote(4, data, es1);
    }
    
    @Test
    public void testBasic(){
        assertEquals(4, l1.getQuantidade());
        assertEquals(data, l1.getData());
        assertEquals(es1, l1.getEspecialidade());
        
        
        assertEquals(1, l1.getEspecialidade().getId());
        assertEquals("Oftalmologista", l1.getEspecialidade().getNome());
    }
}
