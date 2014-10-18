/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesetup;

/**
 *
 * @author sourav
 */
public class createPath {
    int pos=-1,x=105,y=90,color,id;
    public createPath(int c,int unq)
    {
        color=c;
        id=unq;
        coordinates(pos);
    }
    public void create(int color)
    {
        pos=0;
        coordinates(pos);
    }
    public boolean isUseable(int dice,createPath[] cp)
    {
        if(((pos+dice)<57 && pos>=0) ||(pos==-1 && dice==6))
        {
            for(int i=0;i<4;i++)
                if(cp[i]!=this)// && pos>0)
                {
                    if(cp[i].pos==pos+dice && pos>=0)
                    {
                        return false;
                    }
                    else if(cp[i].pos==0 && pos==-1 && dice==6)
                    {
                        return false;
                    }
                    //System.out.println("\npos=="+cp[i].pos+"=="+pos);
                }
            return true;
        }
        else
            return false;
    }
    public int useIt(int dice,int len)
    {
        int flag=0;
        if(dice>0)
            pos+=dice;
        if(check(len) && pos>0 && pos<51 && pos%13!=0)
        {
            System.out.println("\nEAT"+pos);
            pos=-1; 
            flag=1;
        }  
        coordinates(pos);
        return flag;
    }
    public boolean check(int length)
    {
        if(pos==length)
            return true;
        else
            return false;
    }
    public void coordinates(int position)
    {
        int val=color-0,len=0;
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
        if(position<51 && position>=0)
            position=(len+position)%52;
        else if(position==51)
            position=57;
        switch(position)
        {
            case -1:    
                        switch(color)
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
                        switch(id)
                        {
                            case 1: x+=60;
                                    break;
                            case 2: y+=54;
                                    break;
                            case 3: x+=60;y+=54;
                                    break;
                        }
                        break;
            case 0:     x=80;y=235;
                        break;
            case 1:     x=120;y=235;
                        break;
            case 2:     x=160;y=235;
                        break;
            case 3:     x=200;y=235;
                        break;
            case 4:     x=242;y=235;
                        break;
            case 5:     x=285;y=203;
                        break;
            case 6:     x=285;y=170;
                        break;
            case 7:     x=285;y=135;
                        break;
            case 8:     x=285;y=103;
                        break;    
            case 9:     x=285;y=72;
                        break;    
            case 10:    x=285;y=38;
                        break;    
            case 11:    x=317;y=38;
                        break;
            case 12:    x=350;y=38;
                        break;
            case 13:    x=350;y=70;
                        break;
            case 14:    x=350;y=102;
                        break;
            case 15:    x=350;y=138;
                        break;    
            case 16:    x=350;y=171;
                        break;
            case 17:    x=350;y=202;
                        break;
            case 18:    x=385;y=238;
                        break;
            case 19:    x=425;y=238;
                        break;
            case 20:    x=465;y=238;
                        break;
            case 21:    x=508;y=238;
                        break;
            case 22:    x=550;y=238;
                        break;
            case 23:    x=593;y=238;
                        break;
            case 24:    x=593;y=270;
                        break;
            case 25:    x=593;y=302;
                        break;    
            case 26:    x=550;y=302;
                        break;
            case 27:    x=510;y=302;
                        break;
            case 28:    x=468;y=302;
                        break;
            case 29:    x=425;y=302;
                        break;    
            case 30:    x=383;y=302;
                        break;    
            case 31:    x=350;y=335;
                        break;
            case 32:    x=350;y=370;
                        break;
            case 33:    x=350;y=405;
                        break;
            case 34:    x=350;y=437;
                        break;
            case 35:    x=350;y=470;
                        break;
            case 36:    x=350;y=502;
                        break;
            case 37:    x=315;y=502;
                        break;
            case 38:    x=281;y=502;
                        break;
            case 39:    x=281;y=470;
                        break;
            case 40:    x=281;y=435;
                        break;
            case 41:    x=281;y=402;
                        break;
            case 42:    x=281;y=370;
                        break;
            case 43:    x=281;y=335;
                        break;
            case 44:    x=245;y=303;    
                        break;
            case 45:    x=205;y=303;
                        break;
            case 46:    x=162;y=303;
                        break;
            case 47:    x=120;y=303;
                        break;
            case 48:    x=80;y=303;
                        break;
            case 49:    x=40;y=303;
                        break;
            case 50:    x=40;y=270;
                        break;
            case 51:    x=40;y=235;
                        break;
            case 52:    switch(color)
                        {
                            case 0:     x=120;y=270;
                                        break;
                            case 1:     x=317;y=105;
                                        break;
                            case 2:     x=510;y=270;
                                        break;
                            case 3:     x=315;y=435;
                                        break;
                        }
                        break;
            case 53:    switch(color)
                        {
                            case 0:     x=160;y=270;
                                        break;
                            case 1:     x=317;y=138;
                                        break;
                            case 2:     x=470;y=270;
                                        break;
                            case 3:     x=315;y=400;
                                        break;
                        }
                        break;
            case 54:    switch(color)
                        {
                            case 0:     x=200;y=270;
                                        break;
                            case 1:     x=317;y=170;
                                        break;
                            case 2:     x=430;y=270;
                                        break;
                            case 3:     x=315;y=370;
                                        break;
                        }
                        break;
            case 55:    switch(color)
                        {
                            case 0:     x=240;y=270;
                                        break;
                            case 1:     x=317;y=202;
                                        break;
                            case 2:     x=390;y=270;
                                        break;
                            case 3:     x=315;y=335;
                                        break;
                        }
                        break;
            case 56:    switch(color)
                        {
                            case 0:     x=280;y=270;
                                        break;
                            case 1:     x=317;y=235;
                                        break;
                            case 2:     x=350;y=270;
                                        break;
                            case 3:     x=315;y=300;
                                        break;
                        }
                        pos=-2;
                        break;
            case 57:    switch(color)
                        {
                            case 0:     x=80;y=270;
                                        break;
                            case 1:     x=317;y=70;
                                        break;
                            case 2:     x=550;y=270;
                                        break;
                            case 3:     x=315;y=470;
                                        break;
                        }
                        break; 
            default:   // System.out.println("\nERROR"+position);
                        break;
        }
    }
}
