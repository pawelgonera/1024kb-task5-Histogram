package histogram.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HistogramConfigurationLoader
{
    private static HistogramConfigurationLoader instance = null;
    private Properties properties = new Properties();
    public final static List<Character> WHITE_SPACES = Arrays.asList(
            '\n', '\t', '\r', ' ');

    public static HistogramConfigurationLoader getInstance()
    {
        if(instance == null)
            instance = new HistogramConfigurationLoader();

        return instance;
    }

    public HistogramConfiguration loadProperties(String propertyFileName)
    {
        //load property from file name
        HistogramConfiguration histConfig = HistogramConfiguration.getInstance();

        try(FileInputStream inputStream = new FileInputStream(propertyFileName))
        {
            properties.load(inputStream);

            histConfig.setShouldIgnoreWhiteSpaces(loadShouldIgnoreWhiteSpace());
            histConfig.setIgnoreCharacters(loadIgnoredCharactersProperties());

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return histConfig;
    }

    private boolean loadShouldIgnoreWhiteSpace()
    {
        return Boolean.parseBoolean(properties.getProperty("histogram.ignore.white-spaces"));
    }

    private Set<Character> loadIgnoredCharactersProperties()
    {
        String characters = properties.getProperty("histogram.ignore.characters");

        return characters.chars()
                        .mapToObj(chars -> (char) chars)
                        .collect(Collectors.toSet());
    }

}
