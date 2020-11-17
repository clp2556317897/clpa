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
	Image img,img1,img2,img3,img02,img22,img06,img26,img00,img20,img04,img24,currentImg;
    int x;
    int y;
	int m;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
            img2=Image.createImage("/sayo14.png");
			img3=Image.createImage("/sayo16.png");
			img02=Image.createImage("/sayo02.png");
			img22=Image.createImage("/sayo22.png");
			img06=Image.createImage("/sayo06.png");
			img26=Image.createImage("/sayo26.png");
			img00=Image.createImage("/sayo00.png");
			img20=Image.createImage("/sayo20.png");
			img04=Image.createImage("/sayo04.png");
			img24=Image.createImage("/sayo24.png");
			
			
			currentImg=img;
			x=120;
			y=100;
			m=0;
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
			currentImg=img1;
			
			x-=1;m+=1;
			if(m%2==1){ 
            currentImg=img02;}
			else{
		    currentImg=img22;}



			
			
		    
           

			repaint();
			
		} 
		if(action==UP){
			
			currentImg=img2;
			
			y-=1;m+=1;
            if(m%2==1){ 
            currentImg=img04;}
			else{
		    currentImg=img24;}

			repaint();
		}
		if(action==RIGHT){
			
			currentImg=img3;
			
			x+=1;m+=1;
			if(m%2==1){ 
            currentImg=img06;}
			else{
		    currentImg=img26;}

			repaint();
		}
		if(action==DOWN){
			
			currentImg=img;
			
			y+=1;m+=1;
			if(m%2==1){ 
            currentImg=img00;}
			else{
		    currentImg=img20;}

			repaint();
		}
	}
}