package casafer;

import java.text.DecimalFormat;
import java.util.ArrayList;
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
public class GraficoDeBarra {
    
public CategoryDataset createDataSet(ArrayList<Vendedores> listaVendedores){

    DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
    for(Vendedores vendedor : listaVendedores){
        //Double total = new Double(vendedor.getTotal());
        dataSet.addValue(vendedor.getTotalVendasPeriodo(),vendedor.getVen_Nome(), "");
    }
    return dataSet;

}
public JFreeChart createBarChart(CategoryDataset dataSet){
    JFreeChart graficoDeBarra = ChartFactory.createBarChart("Total das vendas por vendedor", " ", "Valor total das vendas ", dataSet, PlotOrientation.VERTICAL,true,false,false);
return graficoDeBarra;
}
public ChartPanel criarGrafico(ArrayList<Vendedores> listaVendedores){
    
    CategoryDataset dataSet = this.createDataSet(listaVendedores);
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



}
