/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlConstruction;

/**
 *
 * @author Estudiante
 */
public class JsEvent {
    
    public String getAction()
    {
        return getIdIn()+".addEventListener('"+getEventType()+"',"+getFunctionName()+");";
    }
    
    public String getEventType()
    {
        String retorno;
        
        switch(evento)
        {
            case CLICK:
                retorno="click";
                break;
            case KP:
                retorno="keydown";
                break;
            case KR:
                retorno="keyup";
                break;
            default:
                retorno="";
                break;
        }
        return retorno;
    }
    
    public String getFunctionName()
    {
        String retorno;
        
        switch(funcion)
        {
            case ERRORALERT:
                retorno="sayError";
                break;
            case WELCOMEALERT:
                retorno="sayHello";
                break;
            default:
                retorno="";
                break;
        }
        return retorno;
    }
    
    public String getIdIn()
    {
        return in.getElementId();
    }
    
    public String getIdOut()
    {
        return out.getElementId();
    }
    
    FunctionType funcion;
    EventType evento;
    
    private HtmlComponent   in,  // elemento al que se agregara el eventListener
                            out; // elemento alterable

    public JsEvent(FunctionType funcion, EventType evento, HtmlComponent in, HtmlComponent out) {
        this.funcion = funcion;
        this.evento = evento;
        this.in = in;
        this.out = out;
    }

    public FunctionType getFuncion() {
        return funcion;
    }

    public EventType getEvento() {
        return evento;
    }

    
    
    
    
    
}
