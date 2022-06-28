package AbstractFactory;

public class ColorPictureFactory extends AbstractFactory{
        public Picture getPicture(String pictureType){
            if(pictureType.equalsIgnoreCase("table")){
                return new LineTable();
            }else if(pictureType.equalsIgnoreCase("desk")){
                return new LineDesk();
            }
            return null;
        }
    }

