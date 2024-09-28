import java.time.LocalDateTime;

public class pdfRelatorio implements iRelatorio {
    private String format = "";
    LocalDateTime data = LocalDateTime.now();

    public pdfRelatorio (String format){
        this.format = format;
    }
    public void gerarRelatorio(String mensagem){

        System.out.println("Seu relatorio "+data+"."+format+ " Foi gerado" );

    }
}
