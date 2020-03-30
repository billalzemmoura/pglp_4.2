package pglp.pglp42;
import static org.junit.Assert.assertTrue;



import org.junit.Test;




/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void  Add() {
	Addition addd=new Addition();
	
	assertTrue(addd.apply(10, 10)==20);
}
    @Test
    public void  sous() {
	Soustraction addd=new Soustraction();
	
	assertTrue(addd.apply(10, 10)==0);
}
    @Test
    public void  multi() {
	Multiplication addd=new Multiplication();
	
	assertTrue(addd.apply(10, 10)==100);
}
    @Test
    public void  div() {
	Division addd=new Division();
	
	assertTrue(addd.apply(10, 10)==1);
}
    
    
    
    @Test
    public void NoUndo() {
    	
    	SaisieRPN s=new SaisieRPN();
    	
    	s.ItInteger(3);
    	s.ItInteger(4);
    	s.excInter("undo");
    	assertTrue(s.getStack().size()==2);
    	
    }

    
    @Test
    public void Undo() {
    	
    	SaisieRPN s=new SaisieRPN();
    	
    	s.ItInteger(3);
    	s.ItInteger(4);
    	s.ExisteCommandeMoteur("+");
    	s.excInter("undo");
    	assertTrue(s.getStack().size()==2);
    	
    }

    
    @Test
    public void NoADD() {
    	
    	SaisieRPN s=new SaisieRPN();
    	
    	s.ItInteger(3);
    	s.excMoteur("+");
     	assertTrue(s.getStack().contains(3));
    	
    }
}
