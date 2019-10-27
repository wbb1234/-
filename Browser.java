package Wbb.src;

import java.util.Scanner;

public class Browser extends User {

	public Browser(String name, String password, String role) {
		// TODO Auto-generated constructor stub
		super(name, password, role);
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("****��ӭ���뵵�����Ա�˵�****\n\t" + 
							"1.�����ļ�\n\t" +
							"2.�ļ��б�\n\t" +
							"3.�޸�����\n\t" +
							"4.��        ��\n" +
							"***********************************");
	}

	public static void select(int se) throws Exception {
		switch(se) {
		case 1:
		case 2:
		case 3:
		case 4:
		default:
		}
	}

}
