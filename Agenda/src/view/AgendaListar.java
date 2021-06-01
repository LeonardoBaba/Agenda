package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.AgendaDao;
import model.Agenda;

@SuppressWarnings("serial")
public class AgendaListar extends JFrame {

	private JPanel JPanelFundo;
	private JPanel JPanelBt;
	private JTable JTable;
	private JScrollPane JScrollPane;
	private JButton btInserir;
	private JButton btExcluir;
	private JButton btEditar;
	private DefaultTableModel def = new DefaultTableModel();

	public static void main(String[] args) {
		AgendaListar agendaListar = new AgendaListar();
		agendaListar.setVisible(true);
	}
	
	public AgendaListar() {
		JTable = new JTable(def);
		def.addColumn("PK");
		def.addColumn("Nome");
		def.addColumn("Telefone");
		def.addColumn("Endereço");
		JTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		JTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		JTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		JTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		listar(def);
		btInserir = new JButton("Inserir");
		btExcluir = new JButton("Excluir");
		btEditar = new JButton("Editar");
		JPanelBt = new JPanel();
		JScrollPane = new JScrollPane(JTable);
		JPanelFundo = new JPanel();
		JPanelFundo.setLayout(new BorderLayout());
		JPanelFundo.add(BorderLayout.CENTER, JScrollPane);
		JPanelBt.add(btInserir);
		JPanelBt.add(btEditar);
		JPanelBt.add(btExcluir);
		JPanelFundo.add(BorderLayout.SOUTH, JPanelBt);

		getContentPane().add(JPanelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 320);
		setVisible(true);
		btInserir.addActionListener(new BtInserirListener());
		btEditar.addActionListener(new BtEditarListener());
		btExcluir.addActionListener(new BtExcluirListener());
	}

	public static void listar(DefaultTableModel def) {
		def.setNumRows(0);
		AgendaDao dao = new AgendaDao();

		for(Agenda a : dao.listar()) {
			def.addRow(new Object[]{a.getAgendaPK(),a.getTxnome(),a.getTxtelefone(), a.getTxendereco()});
		}
	}

	private class BtInserirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			AgendaInserir agendaInserir = new AgendaInserir(def);
			agendaInserir.setVisible(true);
		}
	}

	private class BtEditarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = JTable.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int pkcontato = (int) JTable
				.getValueAt(linhaSelecionada, 0);
				AgendaUpdate ic = new AgendaUpdate(def, pkcontato, linhaSelecionada);
				ic.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null,"É necesário selecionar um contato.");
			}
		}
	}

	private class BtExcluirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = JTable.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int agendaPK = (int)
				JTable.getValueAt(linhaSelecionada, 0);
				AgendaDao dao = new AgendaDao();
				dao.delete(agendaPK);
				def.removeRow(linhaSelecionada);
			} else {
				JOptionPane.showMessageDialog(null,"É necesário selecionar um contato.");
			}
		}
	}

	
}