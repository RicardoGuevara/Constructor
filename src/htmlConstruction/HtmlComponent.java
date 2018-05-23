/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlConstruction;
import static htmlConstruction.ComponentSubType.*;

/**
 *
 * @author RICARDO
 */
public class HtmlComponent {
    
    @Override
    public String toString()
    {
        return this.elementId + " // " + this.initialValue;
    }
    
    @Override
    public boolean equals(Object anObject)
    {
        if(this==anObject)
        {return true;}
        
        if(anObject instanceof HtmlComponent)
        {
            if(this.elementId.equals(((HtmlComponent)anObject).elementId))
            {return true;}
        }
        
        return false;
    }
    
//______________________________________________________________________________    
    
    public String getElementComand()
    {
        String retorno;
        
        switch(this.type)
        {
            case PARAGRAPH:
                retorno= ("        <p class="+"\""+this.clas+"\" >"+this.initialValue+"</p>");
                break;
            case CANVAS:
                retorno= ("        <canvas "+" width=\""+this.width+"\" height=\""+this.heigth+"\" id='"+this.elementId+" class="+"\""+this.clas+"\""+"' />");
                break;
            case IMG:
                retorno = ("<img src=\""+this.initialValue+"\" width=\""+this.width+"\" height=\""+this.heigth+" class="+"\""+this.clas+"\""+"\" />");
                break;
            case LINEBREAK:
                retorno = ("<br>");
                break;
            default:    
                retorno=    "           <input type="+obtainType()+
                            " value='"+this.initialValue+
                            "' id='"+this.elementId+
                            "' width=\""+this.width+
                            "\" height=\""+this.heigth+
                            "\""+" class="+"\""+this.clas+"\""+" / >";
                break;
        }

        return retorno;
    }
    
    private String obtainType() 
    {
        String retorno;

        switch(this.type)
        {
            case TEXTBOX:
                retorno= "'text'";
                break;
            case BUTTON:
                retorno= "'button'";
                break;
            case LABEL:
                retorno= "'label'";
                break;   
            default:
                retorno= "another component";
                break;
        }
        
        return retorno;
    }
    
//______________________________________________________________________________    
    
    public static int idComplement;
    
    private ComponenType        component;
    private ComponentSubType    type;
    private String              initialValue,clas,
                                elementId;
    private int                 width=70,
                                heigth=20,
                                labelNum;

    public HtmlComponent(ComponenType component, ComponentSubType type, String initialValue, String clas) {
        this.component = component;
        this.type = type;
        this.initialValue=initialValue;
        this.elementId = "component"+String.valueOf(idComplement);
        this.labelNum=idComplement;
        this.clas=clas;
        HtmlComponent.idComplement++;
    }
    
    public HtmlComponent(ComponenType component, ComponentSubType type, String initialValue, int width, int higth ,String clas) {
        this.component = component;
        this.type = type;
        this.initialValue=initialValue;
        this.heigth=higth;
        this.width =width;
        this.elementId = "component"+String.valueOf(idComplement);
        this.labelNum=idComplement;
        this.clas=clas;
        HtmlComponent.idComplement++;
    }
 
    public HtmlComponent(ComponenType component, ComponentSubType type, String initialValue) {
        this.component = component;
        this.type = type;
        this.initialValue=initialValue;
        this.elementId = "component"+String.valueOf(idComplement);
        this.labelNum=idComplement;
        
        HtmlComponent.idComplement++;
    }
    
    public HtmlComponent(ComponenType component, ComponentSubType type, String initialValue, int width, int higth) {
        this.component = component;
        this.type = type;
        this.initialValue=initialValue;
        this.heigth=higth;
        this.width =width;
        this.elementId = "component"+String.valueOf(idComplement);
        this.labelNum=idComplement;
        
        HtmlComponent.idComplement++;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }
    
    
    
    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }

    public void setWidth(int wdth) {
        this.width = wdth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public static int getIdComplement() {
        return idComplement;
    }

    public static void setIdComplement(int idComplement) {
        HtmlComponent.idComplement = idComplement;
    }

    public ComponenType getComponent() {
        return component;
    }

    public void setComponent(ComponenType component) {
        this.component = component;
    }

    public ComponentSubType getType() {
        return type;
    }

    public void setType(ComponentSubType type) {
        this.type = type;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public int getLabelNum() {
        return labelNum;
    }

    public void setLabelNum(int labelNum) {
        this.labelNum = labelNum;
    }

    public String getInitialValue() {
        return initialValue;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    
    
}
