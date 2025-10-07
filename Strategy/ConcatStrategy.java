public class ConcatStrategy implements OperationStrategy {
    @Override
    public int execute(int a, int b) {
        String result = String.valueOf(a) + String.valueOf(b);
        return Integer.parseInt(result);
    }
}
