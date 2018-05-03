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
public class NodoM extends Nodo{
    
    private NodoM   rlink,
                    llink;
    
    private SubNodo jsSublist=new SubNodo();
    
    private SubNodo cssSublist=new SubNodo();

    public NodoM() {
    }
    
    public NodoM(Object infor)
    {
        super(infor);
    }
    
    
    @Override
    public String toString()
    {
        String value="";
        NodoM p=this;
        
        while(p!=null)
        {
            value= value + p.getInfor() + ", " ;
            p=p.getRlink();
        }
        return value;
    }
   
    public NodoM getUlt()
    {
        return recursiveUlt(this);
    }
   
    private NodoM recursiveUlt(NodoM actual)
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
    
//GETTERS AND SETTERS___________________________________________________________

    public NodoM getRlink() {
        return rlink;
    }

    public void setRlink(NodoM rlink) {
        this.rlink = rlink;
    }

    public NodoM getLlink() {
        return llink;
    }

    public void setLlink(NodoM llink) {
        this.llink = llink;
    }

    public SubNodo getJsSublist() {
        return jsSublist;
    }

    public void setJsSublist(SubNodo jsSublist) {
        this.jsSublist = jsSublist;
    }

    public SubNodo getCssSublist() {
        return cssSublist;
    }

    public void setCssSublist(SubNodo cssSublist) {
        this.cssSublist = cssSublist;
    }

//ADD___________________________________________________________________________
    
    @Override
    public void add(Object infor)
    {
        add(new NodoM(infor));
    }
    
    public void add(NodoM nuevo)
    {
        recursiveAdd(this,nuevo);
    }
    
    private void recursiveAdd(NodoM actual, NodoM nuevo)
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
    
 //PRINT________________________________________________________________________
    
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
    private void recursivePrint(NodoM actual, boolean orientacion)
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
   
//DELETE________________________________________________________________________

//    public void deleteInLocations(int... location)
//    {
//        for (int i : location) 
//        {    
//            delete(i);
//        }
//    }
//    
//    public void delete(int location)
//    {
//        NodoM p=this;
//        for (int i = 0; i < location; i++) 
//        {
//            p=p.getRlink();
//        }
//        delete(p);
//    }
//    
    
   
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
        NodoM p = this,r;
        
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
    private void delete(NodoM ptr)
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
    
//GET ONE ELEMENT_______________________________________________________________

    
    @Override
    public Object getComponentAt(int location)
    {
        return recursiveGet(this,location).getInfor();
    }
    
    /**
     * get the list of js events directly from a component of the multilist
     * @param location
     * @return 
     */
    public SubNodo getJsListAt(int location)
    {
        return recursiveGet(this,location).getJsSublist();
    }
    
    /**
     * get the list of css instructions directly from a component of the multilist
     * @param location
     * @return 
     */
    public SubNodo getCssListAt(int location)
    {
        return recursiveGet(this,location).getCssSublist();
    }
    
    /**
     * returns the node in the concrete location
     * @param location
     * @return 
     */
    public NodoM getAt(int location)
    {
        return recursiveGet(this,location);
    }
    
    /**
     * recursive function to get an concrete node
     * @param actual
     * @param location
     * @return 
     */
    private NodoM recursiveGet(NodoM actual,int location)
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



    
}
