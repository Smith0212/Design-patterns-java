interface vagFruit{
    void buyVagFruit();
}
class vagitable implements vagFruit{
    public void buyVagFruit(){
        System.out.println("Buying vagitable...");
    }
}
class Fruit implements vagFruit{
    public void buyVagFruit(){
        System.out.println("Buying Fruit...");
    }
}

interface GrainBeans{
    void buyGrainBeans();
}
class Beans implements GrainBeans{
    public void buyGrainBeans(){
        System.out.println("Buying Beans...");
    }
}
class Orphan implements GrainBeans{
    public void buyGrainBeans(){
        System.out.println("Buying Orphan...");
    }
}

interface IFactory{
    vagFruit createVag();
    vagFruit createFruit();
    GrainBeans createBeans();
    GrainBeans createOrphan();
}

class VagFruitFactory implements IFactory{
    public vagFruit createVag(){
        return new vagitable();
    }
    public vagFruit createFruit(){
        return new Fruit();
    }
    public GrainBeans createBeans(){
        return null;
    }
    public GrainBeans createOrphan(){
        return null;
    }
}

class GrainBeansFactory implements IFactory{
    public vagFruit createVag(){
        return null;
    }
    public vagFruit createFruit(){
        return null;
    }
    public GrainBeans createBeans(){
        return new Beans();
    }
    public GrainBeans createOrphan(){
        return new Orphan();
    }
}

class abstrectfactory {
    public static IFactory createFactory(String factory){
        if(factory.equals("Vagitable")){
            return new VagFruitFactory();
        }
        else if(factory.equals("Grain")){
            return new GrainBeansFactory();
        }
        else{
            return null;
        }
    }
}
// creating a class for agriculture(main class)
public class agriculture1 {
    public static void main(String[] args) {
        IFactory vagFactory = abstrectfactory.createFactory("Vagitable");
        vagFruit vag = vagFactory.createVag();
        vagFruit fruit = vagFactory.createFruit();
        vag.buyVagFruit();
        fruit.buyVagFruit();
        IFactory grainFactory = abstrectfactory.createFactory("Grain");
        GrainBeans beans = grainFactory.createBeans();
        GrainBeans orphan = grainFactory.createOrphan();
        beans.buyGrainBeans();
        orphan.buyGrainBeans();
    }
}








