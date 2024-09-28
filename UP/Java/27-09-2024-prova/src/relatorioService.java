public class relatorioService {

    public void gerarRelatorio(RelatorioFactory factory, String mensagem){
        iRelatorio relatorio = factory.processarRelatorio();
        relatorio.gerarRelatorio(mensagem);
    }

}
