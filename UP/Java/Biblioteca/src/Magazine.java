public class Magazine extends LibraryItem{
    public int issueNumber;

    public Magazine(String title, String author, int publicationYear, int issueNumber){
        super(title,author,publicationYear);
        this.issueNumber = issueNumber;
    }

    public void flipPages(){
        System.out.println("O Livro do Titulo: " +title+ 
        ", Autor: " +author+ ", Publicado em: " +publicationYear+ ", Edição: "+issueNumber +" ");
    }
}
