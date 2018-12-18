package histogram.CSV;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HistogramCSVGeneratorTest
{
    private HistogramCSVGenerator histogramCSVGenerator;
    private ImmutableMap<Character, Long> histogramSample;

    @Before
    public void setUp()
    {
        histogramCSVGenerator = new HistogramCSVGenerator();
        histogramSample = ImmutableMap.<Character, Long>builder()
            .put('a', 2L)
            .put('b', 3L)
            .put('c', 1L)
            .build();
    }

    @Test
    public void convertHistogramToCSVTest()
    {
        String scvSampleText = "a,2\nb,3\nc,1\n";

        String csvResultTestText = histogramCSVGenerator.convertHistogramToCSV(histogramSample);

        assertEquals(scvSampleText, csvResultTestText);
    }
}
