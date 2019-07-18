package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LoteTeste {
    private Lote l1, l2;
    private Medico m1, m2;
    private Consulta c1;
    private Exame ex1;
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception{
        m1 = new Medico("Maria", 1995, "feminino", "9900-1131", "Oftalmologista", 1234);
        m2 = new Medico("George", 1990, "masculino", "5555-4432", "Oftalmologista", 3333);
        c1 = new Consulta(1101, m1);
        ex1 = new Exame("Teste Recomendação", "teste Restrição", 1002, m2);
        
        l1 = new Lote(4, 1023, 1102, c1);
        l2 = new Lote(3, 1024, 1002, ex1);
    }
    
    /**
     * Teste de unidade que verifica se os atributos de um lote são
     * atribuídos corretamente.
     */
    @Test
    public void testBasic(){
        assertEquals(4, l1.getQuantidade());
        assertEquals(c1, l1.getProcedimento());
        assertEquals(1102, l1.getId());
        assertEquals(1023, l1.getData());
        
        assertEquals(3, l2.getQuantidade());
        assertEquals(ex1, l2.getProcedimento());
        assertEquals(1002, l2.getId());
        assertEquals(1024, l2.getData());
    }
    
}
