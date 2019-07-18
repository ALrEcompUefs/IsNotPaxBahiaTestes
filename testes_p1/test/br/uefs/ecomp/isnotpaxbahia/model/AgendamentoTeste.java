package br.uefs.ecomp.isnotpaxbahia.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgendamentoTeste {
    private Agendamento ag1;
    private Paciente p1;
    private Atendente a1;
    private Medico m1;
    private Exame ex1;
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception{
        p1 = new Paciente("Carlos", 2001, "masculino", "1234-5678", 1111);
        a1 = new Atendente("Rosa", 1999, "feminino", "8871-1025", 4567);
        m1 = new Medico("José", 1980, "masculino", "1123-4569", "Cardiologista", 1577);
        ex1 = new Exame("Teste Recomendação", "teste Restrição", 1, m1);
        
        ag1 = new Agendamento(1021, p1, a1, ex1);
    }
    
    /**
     * Teste de unidade que verifica se os atributos de um agendamento são
     * atribuídos corretamente.
     */
    @Test
    public void testBasic(){
        assertEquals(1021, ag1.getData());
        assertEquals(p1, ag1.getPaciente());
        assertEquals(ex1, ag1.getProcedimento());
        assertEquals(a1, ag1.getAtendente());
    }
}
