package AbstractFactory;
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // AbstractFactory üzerinden Factory'e boolean değer göndererek masa yada sıranın çizgili olup olmayacağını seçtik
        AbstractFactory pictureFactory = Factory.getFactory(false);
        //Picture üzerinden çizeceğimiz resmin masa yada sıra olmasına karar verdik(pictureType değeri göndererek).
        Picture p1 = pictureFactory.getPicture("table");
        /*Çizilecek resmin özelliklerine karar verdikten sonra yukarıda yapmış
        olduğumuz işlem bize polimorfizmi sağladı ve ilgili sınıfın boyama fonksiyonunu çağırarak çalıştırdık.*/
        p1.paint();


    }
}