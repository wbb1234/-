package Wbb.src;

import java.sql.SQLException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public abstract class User {
	private String name;
	private String password;
	private String role;
	
	User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;				
	}
	
	public boolean changeSelfInfo(String password) throws SQLException{
		//д�û���Ϣ���洢
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			System.out.println("�޸ĳɹ�");
			return true;
		}else
			return false;
	}
	
	public boolean downloadFile(String ID) throws SQLException, IOException{
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new IOException( "Error in accessing file" );
//		System.out.println("�����ļ�... ...");
		Doc d = DataProcessing.searchDoc(ID);
		File f = new File("D:\\java\\uploadFile\\" + d.getFilename());
		FileReader fr = new FileReader(f);
		FileWriter fw = new FileWriter("D:\\java\\downloadFile\\" + d.getFilename());
		
		char[] ch = new char[1024*3];
		int len;
		
		while((len = fr.read(ch)) != -1) {
			fw.write(ch, 0, len);
			fw.flush();
		}
		
		fw.close();
		fr.close();
		System.out.println("���سɹ���");
		return true;
	}
	
	public void showFileList() throws SQLException{
		double ranValue=Math.random();
		if (ranValue>0.5)
			throw new SQLException( "Error in accessing file DB" );
		System.out.println("�б�... ...");
	}
	
	public abstract void showMenu();
	
	public void exitSystem(){
		System.out.println("ϵͳ�˳�, ллʹ�� ! ");
		System.exit(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

}
