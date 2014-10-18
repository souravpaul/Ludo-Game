/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesetup;

/**
 *
 * @author sourav
 */
import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Polygon;
public class graphicalInterface extends JPanel {
    Graphics g1;
    colorHome[] ch;
    int val=0,select=-1,dice=0,rank[];
    char c='0';
    Font f;
    boolean status=true;
    public void repaintIt(colorHome[] cHome,int v,int d,boolean sts,int sel,int[] r)
    {
        ch=cHome;
        repaint();
        val=v;
        dice=d;
        status=sts;
        select=sel;
        rank=r;
    }
    public void paint(Graphics g)
    {
        refresh(g);
        g1=g;
        f = new Font("Dialog", Font.BOLD,30);            
        g1.setColor(Color.LIGHT_GRAY);
        g1.setFont(f);
        if(ch!=null)
        {
            if(status)
                g1.drawString("YOUR TURN..CLICK ON THE DICE ", 25, 600);
            setPosition(val);
        }
        else
        {            
            g1.drawString("CLICK ON THE COLOR TO CHOOSE..", 25, 600);
        }
        if(rank[3]!=-1)
        {
            String str=new String();
            System.out.print("\nlist t ");
             for(int i=0;i<4;i++)
                 System.out.print("  "+rank[i]);
            int x=0,y=0;
            g.setColor(Color.DARK_GRAY);
            g.fill3DRect(220,160, 220, 250, false);
            g.setColor(Color.CYAN);
            g.drawString("RANK", 280,200);y=240;
            for(int i=0;i<4;i++)
            {                
                str=(i+1) +".";
                switch(rank[i])
                {
                    case 0: g1.setColor(Color.red);
                            str+=" RED";
                            x=250;//y=240;
                            break;
                    case 1: g1.setColor(Color.yellow);
                            str+=" YELLOW";
                            x=250;//y=280;
                            break;
                    case 2: g1.setColor(Color.GREEN);
                            str+="  GREEN";
                            x=250;//y=320;
                            break;
                    case 3: g1.setColor(Color.blue);
                            str+="  BLUE";
                            x=250;//y=360;
                            break;
                }
                g.drawString(str, x, y);
                y+=40;
            }
        }
    } 
    public void setPosition(int val)
    {
        f = new Font("Dialog", Font.BOLD,40);
        Polygon p=new Polygon();
        for(int i=0;i<4;i++)
        {
            g1.setColor(Color.BLACK);
             switch(dice)
            {
                case 1:   g1.fillOval(696, 370, 8, 8);
                            g1.fillOval(705, 402, 8, 8);
                            g1.fillOval(723, 410, 8, 8);
                            g1.fillOval(739, 416, 8, 8);
                            g1.fillOval(655, 416, 8, 8);
                            g1.fillOval(655, 390, 8, 8);
                            g1.fillOval(685, 405, 8, 8);
                            g1.fillOval(683, 430, 8, 8);
                            break;
                case 2:  
                            g1.fillOval(696, 360, 8, 8);
                            g1.fillOval(696, 380, 8, 8);
                            g1.fillOval(723, 410, 8, 8);
                            g1.fillOval(655, 416, 8, 8);
                            g1.fillOval(655, 390, 8, 8);
                            g1.fillOval(685, 405, 8, 8);
                            g1.fillOval(683, 430, 8, 8);
                            g1.fillOval(669, 410, 8, 8);
                            break;
                case 3:   /*g1.fillOval(710, 362, 8, 8);
                            g1.fillOval(693, 370, 8, 8);
                            g1.fillOval(676, 378, 8, 8);*/                            
                            g1.fillOval(696, 358, 8, 8);
                            g1.fillOval(696, 370, 8, 8);
                            g1.fillOval(696, 382, 8, 8);                                                      
                            g1.fillOval(723, 408, 8, 8);
                            g1.fillOval(655, 390, 8, 8);
                            g1.fillOval(680, 428, 8, 8);
                            break;
                case 4:   g1.fillOval(696, 382, 8, 8);
                            g1.fillOval(696, 358, 8, 8);
                            g1.fillOval(718, 370, 8, 8);
                            g1.fillOval(674, 370, 8, 8);
                            g1.fillOval(723, 410, 8, 8);                            
                            g1.fillOval(655, 416, 8, 8);
                            g1.fillOval(670, 410, 8, 8);
                            g1.fillOval(685, 405, 8, 8);
                            break;
                case 5:   g1.fillOval(696, 370, 8, 8);
                            g1.fillOval(696, 385, 8, 8);
                            g1.fillOval(696, 355, 8, 8);
                            g1.fillOval(721, 370, 8, 8);
                            g1.fillOval(671, 370, 8, 8);
                            g1.fillOval(723, 410, 8, 8);                            
                            g1.fillOval(655, 416, 8, 8);
                            g1.fillOval(655, 390, 8, 8);
                            g1.fillOval(685, 405, 8, 8);
                            g1.fillOval(683, 430, 8, 8);
                            break;
                case 6:   g1.fillOval(699, 358, 8, 8);
                            g1.fillOval(682, 366, 8, 8);
                            g1.fillOval(665, 374, 8, 8);
                            g1.fillOval(725, 367, 8, 8);
                            g1.fillOval(709, 377, 8, 8);
                            g1.fillOval(691, 385, 8, 8);
                            g1.fillOval(705, 402, 8, 8);
                            g1.fillOval(723, 410, 8, 8);
                            g1.fillOval(739, 416, 8, 8);
                            g1.fillOval(655, 413, 8, 8);
                            g1.fillOval(680, 402, 8, 8);
                            break;
            }
            g1.setColor(Color.BLACK);
            if(select<0)
            {
                for(int j=0;j<4;j++)
                {
                        g1.fillOval(ch[i].create[j].x-2,ch[i].create[j].y-2,25,25);
                }
            }
            else
            {
                for(int j=0;j<4;j++)
                {
                    try{
                        g1.fillOval(ch[select].create[j].x-2,ch[select].create[j].y-2,25,25);
                    }
                    catch(Exception e)
                    {                        
                    }
                }
            }
            switch(ch[i].color)
            {
                case 0: g1.setColor(Color.red);
                        break;
                case 1: g1.setColor(Color.yellow);
                        break;
                case 2: g1.setColor(Color.GREEN);
                        break;
                case 3: g1.setColor(Color.blue);
                        break;
            }
            if(select<0)
            for(int j=0;j<4;j++)
            {
                  //  System.out.println("\nx:="+ch[i].create[j].x+"y"+ch[i].create[j].y);
                    g1.fillOval(ch[i].create[j].x,ch[i].create[j].y,20,20);
            }
            else 
            {                
            switch(select)
            {
                case 0: g1.setColor(Color.red);
                        break;
                case 1: g1.setColor(Color.yellow);
                        break;
                case 2: g1.setColor(Color.GREEN);
                        break;
                case 3: g1.setColor(Color.blue);
                        break;
            }
            for(int j=0;j<4;j++)
            {
                try{
                    g1.fillOval(ch[select].create[j].x,ch[select].create[j].y,20,20);
                }
                catch(Exception e)
                {
                    
                }
            }  
            }           
        }
    }
    public void refresh(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.DARK_GRAY);
        g.setColor(Color.black);
        g.fill3DRect(25,25,609,509,false);
        g.fill3DRect(45,45,600,500,false);
        g.setColor(Color.WHITE);
        g.fill3DRect(30,30,600,500,false);
        g.setColor(Color.black);
        g.draw3DRect(30,230,598,100, true);
        g.draw3DRect(275,30,100,498, true);
        g.fill3DRect(30,30,245,200,false);
        g.fill3DRect(376,30,254,200,false);
        g.fill3DRect(376,330,253,200,false);
        g.fill3DRect(30,330,245,200,false);
        
        g.setColor(Color.RED);
        g.fill3DRect(30,30,242,197,false);
        g.fill3DRect(70,263,205,35,false);
        g.fill3DRect(70,230,41,33,false);
        int[] x={276,325, 276};
        int[] y={230,280,330};
        g.fillPolygon(x,y,3);
        
        g.setColor(Color.yellow);
        g.fill3DRect(379,30,251,197,false);
        g.fill3DRect(310,65,35,165,false);     
        g.fill3DRect(345,65,31,33,false); 
        int[] xY={275,325, 375};
        int[] yY={231,280,231};
        g.setColor(Color.ORANGE);
        g.fillPolygon(xY,yY,3);
        
        g.setColor(Color.GREEN);
        g.fill3DRect(379,333,251,197,false);
        g.fill3DRect(376,263,205,35,false);
        g.fill3DRect(540,298,41,33,false);
        int[] xG={375,326, 375};
        int[] yG={230,280,330};
        g.fillPolygon(xG,yG,3);
        
        g.setColor(Color.BLUE);
        g.fill3DRect(30,333,242,197,false);
        g.fill3DRect(310,330,35,165, false);   
        g.fill3DRect(275,463,35,33, false);  
        int[] xB={275,325, 375};
        int[] yB={330,280,330};
        g.fillPolygon(xB,yB,3);
        
        g.setColor(Color.BLACK);
        
        g.fill3DRect(50,50,200,155,false);
        g.fill3DRect(399,353,205,155,false);
        g.fill3DRect(50,353,200,155,false);
        g.fill3DRect(399,50,205,155,false);
        
        g.drawLine(275,230,375,330);
        g.drawLine(275,330,375,230);
        
        g.drawLine(275,64,375,64);
        g.drawLine(275,97,375,97);
        g.drawLine(275,130,375,130);
        g.drawLine(275,163,375,163);
        g.drawLine(275,196,375,196);
        g.drawLine(310,30,310,65);
        g.drawLine(343,30,343,65);
        
        g.drawLine(275,495,375,495);
        g.drawLine(275,462,375,462);
        g.drawLine(275,429,375,429);
        g.drawLine(275,396,375,396);
        g.drawLine(275,363,375,363);
        g.drawLine(309,495,309,530);
        g.drawLine(344,495,344,530);
        
        g.drawLine(69,230,69,330);
        g.drawLine(110,230,110,330);
        g.drawLine(151,230,151,330);
        g.drawLine(192,230,192,330);
        g.drawLine(233,230,233,330);
        g.drawLine(30,263,70,263);
        g.drawLine(30,297,70,297);
        
        g.drawLine(580,230,580,330);
        g.drawLine(539,230,539,330);
        g.drawLine(498,230,498,330);
        g.drawLine(457,230,457,330);
        g.drawLine(416,230,416,330);
        g.drawLine(581,264,628,264);
        g.drawLine(581,297,628,297);
        
        g.setColor(Color.RED);
        g.fill3DRect(65,65,170,125,false);
        g.setColor(Color.YELLOW);
        g.fill3DRect(414,65,175,125,false);
        g.setColor(Color.GREEN);
        g.fill3DRect(414,368,175,125,false);
        g.setColor(Color.BLUE);
        g.fill3DRect(65,368,170,125,false);
        g.setColor(Color.BLACK);
        g.fillOval(103,85, 35, 35);
        g.fillOval(163,85, 35, 35);
        g.fillOval(103,138,35,35);
        g.fillOval(163,138,35,35);
        
        g.fillOval(455,85,35,35);
        g.fillOval(515,85,35,35);
        g.fillOval(455,138,35,35);
        g.fillOval(515,138,35,35);
        
        g.fillOval(455,385,35,35);
        g.fillOval(515,385,35,35);
        g.fillOval(455,440,35,35);
        g.fillOval(515,440,35,35);
        
        g.fillOval(103,385,35,35);
        g.fillOval(163,385,35,35);
        g.fillOval(103,440,35,35);
        g.fillOval(163,440,35,35);
        
        int[] xD=new int[4];
        int[] yD=new int[4];
         g.setColor(Color.WHITE);
        xD[0]=650;yD[0]=375;
        xD[1]=700;yD[1]=350;
        xD[2]=750;yD[2]=375;
        xD[3]=700;yD[3]=400;
        g.fillPolygon(xD,yD,4);
        
         g.setColor(Color.GRAY);
        xD[0]=650;yD[0]=375;
        xD[1]=650;yD[1]=425;
        xD[2]=700;yD[2]=450;
        xD[3]=700;yD[3]=400;
        g.fillPolygon(xD,yD,4);
        
        g.setColor(Color.LIGHT_GRAY);
        xD[0]=700;yD[0]=400;
        xD[1]=700;yD[1]=450;
        xD[2]=750;yD[2]=425;
        xD[3]=750;yD[3]=375;
        g.fillPolygon(xD,yD,4);
        
       // g.fillOval(80,235,20,20);
        
    }
}
