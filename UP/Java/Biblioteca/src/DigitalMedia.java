public class DigitalMedia extends LibraryItem{
    public String fileFormat;

    public DigitalMedia(String title, String author, int publicationYear, String fileFormat){
        super(title,author,publicationYear);
        this.fileFormat = fileFormat;
    }
    public void play(){
        System.out.println("O Livro do Titulo: " +title+ 
        ", Autor: " +author+ ", Publicado em: " +publicationYear+ ", Formato: "+fileFormat +"Esta Sendo Reproduzindo");
    }
}
