/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poli_pack;
/**
 * aceasta clasa defineste un obiect cu denumirea de polinom care are 2 variabile instanta
 * grad si coeficientii, ambele fiind de tip integer
 * @author Muntean Andrei
 */

import javax.swing.JOptionPane;


public class Polinom {
	int coef[];//tabelul cu coeficientzi
	int grad;//gradul polinomului
	//constructor fara parametri care seteaza gradul si coeficientii polinomului
	//cu metoda specificata ulterior
    @SuppressWarnings("OverridableMethodCallInConstructor")
	Polinom(){
		setCoef();
	}
	//constructor cu parametru de intrare care reprezinta gradul, creaza si un tabel cu lungimea
	//gradului care reprezinta coeficientzii polinomului
	Polinom(int grad){
		this.grad=grad;
		coef=new int[grad+1];
	}
	
	/**
	 * aduna un numar la un coeficient specificat prin puterea lui x
	 * @param putere
	 * @param coefIn
	 */
	public void adCoef(int putere, int coefIn){
		coef[putere]+=coefIn;
	}
	
	/**
	 * setaza gradul polinomului cu ajutorul unui JOptionPane
	 */
	public void setGrad(){
		String in = JOptionPane.showInputDialog("Introduceti gradul polinomului ");
		grad=Integer.parseInt(in);
		coef=new int[grad+1];
	}
	
	/**
	 * seteaza gradul polinomului apeland setGrad si coeficientzii polinomului
	 * cu ajutorul unui JOptionPane
	 */
	public void setCoef(){
		setGrad();
		for (int i=grad; i>=0; i--){
			String in = JOptionPane.showInputDialog("Introduceti coeficientul lui x^"+i);
			coef[i]=Integer.parseInt(in);
		}
		
	}
	
	/**
	 * seteaza coeficientul corespunzator puterii lui x
	 * @param putere
	 * @param coefIn
	 */
	public void setCoef(int putere,int coefIn){
		coef[putere]=coefIn;		
	}
	
	/**
	 * returneaza coeficientul solicitat de puterea lui x
	 * @param putere
	 * @return coeficientul lui x la puterea corespunzatoare
	 */
	public int getCoef(int putere){
		return coef[putere];
	}
	
	/**
	 * 	
	 * @return gradul polinomului
	 */
	public int getGrad(){
		return grad;
	}
	
	/**
	 * creaza un string care reprezinta polinomul
	 * @param pol un string ce reprezinta denumirea polinomului
	 * @return un string ce reprezinta polinomul in forma canonoca
	 */
	public String toString(String pol){
            @SuppressWarnings("StringBufferMayBeStringBuilder")
		StringBuffer s = new StringBuffer(pol+"(x) = ");
		int sts=0;
		if ((getGrad()!=0)&&(getCoef(grad)!=0)&&(getCoef(grad)!=1)&&(getCoef(grad)!=-1)){
			s.append(Integer.toString(getCoef(grad)));
			s.append("x^");
			s.append(Integer.toString(grad));
			sts=1;
		}else if ((getGrad()!=0)&&(getCoef(grad)!=0)&&(getCoef(grad)==1)){
			s.append("x^");
			s.append(Integer.toString(grad));
			sts=1;
		}
		else if ((getGrad()!=0)&&(getCoef(grad)!=0)&&(getCoef(grad)==-1)){
			s.append("-x^");
			s.append(Integer.toString(grad));
			sts=1;
		}
		
			for(int i=grad-1; i >0; i--){
				if (getCoef(i) < 0 ){
					if (sts==1) {
                                        s.append(" - ");
                                    }
					if (getCoef(i)!=1) {
                                        s.append(Integer.toString(-getCoef(i)));
                                    }
				}else if (getCoef(i) > 0 ){
					if (sts==1) {
                                        s.append(" + ");
                                    }
					if (getCoef(i)!=1) {
                                        s.append(Integer.toString(getCoef(i)));
                                    }
				}if (getCoef(i) != 0 ) {if (i!=1) {
                                        StringBuffer append = s.append("x^").append(i);
                                    } else {
                                        s.append("x");
                                    }sts=1;}
			}
			
			if (getCoef(0) < 0){
					if (sts==1) {
                                s.append(" - ");
                            }
					s.append(Integer.toString(-getCoef(0)));
			}else if (getCoef(0) > 0){
					if (sts==1) {
                                s.append( " + ");
                            }
					s.append(Integer.toString(getCoef(0)));
			}else {s.append( " + ");s.append(Integer.toString(getCoef(0)));}
			return s.toString();
	}
}
