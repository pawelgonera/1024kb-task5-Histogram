import histogram.SimpleGraphGenerator;

public class Main
{
    public static void main(String[] args)
    {
        String text = "Zauważyłaś, że książka po kilkakrotnym przeczytaniu staje się o wiele grubsza, niż była? [...] Jakby za każdym razem coś zostawało między kartkami: uczucie, myśli, odgłosy, zapachy... A gdy po latach zaczynam ją kartkować, odnajdujemy w niej nas samych, młodszych, innych... Książka przechowuje nas jak zasuszony kwiat; odnajdujemy w niej siebie i jakby nie siebie.";

        SimpleGraphGenerator simpleGraphGenerator = SimpleGraphGenerator.getInstance();

        String graph = simpleGraphGenerator.generateGraph(text);

        System.out.println(graph);

    }
}
