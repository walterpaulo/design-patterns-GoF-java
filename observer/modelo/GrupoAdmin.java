package modelo;

public class GrupoAdmin implements Observer {

    @Override
    public void update(Subject s) {
        System.out.println("Grupo Admin\nRecebeu a  mensagem: \""+ s +"\"");
        
    }
    
}
