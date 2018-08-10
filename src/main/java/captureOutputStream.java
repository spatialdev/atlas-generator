import java.io.OutputStream;
import java.io.PrintStream;

public class captureOutputStream extends PrintStream
{
    public String log = "";

    public captureOutputStream(OutputStream out){
        super(out);
    }

    @Override
    public PrintStream printf(String format, Object ... args) {
        this.log = this.log.concat(String.format(format, args));
        return super.printf(format, args);
    }
}
