package sen2212;

import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Hash {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);  
		System.out.println("Pick Mode");
		System.out.println("1 = For sender mode");
		System.out.println("2 = For receive mode");
		int mode = sc.nextInt();
		if(mode==1) {
			Scanner sc2=new Scanner(System.in);
			System.out.println("Enter Text");
			String x =  sc2.nextLine();
			System.out.println("Key: " + x.hashCode());
			if(x.hashCode()>65000)
				encrypt(x,x.hashCode()%65000);
			else
			    encrypt(x,x.hashCode());
		}
		else if(mode==2){
			Scanner sc2=new Scanner(System.in);  
			System.out.println("Enter Text");
			
			String y =  sc2.nextLine();
			
			System.out.println("Enter Key");
			
			int z =  sc2.nextInt();
			if(z>65000)
				decrypt(y, z%65000);
			else
				decrypt(y, z);
			
			
		}
		else
			System.out.println("Wrong Enter");
		
		
	}
	public static void encrypt(String strClearText,int strKey) {
		
		for (int i = 0; i < strClearText.length(); i++)
		      System.out.print(keyer(strClearText.charAt(i),strKey));
		    System.out.println();
		
		
	}
	
	public static void decrypt(String strEncrypted,int strKey) {
		strKey=strKey*-1;
		char[] das = new char[strEncrypted.length()];
		for (int i = 0; i < strEncrypted.length(); i++) {
			System.out.print(keyer(strEncrypted.charAt(i),strKey));
			das[i]=keyer(strEncrypted.charAt(i),strKey);
			
		}
		System.out.println();
		String last = String. valueOf(das);
		if(last.hashCode()==strKey*-1)
			System.out.println("Text Verified");
		if(last.hashCode()!=strKey*-1)
			System.out.println("This text not verified");
		     
		    
	}
	private static char keyer(char ch,int hash) {
	    if (!Character.isLetter(ch))
	      return ch;
	    if (Character.isUpperCase(ch))
	      return (char) (((ch) + hash));
	    return (char) (((ch) + hash));
	  }
	
}
