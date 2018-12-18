package histogram.CSV;

import java.util.Map;

public class HistogramCSVGenerator
{
    private static HistogramCSVGenerator instance = null;
    private static final char SEPARATOR = ',';
    private static final char NEW_LINE = '\n';

    public static HistogramCSVGenerator getInstance()
    {
        if(instance == null)
            instance = new HistogramCSVGenerator();

        return instance;
    }

    public String convertHistogramToCSV(Map<Character, Long> histogram)
    {
        StringBuilder csvString = new StringBuilder();

        for(Map.Entry<Character, Long> element : histogram.entrySet())
        {
            csvString.append(element.getKey())
                .append(SEPARATOR)
                .append(element.getValue())
                .append(NEW_LINE);
        }

        // return CSV in String
        return csvString.toString();
    }
}
