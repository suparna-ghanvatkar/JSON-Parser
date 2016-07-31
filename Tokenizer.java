import java.util.*;
import java.util.regex.*;
import java.io.*;
public class Tokenizer{
	RandomAccessFile F;
	public Tokenizer(String fname) throws Exception{
		F=new RandomAccessFile(fname,"r");
	}
	public ArrayList<Token> Tokenize() throws Exception
	{
		String str;
		String sym="{[\":,]}";
		ArrayList<Token> arr=new ArrayList<Token>();
		Token temp=new Token();
		Pattern p=Pattern.compile("\\p{Alnum}+");
		Matcher m;
		Scanner sc=new Scanner(System.in);
		int i=0,j=0;
		try{
			while(true){	
				i=0;
				j=0;
				str=F.readLine();
				System.out.println(str);
				while(i<str.length()){
					if(str.charAt(i)==' ')
						i++;
					else if(sym.indexOf(str.charAt(i))>=0){
						temp.tk=Character.toString(str.charAt(i));
						temp.type=sym.indexOf(temp.tk);
						i++;
					}
					else{
						m=p.matcher(str.substring(i));
						if(m.find()){
							temp.tk=m.group();
							temp.type=8;
							i=(i)+m.end();
							if(str.charAt(i)!='\"'){		
							//handle that everything inside " " goes into one token!
								j=i;
								while(str.charAt(i)!='\"'){
									i++;
								}
								temp.tk=temp.tk+str.substring(j,i-1);
							}
						}
					}
					System.out.println(i);
					System.out.println(temp.tk+str);
					arr.add(temp);
					//sc.next();
				}
			}
		}
		catch(Exception e){}
		return arr;
	}
	public static void main(String[] args) throws Exception{
		Tokenizer t=new Tokenizer("j.json");
		ArrayList<Token> tks=t.Tokenize();
		//System.out.println(tks);	
	}
}
