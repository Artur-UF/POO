/*
  Classe Cliente
*/
public class Cliente{

   private String cpf; /* CPF (único) do Cliente */
   private String nome; /* Nome do Cliente */
   private String telefone; /* Número de telefone do Cliente */
   
   /* Construtor: recebe e manipula todos os atributos de instância */
   public Cliente(String cpf, String nome, String telefone){
       this.cpf = cpf;
       this.nome = nome;
       this.telefone = telefone;
   }
   
   /* Retorna o identificador único de Cliente (CPF) */
   public String getCPF(){
      return cpf;
   }
   
   /* Sobrescrevendo o método toString() de Object */  
   /* Comente o método to String e veja o que acontece. */ 
   public String toString(){
      return nome;
   }


}
