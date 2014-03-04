import java.util.*;
class T{
	public static void main(String[]a){
		(new T()).t();
	}
	
	/** Wrap System.out.print to avoid all that typing */
	void p(String k, int i){
		System.out.print(k +((i<1)?"":"\n"));
	}
	
	/** Game board */
	int[][] G;int P;

	/** Check all possibilities for winner, return 0 for no winner, 1 for X, 2 for O */
	int c(){
		for(int[]i:G)
			if((i[0]==i[1])&&(i[1]==i[2])&&i[0]>0)
				return i[0];
		for(int i=0;i<3;i++)
			if ((G[0][i]==G[1][i])&&(G[1][i]==G[2][i])&&G[0][i]>0)
				return G[0][i];
		int m=G[1][1];
		return (((G[0][0]==m)&&(m==G[2][2])||(G[0][2]==m)&&(m==G[2][0]))?m:0);
	}
	/** Print game board */
	void g(){
		for(int[]i:G){
			for(int j:i)
				p(w(j),0);
			p("",1);
		}p("",1);
	}
	/** Generate a random value */
	int x(int i) {
		return (new Random()).nextInt(i);
	}
	/** Convert 1 to X, 2 to O */
	String w(int i) {
		return (i<1)?".":((2*i-3)*P<0)?"X":"O";
	}
	/** Get a number from the input */
	int y() {
		return (new Scanner(System.in)).nextInt();
	}
	/** Pick the next move for the computer */
	void Z() {
		int i,j;
		do{
			i=x(3);
			j=x(3);
		}while(!s(i,j,1));
		//p(i+"x"+j,1);
	}
	/** Check for win or board condition for player z based on an ordered set of values a,b,c having one space with player x */
	int o(int a, int b, int c, int z, int x) {
		return (a==b&&c==x&&a==z)?2:(a==x&&b==c&&b==z)?0:(a==c&&b==x&&c==z)?1:-1;
	}
	/** Check for win over rows, cols, and grids for user z, place for user y based on findings.
	 *  Means will block z if z != y */
	int q(int z,int y){
		int i=0,j;
		// check for win or block
		for (;i<3;i++){
			j=o(G[i][0],G[i][1],G[i][2],z,0);
			//p(i+"-"+j,1);
			if (j>=0){s(i,j,y);return 1;}
			j=o(G[0][i],G[1][i],G[2][i],z,0);
			//p(i+"|"+j,1);
			if (j>=0){s(j,i,y);return 1;}
		}
		i=o(G[0][0],G[1][1],G[2][2],z,0);
		//p(" \\"+i,1);
		if (i>=0){s(i,i,y);return 1;}
		i=o(G[0][2],G[1][1],G[2][0],z,0);
		//p(" /"+i,1);
		if (i>=0){s(i,2-i,y);return 1;}
		return 0;
	}
	/** Check for placement options over rows, cols, and grids for user z, place for user y based on findings.
	 *  Means will block z if z != y */
	int b(int z,int y){
		int i=0,j;
		// check for placement or block
		for (;i<3;i++){
			j=o(G[i][0],G[i][1],G[i][2],0,z);
			//p(i+"-"+j,1);
			if (j>=0){s(i,2-j/2,y);return 1;}
			j=o(G[0][i],G[1][i],G[2][i],0,z);
			//p(i+"|"+j,1);
			if (j>=0){s(2-j/2,i,y);return 1;}
		}
		i=o(G[0][0],G[1][1],G[2][2],0,z);
		//p(" \\"+i,1);
		if (i>=0){s(2-i/2,2-i/2,y);return 1;}
		i=o(G[0][2],G[1][1],G[2][0],0,z);
		//p(" /"+i,1);
		if (i>=0){s(2-i/2,i/2,y);return 1;}
		return 0;
	}
	/** Pick the next move for the computer, smartly */
	void z() {
		// Check for win
		if (q(1,1)>0)return;
		// Check for block
		if (q(2,1)>0)return;
		// check for best
		if (s(1,1,1))return; // try to take center.
		// take whatever would win the subsequent turn if the other person is stupid.
		if (b(1,1)>0)return;
		Z(); // take anything.
	}
	/** Check if move is possible, if so do it, otherwise return false */
	boolean s(int i, int j, int z){
		if (G[i][j]<1){
			p(w(z)+" to "+j+","+i,1);
			return (G[i][j]=z)==z;
		}
		return 0>1;
	}
	/** Play the game, Computer gets first  move. */
	void t() {
		while(1>0){
			G=new int[3][3];
			int m=9,x;
			if (x(2)<1) { // Computer starts.
				P=1;
				Z();
				g();
				m--;
			}else P=-1;
			do{
				do{
					p("x?",0);
					x=y();
					p("y?",0);
				}while(!s(y(),x,2));
				m--;
				g();
				x=c();
				if (x>0||m<1)
					break;
				z();
				g();
				m--;
				x=c();
			}while(m>0&&x<1);
			if(x<1) p("No winner!",1);
			else p(w(x) + " wins!",1);
		}
	}
}
