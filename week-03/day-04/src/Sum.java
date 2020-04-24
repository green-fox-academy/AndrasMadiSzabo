import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum {
  protected List<Integer> list = new ArrayList<>();

  public int sum(List<Integer> list) {
    int sum = 0;
    for (Integer s : list) {
      sum += s;
    }
    return sum;
  }

  public List<Integer> getList() {
    return list;
  }
}
