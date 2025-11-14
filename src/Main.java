public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Abre a tela cadastroVIEW
                new cadastroVIEW().setVisible(true);
            }
        });
    }
}
