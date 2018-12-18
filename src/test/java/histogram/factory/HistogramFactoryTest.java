package histogram.factory;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class HistogramFactoryTest
{

    HistogramFactory histogramFactory = new HistogramFactory("src/test/resources/histogram-test.properties");

    @Test
    public void testStandardText()
    {
        //given
        String text = "aabbcc";
        ImmutableMap<Character, Long> expected = ImmutableMap.<Character, Long>builder()
                .put('a', 2L)
                .put('b', 2L)
                .put('c', 2L)
                .build();

        //is
        Map<Character, Long> histogram = histogramFactory.createHistogram(text);

        //assert
        Assert.assertEquals(expected, histogram);
    }

    @Test
    public void testTextWithSpaces()
    {
        //given
        String text = "aab bc c";
        ImmutableMap<Character, Long> expected = ImmutableMap.<Character, Long>builder()
                .put('a', 2L)
                .put('b', 2L)
                .put('c', 2L)
                .build();

        //is
        Map<Character, Long> histogram = histogramFactory.createHistogram(text);

        //assert
        Assert.assertEquals(expected, histogram);
    }


    @Test
    public void testTextWithNewLines()
    {
        //given
        String text = "aabb\nc";
        ImmutableMap<Character, Long> expected = ImmutableMap.<Character, Long>builder()
                .put('a', 2L)
                .put('b', 2L)
                .put('c', 1L)
                .build();

        //is
        Map<Character, Long> histogram = histogramFactory.createHistogram(text);

        //assert
        Assert.assertEquals(expected, histogram);
    }


    @Test
    public void testLongText()
    {
        //given
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec diam non lorem tristique rhoncus. Sed ut felis in lectus elementum dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus varius purus eget tellus iaculis, sit amet mattis metus pretium. Praesent convallis et massa a dictum. In diam lorem, dignissim a volutpat non, blandit ut ipsum. Integer id metus eu tortor congue sodales id sit amet purus. Donec sed consectetur dui.\n" +
                "\n" +
                "In vitae egestas ipsum. Sed quis orci ligula. Maecenas maximus massa vel elit porttitor lacinia. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. In hac habitasse platea dictumst. Quisque et leo est. Nunc efficitur euismod eros aliquam commodo. Etiam efficitur faucibus efficitur.";

        ImmutableMap<Character, Long> expected = ImmutableMap.<Character, Long>builder()
                .put('a', 54L)
                .put('b', 6L)
                .put('c', 32L)
                .put('d', 22L)
                .put('e', 78L)
                .put('f', 9L)
                .put('g', 8L)
                .put('h', 5L)
                .put('i', 71L)
                .put('l', 29L)
                .put('m', 36L)
                .put('n', 36L)
                .put('o', 35L)
                .put('p', 18L)
                .put('q', 9L)
                .put('r', 31L)
                .put('s', 69L)
                .put('t', 70L)
                .put('u', 52L)
                .put('v', 7L)
                .put('x', 1L)
                .build();

        //is
        Map<Character, Long> histogram = histogramFactory.createHistogram(text);

        //assert
        Assert.assertEquals(expected, histogram);
    }

    @Test
    public  void testAllNotWantedCharacters()
    {
        //given
        String text = ".,:;\\/?!'\"<>-()*%$@#&{}[]+=^~`|";

        ImmutableMap<Character, Long> expected = ImmutableMap.<Character, Long>builder().build();

        //is
        Map<Character, Long> histogram = histogramFactory.createHistogram(text);

        //assert
        Assert.assertEquals(expected, histogram);
    }

}