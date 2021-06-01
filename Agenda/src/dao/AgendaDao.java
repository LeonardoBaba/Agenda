package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Agenda;

public class AgendaDao extends Agenda{
	// metodo que lista todos os contatos da agenda
	public List<Agenda> listar() {
		//cria array a aser preenchido com os contatos
		List<Agenda> agenda = new ArrayList<Agenda>();
		
		try {
			//estabelece conexão com o banco de dados
			Connection con = new ConexaoBD().getConnection();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM agenda");
			//Executa o comando SQL e retorna os contatos
			ResultSet rs = smt.executeQuery();
			//
			while(rs.next()) {
				Agenda a = new Agenda();
				a.setAgendaPK(rs.getInt("agendaPK"));
				a.setTxnome(rs.getString("txnome"));
				a.setTxendereco(rs.getString("txendereco"));
				a.setTxtelefone(rs.getString("txtelefone"));
				agenda.add(a);
			}
			//fecha conexoes
			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return agenda;
	}
	//metodo para listar os dados de um determinado contato seguindo sua primary key
	public Agenda listarPK(int pk) {
		Agenda agenda = new Agenda();
		try {
			Connection con = new ConexaoBD().getConnection();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM agenda WHERE agendaPK=?");
			smt.setInt(1, pk);
			ResultSet rs = smt.executeQuery();
			while (rs.next()) {
				agenda.setAgendaPK(rs.getInt("agendaPK"));
				agenda.setTxnome(rs.getString("txnome"));
				agenda.setTxendereco(rs.getString("txendereco"));
				agenda.setTxtelefone(rs.getString("txtelefone"));
			}
			//fecha conexões
			rs.close();
			smt.close();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return agenda;
	}
	// metodo para inserir novo contato na agenda
	public void salvar(Agenda agenda) {
		try {
			//estabelece conexão com o banco de dados
			Connection con = new ConexaoBD().getConnection();
			
			PreparedStatement smt = con.prepareStatement("INSERT INTO agenda (txnome,txtelefone,txendereco) VALUES (?,?,?)");
			smt.setString(1, agenda.getTxnome());
			smt.setString(2, agenda.getTxtelefone());
			smt.setString(3, agenda.getTxendereco());
			
			smt.execute();
			//fechar conexoes
			smt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//metodo para atualizar contato
	public void update(Agenda agenda) {
		try {
			Connection con = new ConexaoBD().getConnection();
			PreparedStatement smt = con.prepareStatement("UPDATE agenda SET txnome = ?, txtelefone = ?, txendereco = ? WHERE agendaPK = ?");
			smt.setString(1, agenda.getTxnome());
			smt.setString(2, agenda.getTxtelefone());
			smt.setString(3, agenda.getTxendereco());
			smt.setInt(4, agenda.getAgendaPK());
			//executa o sql
			smt.execute();
			//fechar conexoes
			smt.close();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	//metodo para deletar contato
	public void delete(int pk) {
		try {
			Connection con = new ConexaoBD().getConnection();
			PreparedStatement smt = con.prepareStatement("DELETE FROM agenda WHERE agendaPK=?");
			smt.setInt(1, pk);
			smt.execute();
			
			smt.close();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
}
