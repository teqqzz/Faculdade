public class Book extends LibraryItem {
    public String genre;

    public Book(String title, String author, int publicationYear, String genre){
        super(title, author, publicationYear);
        this.genre = genre;

    }    
    public void readSample(){
        System.out.println("O Livro do Titulo: " +title+ 
        ", Autor: " +author+ ", Publicado em: " +publicationYear+ ", Genero: "+genre +" ");
    }
}
