package br.uefs.ecomp.isnotpaxbahia.model;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgendamentoTeste {
    private Agendamento ag1;
    private Date data;
    private Paciente p1;
    private Atendente a1;
    private Especialidade es1;
    private Procedimento pr;
    
    @Before
    public void setUp() throws Exception{
        p1 = new Paciente("Carlos", 2001, "masculino", "1234-5678", "111.222.333-44");
        a1 = new Atendente("Rosa", 1999, "feminino", "8871-1025", "999.999.999-99");
        es1 = new Especialidade(1, "Oftalmologista");
        data = new Date();
        pr = new Procedimento(es1);
        
        
        ag1 = new Agendamento(data, p1, a1, pr);
    }
    
    @Test
    public void testBasic(){
        assertEquals(data, ag1.getData());
        assertEquals(p1, ag1.getPaciente());
        assertEquals(pr, ag1.getProcedimento());
        assertEquals(a1, ag1.getAtendente());
    }
}
