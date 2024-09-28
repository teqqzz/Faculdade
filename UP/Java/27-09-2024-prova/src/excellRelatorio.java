import java.time.LocalDateTime;

public class excellRelatorio implements iRelatorio {
    private String format = "";
    LocalDateTime data = LocalDateTime.now();

    public excellRelatorio (String format){
        this.format = format;
    }
    public void gerarRelatorio(String mensagem){

        System.out.println("Seu relatorio "+data+"."+format+ " Foi gerado" );

    }

}
