package modelo;


public class GrupoUser implements Observer{

    @Override
    public void update(Subject s) {
        System.out.println("Grupo User\nRecebeu a  mensagem: \""+ s +"\"");
        
    }
    
}
