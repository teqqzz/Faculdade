public abstract class LibraryItem implements Borrowable {
    public String title;
    public String author;
    public int publicationYear;

    public LibraryItem(String title, String author, int publicationYear){
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void borrow(){
            System.out.println("O Livro do Titulo: " +title+ 
            ", Autor: " +author+ ", Publicado em: " +publicationYear+ "Foi Emprestado");
    }
    public void returnItem(){
            System.out.println("O Livro do Titulo: " +title+ 
            ", Autor: " +author+ ", Publicado em: " +publicationYear+ "Foi Devolvido");
    }

}
