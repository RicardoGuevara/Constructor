/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author Bloque G
 */
public class SubNodo extends Nodo{

    private SubNodo rlink,
                    llink;
    
    public SubNodo() {
    }
    
    public SubNodo(Object infor)
    {
        super(infor);
    }
    
    @Override
    public String toString()
    {
        String value="";
        SubNodo p=this;
        
        while(p!=null)
        {
            value= value + p.getInfor() + ", " ;
            p=p.getRlink();
        }
        return value;
    }
    
    public SubNodo getUlt()
    {
        return recursiveUlt(this);
    }
   
    private SubNodo recursiveUlt(SubNodo actual)
    {
        if(actual.getRlink()!=null)
        {
            return recursiveUlt(actual.getRlink());
        }
        else
        {
            return actual;
        }
    }
    
//GETTERS Y SETTERS_____________________________________________________________

    public SubNodo getRlink() {
        return rlink;
    }

    public void setRlink(SubNodo rlink) {
        this.rlink = rlink;
    }

    public SubNodo getLlink() {
        return llink;
    }

    public void setLlink(SubNodo llink) {
        this.llink = llink;
    }
    
//GET ONE CONCRETE ELEMENT______________________________________________________
    
    @Override
    public Object getComponentAt(int location) 
    {
        return recursiveGet(this,location).getInfor();
    }
    
    /**
     * returns the node in the concrete location
     * @param location
     * @return 
     */
    public SubNodo getAt(int location)
    {
        return recursiveGet(this,location);
    }
    
    /**
     * recursive function to get an concrete node
     * @param actual
     * @param location
     * @return 
     */
    private SubNodo recursiveGet(SubNodo actual,int location)
    {
        if (location==0) 
        {
            return actual;
        }
        else
        {
            //IMPORTANTE: no cambiar el "-1" por "--" , crashea epica y estrepitosamente
            return recursiveGet(actual.getRlink(),location-1);
        }
    }

//ADD A NEW ELEMENT_____________________________________________________________
    
    @Override
    public void add(Object infor) 
    {
        add(new SubNodo(infor));
    }
    
    /**
     * add a new node
     * @param nuevo 
     */
    public void add(SubNodo nuevo)
    {
        recursiveAdd(this,nuevo);
    }
    
    /**
     * recursive function to add a new node
     * @param actual
     * @param nuevo 
     */
    private void recursiveAdd(SubNodo actual, SubNodo nuevo)
    {
        if(actual.getRlink()==null)
        {
            actual.setRlink(nuevo);
            nuevo.setLlink(actual);
        }
        else
        {
            recursiveAdd(actual.getRlink(),nuevo);
        }
    }

//DELETE A VALUE FROM THE LIST__________________________________________________
    
    @Override
    public void delete(Object... values) 
    {
        for (Object value : values) 
        {
            delete(value);
        }
    }

    @Override
    public void delete(Object value) 
    {
        SubNodo p = this,r;
        
        while(p!=null)
        {
            if (p.getInfor().equals(value)) 
            {
                r=p.getRlink();
                p.delete(this);
                p=r;
            }
            else
            {
                p=p.getRlink();
            }
        }
    }
    
    /**
     * delete one node
     * @param ptr _ ptr of the original list
     */
    private void delete(SubNodo ptr)
    {
        if(this.getLlink()==null)
        {
            ptr=this.getRlink();
            ptr.setLlink(null);
        }
        else if(this.getRlink()==null)
        {
            this.getLlink().setRlink(null);
            this.setLlink(null);
        }
        else
        {
            this.getLlink().setRlink(this.getRlink());
            this.getRlink().setLlink(this.getLlink());
            this.setLlink(null);
            this.setRlink(null);
        }
    }

//PRINT A LIST__________________________________________________________________
    
    @Override
    public void print()
    {
        recursivePrint(this,true);
    }
    
    @Override
    public void reversePrint()
    {
        recursivePrint(getUlt(),false);
    }
    
    /**
     * recursive function to print a list
     * @param actual
     * @param orientacion 
     */
    private void recursivePrint(SubNodo actual, boolean orientacion)
    {
        
        if(actual!=null)
        {
            System.out.println(actual.getInfor());
            
            if(orientacion)
            {
                recursivePrint(actual.getRlink(),true);
            }
            else
            {
                recursivePrint(actual.getLlink(),false);
            }
        }
    }
    
    
    
}
