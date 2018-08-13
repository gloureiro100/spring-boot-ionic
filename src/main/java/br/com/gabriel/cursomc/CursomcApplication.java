package br.com.gabriel.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gabriel.cursomc.domain.Categoria;
import br.com.gabriel.cursomc.domain.Cidade;
import br.com.gabriel.cursomc.domain.Cliente;
import br.com.gabriel.cursomc.domain.Endereco;
import br.com.gabriel.cursomc.domain.Estado;
import br.com.gabriel.cursomc.domain.Pagamento;
import br.com.gabriel.cursomc.domain.PagamentoComBoleto;
import br.com.gabriel.cursomc.domain.PagamentoComCartao;
import br.com.gabriel.cursomc.domain.Pedido;
import br.com.gabriel.cursomc.domain.Produto;
import br.com.gabriel.cursomc.enums.EstadoPagamento;
import br.com.gabriel.cursomc.enums.TipoCliente;
import br.com.gabriel.cursomc.repository.CategoriaRepository;
import br.com.gabriel.cursomc.repository.CidadeRepository;
import br.com.gabriel.cursomc.repository.ClienteRepository;
import br.com.gabriel.cursomc.repository.EnderecoRepository;
import br.com.gabriel.cursomc.repository.EstadoRepository;
import br.com.gabriel.cursomc.repository.PagamentoRepository;
import br.com.gabriel.cursomc.repository.PedidoRepository;
import br.com.gabriel.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository   produtoRepository;
	@Autowired
	EstadoRepository    estadoRepository;
	@Autowired
	CidadeRepository    cidadeRepository;
	@Autowired
	ClienteRepository   clienteRepository;
	@Autowired
	EnderecoRepository  enderecoRepository;
	@Autowired
	PedidoRepository    pedidoRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
 		Estado est2 = new Estado(null, "São Paulo");
 		
 		Cidade c1 = new Cidade(null, "Uberlândia", est1);
 		Cidade c2 = new Cidade(null, "São Paulo", est2);
 		Cidade c3 = new Cidade(null, "Campinas", est2);
 		
 		est1.getCidades().addAll(Arrays.asList(c1));
 		est2.getCidades().addAll(Arrays.asList(c2, c3));

 		estadoRepository.saveAll(Arrays.asList(est1, est2));
 		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
 		
 		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
 		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
 		
 		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
 		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
 		
 		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
 		
 		clienteRepository.saveAll(Arrays.asList(cli1));
 		enderecoRepository.saveAll(Arrays.asList(end1, end2));
 		
 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
 		
 		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
 		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end2);
 		
 		sdf = new SimpleDateFormat("dd/MM/yyyy");
 		
 		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
 		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017"), null);
 		
 		ped1.setPagamento(pgto1);
 		ped2.setPagamento(pgto2);
 		
 		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
 		
 		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
 		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
 		
	}
}
