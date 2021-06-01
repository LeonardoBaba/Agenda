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
public class AgendaInserir extends JFrame {
	private DefaultTableModel md = new DefaultTableModel();
	private JPanel JPanelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbNome;
	private JLabel lbTelefone;
	private JLabel lbEndereco;
	private JTextField txNome;
	private JTextField txTelefone;
	private JTextField txEndereco;
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
	
	public AgendaInserir(DefaultTableModel def) {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		lbNome = new JLabel("Nome:");
		lbNome.setHorizontalAlignment(SwingConstants.CENTER);
		lbTelefone = new JLabel("Telefone:");
		lbTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lbEndereco = new JLabel("Endereço:");
		lbEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		txNome = new JTextField(10);
		txNome.setDocument(new JTextFieldLimit(50));
		txTelefone = new JTextField();
		txTelefone.setDocument(new JTextFieldLimit(11));
		txEndereco = new JTextField();
		txEndereco.setDocument(new JTextFieldLimit(100));

		
		
		JPanelFundo = new JPanel();
		JPanelFundo.setLayout(new GridLayout(4, 2, 2, 4));
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
		btSalvar.addActionListener(new BtSalvar());
		btLimpar.addActionListener(new BtLimpar());
		md = def;
	}



	private class BtSalvar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Agenda agenda = new Agenda();
			agenda.setTxnome(txNome.getText());
			agenda.setTxtelefone(txTelefone.getText());
			agenda.setTxendereco(txEndereco.getText());

			AgendaDao dao = new AgendaDao();
			dao.salvar(agenda);
			AgendaListar.listar(md);

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