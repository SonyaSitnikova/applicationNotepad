package GUI;

import io.reader.FileReader;
import io.reader.IReader;
import io.reader.ReaderException;
import io.writer.IWriter;
import io.writer.StringWriter;
import io.writer.WriterException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WindowApp extends JFrame {
    /**
     * Constructor WindowApp
     */
    public WindowApp() throws ReaderException, WriterException, AppException {

        super("Блокнот  ");
        setBounds(750, 100, 500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EventHandling eventHandling = new EventHandling();

        JTextPane textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("     Файл     ");
        JMenu newFile = new JMenu("Создать новый");
        JMenuItem txtFileItem = new JMenuItem("Text file");
        JMenuItem openItem = new JMenuItem("Открыть");
        JMenuItem saveItem = new JMenuItem("Сохранить");
        JMenuItem closeItem = new JMenuItem("Закрыть");
        JMenuItem closeAllItem = new JMenuItem("Закрыть все");
        JMenuItem exitItem = new JMenuItem("Выход");
        JMenu editMenu = new JMenu("     Правка     ");
        JMenuItem copyItem = new JMenuItem("Копировать");
        JMenu spravkaMenu = new JMenu("     Справка     ");
        JMenuItem svedeniaItem = new JMenuItem("О программе");

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventHandling.close();
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventHandling.save(textPane);
                } catch (WriterException we) {
                    new WindowDialog(we.getMessage()).setVisible(true);
                } catch (ReaderException re) {
                    new WindowDialog(re.getMessage()).setVisible(true);
                }
            }
        });

        svedeniaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventHandling.about();
            }
        });

        txtFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventHandling.newFile();
                } catch (ReaderException re) {
                    new WindowDialog(re.getMessage()).setVisible(true);
                } catch (WriterException we) {
                    new WindowDialog(we.getMessage()).setVisible(true);
                } catch (IOException ioe) {
                    new WindowDialog(ioe.getMessage()).setVisible(true);
                }
            }
        });

        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventHandling.fileopen(textPane);
                } catch (ReaderException re) {
                    new WindowDialog(re.getMessage()).setVisible(true);
                } catch (WriterException we) {
                    new WindowDialog(we.getMessage()).setVisible(true);
                }
            }
        });

        fileMenu.add(newFile);
        newFile.add(txtFileItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(closeItem);
        fileMenu.add(closeAllItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        editMenu.add(copyItem);
        spravkaMenu.add(svedeniaItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(spravkaMenu);
        setJMenuBar(menuBar);
        add(scrollPane);
    }
}
