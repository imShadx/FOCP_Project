import javax.swing.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create and show the frame on the EDT
            new Home();
        });
        }
    }

