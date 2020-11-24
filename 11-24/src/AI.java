import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas implements Runnable
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/ 
    Thread thread;
	Image currentImg;
	Image bossImg;
	Random rd =new Random();
	Image heroImg[][]=new Image [4][3];
    

	//0代表左，1代表右，2代表上，3代表下
    int heroX;int heroY;int bossX;int bossY;
	int flag;
	
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			//向左
			for (int i=0; i<heroImg.length; i++){
				for(int j=0;j<heroImg[i].length;j++){
               heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				
			}
			}
			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][1];
			heroX=120;
			heroY=100;
            bossX=0;
            bossY=0;            
			flag=1;
			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	//在多线程里写一个死循环，不停的比较boss和hero的座标

	public void run(){
              while (true)
				 
				  {
					  int rdnumber=rd.nextInt(10);
				  try
				  {
					Thread.sleep(200);
				  }

				  catch (InterruptedException e)
				  {
					  e.printStackTrace();
				  }
				  if(rdnumber%3==0){
	            if (bossX<heroX){
               bossX++;
	            }
				else{
                bossX--;
              }
			  if(bossY<heroY){
                 bossY++;}
			  else{
				  bossY--;}
				  }
       
                   repaint();

				  }
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		
	    g.drawImage(currentImg,heroX,heroY,0);//120：X坐标、100：Y坐标
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			changePicanddirection(0);
			  heroX-=1;
		} 
		if(action==UP){
			changePicanddirection(2);
            heroY-=1;
		}
		if(action==RIGHT){
			changePicanddirection(1);
            heroX+=1;
		}
		if(action==DOWN){
			changePicanddirection(3);
           heroY+=1;
		}
	}
	void changePicanddirection(int direction){
         if(flag==1){ 
            currentImg=heroImg[direction][0];
               flag++;
			}
			else if(flag==2){
		    currentImg=heroImg[direction][2];
			flag--;
			}
	}
}