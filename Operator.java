package Wbb.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class Operator extends User {
	
	public Operator(String name, String password, String role) {
		// TODO Auto-generated constructor stub
		super(name, password, role);
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("****��ӭ���뵵�����Ա�˵�****\n\t" +
							"1.�ϴ��ļ�\n\t" +
							"2.�����ļ�\n\t" +
							"3.�ļ��б�\n\t" +
							"4.�޸�����\n\t" +
							"5.��        ��\n" +
							"***********************************");
	}

	public static void select(int se) throws Exception {
		switch(se) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		default:
		}
	}
	
//	public void uploadFile(String filename) throws IOException {
//		File f = new File(filename);
//		FileWriter fw = null;
//		FileReader fr = null;
//		
//		try {
//			System.out.println("�����뵵���ţ�");
//			String ID = sc.nextLine();
//			System.out.println("������������");
//			String description = sc.nextLine();
//			fr = new FileReader(f);
//			
//			File tempFile = new File(filename.trim());
//			filename = tempFile.getName();
//			fw = new FileWriter("D:\\java\\uploadFile\\" + filename);
//			
//			DataProcessing.docs.put(ID, new Doc(ID, this.getName(), new Timestamp(System.currentTimeMillis()), description, filename));
//			char[] ch = new char[1024*3];
//			int len;
//			
//			while((len = fr.read(ch)) != -1) {
//				fw.write(ch, 0, len);
//				fw.flush();
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println(e.toString());
//		}catch (IOException e) {
//			System.out.println(e.toString());
//		}finally {
//			if(fw != null)
//				fw.close();
//			if(fr != null)
//				fr.close();
//		}
//		
//		System.out.println("���سɹ���");
//	}
	
}
