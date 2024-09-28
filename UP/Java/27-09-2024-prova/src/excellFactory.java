public class excellFactory extends RelatorioFactory{
    private String format = "";
    public excellFactory(String format){
        this.format = format;
    }

    public iRelatorio processarRelatorio(){
        return new excellRelatorio(format);
    }

}
