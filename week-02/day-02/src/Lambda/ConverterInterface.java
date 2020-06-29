package Lambda;

@FunctionalInterface
public interface ConverterInterface<F, T> {
  T convert(F f);

}
