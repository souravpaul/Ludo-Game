/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesetup;

/**
 *
 * @author sourav
 */
public class autoPlay {
    int priority=0;
    colorHome[] cHome;
    createPath cPath;
    int dice=0;
    public int getPriority(colorHome[] ch,createPath cp,int d )
    {
        priority=0;
        cHome=ch;
        cPath=cp;
        dice=d;
        EatAbilityTest();
        if(cPath.pos<51 && cPath.pos%13!=0) 
            defensiveTest();
        startAbilityTest();
        endAbilityTest();
        freeAbilityTest();
        return priority;
    }
    public void EatAbilityTest()
    {
        int max=0,prot=4,position=0;
        for(int i=0;i<4;i++)
        {
            if(cHome[i].color!=cPath.color) 
            {
                position=length(cHome[i],cPath.pos+dice);
                for(int j=0;j<4;j++)
                {
                    if(cHome[i].create[j].pos==position)
                    {
                        if(cHome[i].create[j].pos>max)
                        {
                            priority+=prot+cHome[i].create[j].pos%13;
                            max=cHome[i].create[j].pos;
                        }
                    }
                }                
            }
        }
    }
    public void defensiveTest()
    {
        int max=0,prot=1,position;
        if(cPath.pos==0 || cPath.pos>=51)
            return;
        for(int i=0;i<4;i++)
        {
            if(cHome[i].color!=cPath.color)
            {    
                position=length(cHome[i],cPath.pos);
                for(int j=0;j<4;j++)
                {
                    if(cHome[i].create[j].pos>=position-6 && cHome[i].create[j].pos<position)
                    {
                        priority+=prot;//cPath.pos-cHome[i].create[j].pos;
                    }
                }                
            }
        }        
    }
    public void startAbilityTest()
    {
        if(cPath.pos==-1)
            priority+=3;
    }
    public void endAbilityTest()
    {
        if(cPath.pos>39)
            priority+=2;
    }
    public void freeAbilityTest()
    {
        priority++;
    }
     private int length(colorHome obj,int pos)
    {
        if(pos>=51 || pos<0)
            return 0;
        int len=0,val=cPath.color-obj.color;
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
}
