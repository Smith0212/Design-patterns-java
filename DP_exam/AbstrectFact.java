interface IButton{
    public void press();
}

class winButton implements IButton{
    public void press(){
        System.out.println("Windows Button Pressed");
    }
} 

class macButton implements IButton{
    public void press(){
        System.out.println("Mac Button Pressed");
    }
}

interface ITaxbox{
    public void fill();
}

class winTaxbox implements ITaxbox{
    public void fill(){
        System.out.println("Fill Windows Taxbox");
    }
} 

class macTaxbox implements ITaxbox{
    public void fill(){
        System.out.println("Fill Mac Taxbox");
    }
}

interface IFactory{
    public IButton createButton();
    public ITaxbox createTaxbox();
}

class winFactory implements IFactory{
    public IButton createButton(){
        return new winButton();
    }
    public ITaxbox createTaxbox(){
        return new winTaxbox();
    }
}

class macFactory implements IFactory{
    public IButton createButton(){
        return new macButton();
    }
    public ITaxbox createTaxbox(){
        return new macTaxbox();
    }
}

class abstrectGUI{
    public static IFactory createFactory(String str){
        switch (str){
            case "window":
            return new winFactory();
            
            case "mac":
            return new macFactory();
        }
        return null;   
    }
}

public class AbstrectFact{
    public static void main(String []args){
        IFactory fact = abstrectGUI.createFactory("mac");
        IButton btn = fact.createButton();
        btn.press();
        ITaxbox tax = fact.createTaxbox();
        tax.fill();
    }
}