package histogram;

import histogram.CSV.HistogramCSVGenerator;
import histogram.factory.HistogramFactory;

import java.io.*;
import java.util.Map;

public class HistogramFacade
{
    private HistogramFactory histogramFactory;
    private HistogramCSVGenerator histogramCSVGenerator = HistogramCSVGenerator.getInstance();

    public HistogramFacade()
    {
        this.histogramFactory = new HistogramFactory();
    }

    public HistogramFacade(String propertyFileName)
    {
        histogramFactory = new HistogramFactory(propertyFileName);
    }

    public Map<Character, Long> generateHistogram(String text)
    {
        return histogramFactory.createHistogram(text);
    }

    public String generateHistogramCSV(String text)
    {
        return histogramCSVGenerator.convertHistogramToCSV(generateHistogram(text));
    }

    public void saveHistogramToCSV(String text, String fileName)
    {
        //generate histogram from passed text as argument and save him as CSV to file
        try(BufferedWriter writer = new BufferedWriter(new PrintWriter(fileName)))
        {
            String csvText = generateHistogramCSV(text);
            writer.write(csvText);

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
