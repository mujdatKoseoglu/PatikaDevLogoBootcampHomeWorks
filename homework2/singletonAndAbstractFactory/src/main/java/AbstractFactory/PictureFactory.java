package AbstractFactory;

public class PictureFactory extends AbstractFactory {
    public Picture getPicture(String pictureType){
        if(pictureType.equalsIgnoreCase("table")){
            return new Table();
        }else if(pictureType.equalsIgnoreCase("desk")){
            return new Desk();
        }
        return null;
    }
}
