package Wbb.src;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Administrator extends User {

	public Administrator(String name, String password, String role) {
		super(name, password, role);
	}

	@Override
	public void showMenu() {
		System.out.println("****��ӭ���뵵������Ա�˵�****\n\t" +
							"1.�޸��û�\n\t" +
							"2.ɾ���û�\n\t" +
							"3.�����û�\n\t" +
							"4.�г��û�\n\t" +
							"5.�����ļ�\n\t" +
							"6.�ļ��б�\n\t" +
							"7.�޸�(����)�û���������\n\t" +
							"8.��        ��\n" +
							"***********************************");
	}

	void changeUserInfo() {
		System.out.println("��ѡ����Ҫ�޸ĵ����ݣ�\n\t" +
							"1.�û���\n\t" +
							"2.����");
		Scanner sc1 = new Scanner(System.in);
		int se1 = sc1.nextInt();
		if(se1 == 1){
			System.out.println("������������û�����");
			this.setName(sc1.next());
		}
		else if(se1 == 2){
			System.out.println("��������������룺");
			this.setPassword(sc1.next());
		}
		else
			System.out.println("���Ҳ磡");
	}
	
	public static void select(int se){
			switch(se){
			case 1:
				System.out.println("�޸��û� ok");
				break;
			case 2:
				System.out.println("ɾ���û� ok");
				break;
			case 3:
				System.out.println("�����û� ok");
				break;
			case 4:
				System.out.println("�г��û� ok");
				break;
			case 5:
				System.out.println("�����ļ� ok");
				break;
			case 6:
				System.out.println("�ļ��б� ok");
				break;
			case 7:
				System.out.println("�޸�(����)�û��������� ok");
				break;
			}
	}

	
}
