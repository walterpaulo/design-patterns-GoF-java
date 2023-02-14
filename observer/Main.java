import modelo.Grupo;
import modelo.GrupoAdmin;
import modelo.GrupoUser;

public class Main {

    public static void main(String[] args) {
        Grupo t = new Grupo();
        t.addObserver(new GrupoAdmin());
        t.addObserver(new GrupoUser());

        t.setTextos("A verdade liberta!");
    }
}
