package ������Ϸ2;

 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements MouseListener,Runnable,ActionListener,MouseMotionListener{
	private static final long serialVersionUID = 1L;
	int length=800;   //���泤��
	int width=540;    //������
	int x=500;       //����λ��
	int y=250;
	static int gridNum=25;    //������
	static int gridSize=20;   //���Ӵ�С
	static int maxGridSize=gridNum*gridSize;    //���ı߽�ֵ
	static boolean[][] isAlive=new boolean[gridNum+1][gridNum+1];   //ϸ�����״̬
	JPanel p=new JPanel();
	JButton bt1=new JButton("��ʼ");
	JButton bt2=new JButton("��ͣ");
	JButton bt3=new JButton("���¿�ʼ");
	boolean running=false;
	Thread myThread;
	JFrame fe;
	
	public Board() 
	{
		fe=new JFrame("������Ϸ");
		fe.setBounds(x,y,length,width);
		bt1.setBounds(maxGridSize+100,50,60,45);
		bt2.setBounds(maxGridSize+100,150,60,45);
		bt3.setBounds(maxGridSize+100,300,100,45);
		bt2.setEnabled(false);
		bt3.setEnabled(false);
		fe.add(bt1);
		fe.add(bt2);
		fe.add(bt3);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		fe.getContentPane().setBackground(Color.WHITE);
		fe.setLayout(null);
		this.setBounds(0,0,maxGridSize+1, maxGridSize+1);    //�������
		fe.add(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		fe.setVisible(true);
		fe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fe.setResizable(false);
	}

	//��ʼ��  ������
	public void paint(Graphics g)
	{
		g.setColor(Color.LIGHT_GRAY);
		for(int i=0;i<=gridNum;i++) {
			g.drawLine(0, i*gridSize, maxGridSize, i*gridSize);
		}
		for(int i=0;i<=gridNum;i++) {
			g.drawLine(i*gridSize, 0, i*gridSize, maxGridSize);
		}
	}
	
	public void run()
	{
		while(running) {
			update();
			try {
				Thread.sleep(200L);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
	
	//ϸ����� �������ú�
	public void fill(int px,int py) 
	{
		int n=py/gridSize;
		int m=px/gridSize;
		Graphics g=this.getGraphics();
		if(isAlive[n][m]==true) {
			g.setColor(Color.BLACK);
			g.fillRect(m*gridSize+1, n*gridSize+1, gridSize-1,gridSize-1);
		}
	
	}
	
	public void update()
	{
		isAlive=State.getIsAlive();   //��ȡ��һ��ϸ��״̬
		Graphics g=this.getGraphics();
		for(int i=0;i<gridNum;i++) {
			for(int j=0;j<gridNum;j++) {
				if(isAlive[i][j]==true) {   //ϸ������
					g.setColor(Color.BLACK);
					g.fillRect(j*gridSize+1, i*gridSize+1, gridSize-1,gridSize-1);
				}
				else {
					g.setColor(Color.WHITE);
					g.fillRect(j*gridSize+1, i*gridSize+1, gridSize-1,gridSize-1);
				}
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		int px=e.getX();
		int py=e.getY();
		if(px>=0&&px<=maxGridSize&&py>=0&&py<=maxGridSize)  
		{
			isAlive[py/gridSize][px/gridSize]=true;   //�ı��߼�ֵ
			fill(px,py);
		}
	}
	public void mouseDragged(MouseEvent e) {
		 mousePressed(e); 	
	}
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1) {
			myThread=new Thread(this);
			running=true;
			myThread.start();
			bt1.setEnabled(false);
			bt2.setEnabled(true);
			bt3.setEnabled(true);
			bt1.setText("����");
		}
		else if(e.getSource()==bt2) {
			running=false;
			myThread.interrupt();
			bt1.setEnabled(true);
			bt2.setEnabled(false);
		}
		else if(e.getSource()==bt3) {
			for(int i=0;i<gridNum;i++) {
				for(int j=0;j<gridNum;j++) {
					isAlive[i][j]=false;
				}
			}
			bt1.setEnabled(true);
			bt2.setEnabled(false);
			bt3.setEnabled(false);
			bt1.setText("��ʼ");
			myThread.interrupt();
			update();
		}	
	}
	
	public static boolean[][] getIsAlive()
	{
		return isAlive;
	}
	
	public static int getGridNum()
	{
		return gridNum;
	}
	
	public static int getmaxGridSize()
	{
		return maxGridSize;
     }
}
