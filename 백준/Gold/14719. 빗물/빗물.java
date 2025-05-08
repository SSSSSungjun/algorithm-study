
import java.io.*;
import java.util.*;

public class Main {
	static int H, W;
	static int[][] field;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		field=new int[H][W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int height=Integer.parseInt(st.nextToken());
			
			for(int k=0;k<height;k++) {
				field[k][i]=1;
			}
		}
			
		
		//벽두개 안에 있는 것들 카운터 세면 되는거아닌가
		
		int goinMul=0;
		
		for(int i=0;i<H;i++) {
			
			boolean wall=false;
			int prevWallIndex=-1;
			
			for(int k=0;k<W;k++) {
				if(field[i][k]==1 && !wall ) {
					wall=true;
					prevWallIndex=k;
				}
				else if(field[i][k]==1 && wall) {
					
					goinMul+=(k-prevWallIndex-1);
					prevWallIndex=k;
				}
			}
			
		}
		
		System.out.println(goinMul);
	
		
	}
}