package KE2.buffer;
import KE2.buffer.Buffer;

public class BufferTest {
  public static void main(String[] args){
    int size = args.length;
    Buffer buffer = new Buffer(size);
    for (int i=0; i<size;i++){
      buffer.insert(args[i]);
    }

    buffer.print();

  }
}
