@FunctionalInterface
public interface OurFunction<T, G> {
    T invoke(G g);
}