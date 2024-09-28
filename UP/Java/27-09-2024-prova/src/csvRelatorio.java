import java.time.LocalDateTime;

public class csvRelatorio implements iRelatorio{
    private String format = "";
    LocalDateTime data = LocalDateTime.now();

    public csvRelatorio (String format){
        this.format = format;
    }
    public void gerarRelatorio(String mensagem){

        System.out.println("Seu relatorio "+data+"."+format+ " Foi gerado" );

    }

}
