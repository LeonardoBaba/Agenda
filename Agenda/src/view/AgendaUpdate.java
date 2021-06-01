package view;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import dao.AgendaDao;
import model.Agenda;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AgendaUpdate extends JFrame {

	private DefaultTableModel modelo =
	new DefaultTableModel();
	private JPanel JPanelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbNome;
	private JLabel lbTelefone;
	private JLabel lbEndereco;
	private JLabel lbPK;
	private JTextField txNome;
	private JTextField txPk;
	private JTextField txTelefone;
	private JTextField txEndereco;
	Agenda agenda;
	private int linhaSelecionada;

	//metodo para limitar characters inserirdos nos JTextField
	class JTextFieldLimit extends PlainDocument {
		  private int limit;
		  JTextFieldLimit(int limit) {
		    super();
		    this.limit = limit;
		  }

		  JTextFieldLimit(int limit, boolean upper) {
		    super();
		    this.limit = limit;
		  }

		  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		    if (str == null)
		      return;

		    if ((getLength() + str.length()) <= limit) {
		      super.insertString(offset, str, attr);
		    }
		  }
	}
	
	public AgendaUpdate(DefaultTableModel md, int pk, int linha) {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		lbNome = new JLabel("Nome:");
		lbNome.setHorizontalAlignment(SwingConstants.CENTER);
		lbTelefone = new JLabel("Telefone: ");
		lbTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lbEndereco = new JLabel("Endere\u00E7o:");
		lbEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lbPK = new JLabel("PK:");
		lbPK.setHorizontalAlignment(SwingConstants.CENTER);
		txNome = new JTextField(10);
		txNome.setDocument(new JTextFieldLimit(50));
		txTelefone = new JTextField();
		txTelefone.setDocument(new JTextFieldLimit(11));
		txEndereco = new JTextField();
		txEndereco.setDocument(new JTextFieldLimit(100));
		txPk = new JTextField();
		txPk.setEditable(false);

		JPanelFundo = new JPanel();
		JPanelFundo.setLayout(new GridLayout(5, 2, 2, 4));
		JPanelFundo.add(lbPK);
		JPanelFundo.add(txPk);
		JPanelFundo.add(lbNome);
		JPanelFundo.add(txNome);
		JPanelFundo.add(lbTelefone);
		JPanelFundo.add(txTelefone);
		JPanelFundo.add(lbEndereco);
		JPanelFundo.add(txEndereco);
		JPanelFundo.add(btLimpar);
		JPanelFundo.add(btSalvar);
		getContentPane().add(JPanelFundo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 150);
		setVisible(true);
		btSalvar.addActionListener(new AgendaUpdate.BtSalvar());
		btLimpar.addActionListener(new AgendaUpdate.BtLimpar());
		
		modelo = md;
		AgendaDao dao = new AgendaDao();
		agenda = dao.listarPK(pk);
		txPk.setText(Integer.toString(agenda.getAgendaPK()));
		txNome.setText(agenda.getTxnome());
		txTelefone.setText(agenda.getTxtelefone());
		txEndereco.setText(agenda.getTxendereco());
		linhaSelecionada = linha;
	}

	private class BtSalvar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Agenda a = new Agenda();
			a.setAgendaPK(Integer.parseInt(txPk.getText()));
			a.setTxnome(txNome.getText());
			a.setTxtelefone(txTelefone.getText());
			a.setTxendereco(txEndereco.getText());
			
			AgendaDao dao = new AgendaDao();
			dao.update(a);
			modelo.removeRow(linhaSelecionada);
			modelo.addRow(new Object[]{a.getAgendaPK(),a.getTxnome(),a.getTxtelefone(), a.getTxendereco()});
			setVisible(false);
		}
	}

	private class BtLimpar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txNome.setText("");
			txTelefone.setText("");
			txEndereco.setText("");
		}
	}
}