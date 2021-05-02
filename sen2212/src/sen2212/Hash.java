package sen2212;

import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Hash {
 
	static LinkedList list = new LinkedList();
	public static void main(String[] args) {
		  
		start();
		
	}
	//encryption function
	public static void encrypt(String strClearText,int strKey) {
		//the entered text is separated into individual characters and transmitted to the keyer with hash data to be locked.
		for (int i = 0; i < strClearText.length(); i++)
		      System.out.print(keyer(strClearText.charAt(i),strKey));
		
		
		
		    System.out.println();
		
		
	}
	//decryption function
	public static void decrypt(String strEncrypted,int strKey) {
		
			int key=strKey%60000;
		
		System.out.println(strKey);
		key=key*-1; //hash multiplied by -1 to decrypt the reverse
		char[] das = new char[strEncrypted.length()]; //Since the last hash will be taken and compared with the entered hash, char's should be converted to a string.
		for (int i = 0; i < strEncrypted.length(); i++) {
			System.out.print(keyer(strEncrypted.charAt(i),key));
			das[i]=keyer(strEncrypted.charAt(i),key);
			
		}
		System.out.println();
		String last = String. valueOf(das);
		System.out.println(last.hashCode());
		if(last.hashCode()==strKey)
			System.out.println("Text Verified");
		if(last.hashCode()!=strKey)
			System.out.println("This text not verified");
		     
		    
	}
	//The passwords are created by shuffling the char class of java within as many characters as the index, shifting the hash value.
	private static char keyer(char ch,int hash) {
	   
	    return (char) (((ch) + hash));
	  }
	public static void start() {
		//scanner 1 opened
				Scanner sc=new Scanner(System.in);  
				System.out.println();
				System.out.println("Pick Mode");
				System.out.println("1 = For sender mode");
				System.out.println("2 = For receive mode");
				System.out.println("3 = For Show List");
				System.out.println("4 = For Exit");
				
				int mode = sc.nextInt();
				
				if(mode==1) {
					//If mode 1 is selected, the codes here will work.
					//sender mode
					//scanner 2 opened
					//If I don't do that,  wasn't scan the entries here.
					Scanner sc2=new Scanner(System.in);
					System.out.println("Enter Text");
					String x =  sc2.nextLine();
					//gives the hash code of the data
					System.out.println("Key: " + x.hashCode());
					
					//Java's char index ends after 60000 odd so we have to do this here or we will get an out of boundery error
					
						encrypt(x,x.hashCode()%60000); //we lock our message using our hash code
						String chain = "Chain Hash: "+(LinkedList.lastIndex(list)+x.hashCode()).hashCode()+" ";
						//System.out.println(LinkedList.lastIndex(list));
					list=LinkedList.insert(list,chain+"Last Hash: "+ x.hashCode()+" ");
					
					start();
					 
				}
				
				else if(mode==2){
					//If mode 2 is selected, the codes here will work.
					//receiver mode
					//scanner 3 opened
					Scanner sc2=new Scanner(System.in);  
					System.out.println("Enter Text");
					//user enters encrypted message
					String y =  sc2.nextLine();
					System.out.println("Enter Key");
					//Both the hash and lock are entered at this stage.
					int z =  sc2.nextInt();
					decrypt(y, z);
					start();
					
					
				}
				
				else if(mode==3) {
					LinkedList.printList(list);
					start();
				}
				else if(mode==4) {
					System.out.println("Good Bye");
				}
				//gets an error if the user enters another value while selecting a mode
				else {
					System.out.println("Wrong Enter");
					start();
				}
					
				
	}
	
}
