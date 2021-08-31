package casafer;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author bedim
 */
public class GraficoDeBarraMensal {
    
public CategoryDataset createDataSet(){
    
    DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
    ArrayList<NotasVendas> listaNotas = new ArrayList();
    ArrayList<String> dias = new ArrayList<>();
    Calendar cal = Calendar.getInstance();	
    Integer diasDoMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    String mesTemp = getDate();
    String mes = mesTemp.substring(3, 5);
    Integer ano = cal.get(Calendar.YEAR);
    DaoNotasVendas dao = new DaoNotasVendas();
    
   for (Integer i = 1; i <= diasDoMes; i++) {
       
       String data = "";
       data = data + ano.toString();
       data = data + mes;
       if(i<=9){
           data = data + "0"+i.toString();
       }else{
           data = data + i.toString();
       }
        try {
            listaNotas = dao.todasNotas(data, data);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GraficoDeBarraMensal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Double totalDoDia = 0.0;
        Double totalDevolucoes = 0.0;
        Double totalDoDiaSemDevolucao = 0.0;
       for(NotasVendas nota: listaNotas){
           String tempCFOP = Integer.toString(nota.getOpFis_Codigo());
            String tempDIGITO = tempCFOP.substring(1, 2);
            int digito = Integer.parseInt(tempDIGITO);
            
            if(nota.getNF_Situcao().equals("A") && digito == 1 || digito == 4){
                totalDoDia = totalDoDia  + nota.getNF_VlrNota();
            }
            if(digito == 2 && nota.getNF_Situcao().equals("A")){
                totalDevolucoes = totalDevolucoes + nota.getNF_VlrNota();
            }
            totalDoDiaSemDevolucao = totalDoDia - totalDevolucoes;
       }
       dataSet.addValue(totalDoDiaSemDevolucao,i, "");
   
   }
        
    return dataSet;

}
public JFreeChart createBarChart(CategoryDataset dataSet){
    JFreeChart graficoDeBarra = ChartFactory.createBarChart("Vendas mensais totalizado por dia", "Dias do mês", "Total Vendido", dataSet, PlotOrientation.VERTICAL,true,false,false);
return graficoDeBarra;
}
public ChartPanel criarGrafico(){
    
    CategoryDataset dataSet = this.createDataSet();
    JFreeChart grafico =    this.createBarChart(dataSet);
    //Aki fica o codigo para colocar o valor na barra
    CategoryPlot plot = grafico.getCategoryPlot();
    CategoryItemRenderer itemRerender = plot.getRenderer();
    //Aki fica o codigo para colocar o valor na barra
    
    itemRerender.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.00")));
    itemRerender.setItemLabelsVisible(true);

    
    ChartPanel painelDoGrafico = new ChartPanel(grafico);
    return painelDoGrafico;
    


}
   public String getDate() { 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        Date date = new Date();
        return sdf.format(date); 
    }
   public static String formtarDecimal(double saldo) {
    DecimalFormat df = new DecimalFormat("0.00");
    df.setMaximumFractionDigits(2);
    String teste = df.format(saldo);
    return teste;
   }
}