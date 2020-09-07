package problems.done;

import lombok.Data;

import java.util.Arrays;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyGame {
    public static void main(String[] args) {

        int arr[] = {2, 2, 5, 50, 1};
        System.out.println(LargButMinFreq(arr));
    }

    public static int LargButMinFreq(int arr[]) {
        Map<Integer, Long> map = Arrays.stream(arr).
                boxed().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        OptionalInt optionaMinFreq = map.entrySet().stream().
                mapToInt(e -> Math.toIntExact(e.getValue())).
                min();
        if (optionaMinFreq.isPresent()) {
            OptionalInt optionalResult = map.entrySet().stream().
                    filter(e -> e.getValue().intValue()==optionaMinFreq.getAsInt()).
                    mapToInt(e -> e.getKey()).
                    max();
            if (optionalResult.isPresent())
                return optionalResult.getAsInt();
        }
        return -1;

    }
}

@Data
class FreqElement {

}
