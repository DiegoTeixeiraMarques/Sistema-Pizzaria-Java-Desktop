package Beans;

import java.util.ArrayList;
import java.util.List;

public class PedidoBeans {

    private int codigoPedido;
    private int codigoCliente;
    private int codigoFuncionario;
    private int codigoEntregador;
    private String Data;
    private String Hora;
    private Double valor;

    private String status;
    private List<Integer> codCardapio;
    private List<Integer> quantidade;

    public PedidoBeans() {
        codCardapio = new ArrayList<>();
        quantidade = new ArrayList<>();

    }

    public int getCodCardapio(int posicao) {
        return codCardapio.get(posicao);
    }

    public void setCodCardapio(int codCardapio) {
        this.codCardapio.add(codCardapio);
    }

    public int getQuantidade(int posicao) {
        return quantidade.get(posicao);
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.add(quantidade);
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCodigoEntregador() {
        return codigoEntregador;
    }

    public void setCodigoEntregador(int codigoEntregador) {
        this.codigoEntregador = codigoEntregador;
    }

}
