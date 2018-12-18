package histogram.factory;

import histogram.config.HistogramConfiguration;
import histogram.config.HistogramConfigurationLoader;

import java.util.*;
import java.util.regex.Pattern;

public class HistogramFactory
{
    private final static Pattern FIXED_PATTERN = Pattern.compile("[\\-\\[\\]\\\\]+");
    private String propertyFileName = "src/main/resources/histogram.properties";
    private final HistogramConfigurationLoader histogramConfiguration = HistogramConfigurationLoader.getInstance();
    private Set<Character> ignoredCharactersSet;
    private boolean shouldIgnoreWhiteSpaces;

    public HistogramFactory()
    {

    }

    public HistogramFactory(String propertyFileName)
    {
        this.propertyFileName = propertyFileName;
    }

    public Map<Character, Long> createHistogram(String text)
    {
        //load configuration every time before create histogram
        loadConfiguration();

        //create histogram, loaded configuration should impacts
        Map<Character, Long> histogram = new TreeMap<>();

        char[] characters = text.toLowerCase().toCharArray();

        Pattern ignoreCharsPattern = setIgnoreCharsPattern();
        for(int i = 0; i < characters.length; i++)
            if (!ignoreCharsPattern.matcher(String.valueOf(characters[i])).matches())
            {
                long counter = countCharsRepeats(characters, characters[i]);
                histogram.put(characters[i], counter);
            }

        return histogram;
    }

    private Pattern setIgnoreCharsPattern()
    {
        String whiteSpaces = HistogramConfigurationLoader.WHITE_SPACES.toString();

        if(shouldIgnoreWhiteSpaces)
            return ignoreCharsPattern(preparePattern(ignoredCharactersSet) + whiteSpaces);
        else
            return ignoreCharsPattern(preparePattern(ignoredCharactersSet));
    }

    private String preparePattern(Set<Character> ignoredCharsSet)
    {
        StringBuilder preparedStringPattern = new StringBuilder();
        for(Character chars : ignoredCharsSet)
        {
            if(FIXED_PATTERN.matcher(String.valueOf(chars)).matches())
                preparedStringPattern.append("\\");
            preparedStringPattern.append(chars);
        }

        return preparedStringPattern.toString();
    }

    private void loadConfiguration()
    {
        HistogramConfiguration config = histogramConfiguration.loadProperties(propertyFileName);

        ignoredCharactersSet = config.getIgnoreCharacters();
        shouldIgnoreWhiteSpaces = config.shouldIgnoreWhiteSpaces();
    }

    private Pattern ignoreCharsPattern(String regex)
    {
        return Pattern.compile("[" + regex + "]+");
    }

    private long countCharsRepeats(char[] chars, Character character)
    {
        long counter = 0;
        for(char element : chars)
            if(character == element)
                counter++;

        return counter;
    }
}
