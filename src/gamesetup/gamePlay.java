package gamesetup;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author sourav
 */
import javax.swing.JFrame;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;
public class gamePlay extends JFrame {
    graphicalInterface colorJPanel = new graphicalInterface(); // create ColorJPanel
    int val,dice=1,count,getX=0,getY=0,flag=0,myColor,movX=0,movY=0,greade=0;
    int list[]=new int[4];
    boolean cond_global=false;
    public gamePlay()
    {   
        super("LUDO GAME PLAY");
        //MouseListener mls=new MouseListener();
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        this.add( colorJPanel ); // add colorJPanel to frame
        this.setSize( 765,660 ); // set frame size
        this.setVisible(true);
        //this.setResizable(false);
        val=-1;
        for(int i=0;i<4;i++)
            list[i]=-1;
        greade=0;
    }               
    private  class MouseHandler implements MouseListener,MouseMotionListener
    {
        public void mouseClicked(MouseEvent e)
        {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
            getX=e.getX();
            getY=e.getY();
            flag=1;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            movX=e.getX();
            movY=e.getY();
            //throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    class NewThread implements Runnable {
Thread t;
colorHome ch[]=null;
NewThread(colorHome[] c) {
// Create a new, second thread
    ch=c;
t = new Thread(this, "Demo Thread");
System.out.println("Child thread: " + t);
t.start(); // Start the thread
}
// This is the entry point for the second thread.
public void run() {
    while(true)
        try{
    setpoint(ch);
        }
    catch(Exception e)
    {
        
    }
}
}
    
        class demoThread implements Runnable {
Thread t;
colorHome ch[]=null;
demoThread() {
// Create a new, second thread
    //ch=c;
t = new Thread(this, "Demo Thread");
System.out.println("Child thread: " + t);
t.start(); // Start the thread
}
// This is the entry point for the second thread.
public void run() {
    while(true)
    play();
}
}
    
    void setpoint(colorHome[] ch)
    {
            if((30<=movX && 242+30>=movX)&& (30<=movY && 196+30>=movY))
            {
                    colorJPanel.repaintIt(ch,val,dice,cond_global,0,list);
            }
            else if((379<=movX && 251+379>=movX)&& (30<=movY && 197+30>=movY))
            {
                colorJPanel.repaintIt(ch,val,dice,cond_global,1,list);
            }
            else if((379<=movX && 251+379>=movX)&& (333<=movY && 197+333>=movY))
            {
                colorJPanel.repaintIt(ch,val,dice,cond_global,2,list);
            }
            else if((30<=movX && 242+30>=movX)&& (333<=movY && 197+333>=movY))
            {
                colorJPanel.repaintIt(ch,val,dice,cond_global,3,list);
            }
            else
              colorJPanel.repaintIt(ch,val,dice,cond_global,-1,list);  
    }
    public void play() 
    {
        MouseHandler handler = new MouseHandler();  
        Random rand=new Random();
        Scanner scan=new Scanner(System.in);
        dice=1;count=0;
        boolean cond=false;
        myColor=0;getX=0;getY=0;
        colorJPanel.addMouseListener(handler);
        colorJPanel.addMouseMotionListener(handler);    
        colorHome[] ch=new colorHome[4];
        for(int i=0;i<4;i++)
            ch[i]=new colorHome(i); 
        colorJPanel.repaintIt(null,val,dice,false,-1,list); 
        while(true)
        {
            if((30<=getX && 242+30>=getX)&& (30<=getY && 196+30>=getY))
            {
                myColor=0;
                break;
            }
            if((379<=getX && 251+379>=getX)&& (30<=getY && 197+30>=getY))
            {
                myColor=1;
                break;
            }
            if((379<=getX && 251+379>=getX)&& (333<=getY && 197+333>=getY))
            {
                myColor=2;
                break;
            }
            if((30<=getX && 242+30>=getX)&& (333<=getY && 196+333>=getY))
            {
                myColor=3;
                break;
            }
        }
        new NewThread(ch);
        int flag1=1;val=3;
        while(true)
        {       
            cond=false;cond_global=false;
            if((dice!=6 && count==0)|| flag1==0)
            {
                System.out.println("val:"+ch[val].allert);
                if(ch[val].allert==0)
                {
                    do
                    {
                        val=(val+1)%4;
                    }while(checkVal(val));
                }
            }
            getX=0;getY=0;flag=0;
            if(val==myColor)
            {
               cond=true;
               cond_global=true;
            }
           colorJPanel.repaintIt(ch,val,dice,cond,-1,list); 
            if(cond)
            {
                while(true)
                {
                    if((650<=getX && 750>=getX)&& (350<=getY && 450>=getY))
                        break;
                }
            cond_global=false;
            }
            else
            {
                try{
               Thread.sleep(500);
                }
                catch(Exception e)
                {
                    
                }
            }
            do
            {
                dice=rand.nextInt(6)+1;
            }
            while(count==2 && dice==6);
            if(dice!=6)
            {
               // val=(val+1)%4;
                count=0;
            }
            else
                count++;
            getX=0;getY=0;flag=0;
            System.out.println("\nPLEASE THROW A DICE--"+val); 
           // dice=scan.nextInt();
            System.out.println(dice);
            colorJPanel.repaintIt(ch,val,dice,false,-1,list);
            flag1=ch[val].throwDice(ch,dice,cond);
            while(flag1!=0 && cond)
            {
                flag=0;
                while(flag==0)
                {
                }
                if(ch[val].addIt(ch[val].isTrue(getX,getY,dice),ch,dice))
                    break;                    
            }
            int level=ch[val].getCount();
             System.out.print("\ncount==="+level);
            if(level==0)
            setList(level,ch[val].color);
            System.out.print("\ngrade=="+greade);
            if(greade==4)
            {
                colorJPanel.repaintIt(ch,val,dice,false,-1,list);;
                break;
            }
        }        
    }
    boolean checkVal(int val)
    {
        for(int i=0;i<4;i++)
            if(list[i]==val)
                return true;
        return false;
    }
    public void setList(int level,int color)
    {
        for(int i=0;i<4;i++)
            if(list[i]==color)
                return;
        list[greade++]=color;
    }
    public static void main(String args[]) 
    {
        gamePlay gp=new gamePlay();       
        try{
           gp.play();
           // gp.new   demoThread();
        }
        catch(Exception e)
        {
            
        }
    }
}
