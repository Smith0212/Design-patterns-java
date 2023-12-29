interface OS {
    public void specs();
}

class Android implements OS {
    public void specs(){
        System.out.println("Android OS");
    }
}

class MacOS implements OS {
    public void specs(){
        System.out.println("MacOS");
    }
}

class Windows implements OS {
    public void specs(){
        System.out.println("Windows");
    }
}

class OSfactory {
    public static OS createFactory(String str){
        switch(str){
            case "Android" :
            return new Android();

            case "Mac":
            return new MacOS();
            
            case "Windows":
            return new Windows();
        }
        return null;
    }
}

public class factory {
    public static void main(String []args){
        OS obj = OSfactory.createFactory("Android");
        obj.specs();
    }
}