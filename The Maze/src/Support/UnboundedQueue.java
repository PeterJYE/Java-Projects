package Support;

public interface UnboundedQueue<T> extends QueueInterface<T> {
    void enqueue(T elem);
}
