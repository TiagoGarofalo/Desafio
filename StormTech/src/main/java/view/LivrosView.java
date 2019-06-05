package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.controller.LivroController;
import model.dao.LivroDAO;
import model.vo.LivroVO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LivrosView extends JFrame {

	private JPanel contentPane;
	private JTable tbLivros;
	LivroVO livro = new LivroVO();
	LivroController controller = new LivroController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivrosView frame = new LivrosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	List<LivroVO> livrosConsultados = new ArrayList<LivroVO>();
	List<String> paramConsultas = new ArrayList<String>();
	LivroController controlador = new LivroController();
	private JComboBox cbParametro1;
	private JComboBox cbParametro2;
	private JComboBox cbParametro3;

	public LivrosView() {
		setTitle("Lista de Livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblConsultarLivros = new JLabel("Consultar livros");
		lblConsultarLivros.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultarLivros.setBounds(277, 11, 157, 14);
		contentPane.add(lblConsultarLivros);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 182, 664, 3);
		contentPane.add(separator);

		tbLivros = new JTable();
		tbLivros.setModel(new DefaultTableModel(new Object[][] { { "ID", "Titulo", "Autor", "Edi\u00E7\u00E3o" }, },
				new String[] { "ID", "Titulo", "Autor", "Edi\u00E7\u00E3o" }));
		tbLivros.getColumnModel().getColumn(0).setPreferredWidth(42);
		tbLivros.getColumnModel().getColumn(1).setPreferredWidth(214);
		tbLivros.getColumnModel().getColumn(2).setPreferredWidth(214);
		tbLivros.getColumnModel().getColumn(3).setPreferredWidth(109);
		tbLivros.setBounds(10, 196, 664, 175);
		contentPane.add(tbLivros);

		String[] param1 = { "", "Titulo Crescente", "Titulo Decrescente", "Autor Crescente", "Autor Decrescente",
				"Edição Crescente", "Edição Decrescente" };
		cbParametro1 = new JComboBox(param1);
		cbParametro1.setModel(new DefaultComboBoxModel(new String[] { "", "Titulo Crescente", "Titulo Decrescente",
				"Autor Crescente", "Autor Decrescente", "Edição Crescente", "Edição Decrescente" }));
		cbParametro1.setBounds(10, 65, 157, 20);
		contentPane.add(cbParametro1);

		JLabel lblParametro1 = new JLabel("Selecione Parametro 1");
		lblParametro1.setBounds(10, 40, 131, 14);
		contentPane.add(lblParametro1);

		JLabel lblParametro2 = new JLabel("Selecione Parametro 2");
		lblParametro2.setBounds(260, 40, 131, 14);
		contentPane.add(lblParametro2);

		String[] param2 = { "", "Titulo Crescente", "Titulo Decrescente", "Autor Crescente", "Autor Decrescente",
				"Edição Crescente", "Edição Decrescente" };
		cbParametro2 = new JComboBox(param2);
		cbParametro2.setModel(new DefaultComboBoxModel(new String[] { "", "Titulo Crescente", "Titulo Decrescente",
				"Autor Crescente", "Autor Decrescente", "Edição Crescente", "Edição Decrescente" }));
		cbParametro2.setBounds(260, 65, 157, 20);
		contentPane.add(cbParametro2);

		JLabel lblParametro3 = new JLabel("Selecione Parametro 3");
		lblParametro3.setBounds(517, 40, 131, 14);
		contentPane.add(lblParametro3);

		String[] param3 = { "", "Titulo Crescente", "Titulo Decrescente", "Autor Crescente", "Autor Decrescente",
				"Edição Crescente", "Edição Decrescente" };
		cbParametro3 = new JComboBox(param3);
		cbParametro3.setModel(new DefaultComboBoxModel(new String[] { "", "Titulo Crescente", "Titulo Decrescente",
				"Autor Crescente", "Autor Decrescente", "Edição Crescente", "Edição Decrescente" }));
		cbParametro3.setBounds(517, 65, 157, 20);
		contentPane.add(cbParametro3);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroDAO dao = new LivroDAO();
				String parametros = construirConsulta();

				try {
					livrosConsultados = controller.listarLivros(parametros);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (livrosConsultados != null) {
					atualizarTabelaSimulacoes(livrosConsultados);
				}

			}
		});
		btnConsultar.setBounds(287, 125, 89, 23);
		contentPane.add(btnConsultar);
	}

	public String construirConsulta() {
		String paramConsulta1 = "";
		String paramConsulta2 = "";
		String paramConsulta3 = "";
		String paramConsultaFinal = "";

		switch (cbParametro1.getSelectedItem().toString()) {

		case "Titulo Crescente":
			paramConsulta1 = " TITULO ASC";
			break;

		case "Titulo Decrescente":
			paramConsulta1 = " TITULO DESC";
			break;

		case "Autor Crescente":
			paramConsulta1 = " AUTOR ASC";
			break;

		case "Autor Decrescente":
			paramConsulta1 = " AUTOR DESC";
			break;

		case "Edição Crescente":
			paramConsulta1 = " EDICAO ASC";
			break;

		case "Edição Decrescente":
			paramConsulta1 = " EDICAO DESC";
			break;

		}
		switch (cbParametro2.getSelectedItem().toString()) {

		case "Titulo Crescente":
			paramConsulta2 = ", TITULO ASC";
			break;

		case "Titulo Decrescente":
			paramConsulta2 = ", TITULO DESC";
			break;

		case "Autor Crescente":
			paramConsulta2 = ", AUTOR ASC";
			break;

		case "Autor Decrescente":
			paramConsulta2 = ", AUTOR DESC";
			break;

		case "Edição Crescente":
			paramConsulta2 = ", EDICAO ASC";
			break;

		case "Edição Decrescente":
			paramConsulta2 = ", EDICAO DESC";
			break;

		}

		switch (cbParametro3.getSelectedItem().toString()) {

		case "Titulo Crescente":
			paramConsulta3 = ", TITULO ASC";
			break;

		case "Titulo Decrescente":
			paramConsulta3 = ", TITULO DESC";
			break;

		case "Autor Crescente":
			paramConsulta3 = ", AUTOR ASC";
			break;

		case "Autor Decrescente":
			paramConsulta3 = ", AUTOR DESC";
			break;

		case "Edição Crescente":
			paramConsulta3 = ", EDICAO ASC";
			break;

		case "Edição Decrescente":
			paramConsulta3 = ", EDICAO DESC";
			break;

		}

		return paramConsultaFinal += paramConsulta1 += paramConsulta2 += paramConsulta3;
	}

	protected void atualizarTabelaSimulacoes(List<LivroVO> livros) {

		Object[][] header = new Object[][] { new String[] { "ID", "Titulo", "Autor", "Edição" } };
		String[] registros = new String[] { "ID", "Titulo", "Autor", "Edição" };

		tbLivros.setModel(new DefaultTableModel(header, registros));

		DefaultTableModel modelo = (DefaultTableModel) tbLivros.getModel();

		for (LivroVO livro : livros) {
			// Cria uma nova linha na tabela
			// Preenche a linha com os atributos do livro
			// na ORDEM do cabeçalho da tabela

			Object[] novaLinha = new Object[] { livro.getIdLivro(), livro.getTitulo(), livro.getAutor(),
					livro.getEdicao() };
			modelo.addRow(novaLinha);
		}

	}
}
