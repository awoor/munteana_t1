/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poli_pack;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Aceasta clasa extinde clasa JFrame si implementeaza ActionListener.  Acest obiect nou
 * format reprezinta o fereastra cu 8 butoane, are denumirea de "Operatii cu polinoame", si 
 * fiecare buton este etichetat corespunzator unei operatzii cu polinoame
 * @author Muntean Andrei
 */

public class Interfata_Utilizator extends JFrame implements ActionListener{
	private JPanel pane;//pane pentru a seta layoutul butoanelor
	private JButton bE,bA,bD,bIn,bDer,bR,bAf,bRez;// butoanele
	/**
	 * Constructorul creaza o fereastra de dim specif centarata in mijlocul ecranului
	 * cu denum specif, are si metoda de setare a panelui cu butoane care ulterior e 
	 * adaugat la fereastra
	 * @param nu sunt parametri de intrare
	 */
	Interfata_Utilizator(){
		super("Operatii cu polinoame - Muntean Andrei");//denumirea
		setSize(380,300);//marimea
        setLocationRelativeTo(null);//alinierea
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPane();//setare pane
        add(pane);//adaugare pane
        setVisible(true);//setare vizibilitate
	}
	/**
	 * metoda creaza un obiect de tip JPanel si adauga o matrice de butoane
	 * @param nu are parametri de intrare
	 * @return nu returneaza nimic
	 */
	private void setPane(){
		pane=new JPanel();//crearea unui pane
		//crearea butoanelor cu etichetarea lor corespunzatoare
		bE=new JButton("Egalitate");bA=new JButton("Adunare");
		bD=new JButton("Diferenta");bIn=new JButton("Inmultire");
		bDer=new JButton("Derivata");bR=new JButton("Aflarea radacinilor (grad 1,2)");
		bAf=new JButton("Afisare");bRez=new JButton("Rezolvarea polinomului in x");
		//adaugarea ascultatorilor la butoane
		bE.addActionListener(this);bA.addActionListener(this);
		bD.addActionListener(this);bIn.addActionListener(this);
		bDer.addActionListener(this);bR.addActionListener(this);
		bAf.addActionListener(this);bRez.addActionListener(this);
		//adaugarea comenzii la butoane
		bE.setActionCommand("bE");bA.setActionCommand("bA");
		bD.setActionCommand("bD");bIn.setActionCommand("bIn");
		bDer.setActionCommand("bDer");bR.setActionCommand("bR");
		bAf.setActionCommand("bAf");bRez.setActionCommand("bRez");
		pane.setLayout(new GridLayout(8,1));//setarea layoutului pane
		GridBagConstraints c = new GridBagConstraints();//crearea unei constante pt matricea de butoane
		//adaugarea butoanelor la pane
		c.gridy=1;
        c.gridx=1;
        pane.add(bE,c);
        c.gridx=2;
        pane.add(bA,c);
        c.gridx=3;
        pane.add(bD,c);
        c.gridx=4;
        pane.add(bIn,c);
        c.gridx=5;
        pane.add(bDer,c);
        c.gridx=6;
        pane.add(bR,c);
        c.gridx=7;
        pane.add(bAf,c);
        c.gridx=8;
        pane.add(bRez,c);
	}
	
	/**
	 * aceasta metoda extinde metoda din interfata Action listener ea executa operatziile
	 * care corespund anumitui eveiment
	 * @param un parametru de tipul ActionEvent caruia i se atribuie o valoare atunci cand
	 * se apasa vreun buton
	 * @return nu returneaza nimic
	 */
	public void actionPerformed(ActionEvent e){
		String comand = e.getActionCommand();// atribuim unui strng comanda aparuta
        ///verificam comanda daca satisface uneia din operatii si le executa
        switch (comand) {
            case "bE":
                {
                    //egalitate
                    //setam polinoamele
                    JOptionPane.showMessageDialog(this,"Setati polinom 1");
                    Polinom p1 = new Polinom();
                    JOptionPane.showMessageDialog(this,"Setati polinom 2");
                    Polinom p2 = new Polinom();
                    //executare operatiei corespunzatoare si afisarea rezultatului
                    if (Operatii.egalitate(p1, p2)) {
                        JOptionPane.showMessageDialog(this,
                                        "Polinoamele:\n"+(String)p1.toString("P")+"\n"
                                        +(String)p2.toString("Q")+"\nSunt egale!");
                    }
                    else {
                        JOptionPane.showMessageDialog(this,
                                        "Polinoamele:\n"+(String)p1.toString("P")+"\n"
                                        +(String)p2.toString("Q")+"\nNu sunt egale!");
                    }
                    break;
                }
            case "bA":
                {
                    //adunare
                    //setam polinoamele
                    JOptionPane.showMessageDialog(this,"Setati polinom 1");
                    Polinom p1 = new Polinom();
                    JOptionPane.showMessageDialog(this,"Setati polinom 2");
                    Polinom p2 = new Polinom();
                    //executare operatiei corespunzatoare si afisarea rezultatului
                    @SuppressWarnings("UnusedAssignment")
                    Polinom rez= new Polinom(Math.max(p1.getGrad(),p2.getGrad()));
                    rez=Operatii.adunare(p1, p2);
                    JOptionPane.showMessageDialog(this,
                                    "Suma polinoamelor:\n"+(String)p1.toString("P")+"\n"
                                    +(String)p2.toString("Q")+"\neste:\n"+(String)rez.toString("S"));
                    break;
                }
            case "bD":
                {
                    //diferenta
                    //setam polinoamele
                    JOptionPane.showMessageDialog(this,"Setati polinom 1");
                    Polinom p1 = new Polinom();
                    JOptionPane.showMessageDialog(this,"Setati polinom 2");
                    Polinom p2 = new Polinom();
                    //executare operatiei corespunzatoare si afisarea rezultatului
                    @SuppressWarnings("UnusedAssignment")
                    Polinom rez= new Polinom(Math.max(p1.getGrad(),p2.getGrad()));
                    rez=Operatii.diferenta(p1, p2);
                    JOptionPane.showMessageDialog(this,
                                    "Diferenta polinoamelor:\n"+(String)p1.toString("P")+"\n"
                                    +(String)p2.toString("Q")+"\neste:\n"+(String)rez.toString("D"));
                    break;
                }
            case "bIn":
                {
                    //inmultire
                    //setam polinoamele
                    JOptionPane.showMessageDialog(this,"Setati polinom 1");
                    Polinom p1 = new Polinom();
                    JOptionPane.showMessageDialog(this,"Setati polinom 2");
                    Polinom p2 = new Polinom();
                    //executare operatiei corespunzatoare si afisarea rezultatului
                    @SuppressWarnings("UnusedAssignment")
                    Polinom rez= new Polinom(p1.getGrad()+p2.getGrad());
                    rez=Operatii.inmultire(p1, p2);
                    JOptionPane.showMessageDialog(this,
                                    "Produsul polinoamelor:\n"+(String)p1.toString("P")+"\n"
                                    +(String)p2.toString("Q")+"\neste:\n"+(String)rez.toString("R"));
                    break;
                }
            case "bDer":
                {
                    //derivare
                    //setam polinoamele
                    Polinom p=new Polinom();
                    //executare operatiei corespunzatoare si afisarea rezultatului
                    @SuppressWarnings("UnusedAssignment")
                    Polinom rez=new Polinom(p.getGrad()-1);
                    //executare operatiei corespunzatoare si afisarea rezultatului
                    rez=Operatii.derivata(p);
                    JOptionPane.showMessageDialog(this,
                                    (String)"Derivata polinomului:\n"+(String)p.toString("P")+"\n"+
                                    "este :\n"+(String)rez.toString("P"));
                    break;
                }
            case "bR":
                {
                    //calcularea radcinii
                    //setam polinoamele
                    Polinom p=new Polinom();
                    //executare operatiei corespunzatoare si afisarea rezultatului
                    JOptionPane.showMessageDialog(this,
                                    (String)"Radacina(-ile) polinomului:\n"+(String)p.toString("P")+"\n"+
                                    Operatii.radacina(p));
                    break;
                }
            case "bAf":
                {
                    //afisarea in forma canonica
                    //setam polinoamele
                    Polinom p=new Polinom();
                    //executare operatiei corespunzatoare si afisarea rezultatului
                    JOptionPane.showMessageDialog(this,"Polinomul in forma canonica este:\n"+
                                    (String)p.toString("P"));
                    break;
                }
            case "bRez":
                {
                    //calcularea pol intrun punct
                    //setam polinoamele
                    Polinom p=new Polinom();
                    //executare operatiei corespunzatoare si afisarea rezultatului
                    String in = JOptionPane.showInputDialog("Introduceti x");
                    int x=Integer.parseInt(in);
                    int rez=Operatii.rezolvare(p,x);
                    JOptionPane.showMessageDialog(this,"Polinomul:\n"+(String)p.toString("P")+
                                    "\nin punctul: "+x+"\neste egal cu\n"+rez);
                    break;
                }
        }
	}
}
