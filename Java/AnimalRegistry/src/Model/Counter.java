package Model;

public class Counter implements AutoCloseable {
    private int count = 0;

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        if (count > 0) {
            System.out.println("Resource not closed properly");
        }

        // Сбрасываем счетчик при закрытии, независимо от его состояния
        reset();
    }

    // Метод для сброса счетчика
    private void reset() {
        count = 0;
    }
}
