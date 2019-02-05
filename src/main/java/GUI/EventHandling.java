package GUI;

import io.reader.FileReader;
import io.reader.IReader;
import io.reader.ReaderException;
import io.reader.StringReader;
import io.writer.FileWriter;
import io.writer.IWriter;
import io.writer.StringWriter;
import io.writer.WriterException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class EventHandling {

    private String currentDirectory;
    private String currentFile;
    private String currentFilePath;
    private short n = 0;

    public EventHandling() {

    }

    public String getCurrentFilePath() {
        return currentFilePath;
    }

    public void setCurrentFilePath(String currentFilePath) {
        this.currentFilePath = currentFilePath;
    }

    public void close() {
        System.exit(0);
    }

    public void save (JTextPane textPane) throws ReaderException, WriterException {
        String textPaneText = textPane.getText();
        try
        (IReader in = new StringReader(textPaneText);
        IWriter out = new FileWriter(currentFilePath)) {
            while (in.hasNextChar()) {
                char ch;
                ch = in.readChar();
                out.write(ch);
            }
        }
    }

    public void fileopen(JTextPane textPane) throws ReaderException, WriterException {
        JFileChooser fileChooser = new JFileChooser();
        int ret = fileChooser.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.toString();
            currentFilePath = filePath;
            currentDirectory = fileChooser.getCurrentDirectory().toString();
            currentFile = file.getName().toString();
            try(IReader in = new FileReader(filePath);
                IWriter out = new StringWriter()) {
                textPane.setText("");
                while (in.hasNextChar()) {
                    char ch = in.readChar();
                    out.write(ch);
                    textPane.setText(out.toString());
                }
            }
        }
    }

    public void about() {
        JDialog jDialog = new JDialog();
        jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jDialog.setSize(400, 300);
        jDialog.setLocationRelativeTo(null);
        jDialog.setVisible(true);
        jDialog.add(new JLabel(
                        "<html>"
                                + "<h1><i>    Application for working with files</i></h1><hr>"
                                + "<p>    Приложение для работы с текстовыми файлами</p>"
                                + "<p>    позволяет открывать, изменять, сохранять файлы .txt</p>"
                                + "<p>    </p>"
                                + "<p>    </p>"
                                + "<p>    Разработка программных приложений</p>"
                                + "<p>    ОмГТУ</p>"
                                + "<p>    ФИТиКС, Ситникова</p>"
                                + "</html>"),
                BorderLayout.CENTER);
    }

    public void newFile() throws ReaderException, WriterException, IOException {
        JFileChooser fileChooser = new JFileChooser();
        int ret = fileChooser.showDialog(null, "Создать новый файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File fileChooserCurrentDirectory = fileChooser.getCurrentDirectory();
            //System.out.println(fileChooserCurrentDirectory.toString());
            new File(fileChooserCurrentDirectory.toString() + "/" + "newFile" + n++ + ".txt").createNewFile();
        }
    }
}
