import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

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
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Image currentImg;
	Image heroLeft[]=new Image [3];
	Image heroRight[]=new Image [3];
	Image heroUp[]=new Image [3];
	Image heroDown[]=new Image [3];
    int x;
    int y;
	int LeftFlag=1;
	int RightFlag=1;
	int UpFlag=1;
	int DownFlag=1;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			//向左
			for (int i=0; i<3; i++){
               heroLeft[i]=Image.createImage("/sayo"+i+"2.png");
			}
            //向右
			for (int i=0; i<3; i++){
               heroRight[i]=Image.createImage("/sayo"+i+"6.png");
			}
			//向上
			for (int i=0; i<3; i++){
               heroUp[i]=Image.createImage("/sayo"+i+"4.png");
			}
            //向下
			for (int i=0; i<3; i++){
               heroDown[i]=Image.createImage("/sayo"+i+"0.png");
			}
			
			currentImg=heroDown[1];
			
			x=120;
			y=100;
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		
	    g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			if(LeftFlag==1){ 
            currentImg=heroLeft[0];
               LeftFlag++;
			}
			else if(LeftFlag==2){
		    currentImg=heroLeft[2];
			LeftFlag--;
			}
              
			  x-=1;
			repaint();
			
		} 
		if(action==UP){
			
			
			
			if(UpFlag==1){ 
            currentImg=heroUp[0];
               UpFlag++;
			}
			else if(UpFlag==2){
		    currentImg=heroUp[2];
			UpFlag--;
			}
            y-=1;
			repaint();
		}
		if(action==RIGHT){
			
        if(RightFlag==1){ 
            currentImg=heroRight[0];
               RightFlag++;
			}
		else if(RightFlag==2){
		    currentImg=heroRight[2];
			RightFlag--;
			}
            x+=1;
			repaint();
		}
		if(action==DOWN){
			if(DownFlag==1){ 
            currentImg=heroDown[0];
               DownFlag++;
			}
			else if(DownFlag==2){
		    currentImg=heroDown[2];
			DownFlag--;
			}
            y+=1;
			repaint();
		}
	}
}