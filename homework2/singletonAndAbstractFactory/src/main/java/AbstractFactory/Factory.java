package AbstractFactory;

public class Factory {
        public static AbstractFactory getFactory(boolean line){
            if(line){
                return new ColorPictureFactory();
            }else{
                return new PictureFactory();
            }
        }
    }

