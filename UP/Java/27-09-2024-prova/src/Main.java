public class Main {
    public static void main(String[] args) {
        relatorioService service = new relatorioService();
        service.gerarRelatorio(new pdfFactory("pdf"), "Relatorio PDF");
        service.gerarRelatorio(new csvFactory("csv"), "Relatorio Csv");
        service.gerarRelatorio(new excellFactory("xls"), "Relatorio excell");
    }

}
