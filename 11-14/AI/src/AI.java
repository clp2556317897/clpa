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
	Image  currentImg,img1,img2,img3,img4;
	public MainCanvas(){
		try
		{
			img1=Image.createImage("/sayo10.png");
			img2=Image.createImage("/sayo12.png");
			img3=Image.createImage("/sayo16.png");
           img4=Image.createImage("/sayo14.png");
         currentImg=img1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
  public void paint(Graphics g){
   g.setColor(0,0,0);
   g.fillRect(0,0,getWidth(),getHeight());
   g.drawImage(currentImg,120,120,0);
  }
   public void keyPressed(int keyCode){
	   int action=getGameAction(keyCode);
	  if (action==LEFT){
       currentImg=img2;
	   repaint(); }
	   else if (action==RIGHT){
            currentImg=img3;
           repaint();}
      else{
		  currentImg=img4;
       repaint();
	  
	}
   }
 }