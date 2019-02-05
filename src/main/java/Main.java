import GUI.AppException;
import GUI.WindowApp;
import GUI.WindowDialog;
import io.reader.ReaderException;
import io.writer.WriterException;

public class Main {
    public static void main (String[] args)
            throws ReaderException, WriterException, AppException {
        try {
            WindowApp app = new WindowApp();
            app.setVisible(true);
        } catch (ReaderException re) {
            new WindowDialog(re.getMessage()).setVisible(true);
        } catch (WriterException we) {
            new WindowDialog(we.getMessage()).setVisible(true);
        } catch (AppException ae) {
            new WindowDialog(ae.getMessage()).setVisible(true);
        }
    }
}
