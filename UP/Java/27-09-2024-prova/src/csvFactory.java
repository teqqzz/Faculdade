public class csvFactory extends RelatorioFactory {
    private String format = "";
    public csvFactory(String format){
        this.format = format;
    }
    public iRelatorio processarRelatorio(){
        return new csvRelatorio(format);
    }

}
