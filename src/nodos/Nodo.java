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
public abstract class Nodo {

    public Nodo() {
    }
    public Nodo(Object infor)
    {
        this.setInfor(infor);
    }

//______________________________________________________________________________
    
    public Object getInfor() {
        return infor;
    }

    public void setInfor(Object infor) {
        this.infor = infor;
    }

    //___________________________________________________________
    
    @Override
    public String toString()
    {
        return this.getInfor().toString();
    }
    
    @Override
    public boolean equals(Object anObject)
    {
        if(this == anObject)
        {return true;}
        else
        {
            if(anObject instanceof Nodo)
            {
                if (this.getInfor().equals(((Nodo)anObject).getInfor())) 
                {
                    return true;
                }
            }
        }    
        return false;
    }
    
    //___________________________________________________________
    
    /**
     * returns the info from one concrete node
     * @param location
     * @return 
     */
    public abstract Object  getComponentAt  (int location);
    
    /**
     * add a new element to the list
     * @param info 
     */
    public abstract void    add             (Object info);
    
    /**
     * delete a group of values from the list
     * @param values 
     */
    public abstract void    delete          (Object... values);
    
    /**
     * delete one concrete value from the list
     * @param value 
     */
    public abstract void    delete          (Object value);
    
    /**
     * print a list
     */
    public abstract void    print           (/*NO ARGUMENTS*/);
    
    /**
     * print a list in inverse form
     */
    public abstract void    reversePrint    (/*NO ARGUMENTS*/);
    
    
//______________________________________________________________________________    
    
    protected Object infor=new Object();

    
    
}
