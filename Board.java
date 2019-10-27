package 生命游戏2;

 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements MouseListener,Runnable,ActionListener,MouseMotionListener{
	private static final long serialVersionUID = 1L;
	int length=800;   //界面长度
	int width=540;    //界面宽度
	int x=500;       //界面位置
	int y=250;
	static int gridNum=25;    //格子数
	static int gridSize=20;   //格子大小
	static int maxGridSize=gridNum*gridSize;    //面板的边界值
	static boolean[][] isAlive=new boolean[gridNum+1][gridNum+1];   //细胞存活状态
	JPanel p=new JPanel();
	JButton bt1=new JButton("开始");
	JButton bt2=new JButton("暂停");
	JButton bt3=new JButton("重新开始");
	boolean running=false;
	Thread myThread;
	JFrame fe;
	
	public Board() 
	{
		fe=new JFrame("生命游戏");
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
		this.setBounds(0,0,maxGridSize+1, maxGridSize+1);    //放置面板
		fe.add(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		fe.setVisible(true);
		fe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fe.setResizable(false);
	}

	//初始化  画格子
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
	
	//细胞存活 将格子置黑
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
		isAlive=State.getIsAlive();   //获取下一代细胞状态
		Graphics g=this.getGraphics();
		for(int i=0;i<gridNum;i++) {
			for(int j=0;j<gridNum;j++) {
				if(isAlive[i][j]==true) {   //细胞活着
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
			isAlive[py/gridSize][px/gridSize]=true;   //改变逻辑值
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
			bt1.setText("继续");
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
			bt1.setText("开始");
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
