package Controller;

import DAO.TelaPedidosDAO;
import javax.swing.table.DefaultTableModel;

public class TelaPedidosControle {

    TelaPedidosDAO telaPedidosD;

    public TelaPedidosControle() {
        telaPedidosD = new TelaPedidosDAO();

    }

    public void controlePesquisa(DefaultTableModel modelo) {
        telaPedidosD.mostrarPedidos(modelo);

    }

}
