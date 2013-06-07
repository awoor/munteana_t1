/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poli_pack;

/**
 * aceasta clasa implementeaza operatiile aspura polinoamelor
 * @author Muntean Andrei
 *
 */
public class Operatii {
	/**
	 * analizeaza 2 polinoame si returneaza true daca sunt egale si false daca nu
	 * @param p1 primul polinom
	 * @param p2 al doilea polinom
	 * @return true daca sunt egale si false daca nu
	 */
	public static boolean egalitate(Polinom p1, Polinom p2){
		boolean k=true;
		if (p1.getGrad()!=p2.getGrad()) {
                k=false;
            }
		else {
			for (int i=p1.getGrad(); i>=0;i--){
				if (p1.getCoef(i)!=p2.getCoef(i)) {k=false;i=-1;}
			}
		}return k;
	}
	
	/**
	 * aduna 2 polinoame si returneaza suma lor in alt polinom
	 * @param p1 termen1
	 * @param p2 termen2
	 * @return suma
	 */
	public static Polinom adunare(Polinom p1, Polinom p2){
		Polinom rez= new Polinom(Math.max(p1.getGrad(),p2.getGrad()));
		if (p1.getGrad()>p2.getGrad()){
			for (int j=p1.getGrad(); j>=p2.getGrad();j--) {
                        rez.setCoef(j,p1.getCoef(j));
                    }
			for (int i=p2.getGrad(); i>=0;i--){
				rez.setCoef(i, p1.getCoef(i)+p2.getCoef(i));
			}
		}else {
			for (int j=p2.getGrad(); j>=p1.getGrad();j--) {
                        rez.setCoef(j,p2.getCoef(j));
                    }
			for (int i=p1.getGrad(); i>=0;i--){
				rez.setCoef(i, p1.getCoef(i)+p2.getCoef(i));
			}
		}return rez;	
	}
	
	/**
	 * face diferenta dintre 2 polinoame si returneaza diferenta
	 * @param p1 descazut
	 * @param p2 scazator
	 * @return diferenta
	 */
	public static Polinom diferenta(Polinom p1, Polinom p2){
		Polinom rez= new Polinom(Math.max(p1.getGrad(),p2.getGrad()));
		if (p1.getGrad()>p2.getGrad()){
			for (int j=p1.getGrad(); j>=p2.getGrad();j--) {
                        rez.setCoef(j,p1.getCoef(j));
                    }
			for (int i=p2.getGrad(); i>=0;i--){
				rez.setCoef(i, p1.getCoef(i)-p2.getCoef(i));
			}
		}else {
			for (int j=p2.getGrad(); j>=p1.getGrad();j--) {
                        rez.setCoef(j,-p2.getCoef(j));
                    }
			for (int i=p1.getGrad(); i>=0;i--){
				rez.setCoef(i, p1.getCoef(i)-p2.getCoef(i));
			}
		}return rez;	
	}
	
	/**
	 * face produsul dintre 2 polinoame si returneaza produsul lor
	 * @param p1 termen1
	 * @param p2 termen2
	 * @return produs
	 */
	public static Polinom inmultire(Polinom p1, Polinom p2){
		Polinom rez= new Polinom(p1.getGrad()+p2.getGrad());
		for(int i=p1.getGrad();i>=0;i--){
			for (int j=p2.getGrad();j>=0;j--){
				rez.adCoef(i+j, p1.getCoef(i)*p2.getCoef(j));
			}
		}return rez;
	}
	
	/**
	 * rezolva polinomul in punctul x
	 * @param p polinomul de rezolvat
	 * @param x punctul x
	 * @return rezultatul polinomului in punctul x
	 */
	public static int rezolvare(Polinom p, int x){
		int temp=0;
		for(int i=p.getGrad();i>=0;i--){
			temp+=p.getCoef(i)*Math.pow(x,i);
		}
		return temp;
	}
	
	/**
	 * face derivata polinomului si o returneaza
	 * @param p polinom  de derivat
	 * @return polinom ce reprezinta derivata polinomului primit ca parametru
	 */
	public static Polinom derivata(Polinom p){
		Polinom temp=new Polinom(p.getGrad()-1);
		for(int i=p.getGrad();i>=1;i--){
			temp.setCoef(i-1,p.getCoef(i)*i);
		}return temp;
	}
	
	/**
	 * afla radacinile polioamelor de grad 1 si 2 si inrestu cazurilor afiseaza un text corepunzator
	 * @param p polinom de aflat radacinile
	 * @return un string care reprezinta radacinile in dependentza de ce grad ii polinomu;
	 */
	public static String radacina(Polinom p){
		StringBuffer s= new StringBuffer();
		if (p.getGrad()==1){double temp=-(p.getCoef(0)/p.getCoef(1)); 
                StringBuffer append = s.append("este :\n x=").append(temp);
		}else if (p.getGrad()==2){ 
			double d=Math.pow(p.getCoef(1),2)-4*p.getCoef(2)*p.getCoef(0);
			if (d<0) {
				double x1,x2;
				x1=(-p.getCoef(1))/(2*p.getCoef(2));
				x2=(Math.sqrt(-d))/(2*p.getCoef(2));
				if(x2<0) {
                                StringBuffer append = s.append("sunt: \nx1=").append(x1).append("-j").append(Math.abs(x2)).append("\nx2=").append(x1).append("+j").append(Math.abs(x2));
                            }
				else {
                                StringBuffer append = s.append("sunt: \nx1=").append(x1).append("+j").append(x2).append("\nx2=").append(x1).append("-j").append(x2);
                            }
			}
			else if (d==0) {
				double x=-((-p.getCoef(1))/(2*p.getCoef(2)));
                        StringBuffer append = s.append("este :\n x=").append(x);
			}else{
				double x1,x2;
				x1=((-p.getCoef(1))-Math.sqrt(d))/(2*p.getCoef(2));
				x2=((-p.getCoef(1))+Math.sqrt(d))/(2*p.getCoef(2));
				s.append("sunt :\n" + "x1=").append(x1);
                        StringBuffer append = s.append("\nx2=").append(x2);
			}
		}else {
			
			s.append("Nu este implementata metoda pentru un polinom cu acest grad");
		}
		return s.toString();
	}
}

