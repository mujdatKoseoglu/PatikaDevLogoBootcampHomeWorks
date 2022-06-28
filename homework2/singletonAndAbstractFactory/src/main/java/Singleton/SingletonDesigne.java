package Singleton;

public class SingletonDesigne {
        private static SingletonDesigne singletonDesigne = new SingletonDesigne();//nesnesini oluşturduk
        private SingletonDesigne(){}//yapıcı metot
        public static SingletonDesigne getSingleton(){//geri döndüren metod
            return singletonDesigne;
        }
        public void News(){//mesajı ekranda göstersin
            System.out.println("Singleton Designe");
        }
    }

