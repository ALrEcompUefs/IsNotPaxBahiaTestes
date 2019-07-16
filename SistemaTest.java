/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alisson
 */
public class SistemaTest {
    private Sistema sis;
    private Atendente a1,a2;
    private Medico m1,m2,m3;
    private Paciente p1,p2,p3;
    private Exame e1,e2;
    private Consulta c1,c2;
    private Agendamento Ag1,Ag2,Ag3;
    private Lote l1,l2,l3,l4,l5;
    
    @Before
    public void setUp() {
        sis= new Sistema();
                
        a1 = new Atendente("juliana","999-777-55","rua a",1987,1);
        a2 = new Atendente("Jefersom","999-777-55","rua b",1995,2);
        
        m1 = new Medico("Roberval","565-999-78","avenida e",1980,3,"otorrino");
        m2 = new Medico("Ana Lucia","474-988-65","rua x",1995,4,"cardiologista");
        m3 = new Medico("Ana Joaquina","655-978-22","rua o",1987,5,"oftamologista");
        
        p1 = new Paciente("Fulano","999-001-24","rua a",1780,4501);
        p2 = new Paciente("Fulana","442-77-24","rua a",1780,4502);
        p3 = new Paciente("Cicrano","999-001-24","rua a",1780,4503);
        
        e1 = new Exame("exame de vista","vir com acompanhante","nenhuma",1,m3);
        e2 = new Exame("sonda nasal","nenhuma","nenhuma",2,m1);
        
        c1 = new Consulta("Consulta","cardiologia",3,m2);
        c2 = new Consulta("Consulta","otorrino",4,m2);
        
        l1= new Lote(1,3,0723);
        l2= new Lote(2,1,0722);
        l3= new Lote(3,2,0723);
        l4= new Lote(1,1,0721);
        l5= new Lote(4,2,0724);
        
        Ag1 = new Agendamento(p1,false,0722,e2,a1);
        Ag2 = new Agendamento(p2,false,0721,e1,a2);
        Ag3 = new Agendamento(p3,false,0723,c1,a1);
    }
    
    @Test
    public void testAddPaciente(){
        sis.getPacientes().add(p1);
        sis.getPacientes().add(p2);
        sis.getPacientes().add(p3);
        assertEquals(3,sis.getPacientes().size());
        
        assertEquals(p1,sis.getPacientes().get(0));
        assertEquals(p2,sis.getPacientes().get(1));
        assertEquals(p3,sis.getPacientes().get(2));
    }
    
    @Test
    public void testAddMedico(){
        sis.getMedicos().add(m1);
        sis.getMedicos().add(m2);
        sis.getMedicos().add(m3);
        assertEquals(3,sis.getMedicos().size());
        
        assertEquals(m1,sis.getMedicos().get(0));
        assertEquals(m2,sis.getMedicos().get(1));
        assertEquals(m3,sis.getMedicos().get(2));
    }
    
    @Test
    public void testAddAtendentes(){
        sis.getAtendentes().add(a1);
        sis.getAtendentes().add(a2);
        assertEquals(2,sis.getAtendentes().size());
        
        assertEquals(a1,sis.getAtendentes().get(0));
        assertEquals(a2,sis.getAtendentes().get(1));
    }
    
    @Test
    public void testAddAgendamento(){
        sis.getAgendamentos().add(Ag1);
        sis.getAgendamentos().add(Ag2);
        sis.getAgendamentos().add(Ag3);
        assertEquals(3,sis.getAgendamentos().size());
        
        assertEquals(Ag1,sis.getAgendamentos().get(0));
        assertEquals(Ag2,sis.getAgendamentos().get(1));
        assertEquals(Ag3,sis.getAgendamentos().get(2));
    }
    
    @Test
    public void testAddLotes(){
        sis.getLotes().add(l1);
        sis.getLotes().add(l2);
        sis.getLotes().add(l3);
        assertEquals(3,sis.getLotes().size());
        
        assertEquals(l1,sis.getLotes().get(0));
        assertEquals(l2,sis.getLotes().get(1));
        assertEquals(l3,sis.getLotes().get(2));
    }
    
    @Test
    public void testBuscarPacientes(){
        Iterador it;
        sis.getPacientes().add(p1);
        sis.getPacientes().add(p2);
        sis.getPacientes().add(p3);
        
        it = sis.getPacientes.buscarPacientesPorNome("Fulano");
        assertTrue(it.hasNext());
        assertEquals(p1,it.next());
        assertFalse(it.hasNext());
        
        it = sis.getPacientes.buscarPacientesPorTelefone("999-001-24");
        assertTrue(it.hasNext());
        assertEquals(p1,it.next());
        assertTrue(it.hasNext());
        assertEquals(p2,it.next());
        assertFalse(it.hasNext());
        
        it = sis.getPacientes.buscarPacientesPorID(4503);
        assertTrue(it.hasNext());
        assertEquals(p3,it.next());
        assertFalse(it.hasNext());
    }
    
    @Test
    public void testExibirPacientesAusentes(){
        sis.getAgendamentos().add(Ag1);
        sis.getAgendamentos().add(Ag2);
        sis.getAgendamentos().add(Ag3);
        assertEquals(3,sis.getAgendamentos().size());
        
        Iterador it;
        it = sis.getAgendamentos().getAusentes();
        assertFalse(it.hasNext());
        
        sis.getAgendamentos().setToRealizado(Ag2);
        it = sis.getAgendamentos().getAusentes();
        assertTrue(it.hasNext());
        assertEquals(Ag1,it.next());
        assertTrue(it.hasNext());
        assertEquals(Ag3,it.next());
        assertFalse(it.hasNext());
    }
    
    @Test
    public void testBuscaNoHistorico(){
        Iterador it;
        it = sis.getHistorico().iterador();
        assertFalse(it.hasNext());
    }
}
