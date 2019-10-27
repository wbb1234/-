package 生命游戏2;


public class State {
		static int gridNum=Board.gridNum;
		static boolean[][] isAlive;
		static boolean[][] temp=new boolean[gridNum+1][gridNum+1];
		//计算下一代情况
		public static boolean[][] nextGen()
		{
			isAlive=Board.getIsAlive();   //得到当代情况
			int i=0;
			int j=0;
			int n=0;
			for(i=0;i<gridNum;i++) {
				for(j=0;j<gridNum;j++) {
					n=neighbor(i, j);
					if(isAlive[i][j]==true&&(n<2||n>3)) {    //活细胞邻居过少或过多则死亡
						temp[i][j]=false;
					}
					else if(isAlive[i][j]==true&&(n==2||n==3)) {    //活细胞邻居为2或3则继续活着
						temp[i][j]=true;
					}
					else if(isAlive[i][j]==false&&n==3) {     //死细胞活邻居正好是3则活过来
						temp[i][j]=true;
					}
					else {
						temp[i][j]=false;
					}
				}
			}
			for(i=0;i<gridNum;i++) {
				for(j=0;j<gridNum;j++) {
					isAlive[i][j]=temp[i][j];
				}
			}
			return isAlive;
		}
		
		//判断某个邻居是否存在
		public static boolean isok(int i,int j)  
		{
			if(i>=0&&i<gridNum&&j>=0&&j<gridNum) {
				return true;
			}
			else {
				return false;
			}
		}
		
		//计算邻居数
		public static int neighbor(int i,int j)
		{
			int n=0;
			if(isok(i-1,j-1)==true&&isAlive[i-1][j-1]==true) {
				n++;
			}
			if(isok(i-1,j)==true&&isAlive[i-1][j]==true) {
				n++;
			}
			if(isok(i-1,j+1)==true&&isAlive[i-1][j+1]==true) {
				n++;
			}
			if(isok(i,j-1)==true&&isAlive[i][j-1]==true) {
				n++;
			}
			if(isok(i,j+1)==true&&isAlive[i][j+1]==true) {
				n++;
			}
			if(isok(i+1,j-1)==true&&isAlive[i+1][j-1]==true) {
				n++;
			}
			if(isok(i+1,j)==true&&isAlive[i+1][j]==true) {
				n++;
			}
			if(isok(i+1,j+1)==true&&isAlive[i+1][j+1]==true) {
				n++;
			}
			return n;
		}
		
		public static boolean[][] getIsAlive()
		{
			return nextGen();
		}

}
