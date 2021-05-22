# master

Peer-to-peer secure data sharing application

A project to protect and verify the confidentiality of data shared between two users. 
This project is developed using JAVA. Two data structures, linked list and hash were used in the project. 
Linked list is used to store hash information after the data has been hashed. 
Hash is a specially created unique password for each data, which makes one-sided encryption and verifies the accuracy of the data. 
User 1 (the person who will send the data) chooses the sender mode from the system, then enters the data manually, 
the system outputs the encrypted version of the data and gives a hash code, and the system automatically stores the hash codes in the 
linked list, then the user 1 with the other party as requested shares. 
User 2 (the person receiving the data) chooses the receiver mode from the system, puts the encrypted data from user 1 into the system, 
the system requests a key to decrypt this data and enters the hash code from user 1 (here we use the hash code as both verification and decryption key) 
system hash Using the code as a password, it analyzes the data, then takes the hash and checks whether it matches the hash entered by the user. 
If they match, the user is informed that it matches, and then the hash is stored in the linked list. 
Since the hash stores the information in the linked list, it can check the accuracy of the data shared between two people 
in the future by comparing the linked lists.
