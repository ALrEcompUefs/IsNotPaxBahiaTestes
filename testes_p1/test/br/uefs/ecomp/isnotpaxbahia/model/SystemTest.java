package br.uefs.ecomp.isnotpaxbahia.model;

import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class SystemTest {
    private Lote l1, l2, l3, l4, l5, l6;
    private Medico m1, m2;
    private Consulta c1, c2;
    private Exame ex1, ex2;
    private Paciente p1, p2, p3, p4;
    private Agendamento ag1, ag2, ag3, ag4, ag5, ag6;
    private Atendente at1, at2;
    private System sys;
    
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp(){
        sys = new System();
        
        m1 = new Medico("Maria", 1995, "feminino", "9900-1131", "Cardiologista", 1547);
        m2 = new Medico("George", 1990, "masculino", "5555-4432", "Oftalmologista", 1559);
        
        c1 = new Consulta(1101, m1);
        c2 = new Consulta(1102, m2);
        
        ex1 = new Exame("Sem recomendação", "Sem restrição", 1001, m2);
        ex2 = new Exame("Repousar antes do exame", "Jejuar", 1002, m1);

        /*quantidade, data, id, tipo de procedimento*/
        l1 = new Lote(1, 1021, 1101, c1);
        l2 = new Lote(3, 1022, 1001, ex1);
        l3 = new Lote(2, 1022, 1102, c2);
        l4 = new Lote(4, 1023, 1002, ex2);
        l5 = new Lote(2, 1024, 1102, c2);
        l6 = new Lote(3, 1025, 1001, ex1);
        
        p1 = new Paciente("Kevin", 1925, "masculino", "4002-8922", 1337);
        p2 = new Paciente("Lucas", 1992, "masculino", "3654-8922", 7896);
        p3 = new Paciente("Ayala", 1992, "feminino", "0909-8922", 8908);
        p4 = new Paciente("Sandra", 1992, "feminino", "6543-2101", 8900);
        
        at1 = new Atendente("Judite", 1990, "feminino", "9980-9819", 4567);
        at2 = new Atendente("Keannu", 1989, "masculino", "9980-9809", 9912);
        
        ag1 = new Agendamento(1021, p1, at1, c1);
        ag2 = new Agendamento(1022, p2, at2, ex1);
        ag3 = new Agendamento(1025, p3, at2, ex1);
        ag4 = new Agendamento(1022, p4, at2, c2);
        ag5 = new Agendamento(1025, p1, at1, ex1);
        ag6 = new Agendamento(1022, p1, at1, ex1);
        
    }
    
    /**
     * Teste de unidade que verifica se foi possível realizar os agendamentos, e
     * informa a situação, ou seja, se foi possível agendadar ou não e mostra o 
     * motivo.
     */
    @Test
    public void angendarConfirmados(){
        sys.getLote().add(l1);
        sys.getLote().add(l2);
        sys.getLote().add(l3);
        sys.getLote().add(l4);
        sys.getLote().add(l5);
        sys.getLote().add(l6);
        
        /*agendarPaciente verfica a possibilidade no lote do procedimento,
        caso possível instacia um novo agendamento e passa como parâmetro um 
        procedimento, e adiciona-o na lista de agendamento*/
        
        assertEquals(1, sys.getLote().search(1101, 1021).getQuantidade());
        sys.agendarPaciente(1021, p1, at1, 1101); // Criando um novo agendamento
        assertEquals(0, sys.getLote().search(1101, 1021).getQuantidade()); // Verificando se a quantidade do lote mudou para 0
        assertEquals(1, sys.getAgendamentos().size());
        
        assertEquals(3, sys.getLote().search(1001, 1022).getQuantidade());
        sys.agendarPaciente(1022, p2, at2, 1001);
        assertEquals(2, sys.getLote().search(1001, 1022).getQuantidade());
        assertEquals(2, sys.getAgendamentos().size());
        
        assertEquals(2, sys.getLote().search(1102, 1024).getQuantidade());
        sys.agendarPaciente(1024, p3, at2, 1102);
        assertEquals(1, sys.getLote().search(1102, 1024).getQuantidade());
        assertEquals(3, sys.getAgendamentos().size());
        
        sys.agendarPaciente(1115, p4, at1, 1001);// Pedindo numa data invalida
        sys.agendarPaciente(1021, p4, at1, 1101); // Pedindo numa data onde a quantidade de vaga acabou
        assertEquals(3, sys.getAgendamentos().size());//Tamanho continua em 3
        
    }
    
    /**
     * Teste de unidade que verifica a inserção de pacientes no sistema.
     */
    @Test
    public void cadastrarPaciente(){
        assertTrue(sys.getPacientes().isEmpty());
        
        sys.getPacientes().add(p1);
        sys.getPacientes().add(p2);
        sys.getPacientes().add(p3);
        
        assertFalse(sys.getPacientes().isEmpty());
        assertEquals(3, sys.getPacientes().size());
        
        assertEquals(p1, sys.getPacientes().get(0));
        assertEquals(p2, sys.getPacientes().get(1));
        assertEquals(p3, sys.getPacientes().get(2));
        
    }
    
    /**
     * Teste de unidade que procura um determinado paciente na lista de pacientes
     * com base no número do plano.
     */
    @Test
    public void buscarPaciente(){
        sys.getPacientes().add(p1);
        sys.getPacientes().add(p2);
        sys.getPacientes().add(p3);
        sys.getPacientes().add(p4);
        
        assertEquals(p2, sys.getPacientes().search(7896));
        assertEquals(p1, sys.getPacientes().search(1337));
        assertEquals(p3, sys.getPacientes().search(8908));
        assertEquals(p4, sys.getPacientes().search(8900));
        
    }
    
    /**
     * Teste de unidade que verifica a inserção dos procedimentos realizados na 
     * lista do histórico.
     */
    @Test
    public void inserirListaHistorico(){
        assertTrue(sys.getHistorico().isEmpty());
        
        assertNull(sys.getEspera().proximoPaciente(1101, 1021));
        
        sys.getEspera().add(ag3, 2); /*add(agendamento, prioridade)*/
        sys.getEspera().add(ag5, 5);
        
        /*proximoPaciente(id, data)*/
        sys.getEspera().proximoPaciente(1001, 1025); /*Método que chama um paciente para o seu procedimento, tira ele
                                                    da lista de espera e coloca na lista do historico*/
        assertEquals(ag3, sys.getHistorico().get(0));
        
        sys.getEspera().proximoPaciente(1001, 1025);
        assertEquals(ag5, sys.getHistorico().get(1));
        
        assertFalse(sys.getHistorico().isEmpty());
        assertEquals(2, sys.getHistorico().size());
        
        assertTrue(sys.getEspera().isEmpty());
        assertEquals(0, sys.getEspera().size());
        
        
        assertNull(sys.getEspera().proximoPaciente(1001, 1025));
    }
    
    /**
     * Teste de unidade que veifica os agendamentos que estão na lista de espera.
     */
    @Test
    public void verificarListaEspera(){
        /*Ordem que deve ficar: ag6, ag2, ag4*/
        sys.getEspera().add(ag2, 4);
        sys.getEspera().add(ag4, 1);
        sys.getEspera().add(ag6, 5);
        
        assertEquals(3, sys.getEspera().size());
        
        assertEquals(p1, sys.getEspera().proximoPaciente(1001, 1022));
        assertEquals(p2, sys.getEspera().proximoPaciente(1001, 1022));
        assertEquals(p4, sys.getEspera().proximoPaciente(1102, 1022));
        
        assertTrue(sys.getEspera().isEmpty());
        
        assertEquals(3, sys.getHistorico().size());
    }
    
    /**
     * Teste de unidade que procura um determinado agendamento na lista de 
     * historico com base no número do plano.
     */
    @Test
    public void buscarHistorico(){
        sys.getEspera().add(ag2, 4);
        sys.getEspera().add(ag4, 1);
        sys.getEspera().add(ag6, 5);
        
        sys.getEspera().proximoPaciente(1001, 1022);
        sys.getEspera().proximoPaciente(1001, 1022);
        sys.getEspera().proximoPaciente(1102, 1022);
        
        assertEquals(ag2, sys.getHistorico().search(7896));
        assertEquals(ag6, sys.getHistorico().search(1337));
        assertEquals(ag4, sys.getHistorico().search(8900));
        
        
        assertNull(sys.getHistorico().search(8908));
        
    }
    
    /**
     * Teste de unidade que informa os pacientes que não compareceram para 
     * realizar os seus procedimentos agendados.
     */
    @Test
    public void informarAusentes(){
        
        sys.getAgendamento().add(ag1);
        sys.getAgendamento().add(ag2);
        sys.getAgendamento().add(ag3);
        sys.getAgendamento().add(ag4);
        sys.getAgendamento().add(ag5);
        sys.getAgendamento().add(ag6);
        
        sys.getEspera().add(ag6, 5);
        sys.getEspera().proximoPaciente(1001, 1022);
        
        Iterator it = sys.getAgendamento().searchPacientesAusentes(1022);
        assertTrue(it.hasNext());
        assertEquals(ag2, it.next());
        assertTrue(it.hasNext());
        assertEquals(ag4, it.next());
        
        assertFalse(it.hasNext());
        assertNull(it.next());
        
    }
    
    /**
     * Teste de unidade que verifica a inserção dos lotes na lista de lotes.
     */
    @Test
    public void lote(){
        assertTrue(sys.getLote().isEmpty());
        
        sys.getLote().add(l3);
        sys.getLote().add(l4);
        sys.getLote().add(l1);
        sys.getLote().add(l2);
        sys.getLote().add(l5);
        sys.getLote().add(l6);
        
        assertFalse(sys.getLote().isEmpty());
        
        assertEquals(l1, sys.getLote().get(0));
        assertEquals(l3, sys.getLote().get(1));
        assertEquals(l2, sys.getLote().get(2));
        assertEquals(l4, sys.getLote().get(3));
        assertEquals(l5, sys.getLote().get(4));
        assertEquals(l6, sys.getLote().get(5));
        
        assertEquals(6, sys.getLote().size());
    }
    
    /**
     * Teste de unidade que informa a situação atual dos agendamentos.
     */
    
    @Test
    public void informarSituacao(){
        sys.getLote().add(l1);
        sys.getLote().add(l2);
        sys.getLote().add(l4);
        
        /*data, paciente, atendente, id do procedimento*/
        assertEquals(1, sys.getLote().search(1101, 1021).getQuantidade());
        assertEquals("Procedimento confirmado!", sys.agendarPaciente(1021, p1, at1, 1101));  
        assertEquals(0, sys.getLote().search(1101, 1021).getQuantidade());
        
        assertEquals(3, sys.getLote().search(1001, 1022).getQuantidade());
        assertEquals("Procedimento confirmado!", sys.agendarPaciente(1022, p2, at2, 1001));
        assertEquals(2, sys.getLote().search(1001, 1022).getQuantidade());
        
        assertEquals(4, sys.getLote().search(1002, 1023).getQuantidade());
        assertEquals("Procedimento confirmado!", sys.agendarPaciente(1024, p3, at2, 1102));
        assertEquals(3, sys.getLote().search(1002, 1023).getQuantidade());
        
        assertEquals(3, sys.getAgendamentos().size());
        
        assertEquals("Procedimento indisponível para data escolhida", sys.agendarPaciente(1115, p4, at1, 1001));
        assertEquals("Procedimento esgotado", sys.agendarPaciente(1021, p4, at1, 1101));
        assertEquals(3, sys.getAgendamentos().size());
           
    }
}
