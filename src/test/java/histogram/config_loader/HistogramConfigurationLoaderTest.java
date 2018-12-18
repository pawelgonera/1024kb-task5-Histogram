package histogram.config_loader;

import histogram.config.HistogramConfigurationLoader;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class HistogramConfigurationLoaderTest
{
    private HistogramConfigurationLoader histogramConfigurationLoader;
    private static String PROPERTY_FILE_NAME = "src/main/resources/histogram.properties";
    private static Character[] IGNORED_CHARS_SET = {'.',',',':',';','\\','/','?','!','"','<','>','-','(',')','*','%','$','@','#','&','{','}','[',']','+','=','^','~','`','|','\''};

    @Before
    public void setUp()
    {
        histogramConfigurationLoader = new HistogramConfigurationLoader();
    }

    @Test
    public void shouldIgnoreWhiteSpaceTest()
    {
        boolean sampleValue = true;

        boolean shouldIgnoreWhiteSpaceTest = histogramConfigurationLoader.loadProperties(PROPERTY_FILE_NAME).shouldIgnoreWhiteSpaces();

        assertEquals(sampleValue, shouldIgnoreWhiteSpaceTest);
    }

    @Test
    public void ignoreCharactersTest()
    {
        Set<Character> ignoredCharactersSetSample = new HashSet<>(Arrays.asList(IGNORED_CHARS_SET));

        Set<Character> ignoredCharsFromTestClass = histogramConfigurationLoader.loadProperties(PROPERTY_FILE_NAME).getIgnoreCharacters();

        assertEquals(ignoredCharactersSetSample, ignoredCharsFromTestClass);
    }
}
