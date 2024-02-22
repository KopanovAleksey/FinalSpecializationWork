public class Counter implements AutoCloseable{
    private int count;
    private boolean isClosed;
    public Counter(){
        this.isClosed = false;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void add(){
        if(isClosed){
            throw new IllegalStateException("Resource is closed");
        }
        this.count++;
    }

    @Override
    public void close() {
        this.isClosed = true;
    }
}
