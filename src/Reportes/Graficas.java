package Reportes;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graficas extends JFrame {

    private static final long serialVersionUID = 1L;
    private int[] arreglo;
    DefaultCategoryDataset dataset;
    JFreeChart chart;
    ChartPanel chartPanel;

    public Graficas(int[] ar, String applicationTitle, String chartTitle) {
        super(applicationTitle);
        this.arreglo = ar;
        // Creamos el conjunto de los numeros ingresados
        this.dataset = createDataset();
        this.chart = createChart(dataset, chartTitle);
        // Ponemos el gráfico en un panel
        this.chartPanel = new ChartPanel(chart);
        // Dejamos el tamaño por defecto
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        // Lo añadimos a nuestra aplicación (PieChart)
        setContentPane(chartPanel);
    }

    public void updateData(int[] a) {
        this.arreglo = a;
        dataset = createDataset();
        this.chart = createChart(dataset, "Productos");
        this.chartPanel.setChart(chart);
    }

    public DefaultCategoryDataset createDataset() {

        DefaultCategoryDataset result = new DefaultCategoryDataset();

        for (int i = 0; i < arreglo.length; i++) {
            result.setValue(arreglo[i], "Numero " + i, "ORDENADO");
        }
        return result;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createBarChart3D(title, "Numeros",
                "Rango", dataset, // data
                PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // Inclinamos 45 grados las etiquetas del eje X
        plot.setBackgroundAlpha(0.5f);
        return chart;
    }

    public static void main(String[] args) {
        int[] ar = {2, 3, 5, 2, 7, 4, 2};
        Graficas bc = new Graficas(ar, "Tlapaleria HC", "Productos");
        bc.setVisible(true);
        bc.setSize(440, 440);
        bc.setLocationRelativeTo(null);
        bc.setResizable(false);
    }
}
