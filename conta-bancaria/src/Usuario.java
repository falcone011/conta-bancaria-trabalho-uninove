public class Usuario{
    
    private String nome;
    private String cpf;
    
    public Usuario(){
        this.nome = "Kelvin";
        this.cpf = "707070";
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
}