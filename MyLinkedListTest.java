/*
 * Alisson Rodrigues
 * coloquei os testes dos metódos padrões de uma lista encadeada 
 */
package Util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alisson
 */
public class MyLinkedListTest {
    MyLinkedList lista;
    Object Data1,Data2,Data3;
    
    @Before
    public void setUp() {
        Data1=1;
        Data2=2;
        Data3=3;
        lista= new MyLinkedList();
    }
    
    @Test
    public void TestInserir(){
        
        lista.add(Data1);
        assertEquals(1,lista.size());
        
        lista.add(Data2);
        assertEquals(2,lista.size());
        
        lista.add(Data3);
        assertEquals(3,lista.size());
        
        assertEquals(1,lista.get(0));
        assertEquals(2,lista.get(1));
        assertEquals(3,lista.get(2));
    }
    
    @Test
    public void Testget(){
        lista.add(Data1);
        lista.add(Data2);
        lista.add(Data3);
        
        assertEquals(1,lista.get(0));
        assertEquals(2,lista.get(1));
        assertEquals(3,lista.get(2));
    }
    
    @Test
    public void Testremover(){
        lista.add(Data1);
        lista.add(Data2);
        lista.add(Data3);
        
        lista.remover(1);
        assertEquals(2,lista.size());
        assertEquals(3,lista.get(1));
        
        lista.remover(1);
        assertEquals(1,lista.size());
        assertNotNull(lista.get(0));
        
        lista.remover(0);
        assertEquals(0,lista.size());
        assertNull(lista.get(0));
        
        assertNull(lista.get(2));
        assertNull(lista.get(1));
    }
    
    @Test
    public void Testsize(){
        assertEquals(0,lista.size());
        
        lista.add(Data1);
        assertEquals(1,lista.size());
        
        lista.add(Data2);
        assertEquals(2,lista.size());
        
        lista.add(Data2);
        assertEquals(3,lista.size());
        
        lista.remover(0);
        assertEquals(2,lista.size());
        lista.remover(1);
        lista.remover(0);
        assertEquals(0,lista.size());
    }
    
    @Test
    public void TestisEmpty(){
        assertTrue(lista.isEmpty());
        lista.add(Data1);
        assertFalse(lista.isEmpyt());
        lista.remover(0);
        assertTrue(lista.isEmpty());
    }
    
    @Test
    public void TestInserirRemover(){
        assertTrue(lista.isEmpty());
        
        lista.add(Data1);
        assertFalse(lista.isEmpty());
        lista.remover(0);
        assertTrue(lista.isEmpty());
        
        lista.add(Data2);
        lista.add(Data3);
        assertEquals(2,lista.size());
        lista.remover(0);
        assertNotEquals(Data2,lista.get(0));
        
        lista.remover(0);
        assertTrue(lista.isEmpty);
        
    }
    
    @Test
    public void testIterator(){
        Iterador it = lista.getIterador();
        assertFalse(it.hasNext());
        
        lista.add(Data1);
        lista.add(Data2);
        lista.add(Data3);
        
        it= lista.getIterador();
        assertTrue(it.hasNext());
        assertEquals(Data1,it.next());
        assertTrue(it.hasNext());
        assertEquals(Data2,it.next());
        assertTrue(it.hasNext());
        assertEquals(Data3,it.next());
        assertFalse(it.hasNext());
        
    }
}
