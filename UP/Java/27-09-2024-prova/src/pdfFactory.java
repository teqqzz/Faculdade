public class pdfFactory extends RelatorioFactory {
    private String format = "";

    public pdfFactory(String format){
        this.format = format;
    }

    public iRelatorio processarRelatorio(){
        return new pdfRelatorio(format);
    }

}
