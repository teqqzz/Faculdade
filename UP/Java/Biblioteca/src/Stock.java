public class Stock {
    Book book = new Book("Livro 1", "Armando", 2010, "Romance");
    Magazine magazine = new Magazine("Gazeta", "Elias", 2024, 10);
    DigitalMedia digitalmedia = new DigitalMedia("Livro 1", "Armando", 2010, "PDF");
    LibraryItem[] items = {book,magazine,digitalmedia};

    public void stock(){
        
        for (LibraryItem item:items){
            if (item instanceof Book){
                System.out.println("");
                System.out.println("Livros: ");
                System.out.println("Titulo: " +book.title);
                System.out.println("Autor: " +book.author);
                System.out.println("Ano de Publicação: "+book.publicationYear);
                System.out.println("Genero: " +book.genre);
                System.out.println("");
                System.out.println("_________________________________________________________________");
            }
            else if (item instanceof Magazine){
                System.out.println("");
                System.out.println("Revistas: ");
                System.out.println("Titulo: " + magazine.title);
                System.out.println("Autor: " + magazine.author);
                System.out.println("Ano de Publicação: "+magazine.publicationYear);
                System.out.println("Edição: "+magazine.issueNumber);
                System.out.println("");
                System.out.println("_________________________________________________________________");
            }
            else if (item instanceof DigitalMedia){
                System.out.println("");
                System.out.println("Midia Digital: ");
                System.out.println("Titulo: " +digitalmedia.title);
                System.out.println("Autor: " +digitalmedia.author);
                System.out.println("Ano de Publicação: " +digitalmedia.publicationYear);
                System.out.println("Formato: " +digitalmedia.fileFormat);
                System.out.println("");
                System.out.println("_________________________________________________________________");
            }
        }

        }   
        public void borrowItem(int itemChoice) {
            if (itemChoice >= 1 && itemChoice <= items.length) {
                items[itemChoice - 1].borrow();
            } else {
                System.out.println("Opção inválida.");
            }
        }
    
        public void returnItem(int itemChoice) {
            if (itemChoice >= 1 && itemChoice <= items.length) {
                items[itemChoice - 1].returnItem();
            } else {
                System.out.println("Opção inválida.");
            }
        }
    

   

}
