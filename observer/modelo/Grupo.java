package modelo;

public class Grupo extends Subject{
    private String textos;

    public String getTextos() {
        return textos;
    }

    public void setTextos(String textos) {
        this.textos = textos;
        notifyObservers();
    }

    @Override
    public String toString() {
        return textos;
    }

    
}
