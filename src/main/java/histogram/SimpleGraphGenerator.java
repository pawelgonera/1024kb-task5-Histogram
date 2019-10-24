package histogram;

import java.util.Map;

public class SimpleGraphGenerator
{
    private static SimpleGraphGenerator instance = null;
    private HistogramFacade histogramFacade = new HistogramFacade();
    private final static String CHAR = "+";
    private final static String NEW_LINE = "\n";

    public static SimpleGraphGenerator getInstance()
    {
        if(instance == null)
           instance = new SimpleGraphGenerator();

        return instance;
    }

    public String generateGraph(String text)
    {
        Map<Character, Long> histogram =  histogramFacade.generateHistogram(text);
        StringBuilder histogramGraph = new StringBuilder();

        for(Map.Entry<Character, Long> element : histogram.entrySet())
        {
            histogramGraph.append(element.getKey()).append("|");
            for(int i = 0; i < element.getValue(); i++)
                histogramGraph.append(CHAR);
            histogramGraph.append(element.getValue()).append(NEW_LINE);

        }

        return histogramGraph.toString();
    }
}
