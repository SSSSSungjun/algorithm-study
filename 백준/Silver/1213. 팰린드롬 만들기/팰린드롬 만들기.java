
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		char[] input=sc.next().toCharArray();
		int[] alpha=new int[26];
	
		for(char v : input) alpha[v-'A']++;
		
		StringBuilder fr=new StringBuilder();
		StringBuilder bk=new StringBuilder();
		StringBuilder odd=new StringBuilder();
		
		boolean hansoo=false;
		for(int i=0;i<26;i++) {
			if(alpha[i]%2!=0) {
				if(input.length%2==0 || odd.length()!=0) {
					hansoo=true;break;
				}
				odd.append((char)(i + 'A'));
				String inputValue= String.valueOf((char)(i + 'A')).repeat((alpha[i]-1) / 2);
				fr.append(inputValue);bk.insert(0,inputValue);
			}else {

				String inputValue= String.valueOf((char)(i + 'A')).repeat(alpha[i] / 2);
				fr.append(inputValue);bk.insert(0,inputValue);
			}
				
		}
		
		
		if(hansoo) {
			System.out.println("I'm Sorry Hansoo"); return;
		}
		StringBuilder result=new StringBuilder();
		result.append(fr).append(odd).append(bk);
		System.out.println(result);
	}
}
