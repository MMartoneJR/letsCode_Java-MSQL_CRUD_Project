create database projeto_final_loja;

create table vendedor(
	id_vendedor int primary key auto_increment,
    nome_vendedor varchar(35) not null,
    email_vendedor varchar (25) not null
);

create table produtos (
	id_produto int primary key auto_increment,
    nome_produto varchar(20) not null,
    preco numeric (6,2) not null,
    quantidade_estoque numeric
);

create table vendas(
	id_venda int primary key auto_increment,
    id_vendedor int,
    data_venda TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    foreign key (id_vendedor) references vendedor (id_vendedor)
);

create table produtos_vendidos(
	id_prod_vendido int primary key auto_increment,
    id_venda int,
    id_produto int,
    quantidade int,
    valor_unitario numeric (6,2),
    foreign key (id_venda) references vendas (id_venda),
    foreign key (id_produto) references produtos (id_produto)
);

-- Preenchimento básico das tabelas de vendedores e produtos
-- Vendedores
insert into projeto_final_loja.vendedor(nome_vendedor, email_vendedor) values ("Marcelo M", "marcelo@email.com");
insert into projeto_final_loja.vendedor(nome_vendedor, email_vendedor) values ("Gabriela B", "gabriela@email.com");
insert into projeto_final_loja.vendedor(nome_vendedor, email_vendedor) values ("Ronderson R", "ronderson@email.com");

-- Produtos
insert into projeto_final_loja.produtos(nome_produto, preco, quantidade_estoque) values ("Camiseta Branca", 59.99, 10);
insert into projeto_final_loja.produtos(nome_produto, preco, quantidade_estoque) values ("Calca Jeans", 89.99, 17);
insert into projeto_final_loja.produtos(nome_produto, preco, quantidade_estoque) values ("Meias", 9.99, 15);
insert into projeto_final_loja.produtos(nome_produto, preco, quantidade_estoque) values ("Camiseta Preta", 59.99, 10);
insert into projeto_final_loja.produtos(nome_produto, preco, quantidade_estoque) values ("Calca Sarja", 99.99, 17);
insert into projeto_final_loja.produtos(nome_produto, preco, quantidade_estoque) values ("Bermuda", 25.99, 15);

