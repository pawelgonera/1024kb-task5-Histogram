package histogram.config;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HistogramConfiguration
{
    private static HistogramConfiguration instance = null;
    private boolean shouldIgnoreWhiteSpaces = false;
    private Set<Character> ignoreCharacters = new HashSet<>();

    public static HistogramConfiguration getInstance()
    {
        if(instance == null)
            instance = new HistogramConfiguration();

        return instance;
    }

    public boolean shouldIgnoreWhiteSpaces()
    {
        return shouldIgnoreWhiteSpaces;
    }

    public void setShouldIgnoreWhiteSpaces(boolean shouldIgnoreWhiteSpaces)
    {
        this.shouldIgnoreWhiteSpaces = shouldIgnoreWhiteSpaces;
    }

    public Set<Character> getIgnoreCharacters()
    {
        return ignoreCharacters;
    }

    public void setIgnoreCharacters(Set<Character> ignoreCharacters)
    {
        this.ignoreCharacters = ignoreCharacters;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistogramConfiguration that = (HistogramConfiguration) o;
        return shouldIgnoreWhiteSpaces == that.shouldIgnoreWhiteSpaces &&
                Objects.equals(ignoreCharacters, that.ignoreCharacters);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(shouldIgnoreWhiteSpaces, ignoreCharacters);
    }
}
