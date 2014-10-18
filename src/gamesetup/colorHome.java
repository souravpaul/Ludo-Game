/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesetup;

/**
 *
 * @author sourav
 */
import java.util.Random;
import java.util.Scanner;
public class colorHome {
    int numbers;
    int color,count,allert=0;
    Scanner scan=new Scanner(System.in);
    createPath[] create=new createPath[4];
    autoPlay aPlay=new autoPlay();
    public colorHome(int c)
    {
        numbers=0;
        allert=0;
        color=c;
        count=4;
        int x=0,y=0;
        switch(c)
        {
            case 0: x=110;y=93;
                    break;
            case 1: x=463;y=93;
                    break;
            case 2: x=463;y=393;
                    break;
            case 3: x=110;y=393;
                    break;
        }
        for(int i=0;i<4;i++)
            create[i]=new createPath(c,i);
    }
    public boolean addOne(createPath cp)
    {
        if(cp.pos>=0)
            return false;
        cp.create(color);        
        System.out.println("coin"+numbers+"   created");
        numbers++;
        return true;
    }
    public int throwDice(colorHome[] obj,int dice,boolean condtn)
    {
       int flag=0,priority=0;
       allert=0;
       createPath cp=null;
       for(int i=0;i<4;i++)
       {
           if(create[i].isUseable(dice,create))
           {
             //  System.out.println("\nYOU CAN USE A COIN-"+i+"--pos"+create[i].pos);
               if(!condtn)
               {
                   int x=aPlay.getPriority(obj,create[i],dice);
                   if(x>priority)
                   {
                        priority=x;
                        cp=create[i];
                   }
               }
               flag++;
           }
       }
       if(!condtn && cp!=null)
           addIt(cp,obj,dice);
      // System.out.println("\nFLAG====="+flag);
           return flag;
    }
    public boolean addIt(createPath recent,colorHome[]obj,int dice)
    {
        allert=0;
        if(recent==null)
            return false;
        if(recent.pos==-1 && dice==6)
            addOne(recent);
        else
        {
           recent.useIt(dice,0);
           for(int i=0;i<4;i++)
            {
                for(int j=0;j<4;j++)
                {
                    if(obj[i].color!=color)
                    {
                        int x=obj[i].create[j].useIt(0,length(obj[i],recent.pos));
                        if(x==1)
                        {
                            obj[i].numbers--;
                            allert=1;
                        }
                    }
                }
            }
        }  
        if(recent.pos==57 || recent.pos==-2)
        {
            recent.pos=-2;
            count--;
            allert=count;
        }
        return true;
       // System.out.println("\nnaw its pos: "+recent.pos);
    }
    public int getCount()
    {
        return count;
    }
    private int length(colorHome obj,int pos)
    {
        if(pos>=51 || pos<0)
            return 0;
        int len=0,val=this.color-obj.color;
        val*=13;
        while(val!=0)
        {
            if(val<0)
            {
                val++;
                len--;
            }
            else
            {
                val--;
                len++;
            }
            if(len==-1)
                len=51;
            if(len==52)
                len=0;
        }
        return (len+pos)%52;
            
    }
    public createPath isTrue(int x,int y,int dice)
    {
     //   System.out.println("\nx"+x+"y:"+y);
        for(int i=0;i<4;i++)
        {
           //System.out.print("\nx->"+create[i].x+"y->:"+create[i].y);
            if((create[i].x+20>=x && create[i].x<=x)&& (create[i].y+20>y && create[i].y<=y))
            {
               // System.out.println("---ok");
                if(create[i].isUseable(dice,create))
                {
                    if(create[i].pos==-1 && dice !=6)
                        return null;
                        return create[i];
                }
            }
        }
        return null;
    }
    public static void main(String args[])
    {        
        colorHome[] ch=new colorHome[4];
        for(int i=0;i<4;i++)
            ch[i]=new colorHome(i);
        while(true)
        {
            if(ch[0].scan.nextInt()==0)
                break;
            //ch[0].throwDice(ch);
             System.out.println("color--"+ch[0].color);
        }
        //System.out.println(ch[0].create[0].coordinates(52,2));
    }
}
