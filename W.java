import java.util.*;class W{public static void main(String[]a){(new W()).t();}void p(String k,int i){System.out.print(k+(i<1?"":"\n"));}int[]M;int P;int c(){int m,a,b,i;for(a=b=i=0;i<3;i++){a=M[i*3];b=M[i];m=a==M[i*3+1]&&M[i*3+1]==M[i*3+2]&&a>0?a:b==M[i+3]&&M[i+3]==M[i+6]&&b>0?b:0;if(m>0){return m;}}m=M[4];return M[0]==m&&m==M[8]||b==m&&m==a?m:0;}void g(){for(int i=0;i<9;)p(w(M[i]),i++%3/2);p("",1);}int x(int i){return(new Random()).nextInt(i);}String w(int i){return(i<1)?".":((2*i-3)*P<0)?"X":"O";}int y(){return(new Scanner(System.in)).nextInt();}void Z(){int i;do{i=x(9);}while(!s(i,1));}

int o(int a,int b,int c,int z,int x){return a==b&&c==x&&a==z?2:a==x&&b==c&&b==z?0:a==c&&b==x&&c==z?1:-1;}

/*int q(int z,int y){
	int i=0,j;
	for(;i<3;i++){
		if((j=o(M[i*3],M[i*3+1],M[i*3+2],z,0))>=0?s(i*3+j,y):
		   (j=o(M[i],M[i+3],M[i+6],z,0))>=0?s(i+3*j,y):0>1)return 1;
	}
	if((i=o(M[0],M[4],M[8],z,0)*4)>=0?s(i,y):
	   (i=o(M[2],M[4],M[6],z,0)*2+2)>=1?s(i,y):0>1)return 1;
	return 0;
}*/

int d(int z,int y,int k){
	int i=0,j;
	for(;i<3;i++){
		if((j=o(M[i*3],M[i*3+1],M[i*3+2],z*k,z*(1-k)))>=0?s(k>0?i*3+j:i*3+2-j/2,y):
		   (j=o(M[i],M[i+3],M[i+6],z*k,z*(1-k)))>=0?s(k>0?i+3*j:i+(2-j/2)*3,y):0>1)return 1;
	}
	if((i=o(M[0],M[4],M[8],z*k,z*(1-k)))>=0?s(k>0?i*4:8-(i/2)*4,y):
	   (i=o(M[2],M[4],M[6],z*k,z*(1-k)))>=0?s(k>0?i*2+2:6-(i/2)*2,y):0>1)return 1;
	return 0;
}

//int q(int z,int y){int i=0,j;for(;i<3;i++){j=o(M[i*3],M[i*3+1],M[i*3+2],z,0);if(j>=0){s(i*3+j,y);return 1;}j=o(M[i],M[i+3],M[i+6],z,0);if(j>=0){s(i+3*j,y);return 1;}}i=o(M[0],M[4],M[8],z,0)*4;if(i>=0){s(i,y);return 1;}i=o(M[2],M[4],M[6],z,0)*2+2;if(i>=1){s(i,y);return 1;}return 0;}

//int b(int z,int y){int i=0,j;for(;i<3;i++){j=o(M[i*3],M[i*3+1],M[i*3+2],0,z);if(j>=0){s(i*3+2-j/2,y);return 1;}j=o(M[i],M[i+3],M[i+6],0,z);if(j>=0){s(i+(2-j/2)*3,y);return 1;}}i=o(M[0],M[4],M[8],0,z);if(i>=0){s(8-(i/2)*4,y);return 1;}i=o(M[2],M[4],M[6],0,z);if(i>=0){s(6-(i/2)*2,y);return 1;}return 0;}

void z(){if(!(d(1,1,1)>0||d(2,1,1)>0||s(4,1)||d(1,1,0)>0))Z();}
//void z(){if(!(q(1,1)>0||q(2,1)>0||s(4,1)||b(1,1)>0))Z();}

boolean s(int i,int z){if(M[i]<1){p(w(z)+" to "+i%3+","+i/3,1);return(M[i]=z)==z;}return 0>1;}

void t(){while(1>0){M=new int[9];int m=9,x;if(x(2)<1){P=1;Z();g();m--;}else P=-1;do{do{p("x?",0);x=y();p("y?",0);}while(!s(y()*3+x,2));m--;g();x=c();if(x>0||m<1)break;z();g();m--;x=c();}while(m>0&&x<1);if(x<1)p("No winner!",1);else p(w(x)+" wins!",1);}}}
