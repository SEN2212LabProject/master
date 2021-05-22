package sen2212;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Hash_and_GUI extends JFrame {

	private JPanel contentPane;

	static LinkedList list = new LinkedList();
	private JTextField txtmode;
	private JTextField textField_2;
	private JTextField txtPeertopeerSecureData;
	private JTextField text_Verified_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hash_and_GUI frame = new Hash_and_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}


		});
	}

	/**
	 * Create the frame.
	 */
	public  Hash_and_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		

		JButton btnNewButton = new JButton("Encrypt");
		btnNewButton.setBounds(94, 136, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Decrypt");
		btnNewButton_1.setBounds(317, 136, 117, 29);
		contentPane.add(btnNewButton_1);
		
		txtmode = new JTextField();
		txtmode.setBounds(94, 98, 340, 26);
		contentPane.add(txtmode);
		txtmode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Message IN");
		lblNewLabel_2.setBounds(6, 46, 72, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Enter Key:");
		lblNewLabel_3.setBounds(6, 103, 66, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Message Out");
		lblNewLabel_4.setBounds(6, 208, 81, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Key Out");
		lblNewLabel_5.setBounds(6, 267, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(92, 272, 281, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Linked List");
		lblNewLabel_7.setBounds(6, 372, 81, 16);
		contentPane.add(lblNewLabel_7);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 262, 342, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(94, 349, 340, 65);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(94, 189, 340, 52);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(94, 29, 340, 57);
		contentPane.add(textArea_2);
		
		txtPeertopeerSecureData = new JTextField();
		txtPeertopeerSecureData.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		txtPeertopeerSecureData.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeertopeerSecureData.setText("P2P Secure Data Sharing Application");
		txtPeertopeerSecureData.setBackground(UIManager.getColor("Button.background"));
		txtPeertopeerSecureData.setBounds(67, 0, 385, 26);
		contentPane.add(txtPeertopeerSecureData);
		txtPeertopeerSecureData.setColumns(10);
		
		text_Verified_Field = new JTextField();
		text_Verified_Field.setBounds(94, 300, 340, 26);
		contentPane.add(text_Verified_Field);
		text_Verified_Field.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Text Verified");
		lblNewLabel.setBounds(6, 305, 81, 16);
		contentPane.add(lblNewLabel);




		btnNewButton.addActionListener(new ActionListener() {
	

			public void actionPerformed(ActionEvent e) {
				
				String text =  textArea_2.getText();
				String x =text;

				//gives the hash code of the data
				textArea_1.setText(encrypt(x,x.hashCode()%60000));
				textField_2.setText("Key: " + x.hashCode());
				

				
				
				//lblNewLabel_1.setText(keyer(strClearText.charAt(i),strKey).toString());



				//Java's char index ends after 60000 odd so we have to do this here or we will get an out of boundery error

				encrypt(x,x.hashCode()%60000); //we lock our message using our hash code
				String chain = "Chain Hash: "+(LinkedList.lastIndex(list)+x.hashCode()).hashCode()+" ";
				//System.out.println(LinkedList.lastIndex(list));
				list=LinkedList.insert(list,chain+"Last Hash: "+ x.hashCode()+" ");
				textArea.setText(LinkedList.printList(list));



			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void decrypt(String strEncrypted,int strKey) {

				int key=strKey%60000;

				System.out.println(strKey);
				key=key*-1; //hash multiplied by -1 to decrypt the reverse
				char[] das = new char[strEncrypted.length()]; //Since the last hash will be taken and compared with the entered hash, char's should be converted to a string.
				for (int i = 0; i < strEncrypted.length(); i++) {
					das[i]=keyer(strEncrypted.charAt(i),key);

				}
				System.out.println();
				String last = String. valueOf(das);
				System.out.println(last.hashCode());
				
				if(last.hashCode()==strKey) {
					textArea_1.setText(last);
					text_Verified_Field.setText("***Text Verified***");
					System.out.println("Text Verified");
				}
				else {
					textArea_1.setText(last);
					text_Verified_Field.setText("***This text not verified***");
					System.out.println("This text not verified");
				}
			}


			@Override
			public void actionPerformed(ActionEvent e) {
				
				String text =  textArea_2.getText();
				//user enters encrypted message
				String y =  text;
				
				String text_1 =  txtmode.getText();
				int z = Integer.parseInt(text_1);				
				
				decrypt(y, z);
				
				

			}
		});
		
		
		
		
		
		
		
	}
	
	
	public String encrypt(String strClearText,int strKey) {
		//the entered text is separated into individual characters and transmitted to the keyer with hash data to be locked.
		char[]eas = new char[strClearText.length()];
		for (int i = 0; i < strClearText.length(); i++)
		      eas[i]=keyer(strClearText.charAt(i),strKey);
		 System.out.println();
		 String str = String. valueOf(eas);
		 System.out.println(str);
		 
		 return str;
	}


		
	public static char keyer(char ch,int hash) {

		return (char) (((ch) + hash));
	}
}