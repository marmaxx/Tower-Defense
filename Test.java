public class Test {

    public static void main(String [] args){

    
        Map m = new Map();
        m.contourMap(m.getMap());
        System.out.println("map2 ");
        m.map2();
        m.afficher();

        MajMap maj = new MajMap(m,"map2");
        maj.pauseTower(5, 5, new Tourelle(10, 2, 0, 3));

        maj.getMapBase().afficher();

        GameVue vue = new GameVue(m);
        vue.setVisible(true);

    }
    
}
