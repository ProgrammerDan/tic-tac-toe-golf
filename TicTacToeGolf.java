import java.util.*;
public class TicTacToeGolf {
	public static void main(String[] args) {
		(new TicTacToeGolf()).start();
	}
	/** Wrap System.out.print to avoid all that typing */
	void p(String k, int i){
		System.out.print(k +((i<1)?"":"\n"));
	}
	/** Game board */
	int[][] gg = new int[3][3];
	/** Unused more verbose game board */
	void G() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int k=gg[i][j];
				p( (k<1)?" ":(k<2)?"X":"O",0);
				p( (j<2)?"|":"",j-1);
			}
			p((i<2)?"-+-+-":"",1);
		}
	}
	/** Check all possibilities for winner, return 0 for no winner, 1 for X, 2 for O */
	int c(){
		for(int[]i:gg)
			if((i[0]==i[1])&&(i[1]==i[2])&&i[0]>0)
				return i[0];
		for(int i=0;i<3;i++)
			if ((gg[0][i]==gg[1][i])&&(gg[1][i]==gg[2][i])&&gg[0][i]>0)
				return gg[0][i];
		int m=gg[1][1];
		return (((gg[0][0]==m)&&(m==gg[2][2])||(gg[0][2]==m)&&(m==gg[2][0]))?m:0);
	}
	/** Print game board */
	void g(){
		for(int[]i:gg){
			for(int j:i)
				p(w(j),0);
			p("",1);
		}p("",1);
	}
	/** Generate a random value between 0..2 */
	int x() {
		return (new Random()).nextInt(3);
	}
	/** Convert 1 to X, 2 to O */
	String w(int i) {
		return (i<1)?".":(i<2)?"X":"O";
	}
	/** Get a number from the input */
	int y() {
		return (new Scanner(System.in)).nextInt();
	}
	/** Pick the next move for the computer */
	void z() {
		int i,j;
		do{
			i=x();
			j=x();
		}while(!s(i,j,1));
		p(i+"x"+j,1);
	}
	/** Check if move is possible, if so do it, otherwise return false */
	boolean s(int i, int j, int z){
		if (gg[i][j]<1)
			return (gg[i][j]=z)==z;
		return 0>1;
	}
	/** Play the game, Computer gets first  move. */
	void start() {
		gg[x()][x()]=1;
		g();
		int moves=8,x;
		do{
			do{
				p("x?",0);
				x=y();
				p("y?",0);
			}while(!s(y(),x,2));
			g();
			if (c()>0)
				break;
			z();
			g();
			moves-=2;
		}while(moves>0&&c()==0);
		if(c()<1) p("No winner!",1);
		else p(w(c()) + " wins!",1);
	}
}
